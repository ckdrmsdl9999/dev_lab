<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>start.jsp</title>
</head>
<body>
<%
	String name = "이순신";
	out.print("이름:"+name);
	//response.sendRedirect("move.jsp");
	RequestDispatcher view = request.getRequestDispatcher("move.jsp");
	view.include(request, response);
	out.print("여기");
%>
</body>
</html>