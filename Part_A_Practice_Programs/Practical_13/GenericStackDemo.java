import java.util.*;
class GenericStack<T>{private final List<T> data=new ArrayList<>();void push(T v){data.add(v);}T pop(){if(data.isEmpty())throw new NoSuchElementException("Stack is empty");return data.remove(data.size()-1);}boolean isEmpty(){return data.isEmpty();}}
public class GenericStackDemo {
    public static void main(String[] args){GenericStack<Integer> a=new GenericStack<>();a.push(10);a.push(20);System.out.println(a.pop());GenericStack<String>b=new GenericStack<>();b.push("Hello");System.out.println(b.pop());}
}
