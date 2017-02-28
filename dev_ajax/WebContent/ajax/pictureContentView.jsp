<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%@page import="java.util.List, com.vo.PictureVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/picture.css"/>
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<script type="text/javascript">

function subClose(){
	
	$("#d_picture").html("");
	
}

function pictureDetail(a,pnum){
	
	
	
	
	var param2 = "ab_title="+this.innerHTML;
	
	$.ajax({
		type:"POST"
	  , url:"./getBookList.bk"
	  , data:param2
	  ,success:function(result){
		  
		 
		  $("#detail_book").html(result);
		  
	  }
	});
	
	
	

	/* 	$("#d_word").css("backgroundColor","#FFFFFF");
	$("#d_word").css("border","none");
	$("#d_word").html(""); */
	
	var tds = document.getElementsByTagName("td");
	
	//alert(pnum);
	
	
	var param= "pnum="+pnum;
	
	
	
	$.ajax({
		
		type:"POST"
		,url:"./getPictureDetail.aja"                  //		,url:"./searchWordResult.aja?word="+p_word 
		,data:param
		,success:function(result){
			
	/* 	 $("#d_picture").css("border","#000000 1px solid");
			$("#d_picture").css("width",165+"px");
			$("#d_picture").css("background","#FFFFFF 1px solid"); 
		 	$("#d_picture").css("left",$(this).offset().top+"px");
		 	$("#d_picture").css("top",$("#word").offset().top+$("#word").offset().height+"px");  */
			
		 	//alert($(a).width());
		 	
		 	$("#d_picture").css("top",a.offsetTop+6+"px");
		 //	$("#d_picture").css("left",$(a).width()+"px");
		 	$("#d_picture").css("left",a.offsetLeft+a.offsetWidth+13+"px");
			
			$("#d_picture").html(result);
			
			
			
		}
	,error:function(e){
		alert(e.responseText);
	}
	});
	
	
}


</script>


</head>
<body>

<table width ="350px" border ="1">
<!-- 검색결과가 존재 할때 -->

<%   List<PictureVO> pictureList = (List<PictureVO>) request.getAttribute("pictureList"); 



if(pictureList!=null){

	for(int i =0;i<pictureList.size();i++){
	PictureVO rpVO = pictureList.get(i);
%>

<tr>

<td align="center" width ="50">
<img src ="<%=rpVO.getImgFile()%>" width="50" height="50"/>
</td>
<td width="150" onMouseOver=pictureDetail(this,<%=rpVO.getNum() %>)><%=rpVO.getTitle() %></td>
</tr>
<%
}
}
else{

%>
<!-- 검색 결과가 없을때 -->
<tr>
<td>검색 결과가 없습니다.</td>
</tr>

<%
}
%>

</table>
<div id="d_picture">

</div>


</body>
</html>