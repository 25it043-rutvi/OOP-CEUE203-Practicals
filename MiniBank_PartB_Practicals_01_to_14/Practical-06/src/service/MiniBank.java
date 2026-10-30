package service;
import model.Account;
import model.WithdrawRule;
import static util.Rules.hasPositiveAmount;

public class MiniBank {
    public static void main(String[] args) {
        Account account = new Account("AC0001", 5000);
        WithdrawRule anonymousRule = new WithdrawRule() {
            @Override public boolean allow(Account a, long amount) {
                return amount > 0 && a.getBalance() >= amount;
            }
        };
        WithdrawRule lambdaRule = (a, amount) -> hasPositiveAmount(amount) && a.getBalance() >= amount;

        System.out.println("Anonymous rule: " + anonymousRule.allow(account, 1000));
        System.out.println("Lambda rule: " + lambdaRule.allow(account, 1000));
        System.out.println("Yearly interest: " + account.yearlyInterest());
        account.withdraw(1000);
        System.out.println("Balance: " + account.getBalance());
    }
}
