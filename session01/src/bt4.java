public class bt4 {

    // Method A: Chốt chặn cuối cùng (Hàm main)
    public static void main(String[] args) {
        System.out.println("--- Bắt đầu quy trình hệ thống ---");

        try {
            // Gọi Method B
            processUserData();
        } catch (Exception e) {
            // Xử lý dứt điểm lỗi tại đây để chương trình không crash
            System.out.println("Hàm Main đã tóm được lỗi: " + e.getMessage());
        }

        System.out.println("--- Chương trình kết thúc an toàn ---");
    }

    // Method B: Tiếp tục đẩy trách nhiệm lên trên bằng từ khóa 'throws'
    public static void processUserData() throws Exception {
        System.out.println("Method B: Đang xử lý... Tôi sẽ đẩy lỗi lên Main.");

        // Gọi Method C
        saveData();
    }

    // Method C: Nơi chủ động ném lỗi (throw) và báo trước (throws)
    public static void saveData() throws Exception {
        System.out.println("Method C: Tôi phát hiện lỗi lưu trữ!");

        // Chủ động ném ra một lỗi giả lập
        throw new Exception("Lỗi ghi dữ liệu vào hệ thống!");
    }
}