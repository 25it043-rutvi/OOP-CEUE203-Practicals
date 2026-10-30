import java.io.*;
class Student implements Serializable {private static final long serialVersionUID=1L;String name;transient String password;Student(String n,String p){name=n;password=p;}public String toString(){return name+" / password="+password;} }
public class SerializationDemo {
    public static void main(String[] args)throws Exception{Student[] a={new Student("Riya","secret"),new Student("Aman","1234")};try(ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("students.dat"))){o.writeObject(a);}try(ObjectInputStream in=new ObjectInputStream(new FileInputStream("students.dat"))){Student[] b=(Student[])in.readObject();for(Student s:b)System.out.println(s);}}
}
