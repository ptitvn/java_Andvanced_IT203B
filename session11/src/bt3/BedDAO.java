package bt3;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BedDAO {

    public void updateBedStatus(int bedId) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBContext.getConnection();

            String sql = "UPDATE Beds SET bed_status = ? WHERE bed_id = ?";
            ps = conn.prepareStatement(sql);

            ps.setString(1, "Occupied"); // Đang sử dụng
            ps.setInt(2, bedId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println(" Cập nhật trạng thái giường thành công!");
            } else {
                System.out.println("Mã giường không tồn tại!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                DBContext.closeConnection(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}