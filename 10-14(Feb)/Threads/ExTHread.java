package Threads;

public class ExTHread {
    public static void main(String[] args)
    {
    ThreadTwo t1=new ThreadTwo();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t1);
    thread1.start();
    thread2.start();
    }
}
class ThreadTwo extends Thread{
    public void run(){
        System.out.println("From Threads.ThreadTwo!");
        System.out.println("From Threads.ThreadTwo!");
        System.out.println(10 / 0);
    }
}