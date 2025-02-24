package Task4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task4_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
//            System.out.println("enter file path");
//            String filename = sc.nextLine();
            String filename="example.txt";
            fileread(filename);
        } catch (FileNotFoundException e) {
            System.out.println("exception caught :" + e.getMessage());
        }
    }

    public static void fileread(String filename) throws FileNotFoundException
    {
        File file=new File(filename);
        if(!file.exists()){
            throw new FileNotFoundException(filename+" not Found");
        }
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}
