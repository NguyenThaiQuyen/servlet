<%@ include file="/templates/pages/loadCSS.jsp" %>

<!-- page content -->
<div class="right_col" role="main">
    <div class="page-title">
        <div class="title_left">
            <% String follow = (String)request.getAttribute("by");%>
            <h3>Tables Staffs <%= follow %></h3>
        </div>

        <div class="title_right">
            <div class="form-group pull-right top_search width-custom">
                <div class="input-group">
                    <input type="text" class="form-control js-search" placeholder="Search for...">
                    <input type="text" class="form-control " id="url" hidden value="<%= request.getContextPath() %>/SearchServlet">
                    <span class="input-group-btn">
                <button class="btn btn-default" type="button">Go!</button>
              </span>
                </div>
            </div>
        </div>
    </div>

    <%
        if(request.getParameter("msg")!=null) {
            int code = Integer.parseInt(request.getParameter("msg"));
            String message = "";
            switch (code) {
                case 0: {
                    message = "Update successfully!";
                    break;
                }
                case 3: {
                    message = "Update fail!";
                    break;
                }
                default: message = "";
            }
    %>
    <div class="title_right notification" >
        <div class="form-group pull-right top_search width-custom">
            <% if (code == 0) {
            %>
            <div class="alert alert-success">
                <strong> <%= message%></strong>
            </div>
            <% } else {
            %>
            <div class="alert alert-danger">
                <strong> <%= message%></strong>
            </div>
            <%
                }
            %>
        </div>
    </div>
    <%
        }
    %>

    <div class="x_content">
        <% List<Staff> staffs = (List<Staff>)request.getAttribute("staffs");
            %>
        <div class="custom-font">
            <h2>Total staffs: <%= staffs.size() %></h2>
        </div>
        <hr>
        <input type="text" class="form-control " id="urlItemUpdate" hidden value="<%= request.getContextPath() %>/UpdateStaffServlet">
        <input type="text" class="form-control " id="urlItemDelete" hidden value="<%= request.getContextPath() %>/DeleteStaffServlet">

        <div class="table-responsive">
            <table class="table table-striped jambo_table bulk_action">
                <thead>
                <tr class="headings">
                    <th class="column-title">Order </th>
                    <th class="column-title">ID </th>
                    <th class="column-title">FullName </th>
                    <th class="column-title">Gender </th>
                    <th class="column-title">Position </th>
                    <th class="column-title">Department </th>
                    <th class="column-title no-link last"><span class="nobr">Action</span>
                    </th>
                </tr>
                </thead>
                <%
                    for (Staff staff : staffs) {
                %>
                <tbody>
                <tr class="even pointer">
                    <th class="column-title"><%= staffs.indexOf(staff)+1 %> </th>
                    <td class=" "> <%= staff.getID() %></td>
                    <td class=" "> <%= staff.getFullName()%></td>
                    <td class=" "> <%= staff.getGender()%> </td>
                    <td class=" "> <%= staff.getPosition() %></td>
                    <td class=" "> <%= staff.getDepartment() %></td>
                    <td class=" last">
                        <a href="<%= request.getContextPath() %>/UpdateStaffServlet?idStaff=<%= staff.getID()%>">
                            <i class="fa fa-edit icon-custom"></i>
                        </a>
                        <a href="<%= request.getContextPath() %>/DeleteStaffServlet?idStaff=<%= staff.getID()%>">
                            <i class="fa fa-trash icon-custom"></i>
                        </a>
                    </td>
                </tr>
                </tbody>
                <%
                    }
                %>
            </table>
        </div>
    </div>
</div>
<!-- /page content -->

<%@ include file="/templates/pages/loadJS.jsp" %>