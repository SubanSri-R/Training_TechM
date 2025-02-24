package Task3;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task3_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = sc.nextLine();
        readFile(filePath);
        sc.close();
    }

    public static void readFile(String filePath) {
        FileReader reader = null;
        try {
            reader = new FileReader(filePath);
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("An error occurred while closing the file: " + e.getMessage());
            }
        }
    }
}
