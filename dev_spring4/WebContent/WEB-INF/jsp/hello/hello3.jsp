<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.vo.DeptVO, java.util.List" %>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>/WEB-INF/jsp/hello/hello3.jsp</title>
</head>
<body>
hello3.jsp 페이지 입니다.
<br>
<%
	List<String> nameList = (List<String>)request.getAttribute("nameList");
    DeptVO dVO = (DeptVO)request.getAttribute("dVO");
	for(String name:nameList){
		out.print(name+"<br>");
	}
	out.print("부서번호:"+dVO.getDeptno());
	out.print("부서명:"+dVO.getDname());
	out.print("지역:"+dVO.getLoc());
%>
</body>
</html>