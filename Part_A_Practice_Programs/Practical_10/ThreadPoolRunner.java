import java.util.concurrent.*;
public class ThreadPoolRunner {
    public static void main(String[] args)throws InterruptedException{ExecutorService pool=Executors.newFixedThreadPool(3);for(int i=1;i<=10;i++){final int id=i;pool.submit(()->{try{Thread.sleep(100);}catch(InterruptedException e){Thread.currentThread().interrupt();}System.out.println("Task "+id+" on "+Thread.currentThread().getName());});}pool.shutdown();pool.awaitTermination(1,TimeUnit.MINUTES);}
}
