import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class DynamicInputInsertQuery {
    public static void main(String[] args) {
        try {
            InputStream input=DynamicInputInsertQuery.class.getClassLoader().getResourceAsStream("config.properties");
            Properties properties=new Properties();
            properties.load(input);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(properties.getProperty("db.url"),properties.getProperty("db.username"),properties.getProperty("db.password"));
            String q="INSERT INTO book(BKid,title,author,cost,DOB_publishing) values (?,?,?,?,?)";
            PreparedStatement pstmt=con.prepareStatement(q);
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Insert BKid:");
            int BKid=Integer.parseInt(br.readLine());
            System.out.println("Enter title of the book:");
            String title=br.readLine();
            System.out.println("Enter author of the book:");
            String author=br.readLine();
            System.out.println("Enter cost of the book:");
            int cost=Integer.parseInt(br.readLine());
            System.out.println("Enter date of publishing of the book 'YYYY-MM-dd':");
            String dateInput= br.readLine();
            java.sql.Date DOB_publishing =new java.sql.Date(
                    new SimpleDateFormat("yyyy-MM-dd").parse(dateInput).getTime());
            pstmt.setInt(1,BKid);
            pstmt.setString(2,title);
            pstmt.setString(3,author);
            pstmt.setInt(4,cost);
            pstmt.setDate(5,DOB_publishing);
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
