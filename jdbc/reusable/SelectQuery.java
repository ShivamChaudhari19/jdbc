package jdbc.reusable;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class SelectQuery {
    public static void main(String[] args) {
        try {
            Connection connection=ConnectionProvider.getConnectionProvider();
            String q="SELECT * FROM book";
            Statement stmt=connection.createStatement();
            ResultSet resultSet= stmt.executeQuery(q);
            System.out.println("Bkid | Title | Author | Cost | Date");
            while (resultSet.next()){
                int Bkid=resultSet.getInt(1);
                String title=resultSet.getNString(2);
                String author=resultSet.getNString(3);
                double cost=resultSet.getDouble(4);
                Date date=resultSet.getDate(5);
                System.out.println(Bkid+"|"+title+"|"+author+"|"+cost+"|"+date);
            }
            connection.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
