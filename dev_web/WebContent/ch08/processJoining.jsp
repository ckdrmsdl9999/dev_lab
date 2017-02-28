<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.vo.MemberVO" %>    
<%
	request.setCharacterEncoding("euc-kr");
   //왜냐하면 이 페이지에서만 유지된다.
	MemberVO mVO2 = new MemberVO("test","123","나신입","test@hotmail.com");//싫어요
	MemberVO mVO3 = new MemberVO(request.getParameter("id")
			                                             ,request.getParameter("password")
			                                             ,request.getParameter("name")
			                                             ,request.getParameter("email"));//싫어요
	MemberVO mVO4 = new MemberVO();
	mVO4.setId(request.getParameter("id"));
	mVO4.setPassword(request.getParameter("password"));
	mVO4.setName(request.getParameter("name"));
	mVO4.setEmail(request.getParameter("email"));
%>    
<jsp:useBean id="mVO" scope="session" class="com.vo.MemberVO"/>
<jsp:setProperty property="*" name="mVO"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	//submit속성의 경우 무조건 전송이 일어나므로 버튼 속성으로 변경하여
	//사용자가 입력한 정보에 대한 유효성 체크를 할 수 있는 코드로 수정한다.
	$(document).ready(function (){
		//click이벤트 처리하면 서버로 전송되기 전에 인터셉트 하여 
		//유효성 검사를 수행하고 전송되도록 할 수 있다.
		$("#btn_send").click(function (){
			$("#if_login").attr("method","post");
			$("#if_login").attr("action","./memberFormAction.jsp");
			$("#if_login").submit();//전송			
		});
	});
</script>
<form id="if_login" name="f_login">
<table border="1" cellpadding="0" cellspacing="0">
<tr>
<td>아이디</td>
<td><jsp:getProperty property="id" name="mVO"/></td>
<td>비밀번호</td>
<td><jsp:getProperty property="password" name="mVO"/></td>
</tr>
<tr>
<td>이름</td>
<td><jsp:getProperty property="name" name="mVO"/></td>
<td>이메일</td>
<td><jsp:getProperty property="email" name="mVO"/></td>
</tr>
<tr>
<td colspan="4" align="center">
<input type="button" value="회원가입" id="btn_send"></td>
</tr>
</table>
</form>
</body>
</html>