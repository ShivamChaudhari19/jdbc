import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class FristJDBC {
    public static void main(String[] args) {
        try {
            Properties properties=new Properties();
            InputStream input=FristJDBC.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(input);
            //load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");


            //creating connection
            String url=properties.getProperty("db.url");
            String username=properties.getProperty("db.username");
            String password=properties.getProperty("db.password");
            Connection con= DriverManager.getConnection(url,username,password);
            //check is connection created
            if (con.isClosed()){
                System.out.println("Connection not established");
            }else {
                System.out.println("Connection created");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
