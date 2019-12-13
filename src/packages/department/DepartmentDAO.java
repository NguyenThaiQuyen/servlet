package packages.department;

import init.db.BaseDAO;
import javafx.geometry.Pos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO extends BaseDAO {

    public List<Department> getListDepartments() {
        try {
            List<Department> departments = new ArrayList<Department>();
            String query = "select * from department order by id asc";
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Department dep = new Department(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"));
                departments.add(dep);
            };
            return departments;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getTotalDepartments() {
        try {
            String query = "select count(*) as total from department";
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
}