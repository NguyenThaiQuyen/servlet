package packages.position;

import packages.admin.Admin;
import packages.department.Department;
import packages.department.DepartmentBO;
import packages.staff.Staff;
import packages.staff.StaffBO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CreatePositionServlet")
public class CreatePositionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        PositionBO positionBO = new PositionBO();
        if (admin != null) {
            String name = request.getParameter("nameDep");
            if("".equals(name)) {
                request.getRequestDispatcher("views/position/create.jsp?msg=1").forward(request, response);
                return;
            }
            String description = request.getParameter("desdep");
            if("".equals(description)) {
                request.getRequestDispatcher("views/position/create.jsp?msg=1").forward(request, response);
                return;
            }

            Position p = new Position(name, description);
            if (positionBO.addPosition(p) > 0) {
                request.getRequestDispatcher("views/position/create.jsp?msg=0").forward(request, response);
                return;
            } else {
                request.getRequestDispatcher("views/position/create.jsp?msg=3").forward(request, response);
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        if (admin != null) {
            request.getRequestDispatcher("views/position/create.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
