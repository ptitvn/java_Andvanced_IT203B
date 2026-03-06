import java.util.Scanner;

public class bt2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Nhập dữ liệu đầu vào
            System.out.print("Nhập tổng số người dùng: ");
            int tongNguoiDung = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập số lượng nhóm muốn chia: ");
            int soNhom = Integer.parseInt(scanner.nextLine());

            // Vùng nguy hiểm: Phép chia có thể gây ra ArithmeticException nếu soNhom = 0
            int soNguoiMoiNhom = tongNguoiDung / soNhom;

            System.out.println("Mỗi nhóm sẽ có: " + soNguoiMoiNhom + " người.");

        } catch (NumberFormatException e) {
            // Bắt lỗi nếu người dùng nhập chữ thay vì số
            System.out.println("Lỗi: Vui lòng nhập số nguyên hợp lệ!");

        } catch (ArithmeticException e) {
            // Yêu cầu: Bắt lỗi khi số nhóm nhập vào là 0
            System.out.println("Không thể chia cho 0!");

        } finally {
            scanner.close();
        }

        System.out.println("Chương trình kết thúc an toàn. Hệ thống vẫn ổn định.");
    }
}