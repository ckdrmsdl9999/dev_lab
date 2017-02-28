<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    
    String fileName = (String) request.getAttribute("fileName");
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>첨부파일 다운로드</title>
</head>
<body>

<a href="downLoad.jsp?imgFile=<%=fileName%>">다운로드</a>

</body>
</html>