import java.util.Objects;

public class Account implements Comparable<Account> {
    private final String accountNumber, ownerName;
    private long balance;
    public Account(String no, String owner, long balance) {
        this.accountNumber = no; this.ownerName = owner; this.balance = balance;
    }
    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public long getBalance() { return balance; }
    @Override public int compareTo(Account other) { return accountNumber.compareTo(other.accountNumber); }
    @Override public boolean equals(Object o) {
        return o instanceof Account a && accountNumber.equals(a.accountNumber);
    }
    @Override public int hashCode() { return Objects.hash(accountNumber); }
    @Override public String toString() { return accountNumber + " | " + ownerName + " | " + balance; }
}
