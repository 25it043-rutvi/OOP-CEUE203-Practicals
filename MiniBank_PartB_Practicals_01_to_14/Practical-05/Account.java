public abstract class Account {
    protected final String accountNumber;
    protected String ownerName;
    protected long balance;
    public Account(String accountNumber, String ownerName, long balance) {
        this.accountNumber = accountNumber; this.ownerName = ownerName; this.balance = balance;
    }
    public abstract double interestRate();
    public abstract boolean canWithdraw(long amount);
    public boolean withdraw(long amount) {
        if (amount <= 0 || !canWithdraw(amount)) return false;
        balance -= amount; return true;
    }
    public void deposit(long amount) { if (amount > 0) balance += amount; }
    public long getBalance() { return balance; }
    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    @Override public String toString() { return accountNumber + " | " + ownerName + " | " + balance; }
}
