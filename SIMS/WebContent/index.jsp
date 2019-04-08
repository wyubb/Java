<%@ page contentType = "text/html; charset = utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang = "zh-CN">
	<head>
		<meta charset = "utf-8">
		<meta http-equiv = "X-UA-Compatible" content = "IE = edge">
		<meta name = "viewport" content = "width = device-width, initial-scale = 1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<!-- Bootstrap core CSS -->
		<link href = "css/bootstrap.min.css" rel = "stylesheet">
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
		<link href = "css/ie10-viewport-bug-workaround.css" rel = "stylesheet">
		<!-- Custom styles for this template -->
		<link href = "css/signin.css" rel = "stylesheet">
		<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
		<!--[if lt IE 9]><script src = "../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
		<script src = "js/ie-emulation-modes-warning.js"></script>
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
			<script src = "https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src = "https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
		<title> 学生综合测评管理系统 </title>
		<script src = "js/javascript.js"></script>
	</head>
	<%
	    String error = (String)request.getAttribute("error");
	    if(error != null){%>
	        <script> error(); </script>
	    	<%  request.removeAttribute("error");
    	}
	    String update = (String)session.getAttribute("update");
	    if(update != null){%>
	        <script> updateSuccess(); </script>
	    <% session.removeAttribute("update");
	    }
	   	String username = (String)session.getAttribute("username");
	    if(username == null) username = "";
	  %>
	<body>

		<div class = "container">

			<form class = "form-signin" method = "post" action = "login.sims">
				<h2 class = "form-signin-heading">登录窗口</h2>
				<input class = "form-control" type = "text" id = "username" name = "username" placeholder = "请输入你的学号或工号" value = "<%=username%>"  maxlength = "10" required autofocus>
				<input class = "form-control" type = "password" id = "password" name = "password" placeholder = "请输入密码"  maxlength = "10" required>
				<input class = "form-control" type = "text" id = "yzm" name = "yzm" placeholder = "请输入右边的数字" required>
				<div class = "checkbox">
          			<label>
            			<input type = "checkbox" id = "remember" name = "remember" value="remember-me"> 记住我
          			</label>
        		</div>
				<button class = "btn btn-lg btn-primary btn-block" type = "submit">登录</button>
			</form>

		</div> <!-- /container -->
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
	</body>
</html>
<% if(username != ""){%> <script> chooseRemember("<%=username%>"); </script><%}%>
