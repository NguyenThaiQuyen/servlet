package packages.staff;

import java.util.List;

public class StaffBO {
    StaffDAO staffDAO = new StaffDAO();
    public List<Staff> getListStaffs(int code, String nameComponent) {
        return staffDAO.getListStaffs(code, nameComponent);
    }

    public int getTotalStaffs() {
        return staffDAO.getTotalStaffs();
    }

    public int addStaff(Staff newStaff) {
        return staffDAO.addStaff(newStaff);
    }

    public int deleteStaff(String idStaff) {
        return staffDAO.deleteStaff(idStaff);
    }

    public int updateStaff(Staff newStaff, String idStaff) {
        Staff oldStaff = staffDAO.getByID(idStaff);
        if (oldStaff != null) {
            String id = (!newStaff.getID().equals("")) ?  newStaff.getID() :  oldStaff.getID();
            String fullName = (!newStaff.getFullName().equals("")) ?  newStaff.getFullName() :  oldStaff.getFullName();
            String gender = (!newStaff.getGender().equals("")) ?  newStaff.getGender() : oldStaff.getGender();
            String idDepartment = (!newStaff.getIdDepartment().equals("")) ?  newStaff.getIdDepartment() :  oldStaff.getIdDepartment();
            String idPosition = (!newStaff.getIdPosition().equals("")) ?  newStaff.getIdPosition() :  oldStaff.getIdPosition();
            Staff data = new Staff(id, fullName, gender, idDepartment, idPosition);
            return staffDAO.updateStaff(data);
        }
        return -1;
    }

    public Staff getById(String idStaff) {
        return staffDAO.getByID(idStaff);
    }

    public List<Staff> getListStaffSearch(String key) {
        return staffDAO.getListStaffSearch(key);
    }
}
