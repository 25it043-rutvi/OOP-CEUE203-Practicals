public class MiniBank {
    public static void main(String[] args) {
        System.out.println("Mobile valid: " + Validator.isValidMobile("9876543210"));
        System.out.println("Mobile invalid: " + Validator.isValidMobile("12345"));
        System.out.println("Email valid: " + Validator.isValidEmail("abc@xyz.com"));
        System.out.println("Email invalid: " + Validator.isValidEmail("abcxyz"));
        System.out.println("PAN valid: " + Validator.isValidPan("ABCDE1234F"));
        System.out.println("PAN invalid: " + Validator.isValidPan("12345"));
        System.out.println("IFSC valid: " + Validator.isValidIfsc("SBIN0001234"));
        System.out.println("IFSC invalid: " + Validator.isValidIfsc("BAD"));
        Command c = CommandParser.parse("DEPOSIT AC0001 500");
        System.out.println(c);
        Account a = new Account("AC0001", "Riya", 5000);
        System.out.println(StatementFormatter.buildStatement(a));
    }
}
