<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String menu = request.getParameter("menu");
	out.print("menu:"+menu);
	request.setAttribute("rmem_name", "나신입");
	String mem_name = "나용관";
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
<!-- top.jsp 영역 -->
		<%@ include file="./top.jsp" %>
		</td>
	</tr>
	<tr>
		<td width="800" height="450">
<!-- main.jsp 영역 -->
<%
	//자바영역
	if(menu==null){
%>
<!-- html영역 -->
		<%@ include file="./main.jsp" %>
<%
	}
	else if("loginForm".equals(menu)){//로그인
%>
		<%@ include file="./loginForm.jsp" %>
<%
	}
	else if("memberForm".equals(menu)){//회원가입을 선택했을 때
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
<!-- bottom.jsp 영역 -->
		<%@ include file="./bottom.jsp" %>
		</td>
	</tr>		
</table>
</body>
</html>