public class MiniBank {
    public static void main(String[] args) {
        Repository<Account> accounts = new Repository<>(Account.class);
        accounts.save(new Account("AC0001", "Riya", 5000));
        accounts.save(new Account("AC0002", "Aarav", 2000));
        accounts.save(new Account("AC0003", "Meera", 9000));
        System.out.println("Find AC0002: " + accounts.findById("AC0002"));
        System.out.println("All accounts:");
        accounts.findAll().forEach(System.out::println);
        System.out.println("Account count: " + accounts.count());

        Repository<Customer> customers = new Repository<>(Customer.class);
        customers.save(new Customer("CUST101", "Riya"));
        customers.save(new Customer("CUST102", "Aarav"));
        System.out.println("Customer lookup: " + customers.findById("CUST101"));
    }
}
