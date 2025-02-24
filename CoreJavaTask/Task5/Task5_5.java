package Task5;
import java.util.Scanner;

class PrimeSumThread extends Thread {
    private int start, end;
    private long[] sum;

    public PrimeSumThread(int start, int end, long[] sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
    }

    @Override
    public void run() {
        long localSum = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                localSum += i;
            }
        }

        synchronized (sum) {
            sum[0] += localSum;
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
public class Task5_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the upper limit: ");
        int n = sc.nextInt();
        sc.close();

        int numThreads = 4;
        int rangeSize = n / numThreads;

        long[] sum = new long[1];

        PrimeSumThread[] threads = new PrimeSumThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            int start = i * rangeSize + 1;
            int end = (i == numThreads - 1) ? n : (i + 1) * rangeSize;
            threads[i] = new PrimeSumThread(start, end, sum);
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("The sum of all prime numbers up to " + n + " is: " + sum[0]);
    }
}
