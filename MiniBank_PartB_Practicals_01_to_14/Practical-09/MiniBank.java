public class MiniBank {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account("AC0001", 0);
        Thread[] workers = new Thread[10];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Thread(new AccountWorker(account, 1000, 1), "Bank-Worker-" + (i + 1));
            workers[i].start();
        }
        for (Thread worker : workers) worker.join();
        System.out.println("Expected balance: 10000");
        System.out.println("Actual balance: " + account.getBalance());
    }
}
