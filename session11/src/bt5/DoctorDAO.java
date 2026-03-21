package src.bt5;

import java.sql.*;

public class DoctorDAO {

    public void getAllDoctors() {
        String sql = "SELECT * FROM Doctors";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getString("doctor_id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("specialty"));
            }

        } catch (Exception e) {
            System.out.println("Lỗi lấy danh sách bác sĩ");
        }
    }

    public void addDoctor(Doctor doctor) {
        String sql = "INSERT INTO Doctors VALUES (?, ?, ?)";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, doctor.getId());
            ps.setString(2, doctor.getName());
            ps.setString(3, doctor.getSpecialty());

            ps.executeUpdate();
            System.out.println("Thêm bác sĩ thành công");

        } catch (Exception e) {
            System.out.println("Lỗi: Trùng mã hoặc dữ liệu sai");
        }
    }

    public void countBySpecialty() {
        String sql = "SELECT specialty, COUNT(*) AS total FROM Doctors GROUP BY specialty";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(rs.getString("specialty") + ": " + rs.getInt("total"));
            }

        } catch (Exception e) {
            System.out.println("Lỗi thống kê");
        }
    }
}