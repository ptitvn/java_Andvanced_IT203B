package btth.service;

import btth.utils.DatabaseConnection;

import java.sql.*;

public class ReportService {

    public void getTopBuyers() {
        String sql = "{CALL SP_GetTopBuyers()}";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            ResultSet rs = cs.executeQuery();

            System.out.println("=== TOP BUYERS ===");
            while (rs.next()) {
                System.out.println("User: " + rs.getInt("user_id")
                        + " | Orders: " + rs.getInt("total_orders"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getRevenueByCategory(int categoryId) {
        String sql = "{? = CALL FUNC_CategoryRevenue(?)}";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.registerOutParameter(1, Types.DOUBLE);
            cs.setInt(2, categoryId);

            cs.execute();

            System.out.println("Revenue = " + cs.getDouble(1));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}