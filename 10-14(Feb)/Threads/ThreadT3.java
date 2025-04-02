package Threads;

public class ThreadT3 {
    public static void main(String[] args) {
        // Creating and starting three separate Threads.ThreadThree instances
        ThreadThree threadThree1 = new ThreadThree();
        ThreadThree threadThree2 = new ThreadThree();
        ThreadThree threadThree3 = new ThreadThree();

        Thread t1 = new Thread(threadThree1);
        Thread t2 = new Thread(threadThree2);
        Thread t3 = new Thread(threadThree3);

        t1.start();
        t2.start();
        t3.start();

        // Creating and starting Threads.ThreadOne instance
        ThreadOnee tt1 = new ThreadOnee();
        Thread threadt1 = new Thread(tt1);
        threadt1.start();

        // Creating and starting two separate Threads.ThreadTwo instances
        ThreadTwoo tt2 = new ThreadTwoo();
        Thread threadt2 = new Thread(tt2);
        Thread threadt22 = new Thread(tt2);

        threadt2.start();
        threadt22.start();
    }
}

class ThreadThree implements Runnable {
    public void run() {
        System.out.println("From Threads.ThreadThree!");
        System.out.println("From Threads.ThreadThree!");
        System.out.println("From Threads.ThreadThree!");
        System.out.println("From Threads.ThreadThree!");
        System.out.println("From Threads.ThreadThree!");
    }
}

class ThreadOnee implements Runnable {
    public void run() {
        System.out.println("From ThreadRunnableOne!");
        System.out.println("From ThreadRunnableOne!");
    }
}

class ThreadTwoo implements Runnable {
    public void run() {
        System.out.println("From ThreadRunnableTwo!");
        System.out.println("From ThreadRunnableTwo!");
        System.out.println("From ThreadRunnableTwo!");
    }
}
