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
    <title> Student Information List </title>
</head>
<%
    Map m = (HashMap)session.getAttribute("userInfo");
    if(m == null) response.sendRedirect("../index.jsp");
    String aa = (String)m.get("aa");
    String delete = (String)session.getAttribute("delete");
    if(delete != null){%>
        <script>deleteSuccess();</script>
    <%  session.removeAttribute("delete");
    }
    int pages = (int)session.getAttribute("page");
    int maxPage = (int)session.getAttribute("maxPage");
    String query = (String)session.getAttribute("query");
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
            <%if(aa.equals("0")){%><li><a href = "refreshUser.sims">
            <%}else{%><li class = "disabled"><a href = ""><%}%>User List</a></li>
            <li class = "active"><a href = "refreshStu.sims">Student Information List</a></li>
            <li class = "dropdown">
                <a href = "" class = "dropdown-toggle" data-toggle = "dropdown" role = "button" aria-haspopup = "true" aria-expanded = "false">
                    <%= m.get("nn")%> <span class = "caret"></span></a>
                <ul class = "dropdown-menu dropdown-menu-right">
                    <li class = "dropdown-header"> Username:<%= m.get("un")%>
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

    <div class = "text-center">
        <h1> Student Information List </h1>
    </div>

    <%if(!aa.equals("3")){%>
    <div class = "row">
      <div class = "col-lg-4"></div>
        <div class = "col-lg-4">
          <div class = "input-group">
            <div class = "input-group-btn">
                <select class="form-control" style = "width: auto" id = "queryBy" name = "queryBy">
                    <option value = "num"> Num </option>
                    <option value = "name"> Name </option>
                    <option value = "sex"> Sex </option>
                    <option value = "birth"> Birth </option>
                    <option value = "tel"> Tel </option>
                    <option value = "score"> Score </option>
                </select>
            </div><!-- /btn-group -->
            <input type = "text" class = "form-control" aria-label = "..." id = "query"/>
            <span class = "input-group-btn">
                <button class = "btn btn-success" type = "button" onclick = "checkQueryStu()">Search</button>
            </span>
          </div><!-- /input-group -->
        </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->

    <div class = "row text-center" style = "padding-top:20px;">
        <div class = "col-lg-3"></div>
        <div class = "col-lg-2">
            <% if(query == null){//查询后无分页功能%>
            <label for = "display"> Display: </label>
            <select id = "display" name = "display" onchange = "display(this)">
                <option value = "all"> Show all </option>
                <option value = "page"> Show pages </option>
            </select>
            <%} else session.removeAttribute("query"); %>
        </div>
        <div class = "col-lg-2">
                <label for = "orderBy"> Order by: </label>
                <select id = "orderBy" name = "orderBy" onchange = "orderBy(this)">
                    <option value = "num"> Num </option>
                    <option value = "name"> Name </option>
                    <option value = "sex"> Sex </option>
                    <option value = "birth"> Birth </option>
                    <option value = "tel"> Tel </option>
                    <option value = "sc"> Score </option>
                </select>
        </div>
        <div class = "col-lg-2">
                <label  for = "order"> Order: </label>
                <select id = "order" name = "order" onchange = "order(this)">
                    <option value = "asc"> Asc </option>
                    <option value = "desc"> Desc </option>
                </select> <br/>
        </div>
    </div>
    <%}%>

    <div class = "row">
      <div class = "col-lg-3"> </div>
      <div class = "col-lg-6">
        <table class = "table table-striped">
            <thead>
                <tr> <th> No. </th> <th> Num </th> <th> Name </th> <th> Sex </th>
                <th> Birth </th> <th> Tel </th> <th> Score </th>
                <% if(!aa.equals("3")){%> <th> operation </th> <%}%> </tr>
            </thead>
            <tbody>
                <%
                    ArrayList a = (ArrayList)session.getAttribute("sl");
                    if(a != null){
                        int i = 1;
                        for(Object o:a){
                            m = (HashMap)o;%>
                            <tr> <td> <%=i++%> </td> <td> <%=m.get("num")%> </td> <td> <%=m.get("name")%></td>
                            <td> <%=m.get("sex")%></td> <td> <%=m.get("birth")%> </td> <td> <%=m.get("tel")%> </td>
                            <td> <%=m.get("sc")%> </td>
                            <% if(!aa.equals("3")){%>
                            <td>
                                <a href = "gotoUpdateStu.sims?id=<%=m.get("id")%>"> Update </a>
                                <% if(!aa.equals("2")){%>
                                <a href = "deleteStu.sims?id=<%=m.get("id")%>"> Delete </a>
                                <%}%>
                            </td>
                            <%}%>
                        </tr>
                        <%}
                    }else{%>
                        <tr> <% if(aa.equals("3")){%> <th colspan = "7" class = "text-center"> <%}else{%> <th colspan = "8" class = "text-center"> <%}%> NULL </th> </tr>
                    <%}%>
            </tbody>
        </table>
      </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->

    <% if(!aa.equals("3")){%>
    <div class = "row">
        <div class = "col-lg-4"></div>
        <div class = "col-lg-4 text-center">
            <% if(pages != -1){%>
                <div class="btn-group" role="group" aria-label="...">
                    <button type="button" class="btn btn-default" onclick = "goPage(0)">Home</button>
                    <%if(pages == 0){%><button type="button" class="btn btn-default disabled">
                    <%}else{%><button type="button" class="btn btn-default" onclick = "goPage(<%=pages-1%>)"><%}%>Pre</button>
                    <%if(pages == maxPage-1){%><button type="button" class="btn btn-default disabled">
                    <%}else{%><button type="button" class="btn btn-default" onclick = "goPage(<%=pages+1%>)"><%}%>Next</button>
                    <button type="button" class="btn btn-default" onclick = "goPage(<%=maxPage-1%>)">End</button>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Forward<span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <%
                                for(int i = 0; i < maxPage; ++i){%>
                                    <li><a href = "updatePage.sims?page=<%=i%>"> Page<%=i+1%> </a></li>
                                <%}%>
                        </ul>
                    </div>
                </div>
            <%}%>
        </div>
        <% if(aa.equals("2")){%>
            <bution class="btn btn-primary disabled" type="button">
        <%}else{%>
            <button class="btn btn-primary" type="button" onclick = "addStu()"><%}%>
                Students: <span class="badge"><%=session.getAttribute("stuNum")%></span>
            </button>
    </div>
    <%}%>

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
<%
    String queryBy = (String)session.getAttribute("studentQueryBy");
    String display = (String)session.getAttribute("display");
    String orderBy = (String)session.getAttribute("orderBy");
    String order = (String)session.getAttribute("order");
%>
<script> chooseStu("<%=queryBy%>","<%=display%>","<%=orderBy%>","<%=order%>");</script>
