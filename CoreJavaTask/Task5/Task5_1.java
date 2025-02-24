package Task5;
public class Task5_1 {
    public static void main(String[] args) {
        thread t1=new thread();
        t1.run();
    }
}
class thread extends Thread{
    public void run()
    {
        System.out.println("Hello, Java!");
    }
}
