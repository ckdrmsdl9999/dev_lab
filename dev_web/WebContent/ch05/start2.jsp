<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>start2.jsp페이지</title>
<script type="text/javascript">
	function send(){
		document.f_send.method="get";
		document.f_send.action="/ch05/service.do";
		document.f_send.submit();
	}
</script>
</head>
<body>
<form name="f_send">
	아이디 : <input type="text" name="mem_id"><br>
	비  번  : <input type="text" name="mem_pw"><br>
	<input type="button" value="전송" onClick="send()">
</form>
</body>
</html>