package bt2;

public class Main {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        service.thanhToanVienPhi(101, 5001, 200000);
        // Ví dụ: bệnh nhân ID=101, hóa đơn ID=5001, số tiền=200000
    }
}

//Phần 1:
//
//Trong đoạn code lỗi, lập trình viên chỉ in ra lỗi bằng System.out.println()
// khi gặp SQLException nhưng không rollback. Đây là vi phạm nguyên tắc Transaction vì:
//
//Transaction phải đảm bảo Atomicity: hoặc tất cả thao tác thành công, hoặc tất cả bị hủy.
//
//Nếu không rollback, dữ liệu tạm thời đã thay đổi vẫn “treo” trong kết nối,
// gây mất an toàn và ảnh hưởng đến các thao tác khác.
//
// Hành động thiết yếu bị bỏ quên chính là conn.rollback() để khôi phục cơ
// sở dữ liệu về trạng thái ban đầu trước khi lỗi xảy ra.