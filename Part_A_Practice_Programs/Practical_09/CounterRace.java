class Counter { int value=0; synchronized void increment(){value++;} }
public class CounterRace {
    public static void main(String[] args)throws InterruptedException{Counter c=new Counter();Thread[] ts=new Thread[8];for(int i=0;i<ts.length;i++){ts[i]=new Thread(()->{for(int j=0;j<100000;j++)c.increment();});ts[i].start();}for(Thread t:ts)t.join();System.out.println("Counter: "+c.value+" (expected 800000)");}
}
