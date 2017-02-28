<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List" %>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>/WEB-INF/jsp/hello/hello.jsp</title>
</head>
<body>
hello.jsp 페이지 입니다.
<%
	List<String> nameList = (List<String>)request.getAttribute("nameList");
	for(String name:nameList){
		out.print(name+"<br>");
	}
%>
</body>
</html>