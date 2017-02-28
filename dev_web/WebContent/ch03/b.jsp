<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.vo.DeptVO" %>    
<%-- <%=dvo2.getDeptno() %> --%>
<%
	//request.getParameter(String):String-HttpServletRequest
	//DeptVO dvo =request.getParameter("dvo");
	//getAttribute(String):Object-HttpServletRequest
	DeptVO dvo = (DeptVO)request.getAttribute("dvo");
	DeptVO dvo2 = (DeptVO)request.getAttribute("dvo2");
%>
<%=dvo.getDeptno() %><!-- 10 | 0|NullPointerException  -->
<%
	out.print("<br>");
%>
<%=dvo2.getDeptno() %><!-- 20 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>b.jsp페이지 입니다.</title>
</head>
<body>
</body>
</html>