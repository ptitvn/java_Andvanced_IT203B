package bt4;

import java.util.ArrayList;
import java.util.List;

public class BenhNhanDTO {
    private int maBenhNhan;
    private String tenBenhNhan;
    private List<DichVu> dsDichVu = new ArrayList<>();

    public BenhNhanDTO(int maBenhNhan, String tenBenhNhan) {
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
    }

    public void addDichVu(DichVu dv) {
        dsDichVu.add(dv);
    }

    public String toString() {
        return "Bệnh nhân: " + tenBenhNhan + " | Dịch vụ: " + dsDichVu;
    }
}
