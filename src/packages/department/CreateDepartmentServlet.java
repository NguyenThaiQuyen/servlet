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

@WebServlet("/CreateDepartmentServlet")
public class CreateDepartmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        DepartmentBO departmentBO = new DepartmentBO();
        if (admin != null) {
            String name = request.getParameter("nameDep");
            if("".equals(name)) {
                request.getRequestDispatcher("views/department/create.jsp?msg=1").forward(request, response);
                return;
            }
            String description = request.getParameter("desdep");
            if("".equals(description)) {
                request.getRequestDispatcher("views/department/create.jsp?msg=1").forward(request, response);
                return;
            }

            Department d = new Department(name, description);
            if (departmentBO.addPosition(d) > 0) {
                request.getRequestDispatcher("views/department/create.jsp?msg=0").forward(request, response);
                return;
            } else {
                request.getRequestDispatcher("views/department/create.jsp?msg=3").forward(request, response);
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        if (admin != null) {
            request.getRequestDispatcher("views/department/create.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
