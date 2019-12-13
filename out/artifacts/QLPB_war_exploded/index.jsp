<%--
  Created by IntelliJ IDEA.
  User: quyen
  Date: 12/12/2019
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
  <link href="templates/public/css/styleLogin.css" rel="stylesheet" type="text/css" media="all" />
  <link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
</head>
<body>
<!-- main -->
<div class="main-w3layouts wrapper">
  <h1>Login Admin</h1>
  <div class="main-agileinfo">
    <div class="agileits-top">
      <form action=" <%= request.getContextPath() %>/AdminServlet" method="post">
        <input class="text email" type="text" name="username" placeholder="Username" autocomplete="password" required="">
        <input class="text" type="password" name="password" placeholder="Password" autocomplete="password" required="">
        <br>
        <button class='btn-submit'>LOGIN</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>
