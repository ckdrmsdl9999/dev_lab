<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Map, java.util.HashMap" %>    
<%
	response.sendRedirect("b.jsp");//url이 바뀐다-기존이 끊어지고 새로운 요청이 일어난다.
	String name = "이순신";
	String hp = "010-222-2365";
	Map<String,Object> pMap = new HashMap<String,Object>();
	pMap.put("name",name);
	pMap.put("hp",hp);
	//request에 담았을 때는 어떻게 될까?
	request.setAttribute("rpMap", pMap);		
	//세션에 정보를 담을 때
	//세션에는 Object타입도 담을 수 있다.
	session.setAttribute("pMap", pMap);//30분간 유지된다. web.xml 세션타임 설정
	session.setMaxInactiveInterval(60*10);//초단위로 설정할 수 있다.
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>a.jsp(요청페이지)</title>
</head>
<body>

</body>
</html>