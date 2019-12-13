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

@WebServlet("/UpdateDepartmentServlet")
public class UpdateDepartmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        DepartmentBO departmentBO = new DepartmentBO();
        String idPos = request.getParameter("idPos");
        Department d = departmentBO.getByID(idPos);
        if (admin != null) {
            String name = request.getParameter("nameDep");
            if("".equals(name)) {
                request.setAttribute("dep", d);
                request.getRequestDispatcher("views/department/update.jsp?msg=1").forward(request, response);
                return;
            }
            String description = request.getParameter("desdep");
            System.out.println(description);
            if("".equals(description)) {
                request.setAttribute("dep", d);
                request.getRequestDispatcher("views/department/update.jsp?msg=1").forward(request, response);
                return;
            }

            Department p = new Department(idPos, name, description);
            if (departmentBO.updateDepartment(p, idPos) > 0) {
                request.getRequestDispatcher("ViewDepartmentServlet?msg=0").forward(request, response);
                return;
            } else {
                request.setAttribute("dep", d);
                request.getRequestDispatcher("views/department/update.jsp?msg=3").forward(request, response);
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        if (admin != null) {
            String idPos = request.getParameter("idPos");
            DepartmentBO departmentBO = new DepartmentBO();
            Department d = departmentBO.getByID(idPos);
            request.setAttribute("dep", d);
            request.getRequestDispatcher("views/department/update.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
