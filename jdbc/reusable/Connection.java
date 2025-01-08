package jdbc.reusable;

import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

public class Connection {

    public static java.sql.Connection getConnection() {
        java.sql.Connection connection = null;
        try {
            InputStream inputStream = Connection.class.getClassLoader().getResourceAsStream("config.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.username"), properties.getProperty("db.password"));

        } catch (Exception e) {
            e.printStackTrace();

        }
        return connection;
    }
}
