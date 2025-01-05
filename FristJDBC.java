import java.sql.*;
public class FristJDBC {
    public static void main(String[] args) {
        try {
            //load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");


            //creating connection
            String url="jdbc:mysql://localhost:3306/book";
            String username="root";
            String password="shivam";
            Connection con= DriverManager.getConnection(url,username,password);
            //check is connection created
            if (con.isClosed()){
                System.out.println("Connection not established");
            }else {
                System.out.println("Connection created");
            }

            //

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
