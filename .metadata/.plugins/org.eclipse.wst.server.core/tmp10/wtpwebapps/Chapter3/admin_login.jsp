<%@ page language="java" contentType="text/html; charset=gbk"
 %>
  <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<meta http-equiv="X-UA-Compatible" content="ie=edge">
    <base href="<%=basePath%>">
    
    <title>学生综合测评管理系统-管理员登录界面</title>
	 <!-- 引入 Bootstrap 样式库 -->
  <link href="./libs/bootstrap@3.3.7.min.css" rel="stylesheet">

  <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
  <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
  <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
  <![endif]-->

  <!-- 本页面样式  -->
  <style>
    body {
      background-color: #eee;
    }
    .container {
      width: 330px;
      padding-top: 100px;
      display: flex;
      flex-direction: column;
      align-items: center;
    }
    h1 {
      font-size: 25px;
      font-weight: 400;
      margin-bottom: 30px;
    }
    .input {
      margin-bottom: 15px;
    }
    .btn {
      margin-top: 15px;
    }
  </style>
  </head> 
  <body>  		
	<form class="container" action="process_admin_login.jsp" method = "post">
    <h1>学生综合测评管理系统</h1>
    <input type="text" class="form-control input" placeholder="请输入您的工号" name="username" required = "required">
    <input type="password" class="form-control input" placeholder="请输入密码" name="password" required = "required">
    <input type = "text"  class="form-control input"  required = "required" name = "yzm" placeholder = "请输入验证码" >
    <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
  </form>	
  </body>
</html>
