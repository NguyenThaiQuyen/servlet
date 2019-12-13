package packages.staff;

import init.db.BaseDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO extends BaseDAO {

    public List<Staff> getListStaffs(int code, String nameComponent) {
        try {
            List<Staff> staffs = new ArrayList<Staff>();
            String query = "";
            switch(code) {
                case 0: {
                        query = "select *, department.name as nameDepartment, position.name as namePosition from staff \n" +
                                "join department on staff.idDepartment = department.id \n" +
                                "join position on staff.idPosition = position.id\n" +
                                "order by staff.id asc";
                    ps = connection.prepareStatement(query);
                    break;
                }
                case 1: {
                    query = "select *, department.name as nameDepartment, position.name as namePosition from staff \n" +
                            "join department on staff.idDepartment = department.id \n" +
                            "join position on staff.idPosition = position.id where idDepartment=? order by staff.id asc";
                    ps = connection.prepareStatement(query);
                    ps.setString(1, nameComponent);
                    break;
                }
                case 2: {
                    query = "select *, department.name as nameDepartment, position.name as namePosition from staff \n" +
                            "join department on staff.idDepartment = department.id \n" +
                            "join position on staff.idPosition = position.id where idPosition=? order by staff.id asc";
                    ps = connection.prepareStatement(query);
                    ps.setString(1, nameComponent);
                    break;
                }
            }

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Staff staff = new Staff(
                        resultSet.getString("id"),
                        resultSet.getString("fullName"),
                        resultSet.getString("gender"),
                        resultSet.getString("idPosition"),
                        resultSet.getString("namePosition"),
                        resultSet.getString("idDepartment"),
                        resultSet.getString("nameDepartment"));
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
            String sql = "select count(*) as total from staff";
            ps = connection.prepareStatement(sql);
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
            String sql = "insert into staff (fullName, gender,idDepartment, idPosition) values(?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, newStaff.getFullName());
            ps.setString(2, newStaff.getGender());
            ps.setString(3, newStaff.getIdDepartment());
            ps.setString(4, newStaff.getIdPosition());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int deleteStaff(String idStaff) {
        int result = 0;
        try {
            String sql = "delete from staff where id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, idStaff);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updateStaff(Staff newStaff) {
        System.out.println(newStaff.toString());
        int result = 0;
        try {
            String sql = "update staff SET fullName= ?,gender= ?, idPosition= ?, idDepartment= ?  WHERE id= ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, newStaff.getFullName());
            ps.setString(2, newStaff.getGender());
            ps.setString(3, newStaff.getIdDepartment());
            ps.setString(4, newStaff.getIdPosition());
            ps.setString(5, newStaff.getID());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public Staff getByID(String idStaff) {
        try {
            String sql = "select *, department.name as nameDepartment, position.name as namePosition from staff \n" +
                    "join department on staff.idDepartment = department.id \n" +
                    "join position on staff.idPosition = position.id where id=" + idStaff;
            ps = connection.prepareStatement(sql);
            ps.setString(1, idStaff);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Staff staff = new Staff(
                        resultSet.getString("id"),
                        resultSet.getString("fullName"),
                        resultSet.getString("gender"),
                        resultSet.getString("idPosition"),
                        resultSet.getString("namePosition"),
                        resultSet.getString("idDepartment"),
                        resultSet.getString("nameDepartment"));
                return staff;
            };
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Staff> getListStaffSearch(String key) {
        List<Staff> staffs = new ArrayList<Staff>();
        try {
            String sql = "select *, department.name as nameDepartment, position.name as namePosition from staff \n" +
                    "join department on staff.idDepartment = department.id \n" +
                    "join position on staff.idPosition = position.id\n" +
                    "where (staff.fullName like ? or staff.gender like ?) order by staff.id asc ";
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Staff staff = new Staff(
                        resultSet.getString("id"),
                        resultSet.getString("fullName"),
                        resultSet.getString("gender"),
                        resultSet.getString("idPosition"),
                        resultSet.getString("namePosition"),
                        resultSet.getString("idDepartment"),
                        resultSet.getString("nameDepartment"));
                staffs.add(staff);
            };
            return staffs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}