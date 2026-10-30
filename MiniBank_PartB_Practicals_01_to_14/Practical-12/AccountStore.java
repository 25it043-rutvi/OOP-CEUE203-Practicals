import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AccountStore {
    private final HashMap<String, Account> accounts = new HashMap<>();
    private final ArrayList<String> transactionHistory = new ArrayList<>();
    private final ConcurrentHashMap<String, Account> sharedAccounts = new ConcurrentHashMap<>();

    public void add(Account account) {
        accounts.put(account.getAccountNumber(), account);
        sharedAccounts.put(account.getAccountNumber(), account);
    }
    public Account get(String accountNumber) { return accounts.get(accountNumber); }
    public ArrayList<Account> getAll() { return new ArrayList<>(accounts.values()); }
    public ArrayList<Account> sortedByBalance() {
        ArrayList<Account> result = getAll();
        result.sort(Comparator.comparingLong(Account::getBalance).reversed());
        return result;
    }
    public void addTransaction(String line) { transactionHistory.add(line); }
    public ArrayList<String> getTransactionHistory() { return new ArrayList<>(transactionHistory); }
    public ConcurrentHashMap<String, Account> getSharedAccounts() { return sharedAccounts; }
}
