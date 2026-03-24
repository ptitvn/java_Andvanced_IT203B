package bt3;

import java.sql.*;

public class HospitalService {
    public void xuatVienVaThanhToan(int maBenhNhan, double tienVienPhi) {
        Connection conn = null;
        try {
            conn = DatabaseManager.getConnection();
            conn.setAutoCommit(false); // Gom 3 thao tác vào 1 transaction

            // Bước 1: Kiểm tra số dư (Bẫy 1: Thiếu tiền)
            String sqlCheckBalance = "SELECT balance FROM Patient_Wallet WHERE patient_id = ?";
            PreparedStatement psCheck = conn.prepareStatement(sqlCheckBalance);
            psCheck.setInt(1, maBenhNhan);
            ResultSet rs = psCheck.executeQuery();

            if (!rs.next()) {
                throw new Exception("Bẫy 2: Bệnh nhân không tồn tại!");
            }

            double balance = rs.getDouble("balance");
            if (balance < tienVienPhi) {
                throw new Exception("Bẫy 1: Số dư không đủ để thanh toán!");
            }

            // Bước 2: Trừ tiền viện phí
            String sqlDeduct = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(sqlDeduct);
            ps1.setDouble(1, tienVienPhi);
            ps1.setInt(2, maBenhNhan);
            if (ps1.executeUpdate() == 0) {
                throw new Exception("Bẫy 2: Không trừ được tiền (RowAffected=0)");
            }

            // Bước 3: Giải phóng giường bệnh
            String sqlFreeBed = "UPDATE Beds SET status = 'Trống' WHERE patient_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(sqlFreeBed);
            ps2.setInt(1, maBenhNhan);
            if (ps2.executeUpdate() == 0) {
                throw new Exception("Bẫy 2: Không cập nhật giường bệnh (RowAffected=0)");
            }

            // Bước 4: Cập nhật trạng thái bệnh nhân
            String sqlUpdatePatient = "UPDATE Patients SET status = 'Đã xuất viện' WHERE patient_id = ?";
            PreparedStatement ps3 = conn.prepareStatement(sqlUpdatePatient);
            ps3.setInt(1, maBenhNhan);
            if (ps3.executeUpdate() == 0) {
                throw new Exception("Bẫy 2: Không cập nhật trạng thái bệnh nhân (RowAffected=0)");
            }

            // Nếu tất cả thành công
            conn.commit();
            System.out.println("Xuất viện và thanh toán thành công!");

        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra: " + e.getMessage());
            try {
                if (conn != null) conn.rollback(); // Rollback toàn bộ
                System.out.println("Đã rollback, dữ liệu an toàn.");
            } catch (SQLException se) {
                System.out.println("Lỗi rollback: " + se.getMessage());
            }
        } finally {
            try {
                if (conn != null) conn.setAutoCommit(true);
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

