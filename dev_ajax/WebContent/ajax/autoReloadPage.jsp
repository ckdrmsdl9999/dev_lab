<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="/dev_ajax/js/jquery-1.11.1.js"></script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function (){
		var watch;
		function start(){
			watch = setInterval(autoReload,2000);
		}
		function stop(){
			setTimeout(function (){
				clearInterval(watch);
			},20000);
		}
		//ajax구현
		function autoReload(){
			//alert("autoReload호출 성공");
			//$.get({
				//"get", "./getNewsList.do", varName
			//}); 
			//$.post({});
			$.ajax({
				type:"get"
			  , url:"./getNewsList.do"
			  , success:function(result){
				  //alert("success");
			  	  $("#d_news").html(result);  
			  }
			  , error:function(e){
				  $("#d_news").text(e.responseText);
			  } 
			});
		}
		start();
		stop();
	});
</script>
<h3>자동 갱신 페이지 구현</h3>
<div id="d_news"></div>
</body>
</html>