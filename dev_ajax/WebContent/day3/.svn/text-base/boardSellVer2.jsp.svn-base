<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>보드판매량 집계(Ajax적용코드)</title>
<link rel="stylesheet" type="text/css" href="../css/boards.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/dev_jquery/js/jquery-1.11.1.js"></script>
</head>
<!-- <body onLoad="test()"> -->
<body>
<script type="text/javascript">
	$(document).ready(function (){
		$("#btn_account").click(function (){
			console.log("마진 버튼 클릭했을 때");
/*
	$.ajax()->url, type, data, success
	$.get()  -> get() or post()사용시에는 속성(url, type, data{post방식으로 전송할 때}, success)을 사용할 수 없다.
	$.post()
*/
			$.ajax({
				type:"get"
			   ,url:"getUpdateBoardSales.jsp"
			   ,success:function(data){//data:request.responseText;200-OK
				  console.log("서버페이지로 부터 응답메시지:"+data);
					var newTotal = data;//1200 1500
					//html에서 제공하는 콤퍼넌트에 입력한 값을 가져올 때 - $("#[id일때]|선택자").val()
					$("#boards-sold").text(data);//보드판매량을 수정-text(값):텍스트노드 접근할 때
					var price = $("#price").text();//소비자 금액 담기
					var cost = $("#cost").text();//구매가 금액 담기		
					//보드 한 개당 마진 금액 구하기
					var cashPerBoard = price - cost;
					//총 마진 금액 구하기
					var cash = cashPerBoard*newTotal;
					//alert("보드 한개당 마진 : "+cashPerBoard+", 총마진:"+cash);		
					$("#cash").text(cash);
			  }
			});
		});
	});
</script>
<table border="1" width="300" height="80">
	<tr>
	<th>보드판매량</th><!-- textnode 태그이름은 노, 값은 존재 -->
	<td><span id="boards-sold">1000</span></td>
	</tr>
	<tr>
	<th>소비자가</th>
	<td><span id="price">250000</span></td>
	</tr>
	<tr>
	<th>구매가</th>
	<td><span id="cost">170000</span></td>
	</tr>		
</table>
<h2>마진금액 : <span id="cash">80000000</span>원</h2>
<input type="button" value="마진은?" id="btn_account">
<br>
</body>
</html>









