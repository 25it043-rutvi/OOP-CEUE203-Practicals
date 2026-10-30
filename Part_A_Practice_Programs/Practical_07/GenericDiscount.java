import java.util.*;
import java.util.function.Function;
public class GenericDiscount {
    static <T> List<T> apply(List<T> values,Function<T,T> rule){List<T> out=new ArrayList<>();for(T v:values)out.add(rule.apply(v));return out;}
    public static void main(String[] args){List<Double> prices=List.of(100.0,200.0,300.0);System.out.println(apply(prices,p->p*.9));}
}
