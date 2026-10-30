public class MiniBank {
    public static void main(String[] args) {
        Account[] accounts = {
            new SavingsAccount("AC0001", "Riya", 5000, 1000),
            new CurrentAccount("AC0002", "Aarav", 2000, 3000),
            new FixedDepositAccount("AC0003", "Meera", 10000)
        };
        for (Account account : accounts) {
            System.out.println(account + " | Interest: " + account.interestRate() + "%");
            if (account instanceof SavingsAccount savings)
                System.out.println("Savings minimum balance: " + savings.getBalance());
        }
        System.out.println("Savings withdraw 4500: " + accounts[0].withdraw(4500));
        System.out.println("Current withdraw 4000: " + accounts[1].withdraw(4000));
        System.out.println("FD withdraw 100: " + accounts[2].withdraw(100));
    }
}
