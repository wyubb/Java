package com.yzk.studentweb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import javax.servlet.*;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport {
	public HttpServletRequest request;
	public HttpSession session;

	public BaseAction() {
		request = ServletActionContext.getRequest();
		session = request.getSession();
	}
}
