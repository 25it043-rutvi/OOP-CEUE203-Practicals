import java.util.concurrent.*;

public class TransactionProcessor {
    private final ExecutorService executor = Executors.newFixedThreadPool(4);
    public void submit(Runnable task) { executor.execute(task); }
    public void stop() throws InterruptedException {
        executor.shutdown();
        if (!executor.awaitTermination(30, TimeUnit.SECONDS)) executor.shutdownNow();
    }
}
