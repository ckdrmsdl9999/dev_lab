package com.ch17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
/*
 * ��û��ü(HttpServletRequest):����ڰ� �Է��� �� �޾ƿ� ��
 * ���䰴ü(HttpServletResponse):����� ��û�� ���� ������������ ȣ���� ��
 */
	public void doGet(HttpServletRequest req
			         ,HttpServletResponse res)
	throws ServletException, IOException
	{
		//mimeŸ���� �����ϱ� - �������� html������ ������.
		res.setContentType
		("text/html;charset=euc-kr");
		//�������� html�ڵ�, css�ڵ�, js�ڵ带 �ۼ�
		//javascript���� html�ڵ� �ۼ��� ��
		//document.write("<b>�ڹٽ�ũ��Ʈ</b>");
		PrintWriter out = res.getWriter();
		out.print("<b>hello servlet!!!</b>");
	}
}
