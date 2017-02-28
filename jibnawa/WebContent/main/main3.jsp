<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
<
style
>
{
margin




:




0;
padding




:




0;
}
div {
	width: auto;
}

{
float




:left




;
list-style




:none




;
margin-right




:




110
px


;
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
/*메인스타일 끝 */
/*이미지 슬라이드 시작  */
body {
	margin: 0;
}

#location {
	position: relative;
	width: 1000px;
	height: 200px;
	overflow: hidden;
	white-space: nowrap;
	border: 1px solid #000;
}

#location ul#slider {
	list-style: none;
	margin: 0;
	padding: 0;
}

#location ul li {
	position: absolute;
	width: 500px;
	height: 300px;
}

#location ul li img {
	width: 1000px;
	height: 200px;
}
/*이미지 슬라이드 끝 */
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


<script type="text/javascript">
 function doSearch(){
	 
 }

 //function j_login(){
	 
// }
 //function j_join(){
	 
// }
 
 
 var pageID = "AXModal";
 var myModal = new AXModal();
 var fnObj = {
     pageStart: function () {
         myModal.setConfig({
             windowID: "myModalCT", width: 340,
             mediaQuery: {
                 mx: {min: 0, max: 367}, dx: {min: 367}
             },
             displayLoading: true,
             scrollLock: true
         });
     },
     login: function () {
 
         myModal.open({
             url: "login/login.jsp",
             //url:"/samples/AXgrid/index.html",
             pars: "a=1&b=2&c=3".queryToObject(),
             top: 100,
             closeByEscKey: true
         });
     },
     sigin: function () {
         myModal.open({
             url: "login/sigin.jsp",
             //url:"/samples/AXgrid/index.html",
             pars: "a=1&b=2&c=3".queryToObject(),
             top: 100,
             closeByEscKey: true
         });
     },
     //페이지 붙이는 곳
     TEST: function () {
         myModal.open({
        	 //페이지 위치
             url: "../jibnawa/jibnawaMember.kosmo",
             //url:"/samples/AXgrid/index.html",
             pars: "a=1&b=2&c=3".queryToObject(),
             top: 100,
             closeByEscKey: true
         });
     }
 };
 jQuery(document.body).ready(function () {
     fnObj.pageStart()
 });
 </script>
</head>
<body>
	<!--
	<div id="container">
		<!-- 로그인 및 검색창 
		<div  style="width: 100%;" align=center>
				<div id="search" style="width: 40%; float: left;">
					<input class="easyui-searchbox"
						data-options="prompt:'검색조건 입력',searcher:doSearch"
						style="width: 350px">
				</div>
				<div style="width: 50%; float: left;">
					<button type="button" class="btn btn-info" id="login"
						onclick="fnObj.login();">로그인</button>
					<button type="button" class="btn btn-info" id="join"
						onclick="fnObj.sigin();">회원가입</button>
					<br>
				</div>
				</div>
			<br>
			<hr width="100%">
			<!-- 로그인 검색 창 끝 -->
	<!-- <br> -->
	<!--이미지 슬라이더 시작 -->
	<!-- preloader -->
	<div id="preloader">
		<div class="loder-box">
			<div class="battery"></div>
		</div>
	</div>
	<!-- end preloader -->

	<!--
        Fixed Navigation-->
	<div id="container">
		<div style="width: 100%;" align=center>
			<div class="bs-example" data-example-id="navbar-form">
				<nav class="navbar ">
					<div class="container-fluid">
						<div class="navbar-header">
							<button type="button" style="background-color: black"
								class="navbar-toggle" data-toggle="collapse"
								data-target="#bs-example-navbar-collapse-2" aria-expanded="true">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#">Jibnawa</a>
						</div>
						<div class="navbar-collapse collapse in"
							id="bs-example-navbar-collapse-2" aria-expanded="true">
							<form class="navbar-form " style="text-align: center;"
								role="search">
								<div class="form-group" sytle="text-align:center;">
									<input type="text" class="form-control" placeholder="Search">
								</div>
								<button type="button" class="btn btn-info" id="login"
									style="margin-left: 10%;" onclick="fnObj.login();">로그인</button>
								<button type="button" class="btn btn-info" id="join"
									onclick="fnObj.sigin();">회원가입</button>
								<button type="button" class="btn btn-info" id="TEST"
									onclick="fnObj.TEST();">TEST</button>
							</form>
						</div>
					</div>
				</nav>
			</div>
		</div>
	</div>
	<br>
	<div id="container" align=center>
		<table>
			<tr>
				<td width=500><p align="middle">
					<div id="location" style="margin: auto">
						<ul id="slider">
							<div id="container">
								<li><img src="../img/go.jpg" /></li>
								<li><img src="../img/s.jpg" /></li>
								<li><img src="../img/pi.jpg" /></li>
								<li><img src="../img/pa.jpg" /></li>
							</div>
						</ul>
					</div> <script type="text/javascript">
						var x = 300;
						var slider = document.getElementById("slider");
						var slideArray = slider.getElementsByTagName("li");
						var slideMax = slideArray.length - 1;
						var curSlideNo = 0;
						
						for (i = 0; i <= slideMax; i++) {
							if (i == curSlideNo) slideArray[i].style.left = 0;
							else slideArray[i].style.left = -x + "px";
						}
						
						slider.addEventListener('click', function () {
							changeSlide();
						}, false);
						
						var aniStart = false;
						var next = 1;
						var changeSlide = function(){
							if (aniStart === true) return;
							next = curSlideNo + 1;
							if (next > slideMax) next = 0;
							aniStart = true;
							sliding();
						}
						
						function sliding() {
							var curX = parseInt(slideArray[curSlideNo].style.left, 10);
							var nextX = parseInt(slideArray[next].style.left, 10);
							var newCurX = curX + 10;
							var newNextX = nextX + 10;
							if (newCurX >= x) {
								slideArray[curSlideNo].style.left = -x + "px";
								slideArray[next].style.left = 0;
								curSlideNo = curSlideNo + 1;
								if (curSlideNo > slideMax) curSlideNo = 0;
								aniStart = false;
								return;
							}
							slideArray[curSlideNo].style.left = newCurX + "px";
							slideArray[next].style.left = newNextX + "px";
							setTimeout(function () {
								sliding();
							}, 20);
						}
						setInterval(changeSlide,2000);
					</script></td>
			</tr>
		</table>
		<br> <br>
	</div>
	<!--이미지 슬라이더 끝-->
	<!--낙찰 표 시작-->
	<div id="container" style="width: 100%; height: 40%;" align=center>
		<div style="width: 60%; background-color: red" align=center>
			<div style="float: left; width: 450px; margin-left: -3%" id="in_put">
				<table class="easyui-datagrid" title="입찰중 역경매"
					style="height: 250px; width: 450px;" fitColumns="true"
					data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'">
					<thead>
						<tr>
							<th data-options="field:'ib',width:80,align:'center'">입찰유무</th>
							<th data-options="field:'productid',width:100,align:'center'">판매자</th>
							<th data-options="field:'listprice',width:80,align:'center'">지역</th>
							<th data-options="field:'unitcost',width:80,align:'center'">남은날짜</th>
						</tr>
					</thead>
					<tr>
						<td>입찰중</td>
						<td>나</td>
						<td>서울</td>
						<td>D-10</td>
					</tr>
				</table>
			</div>
			<div style="float: right; width: 450px; margin-right: -3%"
				id="container">
				<table class="easyui-datagrid" title="낙찰된 역경매"
					style="height: 250px; width: 450px;" fitColumns="true"
					data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'">
					<thead>
						<tr>
							<th data-options="field:'itemid',width:80,align:'center'">낙찰유무</th>
							<th data-options="field:'productid',width:100,align:'center'">낙찰자</th>
							<th data-options="field:'listprice',width:80,align:'center'">지역</th>
						</tr>
					</thead>
					<tr>
						<td>낙찰</td>
						<td>나</td>
						<td>서울</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<br>
	<br>
	<!--낙찰 표 끝  -->
	<div style="float: left; margin-left: 100px" id="container">
		<h3>이달의 추천업체</h3>
		<img src="../img/pi.jpg" class="img-rounded">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src="../img/pi.jpg"
			class="img-rounded"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img
			src="../img/pi.jpg" class="img-rounded">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src="../img/pi.jpg"
			class="img-rounded">
	</div>
</body>
</html>