 <%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>검색어 자동 완성 기능</title>
<link rel="stylesheet" type="text/css" href="../css/word.css"/>
<!--  jquery api import -->
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<script type="text/javascript">
function clearMethod(){
	$("#d_word").css("backgroundColor","#FFFFFF");
	$("#d_word").css("border","none");
	$("#d_word").html("");
	
	
}


</script>
</head>
<body>


<script type="text/javascript">





$(document).ready(function (){
	

	
	$("#word").keyup(function (){
		
		var p_word = $("#word").val();
		var param= "word="+p_word;
		
		
		$.ajax({
			type:"POST"
			,url:"./searchWordResult.aja"                  //		,url:"./searchWordResult.aja?word="+p_word 
			,data:param
			,success:function(result){
				
				$("#d_word").css("border","#000000 1px solid");
				$("#d_word").css("width",165+"px");
				$("#d_word").css("background","#FFFFFF 1px solid");
				$("#d_word").css("left",$("#word").offset().left+"px");
				$("#d_word").css("top",$("#word").offset().top+$("#word").offset().height+"px");
				
				
				
				$("#d_word").html(result);
				
				
				
				
				var tds = document.getElementsByTagName("td");

				for(var i=0;i<tds.length;i++){
					tds[i].onmouseover = function(){
					this.className = "listIn";
					};
					tds[i].onmouseout = function(){
					this.className = "listOut";
					};
					tds[i].onclick = function() {
												
						$("#word").val($(this).text());
						
						clearMethod();
					};
					
					
					
					}

				
				
				
				
				
			}
		});
		
		
	});
	});
/* 키보드를 눌렀다가 뗄데  */
/* 돔구성이 완료되엇을때  */

</script>


<h3>검색어 자동완성 기능 구현 </h3>
검색어입력 : <input type="text" id="word" >
<div id="d_word"></div>


</body>
</html>