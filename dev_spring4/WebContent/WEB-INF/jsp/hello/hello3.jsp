<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.vo.DeptVO, java.util.List" %>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>/WEB-INF/jsp/hello/hello3.jsp</title>
</head>
<body>
hello3.jsp ������ �Դϴ�.
<br>
<%
	List<String> nameList = (List<String>)request.getAttribute("nameList");
    DeptVO dVO = (DeptVO)request.getAttribute("dVO");
	for(String name:nameList){
		out.print(name+"<br>");
	}
	out.print("�μ���ȣ:"+dVO.getDeptno());
	out.print("�μ���:"+dVO.getDname());
	out.print("����:"+dVO.getLoc());
%>
</body>
</html>