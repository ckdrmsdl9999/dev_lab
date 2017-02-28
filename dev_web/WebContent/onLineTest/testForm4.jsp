<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String test3 = request.getParameter("hn_test3");
	Cookie cookie = new Cookie("test3",test3);
	cookie.setMaxAge(60*20);//20분
	response.addCookie(cookie);
	//out.print(test1);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="/js/jquery-1.11.1.js"></script>
<title>시험문제4</title>
</head>
<body>
<script type="text/javascript">
	var count = 0;
	$(document).ready(function (){
		$("#btn_next").click(function (){
			//alert("시작");
			//$('input:checkbox[id="checkbox_id"]').is(":checked") == true

			if($("#testForm1").is(":checked")==true){
				$("#h_test4").val(1);
				count++;
				//alert("1번:"+$("#h_test2").val());
			}
			else if($("#testForm2").is(":checked")==true){
				$("#h_test4").val(2);
				count++;
			}
			else if($("#testForm3").is(":checked")==true){
				$("#h_test4").val(3);
				count++;
			}
			else if($("#testForm4").is(":checked")==true){
				$("#h_test4").val(4);
				count++;
			}
			if(count==1){
				$("#if_test4").attr("method","get");
				//location.href="./testFormAccount.jsp";
				$("#if_test4").attr("action","./testForm5.jsp");
				$("#if_test4").submit();
			}
			else{
				alert("답을 선택하세요");
				return;
			}			
		});
		$("#btn_pre").click(function (){
			location.href="./testForm3.jsp";
		});
	});
</script>
<form id="if_test4">
<!-- <input type="hidden" id="h_test1" name="hn_test1">
<input type="hidden" id="h_test2" name="hn_test2">
<input type="hidden" id="h_test3" name="hn_test3"> -->
<input type="hidden" id="h_test4" name="hn_test4">
4. 다음 질의어를 SQL문장으로 바르게 나타낸 것은?<br>
학번이 100, 이름이 홍길동, 학과가 컴퓨터인 학생을 학생 테이블에 삽입하라.<br>
(단 학생 테이블에 학번, 이름, 학과의 열이 있다고 가정한다.)<br>

<br>
<input type="checkbox" id="testForm1">
UPDATE 학생 테이블 SET 학번 = 100, 이름 = '홍길동', 학과 = 컴퓨터<br>
<input type="checkbox" id="testForm2">
INSERT INTO 학생테이블 VALUES(100,'홍길동','컴퓨터')<br>
<input type="checkbox" id="testForm3">
INSERT 학생테이블 VALUES(100,'홍길동','컴퓨터')<br>
<input type="checkbox" id="testForm4">
UPDATE 학생 테이블 SET(100,'홍길동','컴퓨터')<br>
<input type="button" id="btn_pre" value="이전">
<input type="button" id="btn_next" value="다음">
</form>
</body>
</html>