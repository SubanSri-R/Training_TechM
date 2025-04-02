//package jdbc;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class Sql {
//    public static void main(String[] args) {
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/anime";
//            String username="root";
//            String password="$ubanSri@2004";
//
//            Connection conne=null;
//            Statement State=null;
//            ResultSet result=null;
//
//            conne= DriverManager.getConnection(url,username,password);
//            State= conne.createStatement();
//
//            String Query="SELECT * FROM Bleach";
//            result=State.executeQuery(Query);
//
//            while(result.next())
//            {
//                System.out.println(result.getString("Bankai"));
//            }
//
//        }catch (Exception e){
//            System.out.println(e);
//        }
//    }
//}
