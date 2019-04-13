/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.12
 * Generated at: 2019-04-11 12:37:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import service.imp.UserService;
import domain.User;

public final class process_005fdata_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("domain.User");
    _jspx_imports_classes.add("service.imp.UserService");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=gbk");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<title>更新个人资料2</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      service.imp.UserService userService = null;
      synchronized (session) {
        userService = (service.imp.UserService) _jspx_page_context.getAttribute("userService", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (userService == null){
          userService = new service.imp.UserService();
          _jspx_page_context.setAttribute("userService", userService, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');

  request.setCharacterEncoding("gbk");
    //获取用户名，"userName"和data.jsp中name属性为"userName"对应
	String userName=((User)session.getAttribute("user")).getUserName(); 
    //获取密码，"password"和data.jsp中name属性为"password"的文本框对应
	String password = request.getParameter("password");
    
    //获取真实姓名，"realName"和data.jsp中name属性为"realName"的文本框对应
	String realName = request.getParameter("realName");
    
    //获取性别，"gender"和data.jsp中name属性为"gender"的文本框对应
	String gender = request.getParameter("gender");
    
    //获取年龄，"age"和data.jsp中name属性为"age"的文本框对应
	String age = request.getParameter("age");
    
    //获取个性签名，"personalSignature"和data.jsp中name属性为"personalSignature"的文本框对应
	String personalSignature = request.getParameter("personalSignature");
	User user = new User();
	
	//设置用户类对象
	user.setUserName(userName);
	user.setPassword(password);
	user.setRealName(realName);
	user.setGender(gender);
	user.setAge(age);
	user.setPersonalSignature(personalSignature);
	try
	{
		//调用业务逻辑层的方法完成更新功能，userService与上面的useBean元素中的id属性对应
		userService.updateUser(user);		

      out.write("\r\n");
      out.write("        <!-- 修改成功，跳转到登录界面 -->\r\n");
      out.write("\t\t");
      if (true) {
        _jspx_page_context.forward("process_admin_login.jsp");
        return;
      }
      out.write('\r');
      out.write('\n');

	}
	//处理异常
	catch(Exception ex)
	{
		ex.printStackTrace();
			

      out.write("\r\n");
      out.write("       <!-- 注册失败，回到原界面 -->\r\n");
      out.write("\t\t");
      if (true) {
        _jspx_page_context.forward("data.jsp");
        return;
      }
      out.write('\r');
      out.write('\n');

	}

      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
