<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Map, java.util.HashMap" %>    
<%
	response.sendRedirect("b.jsp");//url�� �ٲ��-������ �������� ���ο� ��û�� �Ͼ��.
	String name = "�̼���";
	String hp = "010-222-2365";
	Map<String,Object> pMap = new HashMap<String,Object>();
	pMap.put("name",name);
	pMap.put("hp",hp);
	//request�� ����� ���� ��� �ɱ�?
	request.setAttribute("rpMap", pMap);		
	//���ǿ� ������ ���� ��
	//���ǿ��� ObjectŸ�Ե� ���� �� �ִ�.
	session.setAttribute("pMap", pMap);//30�а� �����ȴ�. web.xml ����Ÿ�� ����
	session.setMaxInactiveInterval(60*10);//�ʴ����� ������ �� �ִ�.
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>a.jsp(��û������)</title>
</head>
<body>

</body>
</html>