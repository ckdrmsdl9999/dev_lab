<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String name = "ȫ�浿";
	//���� i�� �ڹٽ�ũ��Ʈ ������� ���� ��
	//�����Ѱ�?
	//int x = i;
	//�ڹٽ�ũ��Ʈ���� ������ �ִ� ���� ��Ű�� ���� �� ����.
	//���� i�� �ڹٽ�ũ��Ʈ ������� �������� ��
	//Cookie cookie = new Cookie("dap1",i);
%>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�ڹ� �� �ڹٽ�ũ��Ʈ</title>
<script type="text/javascript" src="/js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	function send(){
		$("#f_test").attr("method","get");
		$("#f_test").attr("action","./b.jsp");//a.jsp���������� ������ ���� �޾Ƽ� ��Ű�� ��ƺ�����.
		$("#f_test").submit();
	}
</script>
</head>
<body>
<script type="text/javascript">
	var i = 10;
	var j = <%=20%>//�������� ��¹���(�ͽ��������� ���)
	//var j(Ŭ���̾������� ó��) = 20(���������� ó���� ����� �ݿ�);
	console.log("���� j:"+j);//ũ�Һ��������� �����ϴ� ������ api
	//alert("���� j:"+j);//���̾�α�â
	//document.write("���� j:"+j);
	var age = document.getElementById("i_age").value;
	//var age = $("#i_age").val();
	
</script>
<form id="f_test">
	<input type="hidden" id="h_age" name="nh_age" value="40"><!-- ����ȵ� -->
	<input type="text" id="i_age" name="age" value="<%=30%>"><!-- ȭ�� ���� -->
	<input type="button"  value="����" onClick="send()">
</form>
</body>
</html>