package bt3;

public class Main {
    public static void main(String[] args) {

        Authenticatable user = () -> "123456";

        System.out.println(user.isAuthenticated());

        String encrypted = Authenticatable.encrypt("123456");
        System.out.println(encrypted);
    }
}