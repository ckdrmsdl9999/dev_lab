<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, com.vo.MemberVO" %>    
<%
	int size = 0;
	List<MemberVO> memList = 
					(List<MemberVO>)request.getAttribute("memList");
	if(memList != null){
		size = memList.size();//로우의 갯수
	}
	//out.print("memList.size():"+memList.size());//3
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 목록</title>
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
/* 		$("#dlg_memoIns").dialog('open').dialog('setTitle','쪽지쓰기');
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
<table id="tb_memberList" title="회원목록 보기" singleSelect="true" rownumbers="true" class="easyui-datagrid" style="width:800px;height:400px">
	<thead>
		<tr>
			<th field="mem_name" width="150" align="center">성명</th>
			<th field="mem_id" width="150" align="center">아이디</th>
			<th field="mem_tel" width="200" align="center">전화번호</th>
			<th field="gender" width="100" align="center">성별</th>
			<th field="buttons" width="100" align="center">&nbsp;</th>
		</tr>
	</thead>
<!-- db에서 조회한 결과 출력하기 시작 -->	
<!-- 조회 결과가 없니? -->
<%
	if(size == 0){
%>
	<tr>
		<td colspan="5" align="center">조회결과가 없습니다.</td>
	</tr>
	
<!-- 조회 결과 있니? -->	
<%
	}//end of if
	else{
		for(int i=0;i<size;i++){
			if(i==size) break;//for문 탈출하기
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
	//너 받는 아이디랑 다르니?
	if(!sid.equals(mVO.getMem_id())){		
%>		
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="memoInsertForm('<%=mVO.getMem_id()%>')">쪽지쓰기</a>
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
<!-- db에서 조회한 결과 출력하기 끝 -->
</table>
</td>
</tr>
</table>
<!-- 쪽지쓰기 버튼을 클릭했을 때 쪽지쓰기 화면 시작 -->
<div id="dlg_memoIns" class="easyui-dialog" style="width:500px" closed="true" buttons="#dlg_buttons">
<%-- 	<form id="f_memoIns" style="margin:0;padding:20px 50px">
		<div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #CCCCCC">
			쪽지등록
		</div>
		<div style="margin-bottom:10px">
		<label style="width:200">받는사람 &nbsp;:</label>
		<input id="to_id" name="to_id" data-options="prompt:'<%="apple" %>'" class="easyui-textbox" style="width:70%">
		</div>
		<div style="margin-bottom:10px">
		<label style="width:200">보내는사람 :</label>
		<input name="from_id" class="easyui-textbox" style="width:70%">
		</div>	
		<div style="margin-bottom:10px">
		<label style="width:200">내       용 :</label>
		<input name="memo_content" class="easyui-textbox" multiline="true" style="width:70%;height:100px">
		</div>			
		<div id="#dlg_buttons" align="center">
		<a class="easyui-linkbutton c5" iconCls="icon-ok" plain="true" onClick="memoInsert()" style="width:90px">저장</a>	
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_memoIns').dialog('close')" style="width:90px">취소</a>
		</div>	
	</form> --%>
</div>
<!-- 쪽지쓰기 버튼을 클릭했을 때 쪽지쓰기 화면  끝 -->
</body>
</html>










