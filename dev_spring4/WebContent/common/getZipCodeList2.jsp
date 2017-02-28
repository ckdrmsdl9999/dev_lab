<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�����ȣ �˻���</title>
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
      var pdong = $("#dong").val();//����ڰ� �Է��� ������ ��� ����
      //alert("�� : "+pdong);
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
      else alert("2�����̻� �Է����ּ���");
   }
</script>
</head>
<body>
<!-- ���̺��� ���� �߰��� ���� ������Ϲ�ư -->
<div id="tbar_zipList">
<!-- �˻� ���� �߰� ȭ�� �Դϴ�.  -->
<form id="f_search">
   <table>
      <tr>
         <td width="180px">
         <label width="100px">�˻��Ͻ� �ּ�(��)</label>
         <input id="dong" name="dong"  class="easyui-searchbox" 
                   data-options="prompt:'��', searcher:zipCodeSearch" 
                   style="width:80px">
         </td>
      </tr>   
      <tr>
         <td width="380px">
         <label width="100px">������ �ּ� : </label>
         <input id="address" name="address"  class="easyui-textbox" 
                   data-options="prompt:'�ּ�'"
                   style="width:280px">
         </td>
      </tr>   
       <tr>
         <td width="130px">
         <label width="100px">������ �����ȣ : </label>
         <input id="zipcode" name="zipcode"  class="easyui-textbox" 
                   data-options="prompt:'�����ȣ'"
                   style="width:130px">
         </td>
      </tr>   
   </table>
</form>   
<!-- �˻� ���� �߰� ȭ�� �Դϴ�.  -->   
</div>
<!-- ���� �߰��ϱ�  ��   -->
<table id="tb_zipList" toolbar="#tbar_zipList" fitColumns="true" title="�����ȣ �˻�" singleSelect="true" rownumbers="true" class="easyui-datagrid" style="width:400px;height:500px">
   <thead>
      <tr>
         <th data-options="field:'ZIPCODE', width:120, align:'center'">�����ȣ</th>
         <th data-options="field:'ADDRESS', width:180, align:'center'">�ּ�</th>
      </tr>
   </thead>
</table>
</body>
</html>