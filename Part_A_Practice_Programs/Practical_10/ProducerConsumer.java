import java.util.*;
public class ProducerConsumer {
    static class Buffer {Queue<Integer> q=new ArrayDeque<>();synchronized void put(int n)throws InterruptedException{while(q.size()==3)wait();q.add(n);System.out.println("Produced "+n);notifyAll();}synchronized int take()throws InterruptedException{while(q.isEmpty())wait();int n=q.remove();System.out.println("Consumed "+n);notifyAll();return n;} }
    public static void main(String[] args)throws Exception{Buffer b=new Buffer();Thread p=new Thread(()->{try{for(int i=1;i<=8;i++)b.put(i);}catch(Exception e){}});Thread c=new Thread(()->{try{for(int i=1;i<=8;i++)b.take();}catch(Exception e){}});p.start();c.start();p.join();c.join();}
}
