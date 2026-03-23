package bt4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PatientDAO dao = new PatientDAO();

        System.out.print("Nhập tên bệnh nhân: ");
        String name = sc.nextLine();

        dao.findPatientByName(name);
    }
}

///*PHẦN 1 – PHÂN TÍCH
//Code gốc
//String patientName = "' OR '1'='1'; // Hacker input
//String sql = "SELECT * FROM Patients WHERE full_name = '" + patientName + "'";
//Sau khi nối chuỗi → SQL thực tế
//SELECT * FROM Patients WHERE full_name = '' OR '1'='1';
//Tại sao luôn TRUE?
//
//Phân tích:
//
//full_name = ''      → thường FALSE
//OR
//'1'='1'             → LUÔN TRUE
// Mà:
//
//FALSE OR TRUE = TRUE
//
// Kết quả:
//
//WHERE luôn đúng
//Trả về TOÀN BỘ bảng Patients
// Hậu quả
//Lộ toàn bộ dữ liệu bệnh nhân
//Vi phạm bảo mật nghiêm trọng
//Có thể bị khai thác sâu hơn (DROP TABLE, DELETE...)
// Kết luận phần 1
//Do nối chuỗi trực tiếp input vào SQL
//Hacker chèn điều kiện luôn đúng ('1'='1')*/