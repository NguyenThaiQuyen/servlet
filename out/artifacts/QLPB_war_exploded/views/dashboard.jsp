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

    <hr></hr>
    <div class="page-title">
        <div class="title_left">
            <h3>All staffs</h3>
        </div>

        <div class="title_right">
            <div class="form-group pull-right top_search width-custom">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">Go!</button>
                    </span>
                </div>
            </div>
        </div>
    </div>

    <div class="x_content">
        <div class="table-responsive">
            <table class="table table-striped jambo_table bulk_action">
                <thead>
                <tr class="headings">
                    <th>
                        <input type="checkbox" id="check-all" class="flat">
                    </th>
                    <th class="column-title">ID </th>
                    <th class="column-title">FullName </th>
                    <th class="column-title">Gender </th>
                    <th class="column-title">Position </th>
                    <th class="column-title">Department </th>
                    <th class="column-title no-link last"><span class="nobr">Action</span>
                    </th>
                </tr>
                </thead>
                <% List<Staff> staffs = (List<Staff>)request.getAttribute("staffs");
                    for (Staff staff : staffs) {
                        %>
                <tbody>
                <tr class="even pointer">
                    <td class="a-center ">
                        <input type="checkbox" class="flat" name="table_records">
                    </td>
                    <td class=" "> <%= staff.getID() %></td>
                    <td class=" "> <%= staff.getFullName()%></td>
                    <td class=" "> <%= staff.getGender()%> </td>
                    <td class=" "> <%= staff.getPosition() %></td>
                    <td class=" "> <%= staff.getDepartment() %></td>
                    <td class=" last">
                        <a href="../html/updateStaff.html">
                            <i class="fa fa-edit icon-custom"></i>
                        </a>
                        <a href="../html/updateStaff.html">
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