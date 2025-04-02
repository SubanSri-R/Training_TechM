
package Task3;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Task3_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file path:");
        String path = sc.nextLine();
        File file = new File(path);

        if (file.exists()) {
            System.out.println("The file or directory does exist.");

            if (file.isFile()) {
                long lastModified = file.lastModified();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                String formattedDate = sdf.format(lastModified);
                System.out.println("Last modified date: " + formattedDate);
            }
            else if (file.isDirectory()) {
                System.out.println("It's a directory, not a file.");
            }
        } else {
            System.out.println("The file or directory does not exist.");
        }
        sc.close();
    }
}
