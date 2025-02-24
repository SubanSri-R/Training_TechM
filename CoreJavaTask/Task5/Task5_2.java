package Task5;
public class Task5_2 {
    public static void main(String[] args) {
        Odd odd=new Odd();
        Even even=new Even();

        odd.start();
        even.start();
    }
}
class Odd extends Thread{
    public void run(){
        for(int i=1;i<=20;i++)
        {
            if(i%2!=0){
                System.out.println("odd :"+i);
            }
        }
    }
}
class Even extends Thread{
    public void run(){
        for(int i=1;i<=20;i++)
        {
            if(i%2==0){
                System.out.println("even :"+i);
            }
        }
    }
}