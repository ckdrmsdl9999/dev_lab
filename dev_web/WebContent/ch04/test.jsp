<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test.jsp</title>
</head>
<body>
<%
	String path = request.getContextPath();
	out.print("context path : "+path);
%>
<a href="<%=path%>\pds\notouch.exe">다운받기</a>
<hr>
용관자료실<br>
<a href="http://192.168.0.45:9000/dev_web/pds/notouch.exe">notouch</a>
<br>
톰캣서버가 바라보는 물리적인 경로 확인하기<br>
<%=application.getRealPath("/pds/notouch.exe") %>

</body>
</html>