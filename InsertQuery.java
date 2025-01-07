import java.io.BufferedReader;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class InsertQuery {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            InputStream input =InsertQuery.class.getClassLoader().getResourceAsStream("config.properties");
            Properties properties =new Properties();
            properties.load(input);
            String url=properties.getProperty("db.url");
            String username=properties.getProperty("db.username");
            String password=properties.getProperty("db.password");
            Connection con=DriverManager.getConnection(url,username,password);
            if (con.isClosed()) {
                System.out.println("Connection is not created");
            }else {
                System.out.println("Connection is create......\n");
            }
            String q="insert into book(BKid,title,author,cost,DOB_publishing) values (3,'Database System','unknown',200,'2024-12-1')";
            Statement stmt=con.prepareStatement(q);
            stmt.executeUpdate(q);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
