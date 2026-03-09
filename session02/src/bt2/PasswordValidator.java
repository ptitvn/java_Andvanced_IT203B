package bt2;

@FunctionalInterface
interface PasswordValidator {
    boolean isValid(String password);
}