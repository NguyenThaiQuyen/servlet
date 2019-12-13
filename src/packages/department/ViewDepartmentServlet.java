package packages.department;

import packages.admin.Admin;
import packages.position.Position;
import packages.position.PositionBO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ViewDepartmentServlet")
public class ViewDepartmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        if (admin != null) {
            DepartmentBO departmentBO = new DepartmentBO();
            List<Department> dep = departmentBO.getListDepartments();
            request.setAttribute("dep", dep);
            request.getRequestDispatcher("views/department/view.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}

