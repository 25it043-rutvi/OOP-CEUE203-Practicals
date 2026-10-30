public class SavingsAccount extends Account {
    private final long minBalance;
    public SavingsAccount(String no, String owner, long balance, long minBalance) {
        super(no, owner, balance); this.minBalance = minBalance;
    }
    @Override public double interestRate() { return 4.0; }
    @Override public boolean canWithdraw(long amount) { return balance - amount >= minBalance; }
}
