package bt2;

public class Main {
    public static void main(String[] args) {

        // Lambda rút gọn nhất
        PasswordValidator validator = password -> password.length() >= 8;

        // Kiểm tra mật khẩu
        System.out.println(validator.isValid("12345678"));
        System.out.println(validator.isValid("1234"));
    }
}