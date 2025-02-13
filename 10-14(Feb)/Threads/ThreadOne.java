package Threads;

public class ThreadOne {
    public static void main(String[] args) {
        ST1Thread1 t1 = new ST1Thread1();
        t1.start();
    }
}

class ST1Thread1 extends Thread {
    public void run() {
        System.out.println("Threads.ST1Thread1");
        System.out.println("Threads.ST1Thread1");
        System.out.println("Threads.ST1Thread1");
    }
}


