package src.bt2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PharmacyDAO {

    public void printPharmacyCatalogue() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();
            stmt = conn.createStatement();

            String sql = "SELECT medicine_name, stock FROM Pharmacy";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("medicine_name");
                int stock = rs.getInt("stock");

                System.out.println("Thuốc: " + name);
                System.out.println("Tồn kho: " + stock);
                System.out.println("--------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                DBContext.closeConnection(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}