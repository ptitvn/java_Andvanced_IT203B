package bt1;

public class Main {
    public static void main(String[] args) {
        MedicineService service = new MedicineService();
        service.capPhatThuoc(1, 101);
    }
}

//Phần 1 – Phân tích logic
//Trong JDBC, chế độ mặc định là Auto-Commit = true. Điều này có nghĩa là:
//
//Mỗi câu lệnh SQL (executeUpdate) được thực thi sẽ tự động được commit ngay
// lập tức vào cơ sở dữ liệu.
//
//Khi bạn chạy câu lệnh UPDATE Medicine_Inventory, kết quả (trừ thuốc trong kho) được
// ghi nhận ngay và không thể quay lại.
//
//Sau đó, khi xảy ra lỗi (int x = 10/0),
// chương trình dừng trước khi thực hiện câu lệnh INSERT Prescription_History.
// Vì Auto-Commit đã commit thao tác đầu tiên, nên dữ liệu trong kho đã thay đổi,
// nhưng lịch sử bệnh án không được ghi.