package packages.department;

import packages.department.Department;
import packages.department.DepartmentDAO;
import packages.position.Position;

import java.util.List;

public class DepartmentBO {
    DepartmentDAO departmentDAO = new DepartmentDAO();
    public List<Department> getListDepartments() {
        return departmentDAO.getListDepartments();
    }

    public int getTotalPositions() {
        return departmentDAO.getTotalDepartments();
    }

    public Department getByID(String idDep) {
        return departmentDAO.getByID(idDep);
    }

    public int addPosition(Department p) {
        return departmentDAO.addDepartment(p);
    }

    public int updateDepartment(Department p, String id) {
        Department oldDepartment = departmentDAO.getByID(id);
        if (oldDepartment != null) {
            String idPos = (!p.getID().equals("")) ?  p.getID() :  oldDepartment.getID();
            String name = (!p.getName().equals("")) ? p.getName() :  oldDepartment.getName();
            String description = (!p.getDescription().equals("")) ? p.getDescription() : oldDepartment.getDescription();
            Department data = new Department(id, name, description);
            return departmentDAO.updateDepartment(data);
        }
        return -1;
    }
}
