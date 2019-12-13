package packages.staff;

import packages.admin.Admin;
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

@WebServlet("/DeleteStaffServlet")
public class DeleteStaffServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        StaffBO staffBO = new StaffBO();
        List<Staff> staffs = staffBO.getListStaffs(0, "");
        if (admin != null) {
            String idStaff = request.getParameter("idStaff");
            if (staffBO.deleteStaff(idStaff) > 0) {
                request.setAttribute("staffs", staffs);
                response.sendRedirect("ViewStaffServlet?msg=0");
                return;
            } else {
                request.setAttribute("staffs", staffs);
                response.sendRedirect("ViewStaffServlet?msg=3");
                return;
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
