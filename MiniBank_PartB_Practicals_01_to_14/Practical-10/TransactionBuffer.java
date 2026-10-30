import java.util.LinkedList;
import java.util.Queue;

public class TransactionBuffer {
    private final Queue<Runnable> queue = new LinkedList<>();
    private boolean finished = false;

    public synchronized void put(Runnable task) throws InterruptedException {
        queue.add(task);
        notifyAll();
    }
    public synchronized Runnable take() throws InterruptedException {
        while (queue.isEmpty() && !finished) wait();
        return queue.poll();
    }
    public synchronized void finish() { finished = true; notifyAll(); }
}
