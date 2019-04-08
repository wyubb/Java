<%@ page contentType = "text/html; charset = utf-8" import = "java.util.*"%>
<%
    Map M = (HashMap)session.getAttribute("userInfo");
    if(M == null) response.sendRedirect("index.jsp");
    String aa = (String)M.get("aa");
    String attr = (String)session.getAttribute("attr");
    Map m = (HashMap)session.getAttribute("student");
    String Attr = attr.substring(0, 1).toUpperCase() + attr.substring(1);
%>
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
    <title> <%=Attr%> Student </title>
    <script src = "../js/javascript.js"></script>
</head>
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
            <form class = "form-signin" method = "post" action = "<%=attr%>Stu.sims" onsubmit = "return checkStudent()">
                <h1 class = "form-signin-heading"><%=Attr%> Student</h1>
                <div class="input-group input-group-lg">
                  <span class="input-group-addon">Num:&nbsp;&nbsp;</span>
                  <input type="text" class="form-control" id="num" name = "num" value = "<%=m.get("num")%>" <%if(aa.equals("2")){%>readonly<%}else{%>required autofocus<%}%>/>
                </div>
                <div class="input-group input-group-lg">
                  <span class="input-group-addon">Name:</span>
                  <input type="text" class="form-control" id="name" name = "name" value = "<%=m.get("name")%>" <%if(aa.equals("2")){%>readonly<%}else{%>required<%}%>/>
                </div>
                <div class="input-group input-group-lg">
                  <span class="input-group-addon">Sex:&nbsp;&nbsp;&nbsp;</span>
                  <input type="text" class="form-control" id="sex" name = "sex" value = "<%=m.get("sex")%>" <%if(aa.equals("2")){%>readonly<%}else{%>required<%}%>/>
                </div>
                <div class="input-group input-group-lg">
                  <span class="input-group-addon">Birth:&nbsp;&nbsp;</span>
                  <input type="text" class="form-control" id="birth" name = "birth" value = "<%=m.get("birth")%>" <%if(aa.equals("2")){%>readonly<%}else{%>required<%}%>/>
                </div>
                <div class="input-group input-group-lg">
                  <span class="input-group-addon">Tel:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                  <input type="text" class="form-control" id="tel" name = "tel" value = "<%=m.get("tel")%>" <%if(aa.equals("2")){%>readonly<%}else{%>required<%}%>/>
                </div>
                <div class="input-group input-group-lg">
                  <span class="input-group-addon">Score:</span>
                  <input type="text" class="form-control" id="score" name = "score" value = "<%=m.get("sc")%>" required <%if(aa.equals("2")){%>autofocus<%}%>/>
                </div>
                <button class = "btn btn-lg btn-primary btn-block" type = "submit">Submit</button>
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
