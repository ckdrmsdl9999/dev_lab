<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
/*
index.jsp�� include�Ǵ� ���������� ��� ������ �ڹ��ڵ�� ���� �ǹǷ� ������ ������ �� ����.
���� �� �����ϰ� ���� ������ ���� �� �����?
*/
	//out.print(menu);
	String name = (String)request.getAttribute("mem_name");
	String mem_id = (String)request.getAttribute("mem_id");
	String mem_pw = (String)request.getAttribute("mem_pw");
	out.print(name);
	mem_id = request.getParameter("mem_id");
	mem_pw = request.getParameter("mem_pw");	
	String mem_name = request.getParameter("mem_name");
	out.print(mem_id+" , "+mem_pw+",  "+mem_name);//���ʺ�
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table width="100%" height="100%" border="1" borderColor="orange">
	<tr>
		<td align="center">
		<table width="100%" height="100%">
		<!-- ���� ��� -->
			<tr>
				<td align="center">������ ���ȭ�� ��û �帧 ����</td>
			</tr>
		<!-- �޴� ��� -->
			<tr>
				<td align="center" valign="bottom">
				<a href="index.jsp?menu=loginForm">�α���</a>
				 | 
				<a href="index.jsp?menu=memberForm">ȸ������</a> 
				 | 
				<a href="index.jsp?menu=boardList">�Խ���</a> 
				 | 
				<a href="index.jsp?menu=info">ȸ��Ұ�</a> 
				 | 
				<a href="index.jsp?menu=location">ã�ƿ��±�</a>
				</td>
			</tr>			
		</table>
		</td>
	</tr>
</table>
</body>
</html>