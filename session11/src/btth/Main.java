package src.btth;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AppointmentRepository repo = new AppointmentRepository();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Thêm lịch khám");
            System.out.println("2. Cập nhật lịch khám");
            System.out.println("3. Xóa lịch khám");
            System.out.println("4. Xem tất cả");
            System.out.println("5. Tìm theo ID");
            System.out.println("6. Thoát");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Tên bệnh nhân: ");
                    String pname = sc.nextLine();
                    System.out.print("Ngày khám (yyyy-mm-dd): ");
                    String date = sc.nextLine();
                    System.out.print("Tên bác sĩ: ");
                    String dname = sc.nextLine();
                    System.out.print("Trạng thái: ");
                    String status = sc.nextLine();

                    repo.addAppointment(
                            new Appointment(pname, Date.valueOf(date), dname, status));
                    break;

                case 2:
                    System.out.print("ID cần sửa: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Tên bệnh nhân: ");
                    String pname2 = sc.nextLine();
                    System.out.print("Ngày khám: ");
                    String date2 = sc.nextLine();
                    System.out.print("Tên bác sĩ: ");
                    String dname2 = sc.nextLine();
                    System.out.print("Trạng thái: ");
                    String status2 = sc.nextLine();

                    repo.updateAppointment(
                            new Appointment(uid, pname2, Date.valueOf(date2), dname2, status2));
                    break;

                case 3:
                    System.out.print("ID cần xóa: ");
                    int did = sc.nextInt();
                    repo.deleteAppointment(did);
                    break;

                case 4:
                    List<Appointment> list = repo.getAllAppointments();
                    for (Appointment a : list) {
                        System.out.println(a.getId() + " | " +
                                a.getPatientName() + " | " +
                                a.getAppointmentDate() + " | " +
                                a.getDoctorName() + " | " +
                                a.getStatus());
                    }
                    break;

                case 5:
                    System.out.print("Nhập ID: ");
                    int fid = sc.nextInt();
                    Appointment a = repo.getAppointmentById(fid);
                    if (a != null) {
                        System.out.println(a.getPatientName());
                    }
                    break;

                case 6:
                    return;
            }
        }
    }
}