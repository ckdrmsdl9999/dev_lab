<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>


<title>main</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>

<!--이미지 슬라이드 시작  -->
<Style type='text/css'>
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

@media screen and (max-width:1000px) {
	#location {
		width: auto;
	}
	#in_put {
		float: left;
		width: auto;
	}
	#out_put {
		float: left;
		width: auto;
	}
	#search {
		float: none;
		width: auto;
	}
}
</Style>
<!--이미지 슬라이드 끝  -->
<script type="text/javascript">
function doSearch(){
	alert("11")
}
</script>
</head>

<section>
	<div style="float: left; margin-right: 50px;">빠른경매</div>
	<div id="search">
		<input class="easyui-searchbox"
			data-options="prompt:'Please Input Value',searcher:doSearch"
			style="width: 350px">
		<button onclick="doSearch()">test</button>
	</div>
	<div id="location" style="margin: auto">
		<ul id="slider">
			<div>
				<li><img src="../img/go.jpg" /></li>
				<li><img src="../img/s.jpg" /></li>
				<li><img src="../img/pi.jpg" /></li>
				<li><img src="../img/pa.jpg" /></li>
		</ul>
	</div>
	<script type="text/javascript">
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
	</div>
	<!--낙찰 표 시작-->
	<div>
		<div style="margin: 20px 0;"></div>
		<div style="float: left; margin-right: 100px; margin-left: 250px"
			id="in_put">
			<table class="easyui-datagrid" title="입찰중 역경매"
				style="width: 341px; height: 250px"
				data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'">
				<thead>
					<tr>
						<th data-options="field:'itemid',width:80,align:'center'">입찰유무</th>
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
		<div style="margin: 20px 0;"></div>
		<div style="float: left;" id="out_put">
			<table class="easyui-datagrid" title="낙찰된 역경매"
				style="width: 261px; height: 250px"
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
	<!--낙찰 표 끝  -->
	<br>
	<div></div>
</section>

