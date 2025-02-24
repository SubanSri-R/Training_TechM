package Task3;
import java.io.File;
import java.util.Scanner;

public class Task3_8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file path:");
        String path = sc.nextLine();
        File file = new File(path);

        if (file.exists() && file.isFile()) {
            long fileSizeinBytes = file.length();

            double fileSizeinKB = fileSizeinBytes / 1024.0;
            double fileSizeinMB = fileSizeinKB / 1024.0;

            System.out.println("File Size in Bytes: " + fileSizeinBytes + " bytes");
            System.out.println("File Size in KB: " + String.format("%.2f", fileSizeinKB) + " KB");
            System.out.println("File Size in MB: " + String.format("%.2f", fileSizeinMB) + " MB");
        } else {
            System.out.println("The specified file does not exist.");
        }
    }
}
