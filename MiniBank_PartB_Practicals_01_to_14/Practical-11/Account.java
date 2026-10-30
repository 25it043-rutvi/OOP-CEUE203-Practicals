import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String accountNumber;
    private final String ownerName;
    private long balance;
    public Account(String no, String owner, long balance) {
        this.accountNumber = no; this.ownerName = owner; this.balance = balance;
    }
    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public long getBalance() { return balance; }
    @Override public String toString() { return accountNumber + " | " + ownerName + " | " + balance; }
}
