package com.ch17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * ������̼��� ����ϸ� ��ӱ����� ������ �� �ִ�.
 * ��ü ���Թ��� ����� ��쿡 ���˴ϴ�.
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
		out.println("<head><title>�λ�</title></head>");
		out.println("<body>");
		out.println("�ȳ��ϼ���,");
		out.println(request.getParameter("name"));
		out.println("��");
		out.println("</body></html>");
	}
}
