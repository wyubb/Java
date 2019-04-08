<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

<style type="text/css">
body {
	font-size: 20px;
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
</style>
<script type="text/javascript">
			function checkInput() {
				var temp = document.form1.name.value;
				if(temp == "") {
					alert("请输入姓名!");
					return false;
				} else {
					return true;
				}
			}
		</script>
</head>

<body>

	<form name="form1" class="form-inline definewidth m20"
		action="./student_selectStudent.do" method="post"
		onsubmit="return checkInput()">
		<font color="#777777"><strong>学生姓名：</strong> </font> <input
			type="text" name="name" id="menuname" class="abc input-default"
			placeholder="" value="">&nbsp;&nbsp; <input type="submit"
			class="btn btn-primary"></input> &nbsp;&nbsp;
	</form>
	<c:if test="${student.name!=null }" var="result">
		<font color="#777777"><strong>学生信息：</strong> </font>
		<table class="table table-bordered table-hover definewidth m10">
			<thead class="thead1">
				<tr>
					<th>姓名</th>
					<th>年龄</th>
					<th>性别</th>
					<th>班级编号</th>
					<th>操作</th>
					<th>照片</th>
				</tr>
			</thead>
			<tr>
				<td><c:out value="${student.name }"></c:out></td>
				<td><c:out value="${student.age }"></c:out></td>
				<td><c:out value="${student.gender }"></c:out></td>
				<td><c:out value="${student.grade }"></c:out></td>
				<td><a href="./student_deleteStudent.do?name=<c:out value="${student.name }"></c:out>"
					class="a2">删除</a> <a
					href="modify.jsp?name=${student.name }&url=${student.url}" class="a2">修改</a>
				</td>
				<td><img alt="" src="./${student.url }"
					style="width: 40px;height: 40px">
				</td>
			</tr>
		</table>
	</c:if>
</body>
</html>
