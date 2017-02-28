package com.ch17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
/*
 * 요청객체(HttpServletRequest):사용자가 입력한 값 받아올 때
 * 응답객체(HttpServletResponse):사용자 요청에 대한 응답페이지를 호출할 때
 */
	public void doGet(HttpServletRequest req
			         ,HttpServletResponse res)
	throws ServletException, IOException
	{
		//mime타입을 설정하기 - 브라우저가 html문서로 인지함.
		res.setContentType
		("text/html;charset=euc-kr");
		//브라우저에 html코드, css코드, js코드를 작성
		//javascript에서 html코드 작성할 때
		//document.write("<b>자바스크립트</b>");
		PrintWriter out = res.getWriter();
		out.print("<b>hello servlet!!!</b>");
	}
}
