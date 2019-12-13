package packages.staff;

import packages.admin.Admin;
import packages.dashboard.DashBoardBO;

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
            StaffBO staffBO = new StaffBO();
            List<Staff> staffs = staffBO.getListStaffs();
            request.setAttribute("staffs", staffs);
            request.getRequestDispatcher("views/staff/view.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
