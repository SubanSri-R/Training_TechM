package Task5;
import java.util.Arrays;
import java.util.Scanner;

public class Task5_3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size of array");
        int size= sc.nextInt();
        int arr[]=new int[size];
        System.out.println("enter values");
        for(int i=0;i<size;i++){
            arr[i]= sc.nextInt();
        }
        System.out.println("Original Array: " + Arrays.toString(arr));
        Mergesort sortThread = new Mergesort(arr, 0, arr.length - 1);
        sortThread.start();

        try {
            sortThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sorted Array: " + Arrays.toString(arr));


    }
}
class Mergesort extends Thread{
    private int arr[];
    private int left;
    private int right;

    public Mergesort(int arr[],int left,int right){
        this.arr=arr;
        this.left=left;
        this.right=right;
    }
    public void run(){
        mergesort(arr,left,right);
    }
    private void mergesort(int []arr,int left,int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            Mergesort Sortleft = new Mergesort(arr, left, mid);
            Mergesort Sortright = new Mergesort(arr, mid + 1, right);

            Sortleft.start();
            Sortright.start();
            try {
                Sortleft.join();
                Sortright.join();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            merge(arr,left,mid,right);
        }
    }
    public void merge(int arr[],int left,int mid,int right)
    {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0, k = left;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }

    }
}
