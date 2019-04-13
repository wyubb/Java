<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.*,domain.*,service.imp.*,dao.imp.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>所有学生信息</title>
</head>
<body>
<div id="menu">
				<a href =	 "data.jsp">个人资料</a>		
				<a href = "main.jsp">公示信息浏览</a>
				<a href = "class.jsp">班级列表</a>
				<a href = "register.jsp">添加管理员</a>			
				<a href = "addinformation.jsp">发布信息</a>
				<a href = "addclasses.jsp">添加班级</a>
				<a href = "class_student_detail.jsp">所有学生信息</a>
				<a href = "addstudent.jsp">添加学生</a>
				<a href = "login.jsp">退出</a>
				<h3>管理员：<%=((User)session.getAttribute("user")).getUserName() %></h3>				
</div>	
<jsp:useBean id="studentService" class="service.imp.StudentService" scope="session"></jsp:useBean>
<%
    //调用业务逻辑层方法，获取所有信息列表
	List<Student> list = studentService.getAllStudent();
%>
	<%
		for(Student student:list){
			
	%>	
		<p>学号:<%=student.getStudent_id()%> 姓名：<%=student.getStudent_name()%> 绩点：<%=student.getGpa() %>绩点排名：<%=student.getClass_gpa() %></p>
	<%
			
		}
	%>			
<a href = "addstudent.jsp">添加学生</a>
</body>
</html>