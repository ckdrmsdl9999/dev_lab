<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");
//<input type="text" name="mem_id" id="imem_id" size="10">
//var url = "./getUpdateBoardSales.jsp?member_id="+u_memid+"&time="+new Date().getTime();
	String u_memid = request.getParameter("mem_id");//Ajax일때
	String u_memname = request.getParameter("mem_name");//Form전송 일 때
	out.print("1200"+u_memid+", name:"+u_memname);
%>