<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.HashMap" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>목록페이지</title>
</head>
<body>
<%
//서블릿에서 생성된 객체를 화면단에서 사용하고 싶을 때
//어떡하지?
	List<HashMap<String,Object>> list = 
		(List<HashMap<String,Object>>)request.getAttribute("list");
	out.print(list.getClass().getName());
	if(list!=null){
		HashMap<String,Object> pMap= list.get(0);
		Object obj[] = pMap.keySet().toArray();//mem_id, mem_pw, mem_name
		for(Object key:obj){
			//out.print(pMap.get(skey));
			out.print(pMap.get(key));
		}
	}
%>
</body>
</html>