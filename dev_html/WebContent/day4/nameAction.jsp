<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>nameAction.jsp</title>
</head>
<body>
<%
//POST방식일 때 와 GET방식일 때
//GET방식일 때는 URL에 query string으로 넘어가므로 URL을 이용해서 서버로 전송된다.
//server.xml문서에서 URIEncoding=euc-kr설정
//POST방식 request.setCharacterEncoding("euc-kr");
	String u_name = request.getParameter("mem_name");
	out.print("u_name : "+"<b>"+u_name+"</b>");
%>
</body>
</html>