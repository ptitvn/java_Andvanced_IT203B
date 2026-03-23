package bt2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PharmacyDAO {

    public void getAllMedicines() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();
            stmt = conn.createStatement();

            String sql = "SELECT medicine_name, stock FROM Pharmacy";
            rs = stmt.executeQuery(sql);

            System.out.println("=== DANH MỤC THUỐC ===");

            boolean hasData = false;

            while (rs.next()) {
                hasData = true;

                String name = rs.getString("medicine_name");
                int stock = rs.getInt("stock");

                System.out.println("Thuốc: " + name + " | Tồn kho: " + stock);
            }

            if (!hasData) {
                System.out.println("Kho không có thuốc nào!");
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