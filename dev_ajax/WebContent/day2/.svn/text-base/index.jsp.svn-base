<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String s_mem_name = (String)session.getAttribute("mem_name");
	out.print("세션정보:"+s_mem_name);
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
		<jsp:include page="./top.jsp" flush="false">
			<jsp:param value="test" name="mem_id"/>
			<jsp:param value="123" name="mem_pw"/>
		</jsp:include>
		</td>
	</tr>
	<tr>
		<td width="800" height="450">
<!-- main.jsp 영역 -->
		<jsp:include page="./main.jsp" flush="false"/>
		</td>
	</tr>
	<tr>
		<td width="800" height="50">
<!-- bottom.jsp 영역 -->
		<jsp:include page="./bottom.jsp" flush="false"/>
		</td>
	</tr>		
</table>
</body>
</html>