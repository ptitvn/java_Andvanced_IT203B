package bt5;

public class User {
    private int age;

    // Cập nhật hàm setAge để ném ra InvalidAgeException
    // Vì kế thừa từ Exception (Checked), ta cần thêm 'throws' ở chữ ký hàm
    public void setAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Lỗi Nghiệp Vụ: Tuổi " + age + " không hợp lệ cho người dùng hệ thống!");
        }
        this.age = age;
        System.out.println("Cập nhật tuổi thành công.");
    }
}