<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String menu = request.getParameter("menu");
	out.print("menu:"+menu);
	request.setAttribute("rmem_name", "������");
	String mem_name = "�����";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table width="800" height="600" align="center">
	<tr>
		<td width="800" height="100">
<!-- top.jsp ���� -->
		<%@ include file="./top.jsp" %>
		</td>
	</tr>
	<tr>
		<td width="800" height="450">
<!-- main.jsp ���� -->
<%
	//�ڹٿ���
	if(menu==null){
%>
<!-- html���� -->
		<%@ include file="./main.jsp" %>
<%
	}
	else if("loginForm".equals(menu)){//�α���
%>
		<%@ include file="./loginForm.jsp" %>
<%
	}
	else if("memberForm".equals(menu)){//ȸ�������� �������� ��
%>
		<%@ include file="./memberForm.jsp" %>
<%
	}
	else if("boardList".equals(menu)){
%>
	   <%@ include file="./boardList.jsp" %>	
<%
	}
	else if("info".equals(menu)){
%>
      <%@ include file="./info.jsp" %>
<%
	}
	else if("location".equals(menu)){
%>
      <%@ include file="./location.jsp" %>
<%
	}
%>
		</td>
	</tr>
	<tr>
		<td width="800" height="50">
<!-- bottom.jsp ���� -->
		<%@ include file="./bottom.jsp" %>
		</td>
	</tr>		
</table>
</body>
</html>