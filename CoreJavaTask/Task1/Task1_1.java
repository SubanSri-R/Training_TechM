package Task1;
import java.util.Scanner;

public class Task1_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the array size");
        int size= sc.nextInt();
        int arr[]=new int[size];
        System.out.println("enter elements");
        for(int i=0;i<size;i++){
            arr[i]= sc.nextInt();
        }
        int outarr[]=new int[(size+1)/2];
        int j=0;
        for(int i=0; i<size;i+=2)
        {
            outarr[j++]=arr[i];
        }
        for(int elements:outarr){
            System.out.println(elements+"");
        }
    }
}
