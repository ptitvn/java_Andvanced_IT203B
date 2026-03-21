package src.bt4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PatientDAO {

    public void findPatientByName(String patientName) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Kiểm tra SQL Injection
            if (patientName.contains("'") ||
                    patientName.contains("--") ||
                    patientName.contains(";")) {

                System.out.println("Phát hiện SQL Injection! Không thực hiện truy vấn.");
                return;
            }

            conn = DBContext.getConnection();
            stmt = conn.createStatement();

            String sql = "SELECT * FROM Patients WHERE full_name = '" + patientName + "'";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Tên bệnh nhân: " + rs.getString("full_name"));
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