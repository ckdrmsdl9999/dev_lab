<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.ch7.Sonata" %>
<%@ page import="com.ch7.Duck, com.ch7.MallardDuck" %>
<%@ page import="java.util.List, java.util.ArrayList, com.vo.DeptVO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� getSendResult.jsp ������</title>
</head>
<body>
<%
	String mem_id = request.getParameter("mem_id");
	out.print(mem_id);
	//���� �������� �ʰ� �ִٸ� Sonata myCar = null;
	Sonata myCar = (Sonata)request.getAttribute("myCar");
	String r_name = 
			(String)request.getAttribute("r_name");
	out.print("�ҳ�Ÿ �ӵ� : "+myCar.speed);
	out.print("<br>");
	out.print("�̸� : "+r_name);
	out.print("<br>");
	MallardDuck myDuck = (MallardDuck)request.getAttribute("myDuck");
	List<DeptVO> deptList = 
			(List<DeptVO>)request.getAttribute("deptList");
%>
<table border="1" width="300">
	<!-- header ���� -->
	<tr>
		<th>�μ���ȣ</th>
		<th>�μ���</th>
		<th>����</th>
	</tr>
	<!-- header  �� -->
	<!-- ��� ���� -->
	html�ڵ带 �ۼ��ϴ� ��
<%
//�ڹ��ڵ带 �ۼ��ϴ� ��
//��ũ��Ʋ�� - ��������, �޼ҵ� ȣ��, �ν��Ͻ�ȭ, ���
	for(int i=0;i<deptList.size();i++){
		DeptVO dvo = deptList.get(i);
%>
	<tr>
		<td><% out.print(dvo.getDeptno()); %></td>
		<td><% out.print(dvo.getDname()); %></td>
		<td><% out.print(dvo.getLoc()); %></td>
	</tr>
<%
	}///////////////////// end of for
%>	
	<!-- ���  �� -->
</table>
</body>
</html>












