package bt3;

public class Main {
    public static void main(String[] args) {
        SurgeryFeeDAO dao = new SurgeryFeeDAO();
        double cost = dao.getSurgeryFee(505);

        if (cost >= 0) {
            System.out.println("Chi phí phẫu thuật: " + cost);
        } else {
            System.out.println("Lỗi khi tra cứu chi phí.");
        }
    }
}

//Phần 1
//JDBC bắt buộc phải gọi registerOutParameter()
// trước khi thực thi vì hệ quản trị CSDL cần biết kiểu dữ liệu của
// tham số đầu ra để chuẩn bị vùng nhớ nhận giá trị trả về. Nếu không đăng ký,
// JDBC không biết phải đọc dữ liệu dưới dạng gì → gây lỗi “column index out of range” hoặc không
// lấy được kết quả.
//
//Nếu tham số OUT trong SQL là kiểu DECIMAL, thì trong Java phải đăng ký bằng hằng số Types.
// DECIMAL (trong lớp java.sql.Types).