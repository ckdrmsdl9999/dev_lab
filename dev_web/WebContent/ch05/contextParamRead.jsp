<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Enumeration" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>contextParamRead.jsp</title>
</head>
<body>
<%
	Enumeration<String> en = application.getInitParameterNames();
	while(en.hasMoreElements()){
		String name = en.nextElement();
		out.print(name);
		out.print(" , ");
		out.print(application.getInitParameter(name));
		out.print("<br>");
	}
%>
</body>
</html>