package bt2;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<User> users = List.of(
                new User("alice", "alice@gmail.com"),
                new User("bob", "bob@yahoo.com"),
                new User("charlie", "charlie@gmail.com")
        );

        users.stream()
                .filter(user -> user.getEmail().endsWith("@gmail.com"))
                .forEach(user -> System.out.println(user.getUsername()));
    }
}
