package bt1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientDAO {

    public void getAllPatients() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();

            String sql = "SELECT * FROM Patient";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng theo thứ tự ngược
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                DBContext.closeConnection(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}