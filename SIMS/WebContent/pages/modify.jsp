<%@ page contentType = "text/html; charset = utf-8" import = "java.util.*"%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
        <!-- Bootstrap core CSS -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <!-- Bootstrap theme -->
        <link href="../css/bootstrap-theme.min.css" rel="stylesheet">
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="../css/ie10-viewport-bug-workaround.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="../css/theme.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <script src="../js/ie-emulation-modes-warning.js"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script src = "../js/javascript.js"> </script>
        <title> Update Password </title>
    </head>
    <%Map M = (HashMap)session.getAttribute("userInfo");
    if(M == null) response.sendRedirect("index.jsp");
    String aa = (String)M.get("aa");%>
    <body>
        <nav class = "navbar navbar-inverse navbar-fixed-top">
          <div class = "container">
            <div class = "navbar-header">
              <a class = "navbar-brand" href = "">Student Information Manange System</a>
            </div>
            <div id = "navbar" class = "navbar-collapse collapse">
              <ul class = "nav navbar-nav pull-right">
                <%if(aa.equals("0")){%><li><a href = "refreshUser.sims">
                <%}else{%><li class = "disabled"><a href = ""><%}%>User List</a></li>
                <li class = "active"><a href = "refreshStu.sims">Student Information List</a></li>
                <li class = "dropdown">
                    <a href = "" class = "dropdown-toggle" data-toggle = "dropdown" role = "button" aria-haspopup = "true" aria-expanded = "false">
                        <%= M.get("nn")%> <span class = "caret"></span></a>
                    <ul class = "dropdown-menu dropdown-menu-right">
                        <li class = "dropdown-header"> Username:<%= M.get("un")%>
                        <% if(aa.equals("0")){%> <span class="label label-warning">SA</span> <%}
                        else if(aa.equals("1")){%> <span class="label label-danger">AD</span> <%}
                        else if(aa.equals("2")){%> <span class="label label-primary">TE</span> <%}
                        else if(aa.equals("3")){%> <span class="label label-default">ST</span> <%}%></li>
                        <li><a href = "modify.jsp">Modify Password</a></li>
                        <li><a href = "exit.sims">Exit</a></li>
                    </ul>
                </li>
              </ul>
            </div><!--/.nav-collapse -->
          </div>
        </nav>

        <div class = "container">
            <div class = "col-lg-4"></div>
            <div class = "col-lg-4">
                <form class = "form-signin" method = "post" action = "updatePassword.sims" onsubmit = "return check()">
                    <h1 class = "form-signin-heading">Modify Password</h1>
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon">Username:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                      <input type="text" class="form-control" id="username" name = "username" value = "<%=M.get("un")%>" readonly/>
                    </div>
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon">New Password:</span>
                      <input type="password" class="form-control" id="npw" name = "npw" required autofocus/>
                    </div>
                    <div class="input-group input-group-lg">
                      <span class="input-group-addon">Confirm PW:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                      <input type="password" class="form-control" id="cpw" name = "cpw" required/>
                    </div>
                    <button class = "btn btn-lg btn-primary btn-block" type = "submit" id = "submit">Submit</button>
                </form>
            </div>
        </div> <!-- /container -->
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="../js/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/docs.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="../js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
