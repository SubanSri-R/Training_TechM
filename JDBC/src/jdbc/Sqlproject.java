package jdbc;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class Sqlproject  {
    static String username="root";
    static String password="$ubanSri@2004";
    static String url = "jdbc:mysql://localhost:3306/company";

    Connection conne=null;
    Statement State=null;
    ResultSet result=null;



    public static void main(String[] args) throws SQLException{

        while(true){
        System.out.println("enter your choice\n 1:Select\n 2:Insert\n 3:Update\n 4:Delete");

        Scanner sc=new Scanner(System.in);
        //String choice= sc.nextInt();
        String choice = sc.nextLine().toLowerCase();

            switch(choice){
                //case 1:
                case "select":
                {
                    ShowRecord();
                    break;

                }
                //case 2:
                case "insert":
                {
                    insertRecord();
                    break;
                }
                //case 3:
                case "update":
                {
                    updateRecord();
                    break;
                }
                //case 4:
                case "delete":
                {
                    deleteRecord();
                    break;
                }
            }


        }

    }
   public static void ShowRecord()throws SQLException{
       String query = "select * from emp";
       Connection connect = DriverManager.
               getConnection(url,username, password);

       Statement stmt = connect.createStatement();

       ResultSet rs = stmt.executeQuery(query);

       System.out.println("e_id" + " " + "e_name"+ " "+ "e_phone"+" "+"e_role");
       while(rs.next()) {
//
//           System.out.print("\nId is:" + rs.getInt(1));
//           System.out.print("\nName is:" + rs.getString(2));
//           System.out.print("\nphone is:" + rs.getDouble(3));
//           System.out.print("\nrole is:" + rs.getInt(4));
           System.out.println(rs.getInt("e_id") + " " + rs.getString("e_name")+
                   " "+ rs.getInt("e_phone")+" "+rs.getString("e_role"));
       }
//Step 4 - Close connection
       connect.close();


   }
    public static void insertRecord() throws SQLException {

        //String query = "insert into employee values(15, 'ABR',720000);";
        Scanner inp=new Scanner(System.in);

        System.out.println("enter emp id");
        int e_id=inp.nextInt();
        System.out.println("enter emp name");
        String e_name=inp.next();
        System.out.println("enter emp phone");
        int e_phone=inp.nextInt();
        System.out.println("enter emp role");
        String e_role=inp.next();

        String query = "insert into emp values("+e_id+",'"+ e_name+"',"+e_phone+",'"+e_role+"');";

        Connection connect = DriverManager.
                getConnection(url,username,password);
        Statement st = connect.createStatement();

        System.out.println("Number of rows affected:"
                +st.executeUpdate(query));
        ShowRecord();
        connect.close();
    }
    public static void updateRecord() throws SQLException {

        Scanner inp1=new Scanner(System.in);
        System.out.println("enter which id you want to update");
        int e_id=inp1.nextInt();
        System.out.println("enter updated name");
        String e_name=inp1.next();
        System.out.println("enter update number");
        int e_phone=inp1.nextInt();
        System.out.println("enter updated role ");
        String e_role=inp1.next();


        String query = "update emp set e_name='"+e_name+"',e_phone="+e_phone+",e_role='"+e_role+"' where " +
                "e_id="+e_id+";";
        Connection connect = DriverManager.
                getConnection(url,username,password);
        Statement st = connect.createStatement();

        System.out.println("Number of rows affected:"
                +st.executeUpdate(query));
        ShowRecord();
        connect.close();
    }
    public static void deleteRecord() throws SQLException {

        Scanner inp2=new Scanner(System.in);
        System.out.println("enter which id you want to delete");
        int e_id=inp2.nextInt();
//        String query = "delete from emp where e_id="+e_id+";";
        String query = "DELETE FROM emp WHERE e_id = ?";
        Connection connect = DriverManager.getConnection(url,username,password);
//        Statement st = connect.createStatement();
        PreparedStatement pst = connect.prepareStatement(query);
        pst.setInt(1, e_id);
        ShowRecord();
        int rowsAffected = pst.executeUpdate();
        System.out.println("Number of rows affected: " + rowsAffected);
        connect.close();
    }

}
