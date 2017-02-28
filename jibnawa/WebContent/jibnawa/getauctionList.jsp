<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원님의 경매내역</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/dev_spring4/js/commons.js"></script>
<script type="text/javascript">
function savereg(){
     if(confirm("ooo도 ooo군 12월 08일~12월 12일까지 90,000원에 낙찰하시겠습니까?")){
      document.write("접수완료되었습니다. 지정된 계좌로 입금하세요.")
     }
     else{
     }
    }
    function cancel(){
     if(confirm("경매가 전체취소됩니다. 취소하시겠습니까?")){
      document.write("취소완료되었습니다.")
     }
     else{
     }
    }
function searchALL(){
    $('#f_auction').datagrid({
        url: "./getauctionList.kosmo"
     })

	 
}
</script>
</head>
<body>
<script type="text/javascript">
$(document).ready(function (){
	/* 데이터 그리드 초기화 시작 */		
			$("#f_auction").datagrid({
				url:"./getauctionList.kosmo"//List<XXXVO>-소문자, List<Map>-대문자(myBatis)
			  , columns:[[
								{field:'A_NO', title:'번호', width:80, align:'center', editor:'text'}
			                   ,{field:'A_DATE', title:'날짜', width:100, align:'center', editor:'text'}
			                   ,{field:'A_REGION', title:'지역', width:120, align:'center', editor:'text'}
			                   ,{field:'A_COUNT', title:'금액', width:100, align:'center', editor:'text'}
			                   ,{field:'A_STAY', title:'숙박여부', width:100, align:'center', editor:'text'}
			                   ,{field:'A_RENT', title:'렌트여부', width:100, align:'center', editor:'text', hidden:'true'}
			                   ,{field:'A_BID', title:'낙찰여부', width:200, align:'center',
			                	   formatter:function(value,row,index){
			                			   var s = '<input value="낙찰하기" type="button" class="easyui-linkbutton c4" iconCls="icon-ok" plain="true" onClick="savereg()">';
			                			   var a = '<a href="#" class="easyui-linkbutton c3" iconCls="icon-ok" plain="true" onClick="savereg()">선택</a>';
			                			   return s+"  "+a;
			                	   }///////////end of formatter
			                   }//////////////end of action
			                ]]
			});

	/* 데이터 그리드 초기화  끝   */		
		});
</script>

<!-- 테이블 그리기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<table id="f_auction" toolbar="#tbar_auction" title="회원님의 경매내역" class="easyui-datagrid" style="width:900px;height:400px" rownumbers="true" >
<!--    <thead>
      <tr>
         <th  data-options="field:'A_NO', width:50, align:'center'">번호</th>
         <th  data-options="field:'A_DATE', width:150, align:'center'">날짜</th>
         <th  data-options="field:'A_REGION', width:150, align:'center'">지역</th>
         <th  data-options="field:'A_COUNT', width:150, align:'center'">입찰금액</th>
         <th  data-options="field:'A_STAY', width:150, align:'center'">숙박여부</th>
         <th  data-options="field:'A_RENT', width:150, align:'center'">렌트여부</th>
         <th  data-options="field:'A_BID', width:150, align:'center'">낙찰여부</th>
      </tr>
   </thead> -->
</table>   

<!-- 다이얼로그창에서 제공될 화면 입니다. 시작 -->
<div id="dlg_auctionIns" buttons="#linkbtn_auctionIns" title="낙찰하시겠습니까?" class="easyui-dialog" closed="true" style="width:600px" closed="true"
	data-options="iconCls:'icon-help',resizable:true, modal:true">

<%-- <!-- 서버로 사용자가 입력한 정보를 전송합니다.(form전송으로 처리하기) -->
   <form id="f_auctionIns" style="margin:0;padding:20px 50px">    
    <div style="margin-bottom:10px">
    <input id="cb_deptno" name="deptno" label="부서번호 :" style="width:100%"  class="easyui-combobox" data-options="
        valueField: 'DEPTNO',
        textField: 'DNAME',
        url: 'getauctionList.kosmo',
        onSelect: function(rec){
         <!-- alert(rec.DEPTNO); -->
        }">
    </div> --%>
   
    
    <!--팝업창  -->
    <div style="margin-bottom:10px">
    <input name="dname" class="easyui-textbox" label="날짜 : " style="width:100%">
    </div>
    <div style="margin-bottom:10px">
    <input name="loc" class="easyui-textbox" label="지역 : " style="width:100%">
    </div>
    </form>   
 </div>

<!--  
 <div id="dlg_buttons">
   <a href="#" class="easyui-linkbutton c1" iconCls="icon-ok" plain="true" onClick="insertAction()" style="width:90px">저장</a>
   <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_deptIns').dialog('close')" style="width:90px">취소</a>
</div> -->
<!-- 등록 성공시 제공될 화면 입니다.  시작  -->
<div id="dlg_deptInsSuccess" buttons="#dlg_buttons2" class="easyui-dialog" closed="true" style="width:300px">
   <label>등록성공하였습니다.</label>
</div>
 <div id="dlg_buttons2">
   <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_deptInsSuccess').dialog('close')" style="width:90px">닫기</a>
</div>
<!-- 등록 실패시 제공될 화면 입니다.  시작  -->
<div id="dlg_deptInsFail" buttons="#dlg_buttons3" class="easyui-dialog" closed="true" style="width:300px">
   <label>등록실패하였습니다.</label>
</div>
 <div id="dlg_buttons3">
   <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_deptInsFail').dialog('close')" style="width:90px">닫기</a>
</div>
<div style="float:center; width:900px;" a href="#" class="easyui-linkbutton c3" iconCls="icon-no" plain="true" onClick="cancel()" >경매취소</a></div>
</div>
</body>
</html>











