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
//POST����� �� �� GET����� ��
//GET����� ���� URL�� query string���� �Ѿ�Ƿ� URL�� �̿��ؼ� ������ ���۵ȴ�.
//server.xml�������� URIEncoding=euc-kr����
//POST��� request.setCharacterEncoding("euc-kr");
	String u_name = request.getParameter("mem_name");
	out.print("u_name : "+"<b>"+u_name+"</b>");
%>
</body>
</html>