package bt4;

class User {
    private String username;

    public User() {
        this.username = "guest";
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}