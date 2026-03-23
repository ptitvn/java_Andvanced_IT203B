package bt1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoctorLoginDAO {
    public boolean login(String code, String pass) {
        String sql = "SELECT * FROM Doctors WHERE code = ? AND pass = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, code);
            pstmt.setString(2, pass);

            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Có bản ghi -> đăng nhập thành công
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
