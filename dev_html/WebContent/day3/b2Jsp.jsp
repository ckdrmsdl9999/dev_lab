<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//ȭ��ܿ��� �Է��� ���� �������������� ȣ���� ���� 
	//�ݵ�� name�Ӽ��� ����մϴ�.
	String u_id = request.getParameter("mem_id");
	String h_val = request.getParameter("h_val");
	//out.print�� �ܼ��� �ƴ϶� �������� ����.
	out.print("����ڰ� �Է��� ���̵�:"+u_id);
	out.print("<br>");
	out.print("������ �� ����ϱ�:"+h_val);
%>