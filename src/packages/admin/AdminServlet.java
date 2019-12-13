package packages.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AdminBO adminBO = new AdminBO();
        Admin admin = adminBO.getAdmin(username, password);
        if (admin != null) {
            request.getSession().setAttribute("admin", admin);
            response.sendRedirect("DashBoardServlet");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
