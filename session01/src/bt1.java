import java.util.Scanner;

public class bt1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập năm sinh của bạn: ");
            String input = scanner.nextLine();

            int namSinh = Integer.parseInt(input);
            int tuoi = 2026 - namSinh;

            System.out.println("Tuổi của bạn là: " + tuoi);

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập số nguyên hợp lệ (ví dụ: 1990), không nhập chữ hoặc ký tự!");

        } finally {
            scanner.close();
        }
    }
}