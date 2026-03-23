package bt1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã bác sĩ: ");
        String code = sc.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String pass = sc.nextLine();

        DoctorLoginDAO dao = new DoctorLoginDAO();
        if (dao.login(code, pass)) {
            System.out.println("Đăng nhập thành công!");
        } else {
            System.out.println("Sai mã bác sĩ hoặc mật khẩu.");
        }
    }
}

//Phần 1 -
//PreparedStatement chống SQL Injection vì:
//
//SQL được biên dịch trước (pre-compiled), nên cấu trúc câu lệnh cố định, không thể bị thay đổi bởi dữ liệu đầu vào.
//
//Tham số ? được truyền vào như giá trị chứ không phải một phần của câu lệnh SQL.
//
//Nhờ đó, dữ liệu nhập vào (dù có chứa ' OR '1'='1) vẫn chỉ được coi là chuỗi, không thể phá vỡ logic SQL.