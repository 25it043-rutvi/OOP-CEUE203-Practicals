package service;
import java.util.*;
import model.Account;
import exception.*;

public class BankService {
    private final Map<String, Account> accounts = new LinkedHashMap<>();
    private final List<String> history = new ArrayList<>();

    public Account openAccount(String no, String owner, long opening) throws InvalidAmountException {
        if (opening < 0) throw new InvalidAmountException(opening);
        if (accounts.containsKey(no)) throw new IllegalArgumentException("Account already exists");
        Account a = new Account(no, owner, opening);
        accounts.put(no, a);
        history.add("OPEN " + no + " " + opening);
        return a;
    }
    public void deposit(String no, long amount) throws BankException {
        Account a = require(no); a.deposit(amount); history.add("DEPOSIT " + no + " " + amount);
    }
    public void withdraw(String no, long amount) throws BankException {
        Account a = require(no); a.withdraw(amount); history.add("WITHDRAW " + no + " " + amount);
    }
    public void transfer(String from, String to, long amount) throws BankException {
        Account source = require(from), destination = require(to);
        synchronized (this) {
            source.withdraw(amount);
            destination.credit(amount);
        }
        history.add("TRANSFER " + from + " " + to + " " + amount);
    }
    public String statement(String no) throws AccountNotFoundException {
        return require(no).toString();
    }
    public List<Account> listAccounts() { return new ArrayList<>(accounts.values()); }
    public Account require(String no) throws AccountNotFoundException {
        Account a = accounts.get(no);
        if (a == null) throw new AccountNotFoundException(no);
        return a;
    }
    public List<String> getHistory() { return new ArrayList<>(history); }
}
