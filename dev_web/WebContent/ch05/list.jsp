<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.HashMap" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���������</title>
</head>
<body>
<%
//�������� ������ ��ü�� ȭ��ܿ��� ����ϰ� ���� ��
//�����?
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