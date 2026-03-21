package src.bt5;

public class DoctorService {
    private DoctorDAO dao = new DoctorDAO();

    public void showDoctors() {
        dao.getAllDoctors();
    }

    public void addDoctor(String id, String name, String specialty) {
        Doctor doctor = new Doctor(id, name, specialty);
        dao.addDoctor(doctor);
    }

    public void statistic() {
        dao.countBySpecialty();
    }
}