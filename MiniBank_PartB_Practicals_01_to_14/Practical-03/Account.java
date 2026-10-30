import java.util.Objects;

public class Account {
    private final String accountNumber;
    private String ownerName;
    private long balance;
    private boolean active = true;
    private static int counter;

    public Account(String accountNumber, String ownerName, long balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        counter++;
    }
    public Account(String ownerName, long balance) {
        this(String.format("AC%04d", counter + 1), ownerName, balance);
    }
    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public long getBalance() { return balance; }
    public void deposit(long amount) { if (amount > 0) balance += amount; }
    public boolean withdraw(long amount) {
        if (amount <= 0 || balance < amount) return false;
        balance -= amount; return true;
    }
    @Override public String toString() {
        return accountNumber + " | " + ownerName + " | " + balance + " | active=" + active;
    }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account a)) return false;
        return accountNumber.equals(a.accountNumber);
    }
    @Override public int hashCode() { return Objects.hash(accountNumber); }
}
