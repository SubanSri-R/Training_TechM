package Task5;
import java.util.Scanner;

class MatrixMultiplicationThread extends Thread {
    private int[][] A, B, C;
    private int row, col;

    public MatrixMultiplicationThread(int[][] A, int[][] B, int[][] C, int row, int col) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.row = row;
        this.col = col;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int k = 0; k < A[0].length; k++) {
            sum += A[row][k] * B[k][col];
        }
        C[row][col] = sum;
    }
}

public class Task5_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows in Matrix A: ");
        int m = sc.nextInt();
        System.out.print("Enter the number of columns in Matrix A (also rows of Matrix B): ");
        int n = sc.nextInt();
        System.out.print("Enter the number of columns in Matrix B: ");
        int p = sc.nextInt();

        int[][] A = new int[m][n];
        System.out.println("Enter elements of Matrix A:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "]: ");
                A[i][j] = sc.nextInt();
            }
        }

        int[][] B = new int[n][p];
        System.out.println("Enter elements of Matrix B:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                System.out.print("B[" + i + "][" + j + "]: ");
                B[i][j] = sc.nextInt();
            }
        }

        int[][] C = new int[m][p];

        Thread[][] threads = new Thread[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                threads[i][j] = new MatrixMultiplicationThread(A, B, C, i, j);
                threads[i][j].start();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                try {
                    threads[i][j].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Resulting Matrix (C):");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
