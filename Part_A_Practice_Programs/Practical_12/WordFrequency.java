import java.util.*;
public class WordFrequency {
    public static void main(String[] args){String text="java is fun and java is powerful";Map<String,Integer> m=new HashMap<>();for(String w:text.split("\\s+"))m.merge(w,1,Integer::sum);List<Map.Entry<String,Integer>> list=new ArrayList<>(m.entrySet());list.sort(Map.Entry.<String,Integer>comparingByValue().reversed());for(var e:list)System.out.println(e.getKey()+" : "+e.getValue());}
}
