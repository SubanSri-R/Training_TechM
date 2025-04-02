
class ThreadComm {
    private int amount = 10000;
    synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is going to withdraw...");
        if (this.amount < amount) {
            System.out.println(Thread.currentThread().getName() + ": Insufficient balance, waiting for deposit...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.amount -= amount;
        System.out.println(Thread.currentThread().getName() + ": Withdrawal of " + amount + " completed.");
        System.out.println("Remaining balance: " + this.amount);
    }
    synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " is going to deposit...");
        this.amount += amount;
        System.out.println(Thread.currentThread().getName() + ": Deposit of " + amount + " completed.");
        System.out.println("Current balance: " + this.amount);
        notify();
    }
}

public class Task10_2 {
    public static void main(String args[]) {
        ThreadComm account = new ThreadComm();

        Thread withdrawThread = new Thread() {
            public void run() {
                account.withdraw(15000);
            }
        };

        Thread depositThread = new Thread() {
            public void run() {
                account.deposit(10000);
            }
        };
        withdrawThread.start();
        depositThread.start();
    }
}
