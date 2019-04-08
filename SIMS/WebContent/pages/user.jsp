<%@ page contentType = "text/html; charset = utf-8" import = "java.util.*"%>
<%! String type = "";%>
<%
    Map M = (HashMap)session.getAttribute("userInfo");
    if(M == null) response.sendRedirect("index.jsp");
    String aa = (String)M.get("aa");
    if(!aa.equals("0")) response.sendRedirect("pages/sl.jsp");
    String attr = (String)session.getAttribute("attr");
    Map m = (HashMap)session.getAttribute("user");
    if(attr.equals("add")) type = "password";
    else type = "text";
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
    <title> <%=Attr%> User </title>
    <script src = "../js/javascript.js"></script>
    <script src = "../js/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#username").blur(function(){
                $.post("checkUsername.sims",
                {
                    oldUn:"<%=m.get("username")%>",
                    newUn:$(this).val()
                },
                    function(data){
                        if(data == "true")
                            alert("The username already exists!");
                });
            });
            $("#password").blur(function(){
                if("<%=attr%>" == "update")
                    changeCPW();
            });
        });
    </script>
</head>
<body>
    <nav class = "navbar navbar-inverse navbar-fixed-top">
      <div class = "container">
        <div class = "navbar-header">
          <a class = "navbar-brand" href = "">Student Information Manange System</a>
        </div>
        <div id = "navbar" class = "navbar-collapse collapse">
          <ul class = "nav navbar-nav pull-right">
            <li><a href = "refreshUser.sims">User List</a></li>
            <li><a href = "refreshStu.sims">Student Information List</a></li>
            <li class = "dropdown">
                <a href = "" class = "dropdown-toggle" data-toggle = "dropdown" role = "button" aria-haspopup = "true" aria-expanded = "false">
                    <%= M.get("nn")%> <span class = "caret"></span></a>
                <ul class = "dropdown-menu dropdown-menu-right">
                    <li class = "dropdown-header"> Username:<%= M.get("un")%>
                    <% if(aa.equals("0")){%> <span class="label label-warning">SA</span> <%}
                    else if(aa.equals("1")){%> <span class="label label-danger">AD</span> <%}
                    else if(aa.equals("2")){%> <span class="label label-primary">AD</span> <%}
                    else if(aa.equals("3")){%> <span class="label label-default">AD</span> <%}%></li>
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
            <form class = "form-signin" method = "post" action = "<%=attr%>User.sims" onsubmit = "return checkUser()">
                <h1 class = "form-signin-heading"><%=Attr%> User</h1>
                <div class="input-group input-group-lg">
                  <span class="input-group-addon">Nickname:&nbsp;&nbsp;</span>
                  <input type="text" class="form-control" id="nickname" name = "nickname" value = "<%=m.get("nn")%>" required autofocus/>
                </div>
                <div class="input-group input-group-lg">
                  <span class="input-group-addon">Username:&nbsp;</span>
                  <input type="text" class="form-control" id="username" name = "username" value = "<%=m.get("un")%>" required/>
                </div>
                <div class="input-group input-group-lg">
                  <span class="input-group-addon">Password:&nbsp;&nbsp;</span>
                  <input type="<%=type%>" class="form-control" id="password" name = "password" value = "<%=m.get("pw")%>" required/>
                </div>
                <%if(!attr.equals("add")){%><div class = "hidden"><%}%>
                <div class="input-group input-group-lg">
                    <span class="input-group-addon">ConfirmPW:</span>
                    <input type="<%=type%>" class="form-control" id="confirmPW" name = "confirmPW" value = "<%=m.get("pw")%>"/>
                </div>
                <%if(!attr.equals("add")){%></div><%}%>
                <div class = "input-group input-group-lg">
                    <span class="input-group-addon">Authority:&nbsp;&nbsp;&nbsp;&nbsp;</span>
                    <select class = "form-control" id = "adminAty" name = "adminAty">
                        <option value = "0"> Super Admin </option>
                        <option value = "1"> Admin </option>
                        <option value = "2"> Teacher </option>
                        <option value = "3"> Student </option>
                    </select>
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
<script > chooseUser("<%=m.get("aa")%>"); </script>
