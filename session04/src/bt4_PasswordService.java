public class bt4_PasswordService {

    public String evaluatePasswordStrength(String password) {

        if (password == null || password.length() < 8) {
            return "Yếu";
        }

        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");

        int criteria = 0;

        if (hasUpper) criteria++;
        if (hasLower) criteria++;
        if (hasDigit) criteria++;
        if (hasSpecial) criteria++;

        if (criteria == 4) {
            return "Mạnh";
        }

        if (criteria >= 2) {
            return "Trung bình";
        }

        return "Yếu";
    }
}