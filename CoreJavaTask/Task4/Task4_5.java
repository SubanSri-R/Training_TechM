package Task4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task4_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
//            System.out.println("enter file path");
//            String filename = sc.nextLine();
            String filename="example2.txt";
            fileread(filename);
        } catch (FileEmptyException e) {
            System.out.println("exception caught :" + e.getMessage());
        }
        catch (FileNotFoundException e){
            System.out.println("exception caught :" + e.getMessage());
        }
    }

    public static void fileread(String filename) throws FileEmptyException,FileNotFoundException
    {
        File file=new File(filename);
        if(!file.exists()){
            throw new FileNotFoundException(filename+" not Found");
        }
        try (Scanner scanner = new Scanner(file))
        {
            if(!scanner.hasNext()) {
                throw new FileEmptyException("File "+filename+" is empty");
            }
            System.out.println("File content read successfully.");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
        }

    }
    }
}
class FileEmptyException extends Exception{
    public FileEmptyException(String error){
        super(error);
    }
}
