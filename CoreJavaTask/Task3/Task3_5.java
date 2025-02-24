package Task3;
import java.io.File;
import java.util.Scanner;

public class Task3_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file/directory path:");
        String path = sc.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("The path points to a file.");
            }
            else if (file.isDirectory()) {
                System.out.println("The path points to a directory.");
            }
            else {
                System.out.println("The path exists, but it is neither a file nor a directory.");
            }
        } else {
            System.out.println("The file or directory does not exist.");
        }

        sc.close();
    }
}
