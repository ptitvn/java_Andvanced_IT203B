package bt5;

import java.util.List;

public class DoctorService {

    private DoctorDAO dao = new DoctorDAO();

    public void showDoctors() {
        List<Doctor> list = dao.getAllDoctors();

        System.out.println("=== DANH SÁCH BÁC SĨ ===");
        for (Doctor d : list) {
            System.out.println(d.getId() + " | " + d.getName() + " | " + d.getSpecialty());
        }
    }

    public void addDoctor(Doctor d) {
        if (dao.addDoctor(d)) {
            System.out.println(" Thêm thành công!");
        } else {
            System.out.println(" Thêm thất bại!");
        }
    }

    public void statistic() {
        System.out.println("=== THỐNG KÊ ===");
        dao.countBySpecialty();
    }
}