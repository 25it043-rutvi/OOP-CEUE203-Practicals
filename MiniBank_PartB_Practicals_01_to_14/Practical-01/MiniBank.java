import java.util.Scanner;

public class MiniBank {
    record BankInfo(String name, String branch) {}
    enum MenuOption { OPEN_ACCOUNT, DEPOSIT, WITHDRAW, TRANSFER, EXIT }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankInfo bank = new BankInfo("MiniBank", "Jamnagar");
        System.out.println("================================");
        System.out.println("       " + bank.name());
        System.out.println("       Branch: " + bank.branch());
        System.out.println("================================");

        int choice;
        do {
            System.out.println("\n===== MINIBANK MENU =====");
            System.out.println("1. Open Account\n2. Deposit\n3. Withdraw\n4. Transfer\n5. Exit");
            System.out.print("Enter your choice: ");
            if (!sc.hasNextInt()) {
                System.out.println("Please enter a number.");
                sc.nextLine();
                choice = 0;
                continue;
            }
            choice = sc.nextInt();
            MenuOption option = switch (choice) {
                case 1 -> MenuOption.OPEN_ACCOUNT;
                case 2 -> MenuOption.DEPOSIT;
                case 3 -> MenuOption.WITHDRAW;
                case 4 -> MenuOption.TRANSFER;
                case 5 -> MenuOption.EXIT;
                default -> null;
            };
            if (option == null) {
                System.out.println("Invalid choice!");
                continue;
            }
            switch (option) {
                case OPEN_ACCOUNT -> System.out.println("Open Account - to be implemented in a later lab");
                case DEPOSIT -> System.out.println("Deposit - to be implemented in a later lab");
                case WITHDRAW -> System.out.println("Withdraw - to be implemented in a later lab");
                case TRANSFER -> System.out.println("Transfer - to be implemented in a later lab");
                case EXIT -> System.out.println("Thank you for using MiniBank!");
            }
        } while (choice != 5);
        sc.close();
    }
}
