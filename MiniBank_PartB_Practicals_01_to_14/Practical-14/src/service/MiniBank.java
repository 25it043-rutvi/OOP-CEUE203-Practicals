package service;
import java.util.*;
import java.nio.file.*;
import model.Account;
import exception.*;

public class MiniBank {
    public static void main(String[] args) {
        BankService bank = new BankService();
        try {
            bank.openAccount("AC0001", "Riya", 5000);
            bank.openAccount("AC0002", "Aarav", 3000);
            bank.deposit("AC0001", 1000);
            bank.withdraw("AC0002", 500);
            bank.transfer("AC0001", "AC0002", 700);

            Scanner sc = new Scanner(System.in);
            boolean running = true;
            while (running) {
                System.out.println("\n===== MINIBANK =====");
                System.out.println("1. List accounts\n2. Statement\n3. Deposit\n4. Withdraw\n5. Transfer\n6. Exit");
                System.out.print("Choice: ");
                String choice = sc.nextLine().trim();
                try {
                    switch (choice) {
                        case "1" -> bank.listAccounts().forEach(System.out::println);
                        case "2" -> {
                            System.out.print("Account number: ");
                            System.out.println(bank.statement(sc.nextLine().trim()));
                        }
                        case "3" -> {
                            System.out.print("Account number: "); String no = sc.nextLine().trim();
                            System.out.print("Amount: "); long amount = Long.parseLong(sc.nextLine().trim());
                            bank.deposit(no, amount); System.out.println("Deposit successful.");
                        }
                        case "4" -> {
                            System.out.print("Account number: "); String no = sc.nextLine().trim();
                            System.out.print("Amount: "); long amount = Long.parseLong(sc.nextLine().trim());
                            bank.withdraw(no, amount); System.out.println("Withdrawal successful.");
                        }
                        case "5" -> {
                            System.out.print("From account: "); String from = sc.nextLine().trim();
                            System.out.print("To account: "); String to = sc.nextLine().trim();
                            System.out.print("Amount: "); long amount = Long.parseLong(sc.nextLine().trim());
                            bank.transfer(from, to, amount); System.out.println("Transfer successful.");
                        }
                        case "6" -> running = false;
                        default -> System.out.println("Invalid menu option.");
                    }
                } catch (BankException | NumberFormatException e) {
                    System.out.println("Operation failed: " + e.getMessage());
                }
            }
            sc.close();
            System.out.println("Goodbye!");
            System.out.println("Transaction history: " + bank.getHistory());
        } catch (BankException e) {
            System.out.println("Startup error: " + e.getMessage());
        }
    }
}
