<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Map, java.util.HashMap" %>    
<%
    //Map<String,Object> pMap = new HashMap<String,Object>(); 
    Map<String,Object> pMap = (Map<String,Object>)session.getAttribute("pMap"); 
	out.print(pMap.get("name"));//
	if(pMap.containsKey("name")){
		out.print("있다.");
		out.print("이름 : "+pMap.get("name")+", 핸드폰번호 : "+pMap.get("hp"));
	}
	else{
		out.print("없다.");
	}
	Map<String,Object> rpMap = (Map<String,Object>)request.getAttribute("rpMap"); 
	if(rpMap!=null){
		out.print("있다.");
		out.print("이름 : "+rpMap.get("name")+", 핸드폰번호 : "+rpMap.get("hp"));
	}
	else{
		out.print("없다.");
	}	
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>b.jsp(응답페이지)</title>
</head>
<body>
이름 :
핸드폰 : 
</body>
</html>