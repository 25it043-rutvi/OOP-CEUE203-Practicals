package model;
import java.io.Serializable;
import java.util.Objects;
import model.annotation.Id;
import exception.*;

public class Account implements Serializable, Comparable<Account> {
    private static final long serialVersionUID = 1L;
    @Id private final String accountNumber;
    private final String ownerName;
    private long balance;
    private boolean active = true;

    public Account(String no, String owner, long openingBalance) {
        this.accountNumber = no; this.ownerName = owner; this.balance = openingBalance;
    }
    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public synchronized long getBalance() { return balance; }
    public synchronized void deposit(long amount) throws InvalidAmountException {
        if (amount <= 0) throw new InvalidAmountException(amount);
        balance += amount;
    }
    public synchronized void withdraw(long amount)
            throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) throw new InvalidAmountException(amount);
        if (balance < amount) throw new InsufficientFundsException(amount - balance);
        balance -= amount;
    }
    public synchronized void credit(long amount) { balance += amount; }
    public synchronized void debitUnchecked(long amount) { balance -= amount; }
    @Override public int compareTo(Account other) { return accountNumber.compareTo(other.accountNumber); }
    @Override public boolean equals(Object o) { return o instanceof Account a && accountNumber.equals(a.accountNumber); }
    @Override public int hashCode() { return Objects.hash(accountNumber); }
    @Override public String toString() { return accountNumber + " | " + ownerName + " | Rs." + balance; }
}
