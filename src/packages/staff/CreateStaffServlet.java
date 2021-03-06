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

@WebServlet("/CreateStaffServlet")
public class CreateStaffServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        DepartmentBO departmentBO = new DepartmentBO();
        PositionBO positionBO = new PositionBO();
        List<Department> dep = departmentBO.getListDepartments();
        List<Position> pos = positionBO.getListPositions();
        if (admin != null) {
            String fullname = request.getParameter("fullname");
            if("".equals(fullname)) {
                request.setAttribute("dep", dep);
                request.setAttribute("pos", pos);
                request.getRequestDispatcher("views/staff/create.jsp?msg=1").forward(request, response);
                return;
            }
            String gender = request.getParameter("radio");
            if(!gender.equals("Female") && !gender.equals("Male")) {
                request.setAttribute("dep", dep);
                request.setAttribute("pos", pos);
                request.getRequestDispatcher("views/staff/create.jsp?msg=2").forward(request, response);
                return;
            }

            String position = request.getParameter("pos");

            String department = request.getParameter("dep");

            Staff newStaff = new Staff(fullname, gender, position, department);
            StaffBO staffBO = new StaffBO();
            if (staffBO.addStaff(newStaff) > 0) {
                request.setAttribute("dep", dep);
                request.setAttribute("pos", pos);
                request.getRequestDispatcher("views/staff/create.jsp?msg=0").forward(request, response);
                return;
            } else {
                request.setAttribute("dep", dep);
                request.setAttribute("pos", pos);
                request.getRequestDispatcher("views/staff/create.jsp?msg=3").forward(request, response);
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        if (admin != null) {
            DepartmentBO departmentBO = new DepartmentBO();
            PositionBO positionBO = new PositionBO();
            List<Department> dep = departmentBO.getListDepartments();
            List<Position> pos = positionBO.getListPositions();
            request.setAttribute("dep", dep);
            request.setAttribute("pos", pos);
            request.getRequestDispatcher("views/staff/create.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
