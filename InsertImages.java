import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class InsertImages {

    public static void main(String[] args) {
        try(InputStream inputStream=InsertImages.class.getClassLoader().getResourceAsStream("config.properties");
            FileInputStream fileInputStream=new FileInputStream("pics/prof.JPG");
            ) {
                Properties properties=new Properties();
                properties.load(inputStream);
                Class.forName("com.mysql.cj.jdbc.Driver");
                try(Connection con=DriverManager.getConnection(
                        properties.getProperty("db.url"),
                        properties.getProperty("db.username"),
                        properties.getProperty("db.password"))
                ){
                    String q="INSERT INTO images(pic) values(?)";
                    PreparedStatement pstmt=con.prepareStatement(q);
                    pstmt.setBinaryStream(1,fileInputStream,fileInputStream.available());
                    pstmt.executeUpdate();
                    System.out.println("Pic is saved in database.......");
                }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
