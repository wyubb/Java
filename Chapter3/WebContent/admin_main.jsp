<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.*,domain.*,service.imp.*,dao.imp.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>学生综合测评管理系统</title>

  <!-- 引入 Bootstrap 样式库 -->
  <!-- <link href="./libs/bootstrap@3.3.7.min.css" rel="stylesheet"> -->
  <!-- 引入 jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
  <script src="./libs/jquery@1.12.4.min.js"></script>
  <!-- 引入 Bootstrap 的所有 JavaScript 插件 -->
  <!-- <script src="./libs/bootstrap@3.3.7.min.js"></script> -->

  <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
  <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
  <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
  <![endif]-->

  <!-- 本页面样式  -->
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
      width: 200px; /* 宽度可调整 */
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
    //调用业务逻辑层方法，获取所有信息列表
	List<Information> list = infoService.getAllInfo();
%>	
  <!-- 左侧菜单栏 -->
  <div class="sidebar">
    <div class="welcome">Welcome!</div>
    <div class="user-profile">
      <img class="user-type" src="./images/student.png" alt="学生用户" title="学生用户">
      <div>用户名字</div>
    </div>
    <div class="menu">
      <a class="menu-item-father menu-item-father-active" href="javascript:;">
        <div class="menu-item-father-left">
          <img class="menu-icon" src="./images/user-data.png" title="个人资料">
          <div>个人资料</div>
        </div>
        <img class="arrow-icon" src="./images/up-arrow.png" title="收起">
      </a>
      <ul class="menu-item-child menu-item-child-active">
        <li><a class="menu-item-child-a menu-item-child-a-active" href="javascript:;">查看</a></li>
        <li><a class="menu-item-child-a" href="javascript:;">修改</a></li>
      </ul>
      <a class="menu-item-father" href="javascript:;">
        <div class="menu-item-father-left">
          <img class="menu-icon" src="./images/notice.png" title="个人资料">
          <div>公告栏</div>
        </div>
        <img class="arrow-icon" src="./images/below-arrow.png" title="展开">
      </a>
      <ul class="menu-item-child">
          <li><a class="menu-item-child-a" href="javascript:;">查看</a></li>
          <li><a class="menu-item-child-a" href="javascript:;">增加</a></li>
          <li><a class="menu-item-child-a" href="javascript:;">修改</a></li>
      </ul>
    </div>
  </div>

  <!-- 右侧内容主体 -->
  <div class="container"></div>
  
  
  <script>
    $('.menu-item-father').each(function (index) {
      $(this).on('click', function () {
        var menu_item_child = $('.menu-item-child').eq(index)
        if (menu_item_child.hasClass('menu-item-child-active')) {
          $(this).removeClass('menu-item-father-active')
          $('.arrow-icon').eq(index).attr('src', './images/below-arrow.png').attr('title', '展开')
          menu_item_child.removeClass('menu-item-child-active')
        } else {
          $('.menu-item-father').each(function () {
            $(this).removeClass('menu-item-father-active')
          })
          $('.arrow-icon').each(function () {
            $(this).attr('src', './images/below-arrow.png').attr('title', '展开')
          })
          $('.menu-item-child').each(function () {
            $(this).removeClass('menu-item-child-active')
          })
          $(this).addClass('menu-item-father-active')
          $('.arrow-icon').eq(index).attr('src', './images/up-arrow.png').attr('title', '收起')
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