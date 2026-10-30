class InvalidAmountException extends Exception { InvalidAmountException(String m){super(m);} }
class SimpleAccount { long balance;SimpleAccount(long b){balance=b;}void deposit(long n)throws InvalidAmountException{if(n<=0)throw new InvalidAmountException("Amount must be positive");balance+=n;} }
public class BankExceptionDemo {
    public static void main(String[] args){SimpleAccount a=new SimpleAccount(1000);try{a.deposit(-5);}catch(InvalidAmountException e){System.out.println("Deposit failed: "+e.getMessage());}finally{System.out.println("Balance: "+a.balance);}}
}
