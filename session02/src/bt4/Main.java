package bt4;

import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        // Danh sách users
        List<User> users = Arrays.asList(
                new User("An"),
                new User("Binh"),
                new User("Chi")
        );

        // 1. (user) -> user.getUsername()
        Function<User, String> f = User::getUsername;

        // 2. (s) -> System.out.println(s)
        Consumer<String> printer = System.out::println;

        // 3. () -> new User()
        Supplier<User> creator = User::new;

        // Áp dụng vào danh sách
        users.stream()
                .map(f)
                .forEach(printer);

        // Tạo user mới
        User newUser = creator.get();
        System.out.println(newUser.getUsername());
    }
}