<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.css" />
<style type="text/css">
body {
	font-size: 20px;
	padding-bottom: 40px;
	background-color: white;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) { /* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}

.btn {
	position: absolute;
	top: 50%;
	left: 40%;
	color: blue;
	font-size: 20px;
}
</style>
<script type="text/javascript">
			function checkInput() {
				var name = document.form1.name.value;
				var age = document.form1.age.value;
				var a =isNaN(age);
				var file = document.form1.file.value;
				if(name == "") {
					alert("姓名不能为空")
					return false;
				} else if(age == "") {
					alert("年龄不能为空!");
					return false;
				} else if(a){
				alert("年龄错误!");
					return false;
				}else if(file=="")
				{
					alert("头像不能为空!")
					return false;
				}else{
				return true;
				}
			}
		</script>
</head>

<body>
	<strong style="font-size: 20px">添加学生</strong>
	<form name="form1" action="./student_addStudent.do" method="post"
		onsubmit="return checkInput()" enctype="multipart/form-data">
		<table class="table table-bordered table-hover m10"
			style="margin-left:10px;margin-top:3px;">
			<tr>
				<td class="tableleft">学生姓名</td>
				<td><input type="text" name="student.name" id="name" />
				</td>
				<td class="tableleft">年龄</td>
				<td><input type="text" name="student.age" id="age" />
				</td>
			</tr>
			<br>
			<tr>
				<br>
				<td width="10%" class="tableleft">班级</td>
				<td><select name="student.grade">
						<option value='java' />&nbsp;Java
						<option value='安卓' />&nbsp;安卓
				</select>
				<td width="10%" class="tableleft">性别</td>
				<td><select name="student.gender">
						<option value='男' />&nbsp;男
						<option value='女' />&nbsp;女
				</select> <br />头像: <input type="file" name="file" id="file" /><br> <input
					type="submit" value="添加" class="btn">
					</form>
				</td>
			</tr>
		</table>
	</form>
	<p style="color: red">${error}</p>
</body>

</html>