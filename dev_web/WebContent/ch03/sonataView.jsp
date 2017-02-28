<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.ch03.Sonata" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="himCar" class="com.ch03.Sonata" scope="page"/>
<%
	Sonata myCar = new Sonata();
	out.print(myCar.speed);
	out.print("<br>");
	himCar.speedUp();
	out.print(himCar.speed);
	request.setAttribute("himCar", himCar);
	request.setAttribute("myCar", myCar);
	//response.sendRedirect("./sonataResult.jsp");
	RequestDispatcher view = 
			request.getRequestDispatcher("./sonataResult.jsp");
	view.forward(request,response);
%>
</body>
</html>