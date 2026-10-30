abstract class Media { String title;Media(String t){title=t;}abstract double lateFee(int days); }
class Book extends Media { Book(String t){super(t);}double lateFee(int d){return d*2.0;} }
class DVD extends Media { DVD(String t){super(t);}double lateFee(int d){return d*5.0;} }
class Magazine extends Media { Magazine(String t){super(t);}double lateFee(int d){return d*1.0;} }
public class MediaFeeDemo {
    public static void main(String[] args){Media[] returned={new Book("Java"),new DVD("Film"),new Magazine("Tech")};int[] days={3,2,5};double total=0;for(int i=0;i<returned.length;i++){double fee=returned[i].lateFee(days[i]);System.out.println(returned[i].title+": "+fee);total+=fee;}System.out.println("Total late fees: "+total);}
}
