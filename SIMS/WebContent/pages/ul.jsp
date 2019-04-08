<%@ page contentType = "text/html; charset = utf-8" import = "java.util.*" %>
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
    <title> User List</title>
</head>
<%
    Map m = (HashMap)session.getAttribute("userInfo");
    if(m == null) response.sendRedirect("index.jsp");
    String aa = (String)m.get("aa");
    if(!aa.equals("0")) response.sendRedirect("pages/sl.jsp");
    String delete = (String)session.getAttribute("delete");
    if(delete != null){%>
        <script>deleteSuccess();</script>
    <%  session.removeAttribute("delete");
    }
%>
<body>
    <!-- Fixed navbar -->
    <nav class = "navbar navbar-inverse navbar-fixed-top">
      <div class = "container">
        <div class = "navbar-header">
          <a class = "navbar-brand" href = "">Student Information Manange System</a>
        </div>
        <div id = "navbar" class = "navbar-collapse collapse">
          <ul class = "nav navbar-nav pull-right">
            <li class = "active"><a href = "refreshUser.sims">User List</a></li>
            <li><a href = "refreshStu.sims">Student Information List</a></li>
            <li class = "dropdown">
                <a href = "" class = "dropdown-toggle" data-toggle = "dropdown" role = "button" aria-haspopup = "true" aria-expanded = "false">
                    <%= m.get("nn")%> <span class = "caret"></span></a>
                <ul class = "dropdown-menu dropdown-menu-right">
                    <li class = "dropdown-header"> Username:<%= m.get("un")%>
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

    <div class = "text-center">
        <h1> User List </h1>
    </div>

    <div class = "row">
      <div class = "col-lg-4"></div>
        <div class = "col-lg-4">
          <div class = "input-group">
            <div class = "input-group-btn">
                <select class="form-control" style = "width: auto" id = "queryBy" name = "queryBy">
                    <option value = "nickname"> Nickname </option>
                    <option value = "username"> Username </option>
                    <option value = "adminAty"> Authority </option>
                </select>
            </div><!-- /btn-group -->
            <input type = "text" class = "form-control" aria-label = "..." id = "query"/>
            <span class = "input-group-btn">
                <button class = "btn btn-success" type = "button" onclick = "checkQueryUser()">Search</button>
            </span>
          </div><!-- /input-group -->
        </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->

    <div class = "row">
      <div class = "col-lg-3"> </div>
      <div class = "col-lg-6">
        <table class = "table table-striped">
            <thead>
                <tr> <th> No. </th> <th> Nickname </th> <th> Username </th>
                <th> Password </th> <th> Adminauthority </th> <th> operation </th> </tr>
            </thead>
            <tbody>
                <%
                    ArrayList a = (ArrayList)session.getAttribute("ul");
                    if(a != null){
                        int i = 1;
                        for(Object o:a){
                            m = (HashMap)o;%>
                            <tr> <td> <%=i++%> </td> <td> <%=m.get("nn")%> </td><td> <%=m.get("un")%></td>
                            <td> <%=m.get("pw")%> </td> <td> <script> very("<%=m.get("aa")%>"); </script></td>
                            <td> <a href = "gotoUpdateUser.sims?id=<%=m.get("id")%>"> Update </a>
                                <a href = "deleteUser.sims?id=<%=m.get("id")%>"> Delete </a>
                            </td> </tr>
                        <%}
                    }else{%>
                        <tr> <th colspan = "6" class = "text-center"> NULL </th> </tr>
                <%}%>
            </tbody>
        </table>
      </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->

    <div class = "row">
        <div class = "col-lg-8"></div>
            <button class="btn btn-primary" type="button" onclick = "addUser()">
              Users: <span class="badge"><%=session.getAttribute("userNum")%></span>
            </button>
    </div>

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
<% String queryBy = (String)session.getAttribute("userQueryBy");%>
<script> chooseQueryBy("<%=queryBy%>");</script>
