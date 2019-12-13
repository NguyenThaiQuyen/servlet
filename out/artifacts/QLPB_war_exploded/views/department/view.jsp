<%@ page import="packages.department.Department" %>
<%@ page import="java.util.List" %>

<%@ include file="/templates/pages/loadCSS.jsp" %>

<!-- page content -->
<div class="right_col" role="main">
    <div class="page-title">
        <div class="title_left">
            <h3>Tables Departments</h3>
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
                    <th class="column-title">Name </th>
                    <th class="column-title">Description </th>
                    <th class="column-title no-link last"><span class="nobr">Action</span>
                    </th>
                </tr>
                </thead>

                <% List<Department> dep = (List<Department>)request.getAttribute("dep");
                    for (Department d : dep) {
                %>
                <tbody>
                <tr class="even pointer">
                    <td class="a-center ">
                        <input type="checkbox" class="flat" name="table_records">
                    </td>
                    <td class=" "> <%= d.getID() %></td>
                    <td class=" "> <%= d.getName()%></td>
                    <td class=" "> <%= d.getDescription()%> </td>
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
