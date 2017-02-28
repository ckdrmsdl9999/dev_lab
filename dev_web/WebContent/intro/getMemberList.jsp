<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, com.vo.MemberVO" %>    
<%
	int size = 0;
	List<MemberVO> memList = 
					(List<MemberVO>)request.getAttribute("memList");
	if(memList != null){
		size = memList.size();//�ο��� ����
	}
	//out.print("memList.size():"+memList.size());//3
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ�� ���</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/js/commons.js"></script>
<script type="text/javascript">
	function memoInsertForm(to_id){
		//alert(to_id);
/* 		$("#dlg_memoIns").dialog('open').dialog('setTitle','��������');
		$("#f_memoIns").form('clear'); */
		cmm_window_popup('memoForm.jsp?to_id='+to_id,500,400,'memoForm');
	}
	function memoInsert(){
		$("#f_memoIns").attr("method","post");
		$("#f_memoIns").attr("action","./memoInsert.mem");
		$("#f_memoIns").submit();
	}
</script>
</head>
<body>
<table border="1" borderColor="gray" width="100%" height="100%">
<tr>
<td>
<table id="tb_memberList" title="ȸ����� ����" singleSelect="true" rownumbers="true" class="easyui-datagrid" style="width:800px;height:400px">
	<thead>
		<tr>
			<th field="mem_name" width="150" align="center">����</th>
			<th field="mem_id" width="150" align="center">���̵�</th>
			<th field="mem_tel" width="200" align="center">��ȭ��ȣ</th>
			<th field="gender" width="100" align="center">����</th>
			<th field="buttons" width="100" align="center">&nbsp;</th>
		</tr>
	</thead>
<!-- db���� ��ȸ�� ��� ����ϱ� ���� -->	
<!-- ��ȸ ����� ����? -->
<%
	if(size == 0){
%>
	<tr>
		<td colspan="5" align="center">��ȸ����� �����ϴ�.</td>
	</tr>
	
<!-- ��ȸ ��� �ִ�? -->	
<%
	}//end of if
	else{
		for(int i=0;i<size;i++){
			if(i==size) break;//for�� Ż���ϱ�
			MemberVO mVO = memList.get(i);
%>
	<tr>
		<td align="center"><%=mVO.getMem_name() %></td>
		<td align="center"><%=mVO.getMem_id() %></td>
		<td align="center"><%=mVO.getMem_tel() %></td>
		<td align="center"><%=mVO.getGender() %></td>
		<td align="center">
<%
	//String sid = (String)session.getAttribute("sid");    
	//�� �޴� ���̵�� �ٸ���?
	if(!sid.equals(mVO.getMem_id())){		
%>		
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="memoInsertForm('<%=mVO.getMem_id()%>')">��������</a>
<%
	}
	else{
%>
		&nbsp;
<%
	}
%>		
		</td>
	</tr>
<%
		}///////// end of for
	}//////////// end of else
%>	
<!-- db���� ��ȸ�� ��� ����ϱ� �� -->
</table>
</td>
</tr>
</table>
<!-- �������� ��ư�� Ŭ������ �� �������� ȭ�� ���� -->
<div id="dlg_memoIns" class="easyui-dialog" style="width:500px" closed="true" buttons="#dlg_buttons">
<%-- 	<form id="f_memoIns" style="margin:0;padding:20px 50px">
		<div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #CCCCCC">
			�������
		</div>
		<div style="margin-bottom:10px">
		<label style="width:200">�޴»�� &nbsp;:</label>
		<input id="to_id" name="to_id" data-options="prompt:'<%="apple" %>'" class="easyui-textbox" style="width:70%">
		</div>
		<div style="margin-bottom:10px">
		<label style="width:200">�����»�� :</label>
		<input name="from_id" class="easyui-textbox" style="width:70%">
		</div>	
		<div style="margin-bottom:10px">
		<label style="width:200">��       �� :</label>
		<input name="memo_content" class="easyui-textbox" multiline="true" style="width:70%;height:100px">
		</div>			
		<div id="#dlg_buttons" align="center">
		<a class="easyui-linkbutton c5" iconCls="icon-ok" plain="true" onClick="memoInsert()" style="width:90px">����</a>	
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_memoIns').dialog('close')" style="width:90px">���</a>
		</div>	
	</form> --%>
</div>
<!-- �������� ��ư�� Ŭ������ �� �������� ȭ��  �� -->
</body>
</html>










