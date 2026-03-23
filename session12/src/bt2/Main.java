package bt2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã bệnh nhân: ");
        int patientId = sc.nextInt();
        System.out.print("Nhập nhiệt độ: ");
        double temperature = sc.nextDouble();
        System.out.print("Nhập nhịp tim: ");
        int heartrate = sc.nextInt();

        VitalsDAO dao = new VitalsDAO();
        if (dao.updateVitals(patientId, temperature, heartrate)) {
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Không tìm thấy bệnh nhân hoặc lỗi cập nhật.");
        }
    }
}
//Phần 1 –
//Các phương thức setDouble() và setInt() trong PreparedStatement giúp lập trình viên không phải lo về dấu chấm hay dấu phẩy vì:
//
//Chúng truyền giá trị số trực tiếp vào SQL dưới dạng tham số nhị phân (binary parameter).
//
//DBMS sẽ hiểu đúng kiểu dữ liệu (double, int) mà không phụ thuộc vào cách hệ điều hành hiển thị số theo Locale.
//
//Nhờ đó, dù máy tính hiển thị 37.5 hay 37,5 thì SQL vẫn nhận đúng giá trị 37.5.