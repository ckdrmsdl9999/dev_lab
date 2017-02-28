<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.Map" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script type="text/javascript" src="/dev_spring4/js/commons.js"></script>
</head>
<body>
<script type="text/javascript">
/*
  datagrid에 대한 초기화를 html태그내에 처리할 수 있지만 easyui기능을 더 누리기 위해서는 스크립트로 처리
    하는것이 더 유리하다
 */
 $(document).ready(function(){
   /* datagrid 초기화 -> 다른 ui솔루션을 만나더라도 공통적인 부분 */
   $("#grid_board").datagrid({
      columns:[[
         {field:'B_NO',title:'번호',width:60,editor:'text',align:'center'},
         {field:'B_TITLE',title:'제목',width:60,editor:'text',align:'center'},
         {field:'B_NAME',title:'작성자',width:60,editor:'text',align:'center'},
         {field:'B_DATE',title:'작성일',width:100,editor:'text',align:'center'},
         {field:'B_FILE',title:'첨부파일',width:200,editor:'text',align:'center'},
         {field:'B_HIT',title:'조회수',width:80,editor:'text',align:'center'}
         
      ]]
   })
 });
 
</script>
<!-- 툴바 -->
<div id="tbar_board">
<form id="f_search">
<table>
<!-- /*여기서 조건검사를 할것인데 그렇다면 서버에 전송이 된다는말*/ -->
<!-- 버튼 추가 -->
   <tr>
      <td>
      <a href="" class="easyui-linkbutton" iconCls="icon-search" onclick="searchALL()">전체조회</a>
      <a href="" class="easyui-linkbutton" iconCls="icon-add" onclick="writeForm()">글등록</a>
      <a href="" class="easyui-linkbutton" iconCls="icon-edit" onclick="updateForm()">수정</a>
      <a href="" class="easyui-linkbutton" iconCls="icon-remove" onclick="deleteForm()">글삭제</a>
      <td>
   </tr>
</table>
</form>
</div>
<!-- 툴바 끝 -->

<!--데이터 그리드  -->
<table id="grid_board" title="MVC기반 계층형 게시판" toolbar="#tbar_board" pagination="#pg_board" class="easyui-datagrid" style="width:1000px;height:400px">
   <%
   List<Map<String,Object>> boardList =(List<Map<String,Object>>)request.getAttribute("boardList");
   if(boardList!=null){
      for(int i=0; i<boardList.size();i++){//nullpointer 일어날 수 있다.
         Map<String,Object> rMap = boardList.get(i);
   %>
   <tr>
      <td><%=rMap.get("B_NO") %></td>
      <td><%=rMap.get("B_TITLE") %></td>
      <td><%=rMap.get("B_NAME") %></td>
      <td><%=rMap.get("B_DATE") %></td>
      <td><%=rMap.get("B_FILE") %></td>
      <td><%=rMap.get("B_HIT") %></td>
   </tr>
   <%
      }// end for
   }//end if
   %>
</table>
<!-- 데이터그리드 끝 -->

<!-- 페이지네이션 -->   
<div id="pg_board" class="easyui-pagination" style="width:1000px;height:20px"></div>
<!-- 페이지네이션 끝-->   
</body>
</html>