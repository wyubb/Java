<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<style type="text/css">
body {
	font-size: 20px;
	padding-bottom: 40px;
	background-color: #white;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}

.btn {
	position: absolute;
	top: 30%;
	left: 40%;
	color: blue;
	font-size: 20px;
}
</style>
<script type="text/javascript">
			function checkInput() {
				var name = document.form1.name1.value;
				var age = document.form1.age.value;
				var a =isNaN(age);
				if(name == "") {
					alert("请输入姓名!");
					return false;
				} else if(age == "") {
					alert("请输入年龄!");
					return false;
				} else if(a){
				alert("年龄有误!");
					return false;
				}else{
				return true;
				}
			}
		</script>

</head>

<body>
	<form name="form1" action="./student_upStudent.do" method="post"
		onsubmit="return checkInput()" enctype="multipart/form-data">
		<span>修改学生:</span><input style="font-size: 20px;" type="text"
			name="name" value="${param.name }" readonly="readonly">
		<table class="table1"
			style="margin-left:10px;margin-top:3px; font-size: 20px;">
			<tr>
				<td class="tableleft">新的姓名</td>
				<td><input type="text" name="student.name" value="${param.name }" id="name1" />
					<!-- disabled -->
				</td>
				<td class="tableleft">年龄</td>
				<td><input type="text" name="student.age"  id="age"/></td>
			</tr>
			<br>
			<tr>
				<br>
				<td width="10%" class="tableleft">学生班级</td>
				<td><select name="student.grade">
						<option value='java' />&nbsp;Java
						<option value='安卓' />&nbsp;安卓
				</select>
				<td width="10%" class="tableleft">学生性别</td>
				<td><select name="student.gender">
						<option value='男' />&nbsp;男
						<option value='女' />&nbsp;女
				</select>
				</td>
			</tr>

		</table>
		<img alt="" src="./${param.url }" width="50px" height="50px">
		头像文件:<input type="file" name="file" /><br> <br /> <br /> <br />
		<input type="submit" value="提交" class="btn">
	</form>
</body>

</html>