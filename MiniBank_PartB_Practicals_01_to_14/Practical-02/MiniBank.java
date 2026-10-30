public class MiniBank {
    public static void main(String[] args) {
        Account[] accounts = {
            new Account("Riya", 5000),
            new Account("Aarav"),
            new Account("Meera", 2500)
        };

        accounts[0].deposit(2000);
        System.out.println("After deposit: " + accounts[0].getBalance());
        System.out.println("Withdraw 3000: " + accounts[0].withdraw(3000));
        System.out.println("Balance: " + accounts[0].getBalance());
        System.out.println("Withdraw 10000: " + accounts[0].withdraw(10000));
        System.out.println("Balance: " + accounts[0].getBalance());

        for (Account account : accounts)
            System.out.println(account.getAccountNumber() + " | " +
                account.getOwnerName() + " | " + account.getBalance());
    }
}
