<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.ch03.Sonata" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>sonataResult.jsp 페이지</title>
</head>
<body>
<%
	Sonata himCar = (Sonata)request.getAttribute("himCar");
	himCar.speedUp();
	out.print("현재 소나타의 속도 : "+himCar.speed);
	//insert here - myCar를 사용하고 싶을 때
	out.print("<hr>");
	Sonata myCar = null;
	myCar = (Sonata)request.getAttribute("myCar");
	out.print("현재 소나타의 속도 : "+myCar.speed);//
%>
</body>
</html>