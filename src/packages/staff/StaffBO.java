package packages.staff;

import java.util.List;

public class StaffBO {
    StaffDAO staffDAO = new StaffDAO();
    public List<Staff> getListStaffs() {
        return staffDAO.getListStaffs();
    }

    public int getTotalStaffs() {
        return staffDAO.getTotalStaffs();
    }

    public int addStaff(Staff newStaff) {
        return staffDAO.addStaff(newStaff);
    }

}
