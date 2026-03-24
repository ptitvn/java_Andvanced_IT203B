package bt4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DashboardService service = new DashboardService();
        List<BenhNhanDTO> ds = service.layDanhSachBenhNhanCapCuu();

        for (BenhNhanDTO bn : ds) {
            System.out.println(bn);
        }
    }
}

//Phân tích Input / Output
//Input: Không có tham số từ người dùng cuối, nhưng module cần lấy toàn bộ danh sách bệnh nhân trong ngày từ bảng BenhNhan và danh sách dịch vụ từ bảng DichVuSuDung.
//
//Output: Trả về List<BenhNhanDTO>, trong đó mỗi BenhNhanDTO chứa thông tin bệnh nhân + List<DichVu> (có thể rỗng nếu chưa dùng dịch vụ).
//
// Đề xuất 2 giải pháp JDBC
//Giải pháp 1 – N+1 Query (cách cũ, gây chậm)
//
//Truy vấn 1 lần để lấy danh sách bệnh nhân.
//
//Với mỗi bệnh nhân, lại truy vấn thêm 1 lần để lấy dịch vụ.
//
//Tổng cộng: 1 + N query → với 500 bệnh nhân = 501 query.
//
//Giải pháp 2 – JOIN + Grouping (tối ưu)
//
//Dùng LEFT JOIN giữa BenhNhan và DichVuSuDung.
//
//Lấy toàn bộ dữ liệu trong 1 query.
//
//Trên Java, duyệt ResultSet, gom nhóm dịch vụ theo maBenhNhan.
//
//Đảm bảo bệnh nhân chưa có dịch vụ vẫn hiện (nhờ LEFT JOIN).
//
//
//
//Tiêu chí| 	| Giải pháp 1 (N+1)	             |   Giải pháp 2 (JOIN + Grouping)
//Số query	    | 1 + N (501)	                 |  1 query duy nhất
//Network I/O   | Rất lớn, dễ nghẽn	             |   Nhỏ, tối ưu
//RAM xử lý	    | Ít phức tạp	                 |  Gom nhóm cần thêm map/danh sách
//Dễ code	    | Dễ hiểu, nhưng không tối ưu	 |  Phức tạp hơn chút, nhưng hiệu năng vượt trội
//Bẫy 2 	    | Có thể bỏ sót nếu không xử lý	 |  LEFT JOIN đảm bảo không mất dữ liệu