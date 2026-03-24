package bt2;

import java.sql.*;

public class PaymentService {
    public void thanhToanVienPhi(int patientId, int invoiceId, double amount) {
        Connection conn = null;
        try {
            conn = DatabaseManager.getConnection();
            conn.setAutoCommit(false);

            // Bước 1: Trừ tiền trong ví
            String sqlDeductWallet = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(sqlDeductWallet);
            ps1.setDouble(1, amount);
            ps1.setInt(2, patientId);
            ps1.executeUpdate();

            // Bước 2: Cập nhật trạng thái hóa đơn
            String sqlUpdateInvoice = "UPDATE Invoices SET status = 'PAID' WHERE invoice_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(sqlUpdateInvoice);
            ps2.setInt(1, invoiceId);
            ps2.executeUpdate();

            conn.commit(); // Commit nếu cả hai thành công
            System.out.println("Thanh toán hoàn tất!");
        } catch (SQLException e) {
            System.out.println("Lỗi hệ thống: " + e.getMessage());
            // Bổ sung rollback để khôi phục dữ liệu
            try {
                if (conn != null) conn.rollback();
                System.out.println("Đã rollback giao dịch, dữ liệu an toàn.");
            } catch (SQLException se) {
                System.out.println("Lỗi khi rollback: " + se.getMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
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
