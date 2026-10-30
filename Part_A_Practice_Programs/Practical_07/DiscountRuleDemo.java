import java.util.*;
import java.util.function.UnaryOperator;
public class DiscountRuleDemo {
    public static void main(String[] args){Map<Integer,UnaryOperator<Double>> rules=Map.of(1,p->p*.9,2,p->p*.8,3,p->p-50);Scanner sc=new Scanner(System.in);System.out.print("Choose discount 1/2/3: ");int c=sc.nextInt();UnaryOperator<Double> rule=rules.getOrDefault(c,p->p);for(double p:new double[]{100,250,500})System.out.println(rule.apply(p));}
}
