package Task3;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Task3_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file path:");
        String path = sc.nextLine();

        byte[] fileContent = readFileToByteArray(path);
        if (fileContent != null) {
            System.out.println("File content in bytes :");
            for (byte b : fileContent) {
                System.out.format("%02X ", b);
            }
        }
    }
    public static byte[] readFileToByteArray(String filePath) {
        File file = new File(filePath);
        byte[] fileContent = null;

        if (file.exists() && file.isFile()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                long fileSize = file.length();

                fileContent = new byte[(int) fileSize];
                fis.read(fileContent);
                System.out.println("File read successfully!");
            } catch (IOException e) {
                System.err.println("An error occurred while reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("The specified file does not exist.");
        }
        return fileContent;
    }
}
