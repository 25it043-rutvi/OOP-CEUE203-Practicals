class InsufficientFundsException extends Exception { long shortfall;InsufficientFundsException(long s){super("Short by "+s);shortfall=s;} }
class Savings { long balance;Savings(long b){balance=b;}void withdraw(long amount)throws InsufficientFundsException{if(amount>balance)throw new InsufficientFundsException(amount-balance);balance-=amount;} }
public class InsufficientFundsDemo {
    public static void main(String[] args){Savings s=new Savings(1000);try{s.withdraw(5000);}catch(InsufficientFundsException e){System.out.println("Withdrawal failed: "+e.getMessage());}System.out.println("Balance: "+s.balance);}
}
