<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.*,domain.*,service.imp.*,dao.imp.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ñ§Éú½çÃæ-Ê×Ò³</title>
</head>
<body>
<div id="menu">
				<a href =	 "student_data.jsp">¸öÈË×ÊÁÏ</a>
				<a href = "gpa.jsp"	>²é¿´¼¨µãÇé¿ö</a>	
				<a href ="">×ÛºÏ²âÆÀ</a>
				<a href = "student_main.jsp">¹«Ê¾ÐÅÏ¢ä¯ÀÀ</a>
				<a href = "photo.jsp"	>ÉÏ´«Í¼Æ¬</a>			
				<a href = "login.jsp">ÍË³ö</a>			
</div>
<jsp:useBean id="infoService" class="service.imp.InfoService" scope="session"></jsp:useBean>
<%
    //µ÷ÓÃÒµÎñÂß¼­²ã·½·¨£¬»ñÈ¡ËùÓÐÐÅÏ¢ÁÐ±í
	List<Information> list = infoService.getAllInfo();
%>
<div class="post">	
			<h1>¹«¸æÀ¸</h>				
                    <%
                    //Ñ­»·Ìû×ÓÁÐ±í£¬ÏÔÊ¾ÈÕÖ¾ÐÅÏ¢
					for(Information info:list)
					{						
					%>
					<div class="content">
 						<!-- ¶ÁÕßÇë×¢Òâ´Ë´¦µÄJava±í´ïÊ½ÔËÓÃ -->
						<p><a href="detail.jsp?Id=<%=info.getId()%>"><%=info.getTitle()%></a>&nbsp;&nbsp;<%=info.getPublishingtime()%></p>
					</div>			
					<%						
						}
					%>										
</div>	
</body>
</html>