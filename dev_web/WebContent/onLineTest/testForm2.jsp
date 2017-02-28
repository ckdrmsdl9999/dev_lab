<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String test1 = request.getParameter("hn_test1");
	Cookie cookie = new Cookie("test1",test1);
	cookie.setMaxAge(60*20);//20분
	response.addCookie(cookie);
	//out.print(test1);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="/js/jquery-1.11.1.js"></script>
<title>시험문제1</title>
</head>
<body>
<script type="text/javascript">
	var count = 0;
	$(document).ready(function (){		
		$("#btn_next").click(function (){
			//alert("시작");
			//$('input:checkbox[id="checkbox_id"]').is(":checked") == true

			if($("#testForm1").is(":checked")==true){
				$("#h_test2").val(1);
				count++;
				//alert("1번:"+$("#h_test2").val());
			}
			else if($("#testForm2").is(":checked")==true){
				$("#h_test2").val(2);
				count++;
			}
			else if($("#testForm3").is(":checked")==true){
				$("#h_test2").val(3);
				count++;
			}
			else if($("#testForm4").is(":checked")==true){
				$("#h_test2").val(4);
				count++;
			}
			if(count==1){
				$("#if_test2").attr("method","get");
				$("#if_test2").attr("action","./testForm3.jsp");
				$("#if_test2").submit();
			}
			else{
				alert("답을 선택하세요");
				return;
			}	
		});
		$("#btn_pre").click(function (){
			location.href="./testForm1.jsp";
		});		
	});
</script>
<form id="if_test2">
<!-- <input type="hidden" id="h_test1" name="hn_test1"> -->
<input type="hidden" id="h_test2" name="hn_test2">
2. 자료(data)와 정보(Information)에 대한 설명으로 가장 적절한 것은?<br>
<br>
<input type="checkbox" id="testForm1">
정보란 자료를 처리해서 얻을 수 있는 결과이다.<br>
<input type="checkbox" id="testForm2">
자료란 적절한 의사 결정의 수단으로 사용할 수 있는 시작이다.<br>
<input type="checkbox" id="testForm3">
정보란 현실 세계에 존재하는 가능하지 않은 그대로의 모습을 의미한다.<br>
<input type="checkbox" id="testForm4">
자료와 정보는 같은 의미이다.<br>
<input type="button" id="btn_pre" value="이전">
<input type="button" id="btn_next" value="다음">
</form>
</body>
</html>