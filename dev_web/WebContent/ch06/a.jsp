<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page errorPage="/error/aErrorPage.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>a.jsp페이지</title>
</head>
<body>
name 파라미터값1 : <%="이순신".toString() %>
<br>
<%
	try{
%>
name 파라미터값2 : <%=request.getParameter("name").toString() %>
<%
	}catch(Exception e){
		out.print("name파라미터가 올바르지 않습니다.");
	}
	int age = Integer.parseInt(request.getParameter("age"));
%>
name 파라미터값3 : <%=age %>
</body>
</html>