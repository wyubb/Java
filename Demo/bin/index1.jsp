<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
int first = 0;
int second = 0;
if(request.getParameter("first")!=null&&request.getParameter("first").length()>0)
{
first = Integer.parseInt(request.getParameter("first"));
}
if(request.getParameter("second")!=null&&request.getParameter("second").length()>0)
{
second = Integer.parseInt(request.getParameter("second"));
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
 <meta http-equiv="pragma" content="no-cache">
 <meta http-equiv="cache-control" content="no-cache">
 <meta http-equiv="expires" content="0">    
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
 <meta http-equiv="description" content="This is my page">
 <!--
 <link rel="stylesheet" type="text/css" href="styles.css">
 -->
 <script type="text/javascript">
function check()
{
if(this.document.forms[0].first.value.length==0)
alert("请输入第一个整数!");
else if(this.document.forms[0].second.value.length==0)
alert("请输入第二个整数!");
else if (isNaN(this.document.forms[0].first.value))
alert("输入的第一个数字必须是整型数据");
else if (isNaN(this.document.forms[0].second.value))
alert("输入的第二个数字必须是整型数据");
else
this.document.forms[0].submit();
}
</script>
  </head>
  
  <body> 
    This is my JSP page14122scavsd1. <br>
    This is my JSP page14122scavsd1. <br>
   这个JSP 页面的功能是求两个整数的和<br>
   
   <form action="Helloworld" method="post">
<font size="2">
这个JSP 页面的功能是求两个整数的和：<br>
请输入第一个数：<input type="text" name="first"/><br>
请输入第二个数：<input type="text" name="second"/><br>
这两个数的和为：<%=(first+second) %><br></font>
<button type="submit" value="求和" ></button><br>
</form>
  </body>
</html>

