<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.*,domain.*,service.imp.*,dao.imp.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>����ѧ��</title>
</head>
<body>
<div>		
		<div id="menu">
				<a href =	 "data.jsp">��������</a>		
				<a href = "main.jsp">��ʾ��Ϣ���</a>
				<a href = "class.jsp">�༶�б�</a>
				<a href = "register.jsp">���ӹ���Ա</a>			
				<a href = "addinformation.jsp">������Ϣ</a>
				<a href = "addclasses.jsp">���Ӱ༶</a>
				<a href = "class_student_detail.jsp">����ѧ����Ϣ</a>
				<a href = "">����ѧ��</a>
				<a href = "login.jsp">�˳�</a>
				<h3>����Ա��<%=((User)session.getAttribute("user")).getUserName() %></h3>				
		</div>
<div>
		<form action="process_addstudent.jsp" method="post">
		<table>
		<tr>
				<td>
					<label>ѧ��</label>
				</td>
				<td>
					<input type = "text" name = "student_id" "/>
				</td>		
			</tr>
			<tr>
				<td>
					<label>��ʵ����</label>
				</td>
				<td>
					<input type = "text" name = "student_name" "/>
				</td>		
			</tr>
			<tr>
				<td>
					<label>�Ա�</label>
				</td>
				<td>
					<input type = "text" name = "gender" " />
				</td>
			</tr>
			<tr>
				<td>
					<label>�绰����</label>
				</td>
				<td>
					<input type = "text" name = "student_tel" />
				</td>
			</tr>
			<tr>
				<td>
					<label>�꼶</label>
				</td>
				<td>
					<input type = "text" name = "grade"  />
				</td>
			</tr>
			<tr>
				<td>
					<label>�༶</label>
				</td>
				<td>
					<input type = "text" name = "student_class"  />
				</td>
			</tr>
			<tr>
				<td>
					<label>����</label>
				</td>
				<td>
					<input type = "password" name = "student_password" />
				</td>		
			</tr>
			<tr>
				<td>
					<input type = "submit" value = "����">
				</td>
			</tr>	
		
		</div>
</body>
</html>