package bt3;

public class Main {
    public static void main(String[] args) {
        User user = new User();

        try {
            System.out.println("--- Thử nghiệm thiết lập tuổi hợp lệ ---");
            user.setAge(25);

            System.out.println("\n--- Thử nghiệm thiết lập tuổi âm ---");
            user.setAge(-5); // Dòng này sẽ kích hoạt lệnh throw

        } catch (IllegalArgumentException e) {
            // Bắt ngoại lệ đã được ném ra từ phương thức setAge
            System.err.println("Thông báo lỗi hệ thống: " + e.getMessage());
        }

        System.out.println("\nChương trình vẫn an toàn sau khi chặn dữ liệu lỗi.");
    }
}