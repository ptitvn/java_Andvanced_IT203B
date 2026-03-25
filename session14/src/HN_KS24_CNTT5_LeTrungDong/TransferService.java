package HN_KS24_CNTT5_LeTrungDong;

import java.sql.*;

public class TransferService {
    public void transfer(String fromId, String toId, double amount) {
        Connection conn = null;
        try {
            conn = DataConnect.openConnect();
            conn.setAutoCommit(false);

            // 1. Kiểm tra số dư
            PreparedStatement checkStmt = conn.prepareStatement(
                    "SELECT Balance FROM Accounts WHERE AccountId = ?");
            checkStmt.setString(1, fromId);
            ResultSet rs = checkStmt.executeQuery();
            if (!rs.next() || rs.getDouble("Balance") < amount) {
                throw new SQLException("Số dư không đủ!");
            }

            // 2. Trừ tiền
            CallableStatement cs1 = conn.prepareCall("{call sp_UpdateBalance(?, ?)}");
            cs1.setString(1, fromId);
            cs1.setDouble(2, -amount);
            cs1.execute();

            // 3. Cộng tiền
            CallableStatement cs2 = conn.prepareCall("{call sp_UpdateBalance(?, ?)}");
            cs2.setString(1, toId);
            cs2.setDouble(2, amount);
            cs2.execute();

            // 4. Commit nếu thành công
            conn.commit();

            // 5. Hiển thị kết quả
            PreparedStatement showStmt = conn.prepareStatement("SELECT * FROM Accounts");
            ResultSet result = showStmt.executeQuery();
            System.out.println("===== Kết quả sau chuyển khoản =====");
            while (result.next()) {
                Account acc = new Account(
                        result.getString("AccountId"),
                        result.getString("FullName"),
                        result.getDouble("Balance")
                );
                System.out.println(acc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback(); // rollback trên chính connection đang dùng
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
