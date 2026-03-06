package bt6;

public class User {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    // Lập trình phòng ngừa: Dùng if-else thay vì try-catch cho Null
    public void displayName() {
        if (this.name == null) {
            System.out.println("[Cảnh báo] Tên người dùng đang để trống.");
        } else {
            System.out.println("Tên người dùng: " + this.name.toUpperCase());
        }
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Tuổi không thể âm!");
        }
        this.age = age;
    }
}
