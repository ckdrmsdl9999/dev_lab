<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�����Ǹŷ� ����(Ajax�����ڵ�)</title>
<link rel="stylesheet" type="text/css" href="../css/boards.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/dev_jquery/js/jquery-1.11.1.js"></script>
</head>
<!-- <body onLoad="test()"> -->
<body>
<script type="text/javascript">
	$(document).ready(function (){
		$("#btn_account").click(function (){
			console.log("���� ��ư Ŭ������ ��");
/*
	$.ajax()->url, type, data, success
	$.get()  -> get() or post()���ÿ��� �Ӽ�(url, type, data{post������� ������ ��}, success)�� ����� �� ����.
	$.post()
*/
			$.ajax({
				type:"get"
			   ,url:"getUpdateBoardSales.jsp"
			   ,success:function(data){//data:request.responseText;200-OK
				  console.log("������������ ���� ����޽���:"+data);
					var newTotal = data;//1200 1500
					//html���� �����ϴ� ���۳�Ʈ�� �Է��� ���� ������ �� - $("#[id�϶�]|������").val()
					$("#boards-sold").text(data);//�����Ǹŷ��� ����-text(��):�ؽ�Ʈ��� ������ ��
					var price = $("#price").text();//�Һ��� �ݾ� ���
					var cost = $("#cost").text();//���Ű� �ݾ� ���		
					//���� �� ���� ���� �ݾ� ���ϱ�
					var cashPerBoard = price - cost;
					//�� ���� �ݾ� ���ϱ�
					var cash = cashPerBoard*newTotal;
					//alert("���� �Ѱ��� ���� : "+cashPerBoard+", �Ѹ���:"+cash);		
					$("#cash").text(cash);
			  }
			});
		});
	});
</script>
<table border="1" width="300" height="80">
	<tr>
	<th>�����Ǹŷ�</th><!-- textnode �±��̸��� ��, ���� ���� -->
	<td><span id="boards-sold">1000</span></td>
	</tr>
	<tr>
	<th>�Һ��ڰ�</th>
	<td><span id="price">250000</span></td>
	</tr>
	<tr>
	<th>���Ű�</th>
	<td><span id="cost">170000</span></td>
	</tr>		
</table>
<h2>�����ݾ� : <span id="cash">80000000</span>��</h2>
<input type="button" value="������?" id="btn_account">
<br>
</body>
</html>









