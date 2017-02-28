<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>우편번호 검색기</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/dev_spring4/js/commons.js"></script>
<script type="text/javascript">
   function zipCodeSearch()
   {
      var pdong = $("#dong").val();//사용자가 입력한 동정보 담는 변수
      //alert("동 : "+pdong);
      if(pdong.trim().length>=2){
      $("#tb_zipList").datagrid({
         url:'./getZipCodeList.kosmo?dong='+pdong
         ,onDblClickCell:function(index,field,value){
            var row = $("#tb_zipList").datagrid('getSelected');
            $("#address").textbox('setValue',row.ADDRESS);
            $("#zipcode").textbox('setValue',row.ZIPCODE);
         }
      });
      }
      else alert("2글자이상 입력해주세요");
   }
</script>
</head>
<body>
<!-- 테이블내에 툴바 추가해 보기 도서등록버튼 -->
<div id="tbar_zipList">
<!-- 검색 조건 추가 화면 입니다.  -->
<form id="f_search">
   <table>
      <tr>
         <td width="180px">
         <label width="100px">검색하실 주소(동)</label>
         <input id="dong" name="dong"  class="easyui-searchbox" 
                   data-options="prompt:'동', searcher:zipCodeSearch" 
                   style="width:80px">
         </td>
      </tr>   
      <tr>
         <td width="380px">
         <label width="100px">선택한 주소 : </label>
         <input id="address" name="address"  class="easyui-textbox" 
                   data-options="prompt:'주소'"
                   style="width:280px">
         </td>
      </tr>   
       <tr>
         <td width="130px">
         <label width="100px">선택한 우편번호 : </label>
         <input id="zipcode" name="zipcode"  class="easyui-textbox" 
                   data-options="prompt:'우편번호'"
                   style="width:130px">
         </td>
      </tr>   
   </table>
</form>   
<!-- 검색 조건 추가 화면 입니다.  -->   
</div>
<!-- 툴바 추가하기  끝   -->
<table id="tb_zipList" toolbar="#tbar_zipList" fitColumns="true" title="우편번호 검색" singleSelect="true" rownumbers="true" class="easyui-datagrid" style="width:400px;height:500px">
   <thead>
      <tr>
         <th data-options="field:'ZIPCODE', width:120, align:'center'">우편번호</th>
         <th data-options="field:'ADDRESS', width:180, align:'center'">주소</th>
      </tr>
   </thead>
</table>
</body>
</html>