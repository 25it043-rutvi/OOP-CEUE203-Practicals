public class MiniBank {
    public static void main(String[] args) {
        Account a1 = new Account("AC0001", "Riya", 4000);
        Account a2 = new Account("AC0001", "Riya", 4000);
        Customer c = new Customer("Riya", "riya@example.com", "9876543210",
                new Customer.Address("12 MG Road", "Jamnagar", "361001"));

        System.out.println(a1);
        System.out.println("Accounts equal: " + a1.equals(a2));
        System.out.println("Is Account: " + (a1 instanceof Account));
        System.out.println("Customer address: " + c.getAddress());
        Customer copy = c.clone();
        System.out.println("Cloned customer ID: " + copy.getCustomerId());
    }
}
