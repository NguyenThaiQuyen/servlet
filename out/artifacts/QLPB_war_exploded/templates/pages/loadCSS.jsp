<%@ page import="packages.staff.Staff" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="<%= request.getContextPath() %>/templates/public/images/favicon.ico" type="image/ico" />

    <title>Home | </title>

    <!-- Bootstrap -->
    <link href="<%= request.getContextPath() %>/templates/public/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<%= request.getContextPath() %>/templates/public/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="<%= request.getContextPath() %>/templates/public/css/nprogress.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="<%= request.getContextPath() %>/templates/public/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="<%= request.getContextPath() %>/templates/public/css/custom.min.css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/templates/public/css/custom-css.css" rel="stylesheet">

</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>ADMIN!</span></a>
                </div>

                <div class="clearfix"></div>

                <!-- menu profile quick info -->
                <div class="profile clearfix">
                    <div class="profile_pic">
                        <img src="<%= request.getContextPath() %>/templates/public/images/img.jpg" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>Welcome,</span>
                        <h2>Admin</h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br />

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <h3>General</h3>
                        <ul class="nav side-menu">
                            <li><a href="<%= request.getContextPath() %>/DashBoardServlet"><i class="fa fa-home"></i> Home <span ></span></a>
                            </li>
                            <li><a><i class="fa fa-edit"></i> Staff <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="<%= request.getContextPath() %>/ViewStaffServlet">View all staff</a></li>
                                    <li><a href="<%= request.getContextPath() %>/CreateStaffServlet">Create staff</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-desktop"></i> Position <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="<%= request.getContextPath() %>/ViewPositionServlet">View all position</a></li>
                                    <li><a href="<%= request.getContextPath() %>/CreatePositionServlet">Create position</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-table"></i> Department <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="<%= request.getContextPath() %>/ViewDepartmentServlet">View all department</a></li>
                                    <li><a href="<%= request.getContextPath() %>/CreateDepartmentServlet">Create department</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- /sidebar menu -->

            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <div class="nav toggle">
                    <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                </div>
                <nav class="nav navbar-nav">
                    <ul class=" navbar-right">
                        <li class="nav-item dropdown open" style="padding-left: 15px;">
                            <a href="javascript:;" class="user-profile dropdown-toggle" aria-haspopup="true" id="navbarDropdown" data-toggle="dropdown" aria-expanded="false">
                                <img src="../images/img.jpg" alt="">Admin
                            </a>
                            <div class="dropdown-menu dropdown-usermenu pull-right" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item"  href="javascript:;">Help</a>
                                <a class="dropdown-item"  href="<%=request.getContextPath()%>/LogoutServlet"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                            </div>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->