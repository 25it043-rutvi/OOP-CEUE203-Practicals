package model;
import model.annotation.*;
public class Account {
    @Id private String accountNumber;
    @MaxLength(30) private String ownerName;
    @Positive private long balance;
    public Account(String no, String owner, long balance) {
        this.accountNumber = no; this.ownerName = owner; this.balance = balance;
    }
    @Override public String toString() { return accountNumber + " | " + ownerName + " | " + balance; }
}
