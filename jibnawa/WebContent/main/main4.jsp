<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>


<title>����3</title>
<!--���ν�Ÿ��  -->
<style type="text/css">
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


<div id="container" align=center>
	<table>
		<tr>
			<td width=500><p align="middle">
					<!--		<div id="location" style="margin: auto">
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
					</script>  --></td>
		</tr>
	</table>
	<br> <br>
</div>
<!--�̹��� �����̴� ��-->
<!--���� ǥ ����-->
<div id="container">
	<div id="container" style="width: 100%; height: 30%" align=center>
		<div id="container" class="col-md-4">
			<table id="container" class="easyui-datagrid" title="������ �����"
				style="height: 250px; width: 100%;" fitColumns="true" />
			<!-- data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'" > -->
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
		<div id="container" class="col-md-4 wow animated fadeInRight animated">
			<table id="container" class="easyui-datagrid" title="������ �����"
				style="height: 250px; width: 100%; float: right" fitColumns="true" />
			<!--	data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'"> -->
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
</div>
</div>
<br>
<br>
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
<!-- main �� -->
