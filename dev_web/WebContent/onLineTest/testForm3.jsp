<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String test2 = request.getParameter("hn_test2");
	Cookie cookie = new Cookie("test2",test2);
	cookie.setMaxAge(60*20);//20분
	response.addCookie(cookie);
	//out.print(test1);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="/js/jquery-1.11.1.js"></script>
<title>시험문제3</title>
</head>
<body>
<script type="text/javascript">
	var count = 0;
	$(document).ready(function (){
		$("#btn_next").click(function (){
			//alert("시작");
			//$('input:checkbox[id="checkbox_id"]').is(":checked") == true

			if($("#testForm1").is(":checked")==true){
				$("#h_test3").val(1);
				count++;
				//alert("1번:"+$("#h_test2").val());
			}
			else if($("#testForm2").is(":checked")==true){
				$("#h_test3").val(2);
				count++;
			}
			else if($("#testForm3").is(":checked")==true){
				$("#h_test3").val(3);
				count++;
			}
			else if($("#testForm4").is(":checked")==true){
				$("#h_test3").val(4);
				count++;
			}
			if(count==1){
				$("#if_test3").attr("method","get");
				//location.href="./testFormAccount.jsp";
				$("#if_test3").attr("action","./testForm4.jsp");
				$("#if_test3").submit();
			}
			else{
				alert("답을 선택하세요");
				return;
			}			
		});
		$("#btn_pre").click(function (){
			location.href="./testForm2.jsp";
		});
	});
</script>
<form id="if_test3">
<!-- <input type="hidden" id="h_test1" name="hn_test1">
<input type="hidden" id="h_test2" name="hn_test2"> -->
<input type="hidden" id="h_test3" name="hn_test3">
3. 데이터베이스 관리 시스템(DBMS)에서 제어기능이 갖추어야 할 요건과 거리가 먼 것은?<br>
<br>
<input type="checkbox" id="testForm1">
데이터의 무결성 유지<br>
<input type="checkbox" id="testForm2">
갱신, 삽입, 삭제 등의 연산<br>
<input type="checkbox" id="testForm3">
보안 유지와 권한 검사<br>
<input type="checkbox" id="testForm4">
정확성 유지를 위한 병행 제어<br>
<input type="button" id="btn_pre" value="이전">
<input type="button" id="btn_next" value="다음">
</form>
</body>
</html>