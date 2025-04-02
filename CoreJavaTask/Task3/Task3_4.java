package Task3;
import java.io.File;
import java.util.Scanner;

public class Task3_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the file or directory path:");
        String path = sc.nextLine();

        File file = new File(path);

        if (file.exists()) {
            boolean canRead = file.canRead();
            boolean canWrite = file.canWrite();
            System.out.println("The file/directory exists.");

            if (canRead) {
                System.out.println("It has read permissions.");
            } else {
                System.out.println("It doesn't have read permissions.");
            }
            if
            (canWrite) {
                System.out.println("It has write permissions.");
            } else {
                System.out.println("It doesn't have write permissions.");
            }

        }
        else {
            System.out.println("The file or directory does not exist.");
        }
        sc.close();
    }
}
