package Task10;
import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Task10_1 {
    static String username = "root";
    static String password = "$ubanSri@2004";
    static String url = "jdbc:mysql://localhost:3306/school";

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1: Insert a new Row");
            System.out.println("2: Update a Row");
            System.out.println("3: Delete a Row");
            System.out.println("4: Select rows");
            System.out.println("5: Exit");

            String choice = sc.nextLine().toLowerCase();

            switch (choice) {
                case "1":
                    insertRecord();
                    break;
                case "2":
                    updateRecord();
                    break;
                case "3":
                    deleteRecord();
                    break;
                case "4":
                    showRecord();
                    break;
                case "5":
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void insertRecord() throws SQLException {
        Scanner inp = new Scanner(System.in);

        System.out.println("How many rows do you want to insert?");
        int rows = inp.nextInt();
        inp.nextLine();

        String query = "INSERT INTO students (s_id, s_name, age) VALUES (?, ?, ?)";
        try (Connection connect = DriverManager.getConnection(url, username, password);
             PreparedStatement pst = connect.prepareStatement(query)) {
            insertRowsRecursively(pst, inp, rows);
        }
    }
    private static void insertRowsRecursively(PreparedStatement pst, Scanner inp, int rows) throws SQLException {
        if (rows <= 0) {
            return;
        }

        System.out.println("Enter student ID:");
        int s_id = inp.nextInt();
        inp.nextLine();
        System.out.println("Enter student name:");
        String s_name = inp.nextLine();
        System.out.println("Enter student age:");
        int age = inp.nextInt();
        inp.nextLine();

        pst.setInt(1, s_id);
        pst.setString(2, s_name);
        pst.setInt(3, age);

        pst.executeUpdate();
        System.out.println("Row inserted successfully!");

        insertRowsRecursively(pst, inp, rows - 1);
    }
    public static void updateRecord() throws SQLException {
        Scanner inp = new Scanner(System.in);

        System.out.println("Enter which student ID you want to update:");
        int s_id = inp.nextInt();
        inp.nextLine();
        System.out.println("Enter updated name:");
        String s_name = inp.nextLine();
        System.out.println("Enter updated age:");
        int age = inp.nextInt();
        inp.nextLine();

        String query = "UPDATE students SET s_name = ?, age = ? WHERE s_id = ?";
        try (Connection connect = DriverManager.getConnection(url, username, password);
             PreparedStatement pst = connect.prepareStatement(query)) {

            pst.setString(1, s_name);
            pst.setInt(2, age);
            pst.setInt(3, s_id);

            int rowsAffected = pst.executeUpdate();
            System.out.println("Number of rows affected: " + rowsAffected);
            showRecord();
        }
    }
    public static void deleteRecord() throws SQLException {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the ID of the student you want to delete:");
        int s_id = inp.nextInt();

        String query = "DELETE FROM students WHERE s_id = ?";
        try (Connection connect = DriverManager.getConnection(url, username, password);
             PreparedStatement pst = connect.prepareStatement(query)) {

            pst.setInt(1, s_id);

            int rowsAffected = pst.executeUpdate();
            System.out.println("Number of rows affected: " + rowsAffected);

            showRecord();
        }
    }
    public static void showRecord() throws SQLException {
        String query = "SELECT * FROM students";
        try (Connection connect = DriverManager.getConnection(url, username, password);
             Statement stmt = connect.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("s_id  s_name  age");
            while (rs.next()) {
                System.out.println(rs.getInt("s_id") + "     " + rs.getString("s_name") + "     " + rs.getInt("age"));
            }
        }
    }
}
