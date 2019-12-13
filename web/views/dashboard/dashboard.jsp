<%@ page import="packages.department.Department" %>
<%@ page import="packages.position.Position" %>
<%@ include file="/templates/pages/loadCSS.jsp" %>

<!-- page content -->
<div class="right_col" role="main">
    <div class="row tile_count">
        <div class="col-md-4 col-sm-4  tile_stats_count">
            <span class="count_top"><i class="fa fa-user"></i> Total Staffs</span>
            <div class="count"> <%= request.getAttribute("totalStaffs")%></div>
            <span class="count_bottom"><i class="red"><i class="fa fa-sort-desc"></i>12% </i> From last Week</span>
        </div>
        <div class="col-md-4 col-sm-4  tile_stats_count">
            <span class="count_top"><i class="fa fa-user"></i> Total Departments</span>
            <div class="count"><%= request.getAttribute("totalDepartments")%></div>
            <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i> From last Week</span>
        </div>
        <div class="col-md-4 col-sm-4  tile_stats_count">
            <span class="count_top"><i class="fa fa-user"></i> Total Positions</span>
            <div class="count"><%= request.getAttribute("totalPositions")%></div>
            <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i> From last Week</span>
        </div>
    </div>



    <div class="col-md-6 ">
        <div class="page-title">
            <div class="title_left">
                <h3>All Department</h3>
            </div>
        </div>
        <div class="x_content">
            <div class="table-responsive">
                <table class="table table-striped jambo_table bulk_action">
                    <thead>
                    <tr class="headings">
                        <th class="column-title">Order </th>
                        <th class="column-title">ID </th>
                        <th class="column-title">Name Department</th>
                        <th class="column-title">Description </th>
                        <th class="column-title">Amount Staff </th>
                    </tr>
                    </thead>
                    <% List<Department> dep = (List<Department>)request.getAttribute("dep");
                        for (Department d : dep) {
                    %>
                    <tbody>
                    <tr class="even pointer">
                        <th class="column-title"><%= dep.indexOf(d)+1 %> </th>
                        <td class=" "> <%= d.getID() %> </td>
                        <td class=" "> <a class ="ex1" href="<%= request.getContextPath() %>/ViewStaffServlet?idDep=<%= d.getID()%>"><%= d.getName()%> </a></td>
                        <td class=" "> <%= d.getDescription()%> </td>
                        <td class=" "> <%= d.getAmount() %></td>
                        <input class="text" hidden name="nameDep" value="<%= d.getName()%>">
                    </tr>
                    </tbody>
                    <%
                        }
                    %>
                </table>
            </div>
        </div>
    </div>

    <div class="col-md-6 ">
        <div class="page-title">
            <div class="title_left">
                <h3>All Positions</h3>
            </div>
        </div>
        <div class="x_content">
            <div class="table-responsive">
                <table class="table table-striped jambo_table bulk_action">
                    <thead>
                    <tr class="headings">
                        <th class="column-title">Order </th>
                        <th class="column-title">ID </th>
                        <th class="column-title">Name Position </th>
                        <th class="column-title">Description </th>
                        <th class="column-title">Amount Staff </th>
                    </tr>
                    </thead>
                    <% List<Position> pos = (List<Position>)request.getAttribute("pos");
                        for (Position p : pos) {
                    %>
                    <tbody>
                    <tr class="even pointer">
                        <th class="column-title"><%= pos.indexOf(p)+1 %> </th>
                        <td class=" "> <%= p.getID() %></td>
                        <td class=" "> <a class ="ex1" href="<%= request.getContextPath() %>/ViewStaffServlet?idPos=<%= p.getID()%>"><%= p.getName() %> </a></td>
                        <td class=" "> <%= p.getDescription()%> </td>
                        <td class=" "> <%= p.getAmount() %></td>
                    </tr>
                    </tbody>
                    <%
                        }
                    %>
                </table>
            </div>
        </div>
    </div>
</div>
<!-- /page content -->

<%@ include file="/templates/pages/loadJS.jsp" %>