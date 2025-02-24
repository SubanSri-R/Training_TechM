package Task4;
import java.util.Scanner;

public class Task4_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a number to check odd or even");
        int num=sc.nextInt();
        try{
            checkeven(num);
        }
        catch (OddNumException e){
            System.out.println("exception caught :"+e.getMessage());
        }
    }

    public static void checkeven(int x)throws OddNumException{
        if(x%2==0){
            System.out.println("number is even");
        }
        else {
            throw new OddNumException("number is odd");
        }
    }
}

class OddNumException extends Exception
{
    public OddNumException (String error)
    {
        super(error);
}
}