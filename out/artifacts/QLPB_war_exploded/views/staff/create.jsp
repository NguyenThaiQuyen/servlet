<%@ page import="packages.position.Position" %>
<%@ page import="packages.department.Department" %>
<%@ include file="/templates/pages/loadCSS.jsp" %>

<!-- page content -->
<div class="right_col" role="main">
    <div class="page-title">
        <div class="title_left">
            <h3>Create new staff</h3>
        </div>
    </div>
    <%
    if(request.getParameter("msg")!=null) {
        int code = Integer.parseInt(request.getParameter("msg"));
        System.out.println(code);
        String message = "";
        switch (code) {
            case 0: {
                message = "Add successfully!";
                break;
            }
            case 1: {
            message = "The field not empty!";
                break;
            }
            case 2: {
                message = "The field invalid";
                break;
            }
            case 3: {
                message = "Add fail!";
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

    <div class="x_panel">
        <div class="x_content">
            <br />
            <form class="form-horizontal form-label-left" action="<%= request.getContextPath() %>/CreateStaffServlet" method="POST">
                <div class="form-group row ">
                    <label class="control-label col-md-3 col-sm-3 ">Full name</label>
                    <div class="col-md-9 col-sm-9 ">
                        <input type="text" name="fullname" class="form-control" >
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-md-3 col-sm-3  control-label">Gender
                    </label>

                    <div class="radio custome-radio">
                        <input type="radio" class="flat" checked name="radio" value="Female"> Female
                    </div>
                    <div class="radio custome-radio">
                        <input type="radio" class="flat" name="radio" value="Male"> Male
                    </div>
                </div>

                <div class="form-group row">
                    <label class="control-label col-md-3 col-sm-3 ">Position</label>
                    <div class="col-md-9 col-sm-9 ">
                        <select class="form-control" name="pos">
                            <% List<Position> pos = (List<Position>)request.getAttribute("pos");
                                for (Position p : pos) {
                                    %>
                                    <option value="<%= p.getID()%>"><%= p.getName()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="control-label col-md-3 col-sm-3 ">Department</label>
                    <div class="col-md-9 col-sm-9 ">
                        <select class="form-control" name="dep">
                            <% List<Department> dep = (List<Department>)request.getAttribute("dep");
                                for (Department d : dep) {
                            %>
                            <option value="<%= d.getID()%>"><%= d.getName()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-9 col-sm-9  offset-md-3">
                        <button type="button" class="btn btn-primary">Cancel</button>
                        <button type="reset" class="btn btn-primary">Reset</button>
                        <button type="submit" class="btn btn-success">Submit</button>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>

<!-- /page content -->

<%@ include file="/templates/pages/loadJS.jsp" %>