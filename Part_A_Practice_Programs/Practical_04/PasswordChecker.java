public class PasswordChecker {
    public static String strength(String pw){
        int n=0;if(pw.length()>=8)n++;if(pw.matches(".*[A-Z].*"))n++;if(pw.matches(".*[0-9].*"))n++;if(pw.matches(".*[^A-Za-z0-9].*"))n++;
        return n<=1?"Weak":n<=3?"Medium":"Strong";
    }
    public static void main(String[] args){for(String p:new String[]{"abc","Abcd1234!","hello123","HELLO"})System.out.println(p+" -> "+strength(p));}
}
