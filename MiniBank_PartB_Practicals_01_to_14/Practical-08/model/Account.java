package model;
import exception.*;
public class Account {
    private final String accountNumber;
    private long balance;
    public Account(String no, long balance) { this.accountNumber = no; this.balance = balance; }
    public String getAccountNumber() { return accountNumber; }
    public long getBalance() { return balance; }
    public void deposit(long amount) throws InvalidAmountException {
        if (amount <= 0) throw new InvalidAmountException(amount);
        balance += amount;
    }
    public synchronized void withdraw(long amount)
            throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) throw new InvalidAmountException(amount);
        if (balance < amount) throw new InsufficientFundsException(amount - balance);
        balance -= amount;
    }
    public void transfer(Account to, long amount) throws BankException {
        try {
            withdraw(amount);
            to.deposit(amount);
        } catch (BankException e) {
            throw e;
        } finally {
            System.out.println("Transfer attempt completed.");
        }
    }
}
