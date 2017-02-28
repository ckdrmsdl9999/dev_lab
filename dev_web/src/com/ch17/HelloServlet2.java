package com.ch17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 어노테이션을 사용하면 상속구문을 생략할 수 있다.
 * 객체 주입법을 사용할 경우에 사용됩니다.
 */
@WebServlet(urlPatterns="/hello")
public class HelloServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>인사</title></head>");
		out.println("<body>");
		out.println("안녕하세요,");
		out.println(request.getParameter("name"));
		out.println("님");
		out.println("</body></html>");
	}
}
