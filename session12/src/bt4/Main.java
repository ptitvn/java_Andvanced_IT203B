package bt4;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<TestResult> list = new ArrayList<>();
        list.add(new TestResult("Blood Test A"));
        list.add(new TestResult("Blood Test B"));
        list.add(new TestResult("Blood Test C"));
        // giả sử có hàng ngàn kết quả

        ResultsDAO dao = new ResultsDAO();
        dao.insertResults(list);

        System.out.println("Nạp kết quả xét nghiệm thành công!");
    }
}


//Phần 1 – Phân tích sự lãng phí
//Khi dùng Statement trong vòng lặp, mỗi lần chạy executeUpdate(sql) thì Database Server phải:
//
//Parse lại câu lệnh SQL (phân tích cú pháp).
//
//Lập Execution Plan (kế hoạch thực thi).
//
//Biên dịch lại toàn bộ câu lệnh.
//
//Với 1.000 bản ghi, nghĩa là server phải làm lại 1.000 lần cho cùng một cấu trúc câu lệnh → cực kỳ tốn CPU, bộ nhớ và thời gian.
//
//Đây là nguyên nhân khiến việc nạp dữ liệu hàng loạt chạy rất chậm