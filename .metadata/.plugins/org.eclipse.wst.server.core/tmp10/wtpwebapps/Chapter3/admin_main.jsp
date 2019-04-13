<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.*,domain.*,service.imp.*,dao.imp.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>ѧ���ۺϲ�������ϵͳ</title>

  <!-- ���� Bootstrap ��ʽ�� -->
  <!-- <link href="./libs/bootstrap@3.3.7.min.css" rel="stylesheet"> -->
  <!-- ���� jQuery (Bootstrap ������ JavaScript ��������� jQuery�����Ա������ǰ��) -->
  <script src="./libs/jquery@1.12.4.min.js"></script>
  <!-- ���� Bootstrap ������ JavaScript ��� -->
  <!-- <script src="./libs/bootstrap@3.3.7.min.js"></script> -->

  <!-- HTML5 shim �� Respond.js ��Ϊ���� IE8 ֧�� HTML5 Ԫ�غ�ý���ѯ��media queries������ -->
  <!-- ���棺ͨ�� file:// Э�飨����ֱ�ӽ� html ҳ����ק��������У�����ҳ��ʱ Respond.js �������� -->
  <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
  <![endif]-->

  <!-- ��ҳ����ʽ  -->
  <style>
    * {
      margin: 0;
      padding: 0;
    }
    html, body {
      font-size: 14px;
    }
    ul, li {
      list-style: none;
    }
    .sidebar {
      position: fixed;
      top: 0;
      left: 0;
      width: 200px; /* ���ȿɵ��� */
      height: 100%;
      color: #ECF0F1;
      background-color: #2A3F54;
    }
    .sidebar .welcome {
      font-weight: 400;
      font-size: 22px;
      text-align: center;
      line-height: 59px;
    }
    .sidebar .user-profile {
      display: flex;
      flex-direction: row;
      justify-content: center;
      align-items: center;
    }
    .sidebar .user-type {
      width: 32px;
      height: 32px;
      border-radius: 50%;
      margin-right: 15px;
    }
    .sidebar .menu {
      margin: 15px 0;
    }
    .sidebar a {
      color: #ECF0F1;
      text-decoration: none;
      display: block;
    }
    .sidebar .menu-item-father {
      padding: 10px 15px;
      margin-bottom: 6px;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
    .sidebar .menu-item-father-left {
      display: flex;
      align-items: center;
    }
    .sidebar .menu-icon {
      width: 18px;
      margin-right: 10px;
    }
    .sidebar .arrow-icon {
      width: 14px;
    }
    .sidebar .menu-item-child {
      display: none;
    }
    .sidebar .menu-item-father-active {
      text-shadow: rgba(27, 13, 13, 0.25) 0 -1px 0;
      background: linear-gradient(#334556,#2C4257),#2A3F54;
      box-shadow: rgba(0,0,0,.25) 0 1px 0, inset rgba(255,255,255,.16) 0 1px 0;
    }
    .sidebar .menu-item-child-active {
      display: block;
    }
    .sidebar .menu-item-child-a {
      padding: 5px 0;
      padding-left: 42px;
    }
    .sidebar .menu-item-child-a:hover,
    .sidebar .menu-item-child-a-active {
      background: rgba(255,255,255,.05);
    }

    .container {
      margin-left: 200px;
    }
  </style>
</head>
<body>
<jsp:useBean id="infoService" class="service.imp.InfoService" scope="session"></jsp:useBean>
<%
    //����ҵ���߼��㷽������ȡ������Ϣ�б�
	List<Information> list = infoService.getAllInfo();
%>	
  <!-- ���˵��� -->
  <div class="sidebar">
    <div class="welcome">Welcome!</div>
    <div class="user-profile">
      <img class="user-type" src="./images/student.png" alt="ѧ���û�" title="ѧ���û�">
      <div>�û�����</div>
    </div>
    <div class="menu">
      <a class="menu-item-father menu-item-father-active" href="javascript:;">
        <div class="menu-item-father-left">
          <img class="menu-icon" src="./images/user-data.png" title="��������">
          <div>��������</div>
        </div>
        <img class="arrow-icon" src="./images/up-arrow.png" title="����">
      </a>
      <ul class="menu-item-child menu-item-child-active">
        <li><a class="menu-item-child-a menu-item-child-a-active" href="javascript:;">�鿴</a></li>
        <li><a class="menu-item-child-a" href="javascript:;">�޸�</a></li>
      </ul>
      <a class="menu-item-father" href="javascript:;">
        <div class="menu-item-father-left">
          <img class="menu-icon" src="./images/notice.png" title="��������">
          <div>������</div>
        </div>
        <img class="arrow-icon" src="./images/below-arrow.png" title="չ��">
      </a>
      <ul class="menu-item-child">
          <li><a class="menu-item-child-a" href="javascript:;">�鿴</a></li>
          <li><a class="menu-item-child-a" href="javascript:;">����</a></li>
          <li><a class="menu-item-child-a" href="javascript:;">�޸�</a></li>
      </ul>
    </div>
  </div>

  <!-- �Ҳ��������� -->
  <div class="container"></div>
  
  
  <script>
    $('.menu-item-father').each(function (index) {
      $(this).on('click', function () {
        var menu_item_child = $('.menu-item-child').eq(index)
        if (menu_item_child.hasClass('menu-item-child-active')) {
          $(this).removeClass('menu-item-father-active')
          $('.arrow-icon').eq(index).attr('src', './images/below-arrow.png').attr('title', 'չ��')
          menu_item_child.removeClass('menu-item-child-active')
        } else {
          $('.menu-item-father').each(function () {
            $(this).removeClass('menu-item-father-active')
          })
          $('.arrow-icon').each(function () {
            $(this).attr('src', './images/below-arrow.png').attr('title', 'չ��')
          })
          $('.menu-item-child').each(function () {
            $(this).removeClass('menu-item-child-active')
          })
          $(this).addClass('menu-item-father-active')
          $('.arrow-icon').eq(index).attr('src', './images/up-arrow.png').attr('title', '����')
          menu_item_child.addClass('menu-item-child-active')
        }
      })
    })
    $('.menu-item-child-a').each(function (index) {
      $(this).on('click', function () {
        $('.menu-item-child-a').each(function () {
          $(this).removeClass('menu-item-child-a-active')
        })
        $(this).addClass('menu-item-child-a-active')
      })
    })
  </script>
</body>
</html>