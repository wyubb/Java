<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@ page import="service.imp.StudentService" %>
<%@ page import="domain.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加学生</title>
</head>
<body>
<jsp:useBean id="studentService" class="service.imp.StudentService" scope="session"></jsp:useBean>
<%
  request.setCharacterEncoding("gbk");
    //获取用户学号，"student_id"和addstudent.jsp中name属性为"student_id"的文本框对应
	String student_id=request.getParameter("student_id");

    //获取密码，"password"和addstudent.jsp中name属性为"student_password"的文本框对应
	String password = request.getParameter("student_password");
    
    //获取真实姓名，"student_name"和addstudent.jsp中name属性为"student_name"的文本框对应
	String student_name = request.getParameter("student_name");
    
    //获取性别，"gender"和addstudent.jsp中name属性为"gender"的文本框对应
	String gender = request.getParameter("gender");
    
    //获取年级，"grade"和addstudent.jsp中name属性为"grade"的文本框对应
	String grade = request.getParameter("grade");
    
    //获取电话号码，"student_tel"和addstudent.jsp中name属性为"student_tel"的文本框对应
	String student_tel = request.getParameter("student_tel");
	//获取班级，"student_class"和addstudent.jsp中name属性为“student_class”的文本框对应
	String student_class = request.getParameter("student_class");
	
	Student student = new Student();
	
	//设置用户类对象
	student.setStudent_id(student_id);
	student.setStudent_name(student_name);
	student.setStudent_password(password);
	student.setStudent_sex(gender);
	student.setStudent_tel(student_tel);
	student.setGrade(Integer.parseInt(grade));
	try
	{
		//调用业务逻辑层的方法完成添加功能，studentService与上面的useBean元素中的id属性对应
		studentService.addStudent(student);
%>
        <!-- 注册成功，跳转到登录界面 -->
		<jsp:forward page="admin_main.jsp"></jsp:forward>
<%
	}
	//处理异常
	catch(Exception ex)
	{
		ex.printStackTrace();
			
%>
       <!-- 注册失败，回到原界面 -->
		<jsp:forward page="addstudent.jsp"></jsp:forward>
<%
	}
%>	
</body>
</html>
