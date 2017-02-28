<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
//나신입-request, 나초보-parameter
	if(request.getParameter("mem_name") !=null){
		mem_name = request.getParameter("mem_name");
	}
	else if(request.getAttribute("rmem_name") !=null){
		mem_name = (String)request.getAttribute("rmem_name");
	}	
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table width="100%" height="100%" border="1" borderColor="red">
	<tr>
		<td align="center">메인페이지(<%=mem_name %>)</td>
	</tr>
</table>
</body>
</html>