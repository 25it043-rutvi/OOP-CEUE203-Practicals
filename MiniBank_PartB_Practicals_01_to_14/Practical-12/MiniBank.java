public class MiniBank {
    public static void main(String[] args) {
        AccountStore store = new AccountStore();
        store.add(new Account("AC0001", "Riya", 5000));
        store.add(new Account("AC0002", "Aarav", 2000));
        store.add(new Account("AC0003", "Meera", 9000));
        store.addTransaction("DEPOSIT AC0001 500");
        System.out.println("Lookup AC0002: " + store.get("AC0002"));
        System.out.println("Accounts sorted by balance:");
        for (Account a : store.sortedByBalance()) System.out.println(a);
        System.out.println("History: " + store.getTransactionHistory());
        System.out.println("Concurrent map size: " + store.getSharedAccounts().size());
    }
}
