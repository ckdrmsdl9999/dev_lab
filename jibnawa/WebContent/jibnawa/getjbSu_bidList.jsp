<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<div id="container">
		<div id="container"style="width: 100%;height:30%" align=center>
			<div id="container"class="col-md-4">
				<table id="container" class="easyui-datagrid" title="입찰중 역경매"
					style="height: 250px; width: 100%;" fitColumns="true"
					data-options="singleSelect:true,collapsible:true,url:'./getjbSubidList.kosmo',method:'get'">
					<thead>
						<tr>
							<th data-options="field:'SUB_AREA_CODE',width:80,align:'center'">입찰유무</th>
							<th data-options="field:'LODG_COM_NAME',width:100,align:'center'">판매자</th>
							<th data-options="field:'REGION_CODE',width:80,align:'center'">지역</th>
							<th data-options="field:'ACC_END_DATE',width:80,align:'center'">남은날짜</th>
						</tr>
					</thead>
				</table>
			</div>
			<div id="container" class="col-md-4 wow animated fadeInRight animated">
				<table id="container" class="easyui-datagrid" title="낙찰된 역경매"
					style="height: 250px; width: 100%;float:right" fitColumns="true"
					data-options="singleSelect:true,collapsible:true,url:'./getjbTenderList.kosmo',method:'get'">
					<thead>
						<tr>
							<th data-options="field:'AUC_SUCCESS_DATE',width:80,align:'center'">낙찰유무</th>
							<th data-options="field:'AUC_COMM_ID',width:100,align:'center'">낙찰자</th>
							<th data-options="field:'AUC_SUCCESS_COST',width:80,align:'center'">지역</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
	<br>
	<br>
</body>
</html>