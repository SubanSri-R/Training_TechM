package Task8;

import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Task_8 {
    static String username = "root";
    static String password = "$ubanSri@2004";
    static String url = "jdbc:mysql://localhost:3306/company";

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

        String query = "INSERT INTO emp (e_id, e_name, e_phone, e_role) VALUES (?, ?, ?, ?)";
        try (Connection connect = DriverManager.getConnection(url, username, password);
             PreparedStatement pst = connect.prepareStatement(query)) {
            insertRowsRecursively(pst, inp, rows);
        }
    }
    private static void insertRowsRecursively(PreparedStatement pst, Scanner inp, int rows) throws SQLException {
        if (rows <= 0) {
            return;
        }

        System.out.println("Enter emp id:");
        int e_id = inp.nextInt();
        inp.nextLine();
        System.out.println("Enter emp name:");
        String e_name = inp.nextLine();
        System.out.println("Enter emp phone:");
        int e_phone = inp.nextInt();
        inp.nextLine();
        System.out.println("Enter emp role:");
        String e_role = inp.nextLine();

        pst.setInt(1, e_id);
        pst.setString(2, e_name);
        pst.setInt(3, e_phone);
        pst.setString(4, e_role);

        pst.executeUpdate();
        System.out.println("Row inserted successfully!");

        insertRowsRecursively(pst, inp, rows - 1);
    }

    public static void updateRecord() throws SQLException {
        Scanner inp = new Scanner(System.in);

        System.out.println("Enter which ID you want to update:");
        int e_id = inp.nextInt();
        inp.nextLine();
        System.out.println("Enter updated name:");
        String e_name = inp.nextLine();
        System.out.println("Enter updated phone number:");
        int e_phone = inp.nextInt();
        inp.nextLine();
        System.out.println("Enter updated role:");
        String e_role = inp.nextLine();

        String query = "UPDATE emp SET e_name = ?, e_phone = ?, e_role = ? WHERE e_id = ?";
        try (Connection connect = DriverManager.getConnection(url, username, password);
             PreparedStatement pst = connect.prepareStatement(query)) {

            pst.setString(1, e_name);
            pst.setInt(2, e_phone);
            pst.setString(3, e_role);
            pst.setInt(4, e_id);

            int rowsAffected = pst.executeUpdate();
            System.out.println("Number of rows affected: " + rowsAffected);
            showRecord();
        }
    }

    public static void deleteRecord() throws SQLException {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the ID of the row you want to delete:");
        int e_id = inp.nextInt();

        String query = "DELETE FROM emp WHERE e_id = ?";
        try (Connection connect = DriverManager.getConnection(url, username, password);
             PreparedStatement pst = connect.prepareStatement(query)) {

            pst.setInt(1, e_id);

            int rowsAffected = pst.executeUpdate();
            System.out.println("Number of rows affected: " + rowsAffected);

            showRecord();
        }
    }
    public static void showRecord() throws SQLException {
        String query = "SELECT * FROM emp";
        try (Connection connect = DriverManager.getConnection(url, username, password);
             Statement stmt = connect.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("e_id  e_name  e_phone  e_role");
            while (rs.next()) {
                System.out.println(rs.getInt("e_id") + "     " + rs.getString("e_name") +
                        "     " + rs.getInt("e_phone") + "    " + rs.getString("e_role"));
            }
        }
    }
}
