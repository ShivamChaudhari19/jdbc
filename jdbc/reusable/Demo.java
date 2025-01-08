package jdbc.reusable;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo {


    public static void main(String[] args){
        Connection con= jdbc.reusable.Connection.getConnection();
        try {
            if (con.isClosed()){
                System.out.println("connection not established....");
            }else {
                System.out.println("connection establish...");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
