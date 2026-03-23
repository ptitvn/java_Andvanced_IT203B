package bt2;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class VitalsDAO {
    public boolean updateVitals(int patientId, double temperature, int heartrate) {
        String sql = "UPDATE Vitals SET temperature = ?, heartrate = ? WHERE p_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, temperature);
            pstmt.setInt(2, heartrate);
            pstmt.setInt(3, patientId);

            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

