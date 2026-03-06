package bt6;

import java.util.Scanner;

public class Main {

    // Hàm giả lập ghi log lỗi với định dạng đơn giản
    public static void logError(String detail) {
        // Giả lập ngày tháng năm cố định vì chưa học java.time
        String fakeDate = "2026-03-06";
        System.out.println("[ERROR] " + fakeDate + " - " + detail);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User();

        try {
            // Nhập liệu cơ bản
            System.out.print("Nhập năm sinh: ");
            String input = scanner.nextLine();
            int namSinh = Integer.parseInt(input); // Có thể gây NumberFormatException

            user.setAge(2026 - namSinh); // Có thể gây InvalidAgeException

            // Tính toán chia nhóm
            System.out.print("Nhập số nhóm: ");
            int soNhom = Integer.parseInt(scanner.nextLine());

            // Lập trình phòng ngừa: Kiểm tra trước khi chia để tránh ArithmeticException
            if (soNhom == 0) {
                logError("Người dùng nhập số nhóm bằng 0.");
                System.out.println("Không thể chia nhóm cho 0. Vui lòng thử lại.");
            } else {
                System.out.println("Chia nhóm thành công!");
            }

            // Kiểm tra tên (Phòng ngừa Null)
            user.displayName();

        } catch (NumberFormatException e) {
            logError("Người dùng nhập chữ thay vì số.");
        } catch (InvalidAgeException e) {
            logError("Lỗi nghiệp vụ: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Thực hiện dọn dẹp tài nguyên trong finally...");
        }
    }
}