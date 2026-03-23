package bt3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BedDAO dao = new BedDAO();

        System.out.print("Nhập mã giường: ");
        int bedId = sc.nextInt();

        dao.updateBedStatus(bedId);
    }
}
///*Phương thức executeUpdate() trả về:
//
//Số dòng bị ảnh hưởng (rows affected)
//Giá trị	Ý nghĩa
//> 0	Có bản ghi được cập nhật thành công
//= 0	Không có bản ghi nào → mã giường không tồn tại
//
// Do đó:
//
//Nếu không kiểm tra giá trị trả về
//→ hệ thống sẽ luôn báo thành công sai
//
//Cách xử lý đúng:
//
//if (rowsAffected == 0)
//
//→ Thông báo: "Mã giường không tồn tại"*/