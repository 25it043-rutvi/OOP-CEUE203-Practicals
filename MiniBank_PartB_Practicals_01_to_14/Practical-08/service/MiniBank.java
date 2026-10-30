package service;
import model.Account;
import exception.*;

public class MiniBank {
    static class AuditResource implements AutoCloseable {
        public AuditResource() { System.out.println("Audit resource opened."); }
        @Override public void close() { System.out.println("Audit resource closed."); }
    }
    public static void main(String[] args) {
        Account a = new Account("AC0001", 1000);
        try {
            a.withdraw(5000);
        } catch (InsufficientFundsException e) {
            System.out.println("Withdrawal failed: short by " + e.getShortfall());
        } catch (BankException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Current balance: " + a.getBalance());
        }
        try (AuditResource audit = new AuditResource()) {
            a.deposit(500);
            System.out.println("Deposit successful.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
