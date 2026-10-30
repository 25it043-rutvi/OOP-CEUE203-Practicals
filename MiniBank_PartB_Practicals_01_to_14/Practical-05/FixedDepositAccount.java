public class FixedDepositAccount extends Account {
    public FixedDepositAccount(String no, String owner, long balance) { super(no, owner, balance); }
    @Override public double interestRate() { return 7.0; }
    @Override public boolean canWithdraw(long amount) { return false; }
}
