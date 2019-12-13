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

@WebServlet("/UpdatePositionServlet")
public class UpdatePositionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        PositionBO positionBO = new PositionBO();
        String idPos = request.getParameter("idPos");
        Position pos = positionBO.getByID(idPos);
        System.out.println(idPos);
        if (admin != null) {
            String name = request.getParameter("nameDep");
            if("".equals(name)) {
                request.setAttribute("pos", pos);
                request.getRequestDispatcher("views/position/update.jsp?msg=1").forward(request, response);
                return;
            }
            String description = request.getParameter("desdep");
            if("".equals(description)) {
                request.setAttribute("pos", pos);
                request.getRequestDispatcher("views/position/update.jsp?msg=1").forward(request, response);
                return;
            }

            Position p = new Position(idPos, name, description);
            if (positionBO.updatePosition(p, idPos) > 0) {
                request.getRequestDispatcher("ViewPositionServlet?msg=0").forward(request, response);
                return;
            } else {
                request.setAttribute("pos", pos);
                request.getRequestDispatcher("views/position/update.jsp?msg=3").forward(request, response);
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        if (admin != null) {
            String idPos = request.getParameter("idPos");
            PositionBO positionBO = new PositionBO();
            Position pos = positionBO.getByID(idPos);
            request.setAttribute("pos", pos);
            request.getRequestDispatcher("views/position/update.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
