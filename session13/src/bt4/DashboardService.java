package bt4;

import java.sql.*;
import java.util.*;

public class DashboardService {
    public List<BenhNhanDTO> layDanhSachBenhNhanCapCuu() {
        List<BenhNhanDTO> result = new ArrayList<>();
        Map<Integer, BenhNhanDTO> map = new HashMap<>();

        String sql = "SELECT b.maBenhNhan, b.tenBenhNhan, d.maDichVu, d.tenDichVu " +
                "FROM BenhNhan b " +
                "LEFT JOIN DichVuSuDung d ON b.maBenhNhan = d.maBenhNhan " +
                "WHERE b.khoa = 'CapCuu' AND b.ngayNhapVien = CURDATE()";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int maBN = rs.getInt("maBenhNhan");
                String tenBN = rs.getString("tenBenhNhan");

                // Nếu bệnh nhân chưa có trong map → tạo mới
                BenhNhanDTO bn = map.get(maBN);
                if (bn == null) {
                    bn = new BenhNhanDTO(maBN, tenBN);
                    map.put(maBN, bn);
                }

                // Bẫy 2: Nếu bệnh nhân chưa có dịch vụ, cột maDichVu sẽ null
                String tenDV = rs.getString("tenDichVu");
                if (tenDV != null) { // tránh NullPointerException
                    int maDV = rs.getInt("maDichVu");
                    bn.addDichVu(new DichVu(maDV, tenDV));
                }
            }

            result.addAll(map.values());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

