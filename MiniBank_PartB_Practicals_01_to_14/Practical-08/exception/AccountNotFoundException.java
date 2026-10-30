package exception;
public class AccountNotFoundException extends BankException {
    public AccountNotFoundException(String account) { super("Account not found: " + account); }
}
