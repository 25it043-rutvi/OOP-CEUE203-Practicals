import java.util.concurrent.CountDownLatch;

public class MiniBank {
    public static void main(String[] args) throws Exception {
        Account account = new Account("AC0001", 10000);
        TransactionProcessor processor = new TransactionProcessor();
        for (int i = 0; i < 20; i++) {
            final int taskId = i + 1;
            processor.submit(() -> {
                if (taskId % 2 == 0) account.deposit(100);
                else account.withdraw(50);
                System.out.println("Processed transaction " + taskId + " by " +
                        Thread.currentThread().getName());
            });
        }
        processor.stop();
        System.out.println("Balance after batch: " + account.getBalance());

        TransactionBuffer buffer = new TransactionBuffer();
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    final int value = i;
                    buffer.put(() -> System.out.println("Consumed transaction " + value));
                }
                buffer.finish();
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        Thread consumer = new Thread(() -> {
            try {
                Runnable task;
                while ((task = buffer.take()) != null) task.run();
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        producer.start(); consumer.start();
        producer.join(); consumer.join();

        Account a = new Account("AC0001", 5000);
        Account b = new Account("AC0002", 5000);
        Thread t1 = new Thread(() -> safeTransfer(a, b, 500));
        Thread t2 = new Thread(() -> safeTransfer(b, a, 500));
        t1.start(); t2.start(); t1.join(); t2.join();
        System.out.println("Deadlock-safe balances: " + a.getBalance() + ", " + b.getBalance());
    }

    private static void safeTransfer(Account from, Account to, long amount) {
        Account first = from.getAccountNumber().compareTo(to.getAccountNumber()) < 0 ? from : to;
        Account second = first == from ? to : from;
        synchronized (first) {
            synchronized (second) {
                if (from.withdraw(amount)) to.deposit(amount);
            }
        }
    }
}
