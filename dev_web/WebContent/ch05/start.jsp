<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>start.jsp페이지</title>
</head>
<body>
<%
	String name = "이순신";
	String date = "2016-12-26";
	String goods = "거북선";
	request.setAttribute("name", name);
	request.setAttribute("date", date);
	request.setAttribute("goods", goods);
	//세션에 정보를 담아 봅시다. - 약속한 시간동안 유지 됩니다.
	session.setAttribute("name2", "김유신");
	session.setAttribute("date2", "2016-12-25");
	session.setAttribute("goods2", "장갑");
	//application에 정보를 담아 봅시다.
	application.setAttribute("name3", "강감찬");
	application.setAttribute("date3", "2016-12-24");
	application.setAttribute("goods3", "목도리");	
	//url이 변하지 않습니다.
/* 	RequestDispatcher view = 
			request.getRequestDispatcher("end.jsp");
	view.forward(request,response); */
	//url이 바뀝니다 - 요청이 끊어지고 새로운 요청을 보냅니다.
	response.sendRedirect("end.jsp");
%>
</body>
</html>