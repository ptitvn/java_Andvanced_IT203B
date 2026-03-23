package bt1;

public class Main {
    public static void main(String[] args) {

        PatientDAO dao = new PatientDAO();

        System.out.println("=== DANH SÁCH BỆNH NHÂN ===");
        dao.getAllPatients();
    }
}
//Phần 1 – Phân tích (ngắn gọn)
//
//Việc khởi tạo kết nối liên tục mà không đóng sẽ gây rò rỉ tài nguyên (connection leak). Mỗi lần mở kết nối mới, hệ thống chiếm thêm tài nguyên nhưng không giải phóng, dẫn đến:
//
//Hết số lượng kết nối cho phép của database
//Hệ thống chạy chậm dần rồi bị treo
//Xuất hiện lỗi “Communications link failure”
//
//Đối với hệ thống y tế cần hoạt động 24/7, lỗi này rất nguy hiểm vì:
//
//Không truy xuất được hồ sơ bệnh nhân
//Gián đoạn quá trình khám chữa bệnh
//Ảnh hưởng trực tiếp đến người bệnh
//
//Vì vậy cần:
//
//Quản lý kết nối tập trung
//Luôn đóng kết nối sau khi sử dụng (trong finally)