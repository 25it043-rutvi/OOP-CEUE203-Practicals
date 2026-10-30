public class Customer {
    @Id private final String customerId;
    private final String name;
    public Customer(String id, String name) { this.customerId = id; this.name = name; }
    public String getCustomerId() { return customerId; }
    @Override public String toString() { return customerId + " | " + name; }
}
