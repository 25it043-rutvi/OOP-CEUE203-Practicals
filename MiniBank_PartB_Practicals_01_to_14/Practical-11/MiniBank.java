import java.nio.file.*;

public class MiniBank {
    public static void main(String[] args) throws Exception {
        Path data = Path.of("data");
        Account[] accounts = {
            new Account("AC0001", "Riya", 5000),
            new Account("AC0002", "Aarav", 3000),
            new Account("AC0003", "Meera", 9000)
        };
        StatePersister.save(accounts, data.resolve("accounts.dat"));
        Account[] loaded = StatePersister.load(data.resolve("accounts.dat"));
        System.out.println("Reloaded accounts:");
        for (Account a : loaded) System.out.println(a);

        Path log = data.resolve("logs/day1.log");
        TransactionLog.append(log, "DEPOSIT AC0001 500");
        TransactionLog.append(log, "WITHDRAW AC0002 200");
        System.out.println(ReportGenerator.generate(data.resolve("logs"), data.resolve("report.txt")));
    }
}
