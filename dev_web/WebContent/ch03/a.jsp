<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.vo.DeptVO" %>    
<jsp:useBean id="dvo2" scope="request" class="com.vo.DeptVO"/>
<%
	dvo2.setDeptno(20);
	dvo2.setDname("�ѹ�");
	dvo2.setLoc("��õ");
	DeptVO dvo = new DeptVO();
	dvo.setDeptno(10);
	dvo.setDname("����");
	dvo.setLoc("����");
	request.setAttribute("dvo", dvo);
	//get������� �ּҹ����� �ѱ� �� �ִ� | ����
	//response.sendRedirect("b.jsp?dvo="+dvo);//������ �̵�
	//response.sendRedirect("b.jsp");//������ �̵�
	//�����ν��Ͻ�ȭ ���� �� Ȥ�� �׼��±׸� ������� ��
	//sendRedirect�� ������ �̵�ó�� �ϸ� ���� ���� �� ��
	//����.
	//�������� forwardó�� ���� ���� ���� ������ �� �ִ�.
	//������
	//���� �ν��Ͻ�ȭ ���� ���� ��û��ü�� �ּҹ�����
	//���� ��� �־�� �ش� ��ü�� ����� �� �ִ�.
	//�׼��±׸� ������� ���� ���� ������� �ʾƵ�
	//������� ���������� �ش� ��ü�� ����� �� �ִ�.
	//�߰�
	//scope�Ӽ��� session�̳� application���� �������� ��쿡��
	//sendRedirect�� forward�� ������� ������ �� �ִ�.
	RequestDispatcher view =
				request.getRequestDispatcher("b.jsp");
	view.forward(request, response);
	String name = "�̼���";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>a.jsp������ �Դϴ�.</title>
</head>
<body>
</body>
</html>