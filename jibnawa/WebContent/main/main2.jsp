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
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<title>����2</title>
<!--���ν�Ÿ��  -->
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
/*���ν�Ÿ�� �� */
/*�̹��� �����̵� ����  */
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
/*�̹��� �����̵� �� */
/*������  */
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
 function j_login(){
	 
 }
 function j_join(){
	 
 }
 </script>
</head>
<body>
	<div id="container">
		<!-- �α��� �� �˻�â -->
		<div div style="width: 100%;" align=center>
			<table>
				<div id="search" style="width: 40%; float: left;">
					<input class="easyui-searchbox"
						data-options="prompt:'�˻����� �Է�',searcher:doSearch"
						style="width: 350px">
				</div>
				<div style="width: 50%; float: left;">
					<button type="button" class="btn btn-info" id="login"
						onClick="j_login()">�α���</button>
					<button type="button" class="btn btn-info" id="join"
						onClick="j_join">ȸ������</button>
					<br> </a>
				</div>
				</div>
			</table>
			<br>
			<hr width="100%">
			<!-- �α��� �˻� â �� -->
			<br>
			<!--�̹��� �����̴� ���� -->
			<div id="container">
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
								</ul>
							</div>
							</div>
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
</script>
							</p> </a></td>
					</tr>
				</table>
				<br> <br>
			</div>
			<!--�̹��� �����̴� ��-->
			<!--���� ǥ ����-->
			<div id="container">
				<div style="margin: 20px 0;"></div>
				<div style="float: left; margin-right: 100px; margin-left: 150px"
					id="in_put">
					<table class="easyui-datagrid" title="������ �����"
						style="width: 400px; height: 250px" fitColumns="true"
						data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'">
						<thead>
							<tr>
								<th data-options="field:'ib',width:80,align:'center'">��������</th>
								<th data-options="field:'productid',width:100,align:'center'">�Ǹ���</th>
								<th data-options="field:'listprice',width:80,align:'center'">����</th>
								<th data-options="field:'unitcost',width:80,align:'center'">������¥</th>
							</tr>
						</thead>
						<tr>
							<td>������</td>
							<td>��</td>
							<td>����</td>
							<td>D-10</td>
						</tr>
					</table>
				</div>
				<div style="margin: 20px 0;"></div>
				<div style="float: left;" id="container">
					<table class="easyui-datagrid" title="������ �����"
						style="width: 350px; height: 250px" fitColumns="true"
						data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'">
						<thead>
							<tr>
								<th data-options="field:'itemid',width:80,align:'center'">��������</th>
								<th data-options="field:'productid',width:100,align:'center'">������</th>
								<th data-options="field:'listprice',width:80,align:'center'">����</th>
							</tr>
						</thead>
						<tr>
							<td>����</td>
							<td>��</td>
							<td>����</td>
						</tr>
					</table>
				</div>
			</div>
			<br> <br>
			<!--���� ǥ ��  -->
			<div style="float: left; margin-left: 100px" id="container">
				<h3>�̴��� ��õ��ü</h3>
				<img src="../img/pi.jpg" class="img-rounded">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src="../img/pi.jpg"
					class="img-rounded"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img
					src="../img/pi.jpg" class="img-rounded">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src="../img/pi.jpg"
					class="img-rounded">
			</div>
		</div>
</body>
</html>