import java.io.*;
public class TryResourcesDemo {
    public static void main(String[] args){try(BufferedWriter w=new BufferedWriter(new FileWriter("sample.txt"))){w.write("Java try-with-resources");System.out.println("File written");}catch(IOException e){System.out.println(e.getMessage());}}
}
