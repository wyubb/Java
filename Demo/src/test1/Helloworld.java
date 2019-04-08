package test1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Helloworld extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		this.doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
		resp.setContentType("txet/html");
		PrintWriter out = resp.getWriter();
		out.println("<b>hello world</b>");
		
		
	}
}
