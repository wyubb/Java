<%@ page language="java" contentType="text/html; charset=gbk"
 %>
  <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<meta http-equiv="X-UA-Compatible" content="ie=edge">
    <base href="<%=basePath%>">
    
    <title>ѧ���ۺϲ�������ϵͳ-����Ա��¼����</title>
	 <!-- ���� Bootstrap ��ʽ�� -->
  <link href="./libs/bootstrap@3.3.7.min.css" rel="stylesheet">

  <!-- HTML5 shim �� Respond.js ��Ϊ���� IE8 ֧�� HTML5 Ԫ�غ�ý���ѯ��media queries������ -->
  <!-- ���棺ͨ�� file:// Э�飨����ֱ�ӽ� html ҳ����ק��������У�����ҳ��ʱ Respond.js �������� -->
  <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
  <![endif]-->

  <!-- ��ҳ����ʽ  -->
  <style>
    body {
      background-color: #eee;
    }
    .container {
      width: 330px;
      padding-top: 100px;
      display: flex;
      flex-direction: column;
      align-items: center;
    }
    h1 {
      font-size: 25px;
      font-weight: 400;
      margin-bottom: 30px;
    }
    .input {
      margin-bottom: 15px;
    }
    .btn {
      margin-top: 15px;
    }
  </style>
  </head> 
  <body>  		
	<form class="container" action="process_admin_login.jsp" method = "post">
    <h1>ѧ���ۺϲ�������ϵͳ</h1>
    <input type="text" class="form-control input" placeholder="���������Ĺ���" name="username" required = "required">
    <input type="password" class="form-control input" placeholder="����������" name="password" required = "required">
    <input type = "text"  class="form-control input"  required = "required" name = "yzm" placeholder = "��������֤��" >
    <button class="btn btn-lg btn-primary btn-block" type="submit">��¼</button>
  </form>	
  </body>
</html>
