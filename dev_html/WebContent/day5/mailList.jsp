<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ������</title>
<script type="text/javascript">
	function checkAll(size){
	//��ü üũ�ڽ��� �������� ��
	//�ο찡 �Ѱ� �϶� - from
		if(document.getElementById("icb_mail").checked == 1)
		{
			if(size==1){//from
				document.f_mail.from.checked = 1;
			}
			else{//from[i]
				for(var i=0;i<size;i++){
					document.f_mail.from[i].checked = 1;
				}
			}
		}
	//�ο찡 ������ �϶� - from[i]
	//��ü üũ�ڽ��� ���� ���� ��
	   if(document.getElementById("icb_mail").checked == 0)
			if(size==1){//from
				document.f_mail.from.checked = 0;
			}
			else{//from[i]
				for(var i=0;i<size;i++){
					document.f_mail.from[i].checked = 0;
				}
			}
	   }
</script>
</head>
<body>
<form name="f_mail">
<table border="1" borderColor="green" width="350">
<thead>���� ������</thead>
<!-- ���̺� ��� ���� -->
<tr>
	<td width="50" align="center">
	<input type="checkbox" id="icb_mail" onClick="checkAll('5')">
	</td>
	<td width="220">����</td>
	<td width="80">&nbsp;</td>
</tr>
<!-- ���̺� ���  �� -->
<!-- ���� ��� ���� -->
<%
	String title[] = {"����1","����2"
			              ,"����3","����4","����5"};
	for(int i=0;i<5;i++){
%>
<tr>
	<td align="center">
	<input type="checkbox" name="from">
	</td>
	<td><%=title[i] %></td>
	<td><a href="#">����</a></td>
</tr>	
<%
	}/////////// end of for
%>
<!-- ���� ���  �� -->
</table>
</form>
</body>
</html>