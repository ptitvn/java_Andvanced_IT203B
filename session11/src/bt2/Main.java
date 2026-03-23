package bt2;

public class Main {
    public static void main(String[] args) {

        PharmacyDAO dao = new PharmacyDAO();

        dao.getAllMedicines();
    }
}
//
///*Phần 1 – Phân tích (ngắn gọn)
//
//Lệnh if (rs.next()) chỉ kiểm tra và xử lý một lần duy nhất, nên chỉ in ra dòng đầu tiên của kết quả, không thể dùng để in danh sách nhiều bản ghi.
//
//ResultSet hoạt động theo cơ chế con trỏ:
//
//Ban đầu con trỏ đứng trước dòng đầu tiên
//Mỗi lần gọi next() → con trỏ di chuyển xuống dòng tiếp theo
//Khi hết dữ liệu → next() trả về false
//
//Vì vậy, muốn duyệt toàn bộ dữ liệu phải dùng vòng lặp (while), không thể dùng if.*/