<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.Map" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�۸��</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
//���ΰ�ħ ó���� �� Ȥ�� ���ǰ˻� ����� ���� ������ �� Ȱ�밡��.
	function searchALL()
	{
		location.href="./getBoardList.kosmo";
	}
	function writeForm()
	{
		$("#dlg_boardIns").dialog('open').dialog('setTitle','�۵��');
	}
	function boardInsert()
	{
		$("#f_boardIns").attr("method","post");
		$("#f_boardIns").attr("action","./boardInsert.kosmo");
		$("#f_boardIns").submit();
	}
</script>
</head>
<body>
<script type="text/javascript">
/* datagrid�� ���� �ʱ�ȭ�� html�±׳��� ó���� �� ������ easyui����� �� ������ ���ؼ��� ��ũ��Ʈ�� 
   ó���� �δ� ���� �����ϴ�.
*/
	$(document).ready(function (){
		/* datagrid �ʱ�ȭ (�ٸ� UI�ַ�ǰ� �������)*/
		$("#grid_board").datagrid({
			columns:[[
				{field:'B_NO',title:'��ȣ',width:60,editor:'text',align:'center'}
			   ,{field:'B_TITLE',title:'����',width:460,editor:'text'}
			   ,{field:'B_NAME',title:'�ۼ���',width:100,editor:'text',align:'center'}
			   ,{field:'B_DATE',title:'�ۼ���',width:100,editor:'text',align:'center'}
			   ,{field:'B_FILE',title:'÷������',width:200,editor:'text',align:'center'}
			   ,{field:'B_HIT',title:'��ȸ��',width:80,editor:'text',align:'center'}
			]]
		});
	});
</script>
<!-- ���� ���� -->
<div id="tbar_board">
	<form id="f_search">	
	<table>
		<!-- ���� �˻� ȭ�� �߰� -->
		<!-- ��ư �߰� -->
		<tr>
			<td>
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchALL()">��ü��ȸ</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="writeForm()">�۵��</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="updateForm()">�ۼ���</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="deleteForm()">�ۻ���</a>
			</td>
		</tr>
	</table>
	</form>
</div>
<!-- ����  ��   -->
<!-- ������ �׸��� ���� -->
<table id="grid_board" title="MVC��� ������ �Խ���" fitColumns="true" singleSelect="true" toolbar="#tbar_board" pagination="#pg_board" class="easyui-datagrid" style="width:1000px;height:400px">
<!-- ��ȸ����� ������ ����ϱ� -->
<%
	List<Map<String,Object>> boardList =
				(List<Map<String,Object>>)request.getAttribute("boardList");
	if(boardList !=null){
		for(int i=0;i<boardList.size();i++){//NullPointerException �Ͼ �� �ִ�.
			Map<String,Object> rMap = boardList.get(i);
%>
	<tr>
		<td><%=rMap.get("B_NO") %></td>
		<td align="left"><a href="./getBoardDetail.kosmo?b_no=<%=rMap.get("B_NO") %>"><%=rMap.get("B_TITLE") %></a></td>
		<td><%=rMap.get("B_NAME") %></td>
		<td><%=rMap.get("B_DATE") %></td>
		<td><a href="downLoad.jsp?b_file=<%=rMap.get("B_FILE")%>"><%=rMap.get("B_FILE") %></td>
		<td><%=rMap.get("B_HIT") %></td>
	</tr>
<%
		}////////////////end of for
	}///////////////////end of if
%>	
</table>
<!-- ������ �׸���  ��   -->
<!-- ���������̼� ����  -->
<div id="pg_board" class="easyui-pagination" style="width:1000px;height:20px"></div>
<!-- ���������̼�   ��   -->
<!--================== �۵�� ȭ�� �߰� ���� ==================-->
<div id="dlg_boardIns" buttons="#dlg_btnInsert" class="easyui-dialog" closed="true" style="width:600px">
	<form id="f_boardIns" method="post" enctype="multipart/form-data" style="padding:20px 50px">
	<div style="margin-bottom:10px">
		<input name="b_title" class="easyui-textbox" label="����" required="true" style="width:100%">
	</div>
	<div style="margin-bottom:10px">
		<input name="b_name" class="easyui-textbox" label="�ۼ���" required="true" style="width:100%">
	</div>
	<div style="margin-bottom:10px">
		<input name="b_content" class="easyui-textbox" multiline="true" label="����" required="true" style="width:100%;height:120px">
	</div>
	<div style="margin-bottom:10px">
		<input name="bfile" class="easyui-filebox" label="÷������" required="true" style="width:100%">
	</div>
	<div style="margin-bottom:10px">
		<input name="b_pw" class="easyui-textbox" label="���" required="true" style="width:100%">
	</div>				
	</form>
</div>
<!--�۵�� ȭ�鿡  �����ư�� ��� ��ư �߰��ϱ� -->
<div id="dlg_btnInsert">
	<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="boardInsert()">����</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg_boardIns').dialog('close')">�ݱ�</a>
</div>
<!--================== �۵�� ȭ�� �߰�   ��  ==================-->
</body>
</html>











