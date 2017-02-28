<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.net.URLDecoder, com.vo.JibnawaMemberVO,java.util.*"%>
	<%!	 String mem_email=null;	
		 String mem_div =null; 
		 JibnawaMemberVO jm=new JibnawaMemberVO();
		%>
	 <%
		jm= (JibnawaMemberVO)session.getAttribute("login");
		String mem=null;
		Map userInfo = new HashMap();
		if(jm!=null){
			switch (jm.getMem_div().trim()){
			case "a" :
				mem_div="a";
			break;
			case "c" :
				mem_div="c";
			break;
			case "m" :
				mem_div="m";
			break;
				}
			
			userInfo.put("mem_div", mem_div);
			userInfo.put("mem_nickname", jm.getMem_nickname());%>
				 <script type="text/javascript">
				 myModal.close('modalDiv01');
				 </script>
			
		<%}
		String loginChk = request.getParameter("loginChk");
		
	 %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="shortcut icon" href="../img/favicon.png">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="../axisjui/arongi/page.css">
<link rel="stylesheet" type="text/css"
	href="../axisj/ui/arongi/AXJ.min.css">

<script type="text/javascript" src="../../jquery/jquery.min.js"></script>
<!--script type="text/javascript" src="../../dist/AXJ.min.js"></script-->

<script type="text/javascript" src="../axisj/lib/AXJ.js"></script>
<script type="text/javascript" src="../axisj/lib/AXTopDownMenu.js"></script>
<script type="text/javascript" src="../axisj/lib/AXMobileMenu.js"></script>
<script type="text/javascript" src="../axisj/lib/AXModal.js"></script>
<script type="text/javascript" src="../axisj/lib/AXTab.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<title>메인3</title>
<!--메인스타일  -->
<style type="text/css">
<style>
{
margin:0;
padding:0;
}
div {
	width: auto;
}

{
float:left;
list-style:none;
margin-right:110px;
}
ul li a {
	color: #898989;
}

ul li :hover {
	color: #f8b62b;
}

table a {
	color: #898989;
}

table :hover {
	color: #f8b62b;
}

.line1 {
	border-bottom: 1px solid #d2d2d2;
}

.line2 {
	border-right: 1px solid green;
}

.line3 {
	border-top: 1px solid #d2d2d2;
}

.line4 {
	border-left: 1px solid green;
}

a {
	text-decoration: none
}
/*반응형  */
.container {
	padding-right: 15px;
	padding-left: 15px;
	margin-right: auto;
	margin-left: auto;
}

@media ( min-width : 768px) {
	.container {
		width: 750px;
	}
}

@media ( min-width : 992px) {
	.container {
		width: 970px;
	}
}

@media ( min-width : 1200px) {
	.container {
		width: 1170px;
	}
}
</style>


</head>
<body>
	</br>
	<div>

			<%
				request.setAttribute("userInfo", userInfo);
			%>
				<jsp:include page="header.jsp" flush="false"/>
			<div>
					<jsp:include page="main4.jsp" />		
			</div>
	<!-- end preloader -->
	<!--
        Fixed Navigation-->
	</div>
	<br>
</body>
</html>