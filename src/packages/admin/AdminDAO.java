package packages.admin;

import init.db.BaseDAO;

import java.sql.ResultSet;

public class AdminDAO extends BaseDAO {

    public  Admin getAdmin(String username, String password) {
        try {
            String query = "select * from admin where username = '" + username + "' and password = '" + password + "'";
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                Admin admin = new Admin(resultSet.getString("id"), resultSet.getString("username"), resultSet.getString("password"));
                return admin;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}