package bt1;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        // 1. Supplier: Khởi tạo User mặc định (Không input -> Trả về User)
        Supplier<User> userSupplier = () -> new User("guest_user", "GUEST");
        User defaultUser = userSupplier.get();

        // 2. Predicate: Kiểm tra có phải Admin không (Input User -> Trả về boolean)
        Predicate<User> isAdmin = user -> "ADMIN".equals(user.role);

        // 3. Function: Lấy username từ đối tượng User (Input User -> Trả về String)
        Function<User, String> getUsername = user -> user.username;

        // 4. Consumer: In thông tin User (Input User -> void)
        Consumer<User> printUser = user -> System.out.println("Thông tin chi tiết: " + user);

        // --- Chạy thử nghiệm ---
        User admin = new User("hoang_admin", "ADMIN");

        System.out.println("--- Kiểm tra logic ---");
        System.out.println("Is Admin? " + isAdmin.test(admin));
        System.out.println("Username: " + getUsername.apply(admin));

        printUser.accept(defaultUser);
    }
}