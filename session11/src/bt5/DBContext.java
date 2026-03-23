package bt5;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {

    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(">> Driver loaded");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}