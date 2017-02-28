<%@page import="com.vo.DeptVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.util.List, com.vo.DeptVO" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
List<String> nameList =(List<String>) request.getAttribute("nameList");
for(String name:nameList){
	out.print("이름:"+name+"<br>");
}
/* DeptVO dVO =(DeptVO) request.getAttribute("dVO");
out.print(dVO.getDeptno());
out.print(dVO.getDname());
out.print(dVO.getLoc());
 */
%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>/WebContent/hello/hello5.jsp</title>
</head>
<body>
hello5.jsp 입니다
</body>
</html>