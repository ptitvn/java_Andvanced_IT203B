package bt3;

@FunctionalInterface
public interface Authenticatable {

    // Phương thức trừu tượng
    String getPassword();

    // Default method kiểm tra mật khẩu có rỗng hay không
    default boolean isAuthenticated() {
        return getPassword() != null && !getPassword().isEmpty();
    }

    // Static method mô phỏng mã hóa mật khẩu
    static String encrypt(String rawPassword) {
        return "ENC_" + rawPassword;
    }
}