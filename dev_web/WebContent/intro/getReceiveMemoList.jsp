<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%@ page import = "java.util.List, com.vo.MemoVO" %>
    <<jsp:useBean id=" moLogic" scope ="page" class="com.ajax.memo.MemoLogic"></jsp:useBean>
<%

/* List<MemoVO> memoList = (List<MemoVO>) request.getAttribute("memoList"); */

MemoVO pmoVO = new MemoVO();
pmoVO.setTo_id(request.getParameter("to_id"));
List<MemoVO> memoList = moLogic.getReceiveMemoList(pmoVO);

int size = 0;
if(memoList!=null){
	size = memoList.size();
	
}
	
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<div id="tbar_memoList">
<table>
<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="b_write()">����</a>
</table>
</div>



<table border="1" borderColor="blue" width="100%" height="100%">

	<tr>
		<td align="center">
		
		<table align="center">
		
		<tr>
		
		<tr>
		<td align="center">
		
		<!-- 
		���� ���� ��� ����
		
		
		
		
 -->	
 
 <table id="tb_rmemoList" toolbar="#tbar_memoList" title="�޴�������" class="easyui-datagrid" style="width:800px;height:400px" rownumbers="true">
<!-- ���̺� ��� �����ϱ� -->
	<thead>
	<tr>
		<th field="no" align="center" width="80">��ȣ</th>
		<th field="mem_name" align="center" width="150">������</th>
	    <th field="from_id" align="center" width="150">�����̾��̵�</th>
	    <th field="create_date" align="center" width="120">��������</th>
	    <th field="read_yn" align="center" width="100">��������</th>
	</tr>
	</thead>
<!-- ��ȸ��� ����ϱ� -->
<%
	
	if(size>0){
		for(int i=0;i<size;i++){
			MemoVO mVO = memoList.get(i);
%>
		<tr>
			<td><%=mVO.getNo() %></td>
			<td align="left"><%=mVO.getMem_name() %></td>
			<td><%=mVO.getFrom_id() %></td>
			<td><%=mVO.getCreate_date() %></td>		
			<td><%=mVO.getRead_yn() %></td>		
		</tr>
<%
		}///////////////end of for
	}///////////////end of if
	else{
%>	
	<tr>
		<td colspan="5">��ȸ����� ������ �� �����ϴ�.</td>
	</tr>
<%
	}
%>
</table>
 
 
 
 
 
 
 	
		</td>
		</tr>
		</table>
		</td>
			</tr>
		
</table>
</body>
</html>