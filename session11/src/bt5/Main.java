package bt5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DoctorService service = new DoctorService();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Xem danh sách bác sĩ");
            System.out.println("2. Thêm bác sĩ");
            System.out.println("3. Thống kê chuyên khoa");
            System.out.println("4. Thoát");

            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    service.showDoctors();
                    break;

                case 2:
                    try {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Tên: ");
                        String name = sc.nextLine();

                        System.out.print("Chuyên khoa: ");
                        String spec = sc.nextLine();

                        service.addDoctor(new Doctor(id, name, spec));
                    } catch (Exception e) {
                        System.out.println(" Nhập sai dữ liệu!");
                        sc.nextLine();
                    }
                    break;

                case 3:
                    service.statistic();
                    break;

                case 4:
                    System.out.println("Thoát...");
                    return;

                default:
                    System.out.println(" Chọn sai!");
            }
        }
    }
}


///*PHẦN 1 – Kịch bản lỗi (ghi vào bài)
//
//Ví dụ các lỗi có thể xảy ra:
//
//Trùng mã bác sĩ (Primary Key)
//Khi thêm doctor có doctor_id đã tồn tại
//→ SQL Exception
// Chuyên khoa quá dài
//Vượt quá VARCHAR trong DB
//→ Data too long error
//Nhập rỗng
//Không nhập tên hoặc chuyên khoa
// Sai kiểu dữ liệu
//Nhập chữ vào ID (int)
//
// Cách xử lý:
//
//Validate input
//Try-catch SQLException
//Thông báo rõ cho người dùng*/