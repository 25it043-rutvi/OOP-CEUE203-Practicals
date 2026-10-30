public class StatementFormatter {
    public static String buildStatement(Account account) {
        StringBuilder sb = new StringBuilder();
        sb.append("========== MINIBANK STATEMENT ==========\n");
        sb.append("Account Number: ").append(account.getAccountNumber()).append('\n');
        sb.append("Owner: ").append(account.getOwnerName()).append('\n');
        sb.append("Balance: Rs. ").append(account.getBalance()).append('\n');
        sb.append("========================================");
        return sb.toString();
    }
}
