package com.yzk.studentweb.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFiltertow implements Filter {
	private String noUri;

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String requestUrl = req.getRequestURI();
		String[] urls = noUri.split(";");
		if (noUri != null && noUri.length() > 0) {
			for (String url : urls) {
				if (requestUrl.indexOf(url) == -1) {// url都等于-1就是不包含 继续遍历
					continue;
				} else {// !=-1放行
					chain.doFilter(request, response);
					return;
				}
			}
		}
		HttpSession session = req.getSession();
		String user = (String) session.getAttribute("user");
		if (user == null) {
			res.sendRedirect("login.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		noUri = fConfig.getInitParameter("noFilterUri");
		System.out.println("noUrl" + noUri);
	}

}
