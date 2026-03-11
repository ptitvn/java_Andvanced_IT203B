public class bt3_UserProcessor {

    public String processEmail(String email) {

        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        String[] parts = email.split("@");

        if (parts.length != 2 || parts[1].isEmpty()) {
            throw new IllegalArgumentException("Email must contain domain");
        }

        return email.toLowerCase();
    }
}