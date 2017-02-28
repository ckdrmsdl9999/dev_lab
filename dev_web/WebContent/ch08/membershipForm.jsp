<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
			$("#if_login").attr("action","./processJoining.jsp");
			$("#if_login").submit();//전송			
		});
	});
</script>
<form id="if_login" name="f_login">
<table border="1" cellpadding="0" cellspacing="0">
<tr>
<td>아이디</td>
<td><input type="text" name="id" size="10"></td>
<td>비밀번호</td>
<td><input type="text" name="password" size="10"></td>
</tr>
<tr>
<td>이름</td>
<td><input type="text" name="name" size="10"></td>
<td>이메일</td>
<td><input type="text" name="email" size="10"></td>
</tr>
<tr>
<td colspan="4" align="center">
<input type="button" value="회원가입" id="btn_send"></td>
</tr>
</table>
</form>
</body>
</html>