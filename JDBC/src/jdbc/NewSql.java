package jdbc;

import java.sql.*;

public class NewSql {
    static String url = "jdbc:mysql://localhost:3306/product";
    static String username="root";
    static String password="$ubanSri@2004";
    public static void main(String[] args) throws SQLException {



        //selectRecords();
        //selectColumnFromRecords();
        //selectRecordsWithCondition();
        //selectRecordsWithExternalParameters(24);
        //selectRecordsWithPreparedStatement(1);
        //insertRecord();
         //insertRecordWithVariables(18,"SP",780,5);
         //insertRecordWithPreparedStatement(11,"MDH",670000,5);
        //deleteRecord();
        //deleteRecordWithVariables(3);
        //deleteRecordWithPreparedStatement(34);
        // updateRecord();
         //updateRecordWithVariables(4, 444);
        //updateRecordWithPreparedStatement(17, 880000);
    }
    public static void insertRecord() throws SQLException {

        String query = "insert into productdetails values(4, 'ddd',5895,8);";
        Connection connect = DriverManager.
                getConnection(url,username,password);
        Statement st = connect.createStatement();
        int row = st.executeUpdate(query);
        System.out.println("Number of rows affected:"
                +row);
        connect.close();
    }
    public static  void selectRecords() throws SQLException {
        String query = "select * from productdetails";
        //Step 1 - connect database
        Connection connection = DriverManager.
                getConnection(url,username, password);
        //Step 2 - Creating statement
        Statement stmt = connection.createStatement();
        //Step 3 - Executing query and Processing resultset
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()) {

            System.out.print("\nId is:" + rs.getInt(1));
            System.out.print("\nName is:" + rs.getString(2));
            System.out.print("\nPrice is:" + rs.getDouble(3));
            System.out.print("\nQuantity is:" + rs.getInt(4));
        }
        //Step 4 - Close connection
        connection.close();
    }
    public static  void selectColumnFromRecords() throws SQLException {

        String query = "select idproductdetails, pname, price from productdetails";
        //Step 1 - connect database
        Connection connection = DriverManager.
                getConnection(url,username, password);
        //Step 2 - Creating statement
        Statement stmt = connection.createStatement();
        //Step 3 - Executing query and Processing resultset
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()) {
            System.out.print("\nId is:" + rs.getInt(1));
            System.out.print("\nName is:" + rs.getString(2));
            System.out.print("\nPrice is:" + rs.getDouble(3));
        }
        //Step 4 - Close connection
        connection.close();
    }
    public static  void selectRecordsWithCondition() throws SQLException {

        String query = "select idproductdetails, pname, price from productdetails where idproductdetails=1;";
        //Step 1 - connect database
        Connection connection = DriverManager.
                getConnection(url,username, password);
        //Step 2 - Creating statement
        Statement stmt = connection.createStatement();
        //Step 3 - Executing query and Processing resultset
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()) {
            System.out.print("\nId is:" + rs.getInt(1));
            System.out.print("\nName is:" + rs.getString(2));
            System.out.print("\nPrice is:" + rs.getDouble(3));
        }
        //Step 4 - Close connection
        connection.close();
    }
    public static  void selectRecordsWithExternalParameters(int id) throws SQLException {

        // int eid = 24;
        // String query = "select emp_id, emp_name from employee " +
        //  "where emp_id=24";
        String query = "select idproductdetails, pname, price from productdetails " +
                "where idproductdetails="+1+";";
        //Step 1 - connect database
        Connection connection = DriverManager.
                getConnection(url,username, password);
        //Step 2 - Creating statement
        Statement stmt = connection.createStatement();
        //Step 3 - Executing query and Processing resultset
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()) {
            System.out.print("\nId is:" + rs.getInt(1));
            System.out.print("\nName is:" + rs.getString(2));
            System.out.print("\nPrice is:" + rs.getDouble(3));
        }
        //Step 4 - Close connection
        connection.close();
    }
    public static  void selectRecordsWithPreparedStatement(int id) throws SQLException {

        // int eid = 24;
        // String query = "select emp_id, emp_name from employee " +
        //  "where emp_id=24";
        //  String query = "select emp_id, emp_name from employee where emp_id=?";
        //Step 1 - connect database
        Connection connection = DriverManager.
                getConnection(url,username, password);
        //Step 2 - Creating statement
        PreparedStatement pstmt = connection.
                prepareStatement("select idproductdetails, pname from productdetails where idproductdetails=?");
        pstmt.setInt(1,id);
        ResultSet rs = pstmt.executeQuery();

        //Step 3 - Executing query and Processing resultset
        // ResultSet rs = pstmt.executeQuery(query);
        while(rs.next()) {
            System.out.print("\nId is:" + rs.getInt(1));
            System.out.print("\nName is:" + rs.getString(2));

        }
        //Step 4 - Close connection
        connection.close();
    }
    public static void insertRecordWithVariables(int id,
                                                 String  pname, double price,int quantity) throws SQLException {

        //String query = "insert into employee values(15, 'ABR',720000);";
        String query = "insert into productdetails values("+id+", '" + pname+"',"+price+","+quantity+");";
        Connection connect = DriverManager.
                getConnection(url,username,password);
        Statement st = connect.createStatement();
        System.out.println("Number of rows affected:"
                +st.executeUpdate(query));
        connect.close();
    }

    public static void insertRecordWithPreparedStatement(int id,
                                                         String  pname, int price,int quantity) throws SQLException {

        //String query = "insert into employee values(15, 'ABR',720000);";
        //String query = "insert into employee values("+id+", '" +
        //   name+"',"+salary+");";
        String query = "insert into productdetails values(?,?,?,?);";
        Connection connect = DriverManager.
                getConnection(url,username,password);
        PreparedStatement pst = connect.prepareStatement(query);
        pst.setInt(1,id);
        pst.setString(2,pname);
        pst.setInt(3,price);
        pst.setInt(4,quantity);
        System.out.println("Number of rows affected:"
                +pst.executeUpdate());
        connect.close();
    }
    public static void deleteRecord() throws SQLException {

        String query = "delete from productdetails where idproductdetails=1;";
        Connection connect = DriverManager.
                getConnection(url,username,password);
        Statement st = connect.createStatement();
        System.out.println("Number of rows affected:"
                +st.executeUpdate(query));
        connect.close();
    }
    public static void deleteRecordWithVariables(int idproductdetails) throws SQLException {

        // String query = "delete from employee where emp_id=11;";
        String query = "delete from productdetails where idproductdetails="
                +idproductdetails+";";
        Connection connect = DriverManager.
                getConnection(url,username,password);
        Statement st = connect.createStatement();
        System.out.println("Number of rows affected:"
                +st.executeUpdate(query));
        connect.close();
    }
    public static void deleteRecordWithPreparedStatement(int idproductdetails) throws SQLException {

        // String query = "delete from employee where emp_id=11;";
        // String query = "delete from employee where emp_id="
        // +id+";";
        String query = "delete from productdetails where idproductdetails=?;";
        Connection connect = DriverManager.
                getConnection(url,username,password);
        PreparedStatement pst = connect.prepareStatement(query);
        pst.setInt(1,idproductdetails);
        System.out.println("Number of rows affected:"
                +pst.executeUpdate());
        connect.close();
    }
    public static void updateRecord() throws SQLException {

        String query = "update productdetails set price=5000 where idproductdetails=11;";
        Connection connect = DriverManager.
                getConnection(url,username,password);
        Statement st = connect.createStatement();
        System.out.println("Number of rows affected:"
                +st.executeUpdate(query));
        connect.close();
    }
    public static void updateRecordWithVariables(int idproductdetails, int quantity) throws SQLException {

        //String query = "update employee set salary=800000 where emp_id=15;";
        String query = "update productdetails set quantity="+quantity+" where " +
                "idproductdetails="+idproductdetails+";";
        Connection connect = DriverManager.
                getConnection(url,username,password);
        Statement st = connect.createStatement();
        System.out.println("Number of rows affected:"
                +st.executeUpdate(query));
        connect.close();
    }
    public static void updateRecordWithPreparedStatement(int idproductdetails, double price) throws SQLException {

        //String query = "update employee set salary=800000 where emp_id=15;";
        //String query = "update employee set salary="+salary+" where " +
        // "emp_id="+id+";";
        String query = "update produtdetails set price=? where idproductdetails=?;";
        Connection connect = DriverManager.
                getConnection(url,username,password);
        PreparedStatement pst = connect.prepareStatement(query);
        pst.setDouble(1,price);
        pst.setInt(2,idproductdetails);
        System.out.println("Number of rows affected:"
                +pst.executeUpdate());
        connect.close();
    }

}
