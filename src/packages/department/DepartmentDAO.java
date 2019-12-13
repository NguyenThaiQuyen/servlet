package packages.department;

import init.db.BaseDAO;
import javafx.geometry.Pos;
import packages.position.Position;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO extends BaseDAO {

    public List<Department> getListDepartments() {
        try {
            List<Department> departments = new ArrayList<Department>();
            String query = "select department.* , (select count(*) from staff where staff.idDepartment = department.id ) as amount from department order by department.id asc";
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Department dep = new Department(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        Integer.parseInt(resultSet.getString("amount")));
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

    public Department getByID(String idDep) {
        try {
            String sql = "select * from department where id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, idDep);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Department dep = new Department(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"));
                return dep;
            };
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int addDepartment(Department p) {
        int result = 0;
        try {
            String sql = "insert into department (name, description) values(?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getDescription());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updateDepartment(Department p) {
        int result = 0;
        try {
            String sql = "update department SET name= ?,description= ? WHERE id= ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getDescription());
            ps.setString(3, p.getID());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}