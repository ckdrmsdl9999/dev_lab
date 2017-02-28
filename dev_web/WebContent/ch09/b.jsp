<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String nh_age = request.getParameter("nh_age");
	String age = request.getParameter("age");
	Cookie cookie1 = new Cookie("nh_age",nh_age);
	Cookie cookie2 = new Cookie("age",age);
	cookie1.setMaxAge(60*60);
	cookie2.setMaxAge(60*60);
	response.addCookie(cookie1);
	response.addCookie(cookie2);
	//out.print(nh_age);//다른 페이지에서는 접근할 수 없다.
	Cookie cookies[] = request.getCookies();
	for(int i=0;i<cookies.length;i++){
		out.print(cookies[i].getName()
			+" , "+cookies[i].getValue());
	}
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>