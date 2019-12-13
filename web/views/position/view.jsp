<%@ page import="packages.position.Position" %>
<%@ include file="/templates/pages/loadCSS.jsp" %>

<!-- page content -->
<div class="right_col" role="main">
    <div class="page-title">
        <div class="title_left">
            <h3>Tables Positions</h3>
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
                <% List<Position> pos = (List<Position>)request.getAttribute("pos");
                    for (Position p : pos) {
                %>
                <tbody>
                <tr class="even pointer">
                    <td class="a-center ">
                        <input type="checkbox" class="flat" name="table_records">
                    </td>
                    <td class=" "> <%= p.getID() %></td>
                    <td class=" "> <%= p.getName()%></td>
                    <td class=" "> <%= p.getDescription()%> </td>
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