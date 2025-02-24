package Task3;
import java.io.File;
import java.util.Scanner;

public class Task3_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter directory path");
        String dirpath=sc.nextLine();
        File dir=new File(dirpath);
        if(dir.exists() &&dir.isDirectory()){
            String dirval[]=dir.list();

            if (dirval!=null){
                System.out.println("values in "+dirpath+" are");
                for (String fileOrDir : dirval) {
                    System.out.println(fileOrDir);
                }
            }
            else
            {
                System.out.println("empty directory");
            }
        }
        else {
            System.out.println("directory doesn't exist");
        }
        sc.close();
    }
}
