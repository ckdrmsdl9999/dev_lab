<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//만일 hidden속성을 이용해서 앞페이지에 값들을 유지하려면
	//1번 문항에 대한 답안을 참조하려면
/* 	String hn_test1 = request.getParameter("hn_test1");
	String hn_test2 = request.getParameter("hn_test2");
	String hn_test3 = request.getParameter("hn_test3");
	String hn_test4 = request.getParameter("hn_test4"); */
	String test4 = request.getParameter("hn_test4");
	Cookie cookie = new Cookie("test4",test4);
	cookie.setMaxAge(60*20);//20분
	response.addCookie(cookie);
	//out.print(test1);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="/js/jquery-1.11.1.js"></script>
<title>시험문제5</title>
</head>
<body>
<script type="text/javascript">
	var count = 0;
	$(document).ready(function (){
		$("#btn_send").click(function (){
			//alert("시작");
			//$('input:checkbox[id="checkbox_id"]').is(":checked") == true

			if($("#testForm1").is(":checked")==true){
				$("#h_test5").val(1);
				count++;
				//alert("1번:"+$("#h_test2").val());
			}
			else if($("#testForm2").is(":checked")==true){
				$("#h_test5").val(2);
				count++;
			}
			else if($("#testForm3").is(":checked")==true){
				$("#h_test5").val(3);
				count++;
			}
			else if($("#testForm4").is(":checked")==true){
				$("#h_test5").val(4);
				count++;
			}
			if(count==1){
				$("#if_test5").attr("method","get");
				//location.href="./testFormAccount.jsp";
				$("#if_test5").attr("action","./marking.test");//쿠키에 담는 코드(jsp처리:화면제공 필요없다)
				$("#if_test5").submit();
			}
			else{
				alert("답을 선택하세요");
				return;
			}			
		});
		$("#btn_pre").click(function (){
			location.href="./testForm4.jsp";
		});
	});
</script>
<form id="if_test5">
<!-- <input type="hidden" id="h_test1" name="hn_test1">
<input type="hidden" id="h_test2" name="hn_test2">
<input type="hidden" id="h_test3" name="hn_test3">
<input type="hidden" id="h_test4" name="hn_test4"> -->
<input type="hidden" id="h_test5" name="hn_test5">
5. 데이터베이스 설계시 다음 ()안의 내용으로 옳은 것은?<br>
요구 조건 분석 -> (   ) -> (   ) -> (   ) -> 데이터베이스 구현
<br>
<input type="checkbox" id="testForm1">
물리적 설계 - 논리적 설계 - 개념적 설계<br>
<input type="checkbox" id="testForm2">
개념적 설계 - 논리적 설계 - 물리적 설계<br>
<input type="checkbox" id="testForm3">
논리적 설계 - 개념적 설계 - 물리적 설계<br>
<input type="checkbox" id="testForm4">
논리적 설계 - 물리적 설계 - 개념적 설계<br>
<input type="button" id="btn_pre" value="이전">
<input type="button" id="btn_send" value="제출">
</form>
</body>
</html>