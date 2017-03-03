<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.Map, java.util.HashMap" %>    
<%
	//insert here -  1을 출력
	List<Map<String,Object>> boardList = 
							(List<Map<String,Object>>)request.getAttribute("boardList");
    //out.print("size:"+boardList.size());//1
    Map<String,Object> rMap = new HashMap<String,Object>();
    if(boardList!=null){
    	rMap = boardList.get(0);
    }
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글상세보기</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function(){
		$("#b_title").textbox('setValue','<%=rMap.get("B_TITLE")%>');
		$("#b_name").textbox('setValue','<%=rMap.get("B_NAME")%>');
		$("#b_date").textbox('setValue','<%=rMap.get("B_DATE")%>');
		$("#b_content").textbox('setValue','<%=rMap.get("B_CONTENT")%>');
		$("#b_file").textbox('setValue','<%=rMap.get("B_FILE")%>');
	});
</script>
<div id="p" class="easyui-panel" data-options="footer:'#footer',tools:'#tt'" title="글상세보기" style="width:800px;height:350px;padding:20px 20px;background:#fafafa;"
        data-options="iconCls:'icon-save',closable:true,
                collapsible:true,minimizable:true,maximizable:true">
	<div style="margin-bottom:10px">
		<input id="b_title" name="b_title" class="easyui-textbox" label="제목" required="true" style="width:90%">
	</div>
	<div style="margin-bottom:10px">
		<input id="b_date" name="b_date" class="easyui-textbox" label="작성일" required="true" style="width:90%">
	</div>	
	<div style="margin-bottom:10px">
		<input id="b_name" name="b_name" class="easyui-textbox" label="작성자" required="true" style="width:90%">
	</div>
	<div style="margin-bottom:10px">
		<input id="b_content" name="b_content" class="easyui-textbox" multiline="true" label="내용" required="true" style="width:90%;height:120px">
	</div>
	<div style="margin-bottom:10px">
		<input id="b_file" name="b_file" class="easyui-textbox" label="첨부파일" required="true" style="width:90%">
	</div>
</div>	
<div align="right" id="footer">
   <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="searchA%LL()">답글</a>
   <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="updateForm()">글수정</a>
   <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="writeForm()">글삭제</a>
   <a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="javascript:location.href='./getBoardList.kosmo'">글목록</a>
</div>
<div align="left" id="tt">
   <a href="#" class="easyui-linkbutton" iconCls="icon-man" onclick="updateForm()">이메일</a>


</div>
</body>
</html>