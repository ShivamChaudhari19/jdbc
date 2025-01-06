import java.sql.*;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;
public class CreateQuery {
    public static void main(String[] args) {
        try {

            Properties properties=new Properties();
            InputStream input=CreateQuery.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(input);
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url=properties.getProperty("db.url");
            String username=properties.getProperty("db.username");
            String password=properties.getProperty("db.password");
            Connection con=DriverManager.getConnection(url,username,password);
            String q="CREATE TABLE IF NOT EXISTS isbn("
                    +"register_date date,"
                    +" BKid int not null,"
                    +" isbnNo int not null unique,"
                    +" foreign key (BKid) references Book(BKid)"
                    +");";
            Statement stmt=con.createStatement();
            stmt.executeUpdate(q);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
