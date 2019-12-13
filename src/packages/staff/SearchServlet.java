package packages.staff;

import packages.admin.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Admin admin = (Admin)request.getSession().getAttribute("admin");
        if (admin != null) {
            String keyWord = request.getParameter("key");
            PrintWriter io = response.getWriter();
            StaffBO s = new StaffBO();
            List<Staff> staffs = s.getListStaffSearch(keyWord);
            int size = staffs.size();
            String html = "";
            for (Staff staff : staffs) {
                html += "<tbody>"
                        + "<tr class=\"even pointer\">"
                        + "<th class=\"column-title\">" + (staffs.indexOf(staff) + 1) + "</th>"
                        + "<td >" + staff.getID() + "</td>"
                        + "<td >" + staff.getFullName() + "</td>"
                        + "<td >" + staff.getGender() + "</td>"
                        + "<td >" + staff.getPosition() + "</td>"
                        + "<td>" + staff.getDepartment() + "</td>"
                        + "<td class=\"last\">"
                        + "<a href=\"" + request.getContextPath() + "/UpdateStaffServlet?idStaff=" + staff.getID() + "\">"
                        + "<i class=\"fa fa-edit icon-custom\"></i>"
                        + "</a>"
                        + "<a href=\"" + request.getContextPath() + "/DeleteStaffServlet?idStaff=" + staff.getID() + "\">"
                        + "<i class=\"fa fa-trash icon-custom\"></i>"
                        + "</a>"
                        + "</td>"
                        + "</tr>"
                        + "</tbody>";
            }
                String htmlBig = "<div class=\"custom-font\">\n" +
                        "            <h2>Total staffs:" + size + " </h2>\n" +
                        "        </div>\n" +
                        "        <hr>\n" +
                        "        <div class=\"table-responsive\">\n" +
                        "            <table class=\"table table-striped jambo_table bulk_action\">\n" +
                        "                <thead>\n" +
                        "                <tr class=\"headings\">\n" +
                        "                    <th class=\"column-title\">Order </th>\n" +
                        "                    <th class=\"column-title\">ID </th>\n" +
                        "                    <th class=\"column-title\">FullName </th>\n" +
                        "                    <th class=\"column-title\">Gender </th>\n" +
                        "                    <th class=\"column-title\">Position </th>\n" +
                        "                    <th class=\"column-title\">Department </th>\n" +
                        "                    <th class=\"column-title no-link last\"><span class=\"nobr\">Action</span>\n" +
                        "                    </th>\n" +
                        "                </tr>\n" +
                        "                </thead>"+
                        html +
                        "            </table>\n" +
                        "        </div>";
                io.print(htmlBig);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
