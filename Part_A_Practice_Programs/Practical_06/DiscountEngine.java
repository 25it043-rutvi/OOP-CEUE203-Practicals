import java.util.*;
import java.util.function.UnaryOperator;
public class DiscountEngine {
    public static void main(String[] args){List<Double> prices=List.of(100.0,250.0,500.0);Scanner sc=new Scanner(System.in);System.out.println("1=10% off, 2=20 off, 3=no discount");int choice=sc.nextInt();
        UnaryOperator<Double> rule=switch(choice){case 1->p->p*.90;case 2->p->Math.max(0,p-20);default->p->p;};
        prices.stream().map(rule).forEach(System.out::println);}
}
