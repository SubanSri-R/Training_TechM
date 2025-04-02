package Task1;
import java.util.Scanner;

public class Task1_4
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter array size");
        int size=sc.nextInt();
        int[] array =new int[size];
        System.out.println("enter elements");
        for(int i=0;i<size;i++)
        {
            array[i]= sc.nextInt();
        }

        int[] destArray = new int[3];

        System.arraycopy(array, 2, destArray, 0, 3);

        // Output the destination array after copying
        System.out.println("Destination Array after copying the range: ");
        for (int i : destArray) {
            System.out.print(i + " ");
        }
    }
}
