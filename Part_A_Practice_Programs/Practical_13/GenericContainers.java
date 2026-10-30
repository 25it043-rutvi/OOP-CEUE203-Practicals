class Box<T>{private T value;void set(T v){value=v;}T get(){return value;}}
record Pair<A,B>(A first,B second){}
public class GenericContainers {
    static <T>T first(T[] a){return a[0];}
    public static void main(String[] args){Box<String>b=new Box<>();b.set("Java");Pair<Integer,String>p=new Pair<>(1,"one");String[] names={"Riya","Aman"};System.out.println(b.get());System.out.println(p);System.out.println(first(names));}
}
