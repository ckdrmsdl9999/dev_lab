<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.ArrayList" %>    
<%
/*
sonata.jsp�� WAS�� jsp�����̳ʿ� ���� sonata_jsp.java�ڵ�� ����˴ϴ�.
sonata_jsp.java�� servlet�����̳ʿ� ���� sonata_jsp.class�� ������ �˴ϴ�.
sonata_jsp.class���� ��¹��� ����ִ� �ڵ���� Ŭ���̾�Ʈ�� �ٿ�ε�
�˴ϴ�.
�ٿ�ε�� �ڵ���� �������� ���� ���������� �Ǿ� ȭ�鿡 ��µ˴ϴ�.
�����̳� ���� XXX.jsp�� �ڹ��ڵ�� �����ϴ� ����Ģ�� �ٸ� �� �ֽ��ϴ�.
�� Ŭ���� �̸��� Ȯ���� ���� ������ 
�� ��ü�� ���� ������ ����Ŭ�� ���� ����(��ü����-���-�Ҹ�)��
WAS�� ���� �̷�� ���ϴ�.
�츮(������)�� ���Ƿ� �ν��Ͻ�ȭ �ϴ��� �� �������� ������� �� 
���� ���Դϴ�.
���
jsp������ �ȿ��� ������ �޼ҵ�� ���뼺�� �������ϴ�.
���յ��� ���Ƽ� �����׽�Ʈ �ϰų� Ȱ���ϴµ��� �����մϴ�.

*/
	//��ũ��Ʋ�� - �ڹٿ���--
	List<String> nameList = new ArrayList<String>();
	nameList.add("ȫ�浿");
	nameList.add("������");
	nameList.add("�̼���");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- html���� �Դϴ�. -->
<!-- body�±׾ȿ� �ִ� ������ ȭ�鿡 ��� -->
<%!
	//��Ŭ�����̼� - ���������Դϴ�. 
	//�ʱ�ȭ ���������մϴ�.
	String carName = "2017���� �ҳ�Ÿ";
	int speed = 0;
	int wheelNum = 0;
	public void speedUp(){
		speed += 1;
	}
	public void speedDown(){
		speed -= 1;
	}
%>
<%
	//��ũ��Ʋ���� ����� �� �ִ� �ڵ��
	//���, ��������, �ν��Ͻ�ȭ, �޼ҵ� ȣ��, ��������, try..catch
	//insert here - ������ ���(������)�� ����
	//��ũ��Ʋ�� - out.print(nameList.get(1));
	speedUp();
	out.print(nameList.get(1));//������
	out.print("<hr>");//�������� ���⿡ �ش��մϴ�.
	for(int i=0;i<nameList.size();i++){
		out.print(nameList.get(i)+"<br>");
	}
%>
<%="���� �ҳ�Ÿ�� �ӵ� : "+speed %>
</body>
</html>