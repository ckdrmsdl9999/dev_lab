<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page errorPage="/error/aErrorPage.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>a.jsp������</title>
</head>
<body>
name �Ķ���Ͱ�1 : <%="�̼���".toString() %>
<br>
<%
	try{
%>
name �Ķ���Ͱ�2 : <%=request.getParameter("name").toString() %>
<%
	}catch(Exception e){
		out.print("name�Ķ���Ͱ� �ùٸ��� �ʽ��ϴ�.");
	}
	int age = Integer.parseInt(request.getParameter("age"));
%>
name �Ķ���Ͱ�3 : <%=age %>
</body>
</html>