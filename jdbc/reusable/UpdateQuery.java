package jdbc.reusable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateQuery {
    public static void main(String[] args) {
        try {

            Connection connection = ConnectionProvider.getConnectionProvider();
            String q = "UPDATE  book set author=?,cost=? where BKid=?";
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Author Name:");
            String author = br.readLine();
            System.out.println("Enter Price of book:");
            double cost=Double.parseDouble(br.readLine());
            System.out.println("Enter book id:");
            int BKid=Integer.parseInt(br.readLine());
            PreparedStatement pstmt=connection.prepareStatement(q);
            pstmt.setString(1,author);
            pstmt.setDouble(2,cost);
            pstmt.setInt(3,BKid);
            pstmt.executeUpdate();
            System.out.println("Done.....");

        }catch (Exception e){
            System.out.println(e);
        }

    }
}
