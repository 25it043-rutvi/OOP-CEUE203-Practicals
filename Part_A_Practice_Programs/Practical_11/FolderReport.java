import java.nio.file.*;import java.nio.file.attribute.*;import java.io.*;
public class FolderReport {
    public static void main(String[] args)throws Exception{Path root=Path.of(".");try(BufferedWriter w=Files.newBufferedWriter(Path.of("folder-report.txt"))){try(var paths=Files.walk(root)){paths.filter(Files::isRegularFile).forEach(p->{try{BasicFileAttributes a=Files.readAttributes(p,BasicFileAttributes.class);w.write(p+" | "+a.size()+" bytes | "+a.lastModifiedTime());w.newLine();}catch(IOException e){throw new UncheckedIOException(e);}});}}System.out.println("Created folder-report.txt");}
}
