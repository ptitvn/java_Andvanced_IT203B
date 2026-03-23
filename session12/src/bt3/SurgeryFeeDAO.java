package bt3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class SurgeryFeeDAO {
    public double getSurgeryFee(int surgeryId) {
        String sql = "{call GET_SURGERY_FEE(?, ?)}";
        try (Connection conn = DBConnection.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {

            // Tham số IN
            cstmt.setInt(1, surgeryId);

            // Tham số OUT (DECIMAL trong SQL)
            cstmt.registerOutParameter(2, Types.DECIMAL);

            // Thực thi
            cstmt.execute();

            // Lấy kết quả OUT
            return cstmt.getDouble(2);

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
