package bt4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class ResultsDAO {
    public void insertResults(List<TestResult> list) {
        String sql = "INSERT INTO Results(data) VALUES(?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (TestResult tr : list) {
                pstmt.setString(1, tr.getData());
                pstmt.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
