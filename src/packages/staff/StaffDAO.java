package packages.staff;

import init.db.BaseDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO extends BaseDAO {

    public List<Staff> getListStaffs() {
        try {
            List<Staff> staffs = new ArrayList<Staff>();
            String query = "select * from staff order by id asc";
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Staff staff = new Staff(
                        resultSet.getString("id"),
                        resultSet.getString("fullName"),
                        resultSet.getString("gender"),
                        resultSet.getString("position"),
                        resultSet.getString("department"));
                staffs.add(staff);
            };
            return staffs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getTotalStaffs() {
        try {
            List<Staff> staffs = new ArrayList<Staff>();
            String query = "select count(*) as total from staff";
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int addStaff(Staff newStaff) {
        int result = 0;
        try {
            String sql = "INSERT INTO staff (name, gender,department, position) values(?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, newStaff.getFullName());
            ps.setString(2, newStaff.getGender());
            ps.setString(3, newStaff.getDepartment());
            ps.setString(4, newStaff.getPosition());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}