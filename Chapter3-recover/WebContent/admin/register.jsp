<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.*,domain.*,service.imp.*"%><html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加用户</title>
</head>
<body>
<jsp:useBean id="infoService" class="service.imp.InfoService" scope="session"></jsp:useBean>

<div>	
				
			<div id="menu">
				<a href =	 "data.jsp">个人资料</a>		
				<a href = "main.jsp">公示信息浏览</a>
				<a href = "class.jsp">班级列表</a>
				<a href = "register.jsp">添加管理员</a>			
				<a href = "addinformation.jsp">发布信息</a>
				<a href = "addclasses.jsp">添加班级</a>
				<a href = "class_student_detail.jsp">所有学生信息</a>
				<a href = "login.jsp">退出</a>
				<h3>管理员：<%=((User)session.getAttribute("user")).getUserName() %></h3>				
		</div>	
			<div class="post">
				<div class="header">
					<h3>个人信息</h3>					
				</div>
				<div class="content">
					<form action="process_register.jsp" method="post">
                       <table id ="userInfo_table">
							<tr>
								<td>
									<label>用户名</label>
							 	</td>
								<td>
									<input type="text" name="userName"/>
								</td>
							</tr>
							<tr>
								<td>
									<label>性    别</label>
							 	</td>
								<td>
									<select name="gender">
										<option value="男" selected="selected">男</option>
                                        <option value="女">女</option>
									</select>
								</td>
							</tr>
                            <tr>
								<td>
									<label>真实姓名</label>
							 	</td>
								<td>
									<input type="text" name="realName"/>
								</td>
							</tr>
                            <tr>
								<td>
									<label>密码</label>
							 	</td>
								<td>
									<input type="password" name="password"/>
								</td>
							</tr>
                            <tr>
								<td>
									<label>年龄</label>
							 	</td>
								<td>
									<input type="text" name="age"/>
								</td>
							</tr>
                            <tr>
								<td>
									<label>个性签名</label>
							 	</td>
								<td>
									<textarea rows="3" cols="18" name="personalSignature"></textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type ="submit" value="注册"/>
								</td>
							</tr>
						</table>
					</form>
				</div>											
</div>
</body>
</html>

