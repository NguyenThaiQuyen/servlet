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

@WebServlet("/UpdateStaffServlet")
public class UpdateStaffServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        DepartmentBO departmentBO = new DepartmentBO();
        PositionBO positionBO = new PositionBO();
        StaffBO staffBO = new StaffBO();
        List<Department> dep = departmentBO.getListDepartments();
        List<Position> pos = positionBO.getListPositions();
        String idStaff = request.getParameter("idStaff");
        Staff staff = staffBO.getById(idStaff);
        if (admin != null) {
            String fullname = request.getParameter("fullName");
            if("".equals(fullname)) {
                request.setAttribute("dep", dep);
                request.setAttribute("pos", pos);
                request.setAttribute("staff", staff);
                request.getRequestDispatcher("views/staff/update.jsp?msg=1").forward(request, response);
                return;
            }
            String gender = request.getParameter("radio");
            if(!gender.equals("Female") && !gender.equals("Male")) {
                request.setAttribute("dep", dep);
                request.setAttribute("pos", pos);
                request.setAttribute("staff", staff);
                request.getRequestDispatcher("views/staff/update.jsp?msg=2").forward(request, response);
                return;
            }

            String position = request.getParameter("pos");

            String department = request.getParameter("dep");

            Staff newStaff = new Staff(idStaff, fullname, gender, position, department);
            if (staffBO.updateStaff(newStaff, idStaff) > 0) {
                request.getRequestDispatcher("ViewStaffServlet?msg=0").forward(request, response);
                return;
            } else {
                request.setAttribute("dep", dep);
                request.setAttribute("pos", pos);
                request.setAttribute("staff", staff);
                request.getRequestDispatcher("views/staff/update.jsp?msg=3").forward(request, response);
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        if (admin != null) {
            String idStaff = request.getParameter("idStaff");
            StaffBO staffBO = new StaffBO();
            PositionBO positionBO = new PositionBO();
            DepartmentBO departmentBO = new DepartmentBO();
            List<Department> dep = departmentBO.getListDepartments();
            List<Position> pos = positionBO.getListPositions();
            Staff staff = staffBO.getById(idStaff);
            request.setAttribute("dep", dep);
            request.setAttribute("pos", pos);
            request.setAttribute("staff", staff);
            request.getRequestDispatcher("views/staff/update.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
