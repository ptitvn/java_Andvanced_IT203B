package bt5;

public class User {

    private String username;
    private String role;

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}