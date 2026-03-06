package bt5;

// Bước 1: Tạo lớp ngoại lệ tùy chỉnh
public class InvalidAgeException extends Exception {

    // Constructor nhận thông báo lỗi
    public InvalidAgeException(String message) {
        // Truyền thông báo lên lớp cha (Exception)
        super(message);
    }
}