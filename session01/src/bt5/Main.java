package bt5;

public class Main {
    public static void main(String[] args) {
        User user = new User();

        try {
            System.out.println("Đang thiết lập tuổi người dùng...");
            // Thử nhập một giá trị vô lý
            user.setAge(-10);

        } catch (InvalidAgeException e) {
            // In ra tên lỗi tùy chỉnh và thông báo cụ thể
            System.err.println("Phát hiện ngoại lệ riêng biệt: " + e.getClass().getSimpleName());
            System.err.println("Nội dung lỗi: " + e.getMessage());

            // In Stack Trace để thấy tên InvalidAgeException xuất hiện trong nhật ký hệ thống
            // e.printStackTrace();
        }

        System.out.println("\n--- Hệ thống vẫn vận hành an toàn ---");
    }
}
