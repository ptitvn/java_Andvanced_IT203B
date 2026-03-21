package src.bt4;

public class Main {
    public static void main(String[] args) {

        PatientDAO dao = new PatientDAO();

        // Test bình thường
        dao.findPatientByName("Nguyen Van A");

        // Test SQL Injection
        dao.findPatientByName("' OR '1'='1");
    }
}