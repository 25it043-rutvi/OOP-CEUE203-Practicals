public class DeadlockDemo {
    public static void main(String[] args)throws InterruptedException{Object a=new Object(),b=new Object();Thread t1=new Thread(()->{synchronized(a){synchronized(b){System.out.println("T1 done");}}});Thread t2=new Thread(()->{synchronized(a){synchronized(b){System.out.println("T2 done");}}});t1.start();t2.start();t1.join();t2.join();System.out.println("Consistent lock order avoids deadlock.");}
}
