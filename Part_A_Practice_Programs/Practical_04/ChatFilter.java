import java.util.*;
public class ChatFilter {
    public static void main(String[] args){
        String[] logs={"10:05 alice Hello there","10:06 bob Meeting at noon","bad line","10:07 cara hello again"};
        Scanner sc=new Scanner(System.in);System.out.print("Keyword: ");String key=sc.nextLine().toLowerCase();
        int count=0;StringBuilder report=new StringBuilder();
        for(String line:logs){String[] p=line.split(" ",3);if(p.length<3)continue;if(p[2].toLowerCase().contains(key)){count++;report.append(p[0]).append(" ").append(p[1]).append(": ").append(p[2]).append("\\n");}}
        System.out.println("Matches: "+count);System.out.print(report);
    }
}
