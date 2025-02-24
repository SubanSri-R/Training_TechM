package Task3;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class Task3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirpath = sc.nextLine();
        System.out.println("Enter file extension (e.g., .txt, .jpg):");
        String extension = sc.nextLine();

        File dir = new File(dirpath);
        if (dir.exists() && dir.isDirectory()) {
            String[] files = dir.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(extension.toLowerCase());
                }
            });
            if (files != null && files.length > 0) {
                System.out.println("Files with extension " + extension + " in " + dirpath + ":");
                for (String file : files) {
                    System.out.println(file);
                }
            } else {
                System.out.println("No files with extension " + extension + " found in the directory.");
            }
        } else {
            System.out.println("Directory doesn't exist or is not a valid directory.");
        }
        sc.close();
    }
}
