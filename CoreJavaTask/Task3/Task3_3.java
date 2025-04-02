package Task3;
import java.io.File;
import java.util.Scanner;

public class Task3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file/directory path:");
        String path = sc.nextLine();

        File file = new File(path);

        if (file.exists()) {
            System.out.println("The file or directory does exist.");
        } else {
            System.out.println("The file or directory does not exist.");
        }

        sc.close();
    }
}
