<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.ch7.Sonata" %>
<%@ page import="com.ch7.Duck, com.ch7.MallardDuck" %>
<%@ page import="java.util.List, java.util.ArrayList, com.vo.DeptVO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>나는 getSendResult.jsp 페이지</title>
</head>
<body>
<%
	String mem_id = request.getParameter("mem_id");
	out.print(mem_id);
	//만일 유지되지 않고 있다면 Sonata myCar = null;
	Sonata myCar = (Sonata)request.getAttribute("myCar");
	String r_name = 
			(String)request.getAttribute("r_name");
	out.print("소나타 속도 : "+myCar.speed);
	out.print("<br>");
	out.print("이름 : "+r_name);
	out.print("<br>");
	MallardDuck myDuck = (MallardDuck)request.getAttribute("myDuck");
	List<DeptVO> deptList = 
			(List<DeptVO>)request.getAttribute("deptList");
%>
<table border="1" width="300">
	<!-- header 시작 -->
	<tr>
		<th>부서번호</th>
		<th>부서명</th>
		<th>지역</th>
	</tr>
	<!-- header  끝 -->
	<!-- 목록 시작 -->
	html코드를 작성하는 곳
<%
//자바코드를 작성하는 곳
//스크립틀릿 - 변수선언, 메소드 호출, 인스턴스화, 제어문
	for(int i=0;i<deptList.size();i++){
		DeptVO dvo = deptList.get(i);
%>
	<tr>
		<td><% out.print(dvo.getDeptno()); %></td>
		<td><% out.print(dvo.getDname()); %></td>
		<td><% out.print(dvo.getLoc()); %></td>
	</tr>
<%
	}///////////////////// end of for
%>	
	<!-- 목록  끝 -->
</table>
</body>
</html>












