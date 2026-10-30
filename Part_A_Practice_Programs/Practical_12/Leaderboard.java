import java.util.*;
public class Leaderboard {
    public static void main(String[] args){Map<String,Integer> scores=Map.of("Riya",95,"Aman",88,"Meera",95,"Jay",76);int n=3;scores.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey())).limit(n).forEach(e->System.out.println(e.getKey()+" "+e.getValue()));}
}
