package packages.position;

import packages.admin.Admin;
import packages.staff.Staff;
import packages.staff.StaffBO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ViewPositionServlet")
public class ViewPositionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        if (admin != null) {
            PositionBO positionBO = new PositionBO();
            List<Position> pos = positionBO.getListPositions();
            request.setAttribute("pos", pos);
            request.getRequestDispatcher("views/position/view.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
