package packages.dashboard;

import packages.admin.Admin;
import packages.department.Department;
import packages.department.DepartmentBO;
import packages.position.Position;
import packages.position.PositionBO;
import packages.staff.Staff;
import packages.staff.StaffBO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/DashBoardServlet")
public class DashBoardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        if (admin != null) {
            DashBoardBO dashBoardBO = new DashBoardBO();
            PositionBO positionBO = new PositionBO();
            DepartmentBO departmentBO = new DepartmentBO();
            int totalStaffs = dashBoardBO.getTotalStaffs();
            int totalDepartments = dashBoardBO.getTotalDepartments();
            int totalPositions = dashBoardBO.getTotalPositions();
            List<Position> pos = positionBO.getListPositions();
            List<Department> dep = departmentBO.getListDepartments();
            request.setAttribute("totalStaffs", totalStaffs);
            request.setAttribute("totalDepartments", totalDepartments);
            request.setAttribute("totalPositions", totalPositions);
            request.setAttribute("dep", dep);
            request.setAttribute("pos", pos);
            request.getRequestDispatcher("views/dashboard/dashboard.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
