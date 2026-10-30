import java.util.*;
public class UniqueVisitors {
    public static void main(String[] args){String[] names={"riya","aman","riya","meera","jay","aman"};Set<String> hash=new HashSet<>(Arrays.asList(names));LinkedHashSet<String> ordered=new LinkedHashSet<>(Arrays.asList(names));System.out.println("Unique count: "+hash.size());System.out.println("First three: "+ordered.stream().limit(3).toList());}
}
