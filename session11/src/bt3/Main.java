package src.bt3;

public class Main {
    public static void main(String[] args) {
        BedDAO dao = new BedDAO();

        dao.updateBedStatus("Bed_001"); // tồn tại
        dao.updateBedStatus("Bed_999"); // không tồn tại
    }
}