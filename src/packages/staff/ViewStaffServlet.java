package packages.staff;

import packages.admin.Admin;
import packages.dashboard.DashBoardBO;
import packages.department.Department;
import packages.department.DepartmentBO;
import packages.position.Position;
import packages.position.PositionBO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ViewStaffServlet")
public class ViewStaffServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        if (admin != null) {
            DepartmentBO departmentBO = new DepartmentBO();
            PositionBO positionBO = new PositionBO();
            StaffBO staffBO = new StaffBO();
            List<Staff> staffs;
            String idDep = request.getParameter("idDep");
            String idPos = request.getParameter("idPos");
            String follow = "All";
            if (idDep != null) {
                Department d = departmentBO.getByID(idDep);
                staffs = staffBO.getListStaffs(1, idDep);
                follow = d.getName();
            } else if ( idPos != null) {
                Position p = positionBO.getByID(idPos);
                staffs = staffBO.getListStaffs(2, idPos);
                follow = p.getName();
            } else {
                staffs = staffBO.getListStaffs(0, "");
            }
            request.setAttribute("staffs", staffs);
            request.setAttribute("by", follow);
            request.getRequestDispatcher("views/staff/view.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
