package src.bt3;

import java.sql.Connection;
import java.sql.Statement;

public class BedDAO {

    public void updateBedStatus(String bedId) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DBContext.getConnection();
            stmt = conn.createStatement();

            String sql = "UPDATE Beds SET bed_status = 'Occupied' WHERE bed_id = '" + bedId + "'";
            int rowsAffected = stmt.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("Cập nhật giường thành công!");
            } else {
                System.out.println("Không tồn tại mã giường!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                DBContext.closeConnection(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}