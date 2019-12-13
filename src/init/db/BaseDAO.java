package init.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BaseDAO {
    protected PreparedStatement ps;
    protected Connection connection;

    public BaseDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlpb", "thaiquyen", "qwe123!@#");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
