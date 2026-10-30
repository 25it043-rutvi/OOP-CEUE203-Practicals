public class CommandParser {
    public static Command parse(String line) {
        if (line == null) throw new IllegalArgumentException("Command cannot be null");
        String[] parts = line.trim().split("\\s+");
        if (parts.length != 3) throw new IllegalArgumentException("Expected: TYPE ACCOUNT_NUMBER AMOUNT");
        TransactionType type = TransactionType.valueOf(parts[0].toUpperCase());
        long amount = Long.parseLong(parts[2]);
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        return new Command(type, parts[1], amount);
    }
}
