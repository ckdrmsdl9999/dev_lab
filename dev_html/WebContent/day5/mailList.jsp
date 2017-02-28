<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>받은 메일함</title>
<script type="text/javascript">
	function checkAll(size){
	//전체 체크박스를 선택했을 때
	//로우가 한개 일때 - from
		if(document.getElementById("icb_mail").checked == 1)
		{
			if(size==1){//from
				document.f_mail.from.checked = 1;
			}
			else{//from[i]
				for(var i=0;i<size;i++){
					document.f_mail.from[i].checked = 1;
				}
			}
		}
	//로우가 여러개 일때 - from[i]
	//전체 체크박스를 해제 했을 때
	   if(document.getElementById("icb_mail").checked == 0)
			if(size==1){//from
				document.f_mail.from.checked = 0;
			}
			else{//from[i]
				for(var i=0;i<size;i++){
					document.f_mail.from[i].checked = 0;
				}
			}
	   }
</script>
</head>
<body>
<form name="f_mail">
<table border="1" borderColor="green" width="350">
<thead>받은 메일함</thead>
<!-- 테이블 헤더 시작 -->
<tr>
	<td width="50" align="center">
	<input type="checkbox" id="icb_mail" onClick="checkAll('5')">
	</td>
	<td width="220">제목</td>
	<td width="80">&nbsp;</td>
</tr>
<!-- 테이블 헤더  끝 -->
<!-- 메일 목록 시작 -->
<%
	String title[] = {"제목1","제목2"
			              ,"제목3","제목4","제목5"};
	for(int i=0;i<5;i++){
%>
<tr>
	<td align="center">
	<input type="checkbox" name="from">
	</td>
	<td><%=title[i] %></td>
	<td><a href="#">보기</a></td>
</tr>	
<%
	}/////////// end of for
%>
<!-- 메일 목록  끝 -->
</table>
</form>
</body>
</html>