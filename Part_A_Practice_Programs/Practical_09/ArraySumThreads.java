public class ArraySumThreads {
    static long total=0;static final Object lock=new Object();
    public static void main(String[] args)throws InterruptedException{int[] a=new int[100000];java.util.Arrays.fill(a,1);Thread[] ts=new Thread[4];for(int k=0;k<4;k++){final int start=k*a.length/4,end=(k+1)*a.length/4;ts[k]=new Thread(()->{long local=0;for(int i=start;i<end;i++)local+=a[i];synchronized(lock){total+=local;}});ts[k].start();}for(Thread t:ts)t.join();System.out.println("Sum: "+total);}
}
