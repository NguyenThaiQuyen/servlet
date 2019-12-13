package packages.department;

import packages.department.Department;
import packages.department.DepartmentDAO;

import java.util.List;

public class DepartmentBO {
    DepartmentDAO departmentDAO = new DepartmentDAO();
    public List<Department> getListDepartments() {
        return departmentDAO.getListDepartments();
    }

    public int getTotalPositions() {
        return departmentDAO.getTotalDepartments();
    }
}
