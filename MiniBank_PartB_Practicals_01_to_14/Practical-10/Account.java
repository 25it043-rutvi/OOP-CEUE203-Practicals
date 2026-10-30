public class Account {
    private final String accountNumber;
    private long balance;
    public Account(String no, long balance) { this.accountNumber = no; this.balance = balance; }
    public synchronized void deposit(long amount) { if (amount > 0) balance += amount; }
    public synchronized boolean withdraw(long amount) {
        if (amount <= 0 || balance < amount) return false;
        balance -= amount; return true;
    }
    public synchronized long getBalance() { return balance; }
    public String getAccountNumber() { return accountNumber; }
}
