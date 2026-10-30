public class Customer implements Cloneable {
    private String name, email, mobile;
    private final String customerId;
    private Address address;
    private static long counter = 100;

    public static class Address {
        private final String line, city, pincode;
        public Address(String line, String city, String pincode) {
            this.line = line; this.city = city; this.pincode = pincode;
        }
        public String getLine() { return line; }
        public String getCity() { return city; }
        public String getPincode() { return pincode; }
        @Override public String toString() { return line + ", " + city + " - " + pincode; }
    }

    public Customer(String name, String email, String mobile, Address address) {
        this.name = name; this.email = email; this.mobile = mobile;
        this.address = address; this.customerId = "CUST" + (++counter);
    }
    public String getCustomerId() { return customerId; }
    public Address getAddress() { return address; }
    @Override public Customer clone() {
        try { return (Customer) super.clone(); }
        catch (CloneNotSupportedException e) { throw new AssertionError(e); }
    }
}
