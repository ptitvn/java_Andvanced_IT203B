package bt3;

public class User {
    private String name;
    private int age;

    // Phương thức setter cho age với logic kiểm soát dữ liệu
    public void setAge(int age) {
        if (age < 0) {
            // Chủ động ném ngoại lệ khi dữ liệu vi phạm quy tắc
            throw new IllegalArgumentException("Tuổi không thể âm!");
        }
        // Nếu age >= 0, thực hiện gán giá trị bình thường
        this.age = age;
        System.out.println("Cập nhật tuổi thành công: " + this.age);
    }

    public int getAge() {
        return age;
    }
}