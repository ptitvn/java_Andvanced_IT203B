package HN_KS24_CNTT5_LeTrungDong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/flashsale_db?createDatabaseIfNotExist=true";
    private final static String USER = "root";
    private final static String PASSWORD = "123456";

    public static Connection openConnect() {
        Connection con;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}



