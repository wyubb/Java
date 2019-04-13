<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.*,domain.*,service.imp.*,dao.imp.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>¼¨µãÇé¿ö</title>
</head>
<body>
<div id="menu">
				<a href =	 "student_data.jsp">¸öÈË×ÊÁÏ</a>
				<a href = "gpa.jsp"	>²é¿´¼¨µãÇé¿ö</a>	
				<a href ="">×ÛºÏ²âÆÀ</a>
				<a href = "student_main.jsp">¹«Ê¾ÐÅÏ¢ä¯ÀÀ</a>				
				<a href = "login.jsp">ÍË³ö</a>			
</div>
<jsp:useBean id="studentService" class="service.imp.StudentService" scope="session"></jsp:useBean>
<p>Ñ§ºÅ£º<%=((Student)session.getAttribute("student")).getStudent_id() %></p>
<p>ÄãµÄ¼¨µã£º<%=((Student)session.getAttribute("student")).getGpa()%></p>
<p>ÄãÔÚ°à¼¶µÄÅÅÃû£º</p>
<p>ÄãÔÚ×¨ÒµµÄÅÅÃû£º</p>
</body>
</html>