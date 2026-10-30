import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class ReportGenerator {
    public static String generate(Path logsFolder, Path reportFile) throws IOException {
        long deposits = 0, withdrawals = 0;
        StringBuilder details = new StringBuilder();
        if (Files.exists(logsFolder)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(logsFolder, "*.log")) {
                for (Path file : stream) {
                    try (BufferedReader reader = Files.newBufferedReader(file)) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] p = line.trim().split("\\s+");
                            if (p.length >= 3) {
                                long amount = Long.parseLong(p[2]);
                                if (p[0].equals("DEPOSIT")) deposits += amount;
                                if (p[0].equals("WITHDRAW")) withdrawals += amount;
                            }
                        }
                    }
                    BasicFileAttributes a = Files.readAttributes(file, BasicFileAttributes.class);
                    details.append(file.getFileName()).append(" | size=").append(a.size())
                           .append(" | modified=").append(a.lastModifiedTime()).append('\n');
                }
            }
        }
        String report = "END OF DAY REPORT\nDeposits: " + deposits +
                "\nWithdrawals: " + withdrawals + "\nNet change: " +
                (deposits - withdrawals) + "\nFiles:\n" + details;
        Path parent = reportFile.getParent();
        if (parent != null) Files.createDirectories(parent);
        Files.writeString(reportFile, report);
        return report;
    }
}
