package bt4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PatientDAO {

    // ===== HÀM LỌC INPUT =====
    public String sanitizeInput(String input) {
        if (input == null) return null;

        input = input.replace("'", "");
        input = input.replace("--", "");
        input = input.replace(";", "");

        return input;
    }

    // ===== TÌM KIẾM BỆNH NHÂN =====
    public void findPatientByName(String name) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();
            stmt = conn.createStatement();

            // LỌC INPUT
            name = sanitizeInput(name);

            String sql = "SELECT * FROM Patients WHERE full_name = '" + name + "'";

            rs = stmt.executeQuery(sql);

            System.out.println("=== KẾT QUẢ ===");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println("Tên: " + rs.getString("full_name"));
            }

            if (!found) {
                System.out.println("❌ Không tìm thấy bệnh nhân!");
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