<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="/js/jquery-1.11.1.js"></script>
<title>���蹮��1</title>
</head>
<body>
<script type="text/javascript">
	var count=0;
	$(document).ready(function (){
		$("#btn_next").click(function (){
			//alert("����");
			//$('input:checkbox[id="checkbox_id"]').is(":checked") == true

			if($("#testForm1").is(":checked")==true){
				$("#h_test1").val(1);
				count++;
				//alert("1��:"+$("#h_test1").val());
			}
			else if($("#testForm2").is(":checked")==true){
				$("#h_test1").val(2);
				count++;
			}
			else if($("#testForm3").is(":checked")==true){
				$("#h_test1").val(3);
				count++;
			}
			else if($("#testForm4").is(":checked")==true){
				$("#h_test1").val(4);
				count++;
			}
			if(count==1){
				$("#if_test1").attr("method","get");
				$("#if_test1").attr("action","./testForm2.jsp");
				$("#if_test1").submit();
			}
			else{
				alert("���� �����ϼ���");
				return;
			}
		});
	});
</script>
<form id="if_test1">
<input type="hidden" id="h_test1" name="hn_test1">
1. ������ ��(data model)�� �������� ���� ������ ����?<br>
<br>
<input type="checkbox" id="testForm1">
���� ������ ������ ������ ��ǻ�� ������ ������ ������ ����ϴ� �������� �����̴�.<br>
<input type="checkbox" id="testForm2">
��ǻ�� ������ ������ ������ ���� ������ ������ ������ ����ϴ� �������� �����̴�.<br>
<input type="checkbox" id="testForm3">
���� ������ Ư���� �� �κ��� ǥ���̴�.<br>
<input type="checkbox" id="testForm4">
���� ������ ������ ������ ���� ������ ������ ������ ����ϴ� �������� �����̴�.<br>
<input type="button" id="btn_next" value="����">
</form>
</body>
</html>