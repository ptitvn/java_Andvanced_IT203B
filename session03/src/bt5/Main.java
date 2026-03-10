package bt5;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<User> users = List.of(
                new User("alexander"),
                new User("bob"),
                new User("charlotte"),
                new User("Benjamin"),
                new User("anna")
        );

        users.stream()
                .sorted(Comparator.comparingInt((User u) -> u.getUsername().length()).reversed())
                .limit(3)
                .forEach(u -> System.out.println(u.getUsername()));
    }
}