<%@ page language="java" import="java.util.*"    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class = "login_b f1">
		<p class = "title f1">用户登录</p>
		<div class = "login_d f1">
			<form name="loginform" action="login.action" method="post">
        		<table width="350" border="0" >
        			<tr>
						    <td width="100" height="40" align="middle" colspan=2>
						   		 <font color="red">${message} </font>  <!--s:property value="message"/-->
						    </td>   
					</tr>	
					<tr>
	      				<td>用户名：</td>
	      				<td><input name="user.userName" type="text" class="login_input" /></td>
					</tr>
					<tr>
	     				 <td>密码：</td>
	    				 <td><input name="user.password" type="password" class="login_input" ></td>
					</tr>
					<tr>
	        			<td height="50" colspan="2" align="center">
							<input type="radio" name="radiobutton" value="radiobutton">
							请保存我这次的登录信息
						</td>
					</tr>
					<tr>
	        			<td height="50" colspan="2" align="center">
							<input type="submit" height="50" value="登录">
						</td>
					</tr>
        		</table>
    		</form>		
		</div>
	</div>
</body>
</html>