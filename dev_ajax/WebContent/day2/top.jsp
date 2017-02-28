<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/dev_jquery/js/jquery-1.11.1.js"></script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function (){
		$("#btn_login").click(function (){
			$("#if_login").attr("method","get");
			$("#if_login").attr("action","./loginAction.jsp");
			$("#if_login").submit();//전송
		});
	});
</script>
<table width="100%" height="100%" border="1" borderColor="orange">
	<tr>
		<td align="center">
		<form id="if_login">
		<table width="100%" height="100%" >
			<tr>
				<td align="center">Jquery를 적용한 웹페이지 실습</td>
			</tr>
			<tr>
				<td align="right">
				ID : <input type="text" id="imem_id" name="mem_id" size="10">
				&nbsp;
				PW : <input type="text" id="imem_pw" name="mem_pw" size="10">
				&nbsp;
				<input type="button" id="btn_login" value="로그인">
				</td>
			</tr>
		</table>
		</form>
		</td>
	</tr>
</table>
</body>
</html>