import java.nio.file.*;import java.io.*;import java.util.*;
public class LogAnalyzer {
    public static void main(String[] args)throws Exception{Path dir=Path.of("logs");Files.createDirectories(dir);Files.writeString(dir.resolve("app.log"),"INFO started\\nERROR failed\\nINFO stopped\\n");String keyword="ERROR";int lines=0,matches=0;try(DirectoryStream<Path> ds=Files.newDirectoryStream(dir)){for(Path p:ds){System.out.println(p+" size="+Files.size(p));try(BufferedReader r=Files.newBufferedReader(p)){String s;while((s=r.readLine())!=null){lines++;if(s.contains(keyword))matches++;}}}}System.out.println("Lines="+lines+", matches="+matches);}
}
