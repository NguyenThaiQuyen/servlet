package packages.dashboard;

import packages.department.DepartmentBO;
import packages.position.PositionBO;
import packages.staff.Staff;
import packages.staff.StaffBO;

import java.util.List;

public class DashBoardBO {
    StaffBO staffBO = new StaffBO();
    DepartmentBO departmentBO = new DepartmentBO();
    PositionBO positionBO = new PositionBO();

    int getTotalStaffs () {
        return staffBO.getTotalStaffs();
    }

    int getTotalDepartments () {
        return departmentBO.getTotalPositions();
    }

    int getTotalPositions () {
        return positionBO.getTotalPositions();
    }

    List<Staff> getListStaffs() {
        return staffBO.getListStaffs(0, "");
    }
}
