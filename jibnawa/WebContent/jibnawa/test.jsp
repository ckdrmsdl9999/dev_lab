<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<!-- <meta charset="UTF-8"> -->
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Ź��� �����</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
///////////////////////////////////////////////DateBox YYYY-MM-DDŸ������ �����ϴ� ����
    $.fn.datebox.defaults.formatter = function(date){
    	   var y = date.getFullYear();
    	   var m = date.getMonth()+1;
    	   var d = date.getDate();
    	   return y+'-'+m+'-'+d;
    	}
    	$.fn.datebox.defaults.parser = function(s){
    	   var t = Date.parse(s);
    	   if (!isNaN(t)){
    	      return new Date(t);
    	   } else {
    	      return new Date();
    	   }
    	}
//////////////////////////////////////////////DateBox YYYY-MM-DDŸ������ �����ϴ� ����
///////////////////////////////////////////////////////////////////DateBox �̺�Ʈ
    $('#acc_start_date').datebox({
        required:true
    });
    $('#acc_end_date').datebox({
        required:true
    });
    $('#auc_start_date').datebox({
        required:true
    });
    $('#auc_end_date').datebox({
        required:true
    });
///////////////////////////////////////////////////////////////////DateBox �̺�Ʈ
   
//////////////////////////////////////////////////////////���ڸŹ� ��� (��� ��� ��ư)
     function a_search(){
  	   $("#f_jibnawaIns").attr("method","get");
  	   $("#f_jibnawaIns").attr("action","./jibnawaInsert.kosmo");
  	   $("#f_jibnawaIns").submit();
     }
//////////////////////////////////////////////////////////���ڸŹ� ��� (��� ��� ��ư)
   //��Ʈ�Ź� ���� ���̺� �����ϱ�
     /* function a1_search(){
  	   $("#f_jibnawa1Ins").attr("method","get");
  	   $("#f_jibnawa1Ins").attr("action","./jibnawaInsertSuccess.jsp");
  	   $("#f_jibnawa1Ins").submit();
     } */
    </script>
</head>
<body>
<!----------------------------------����  ----------------------------------------->
<!----------------------------------����  ----------------------------------------->
<!----------------------------------����  ----------------------------------------->
<!----------------------------------����  ----------------------------------------->
<!----------------------------------����  ----------------------------------------->
<!----------------------------------����  ----------------------------------------->
<!----------------------------------����  ----------------------------------------->
<!----------------------------------����  ----------------------------------------->
<!----------------------------------����  ----------------------------------------->
<!----------------------------------����  ----------------------------------------->
<!----------------------------------����  ----------------------------------------->
<!----------------------------------����  ----------------------------------------->
<!----------------------------------����  ----------------------------------------->
<!----------------------------------����  ----------------------------------------->
<!----------------------------------����  ----------------------------------------->
<!----------------------------------����  ----------------------------------------->
<!----------------------------------����  ----------------------------------------->
<!----------------------------------����  ----------------------------------------->
<!----------------------------------����  ----------------------------------------->

<form id="f_jibnawaIns">
<div id="p1" class="easyui-panel" title="����" 
        style="width:800px;height:250px;padding:10px;background:#fafafa;"
        data-options="iconCls:'icon-save',closable:true,
                collapsible:true,minimizable:true,maximizable:true">
    <p>��Ž���</p>
 <!--  -->
 <table>

<tr>
    <td>
	 <label width="30px">����</label>
	 <br>
	 <input id="region_code" name="region_code" class="easyui-textbox" style="width:60px">
	</td>
	  <td>
	  <label width="30px">��������</label>
	 <br>
	 <input id="sub_area_code" name="sub_area_code" class="easyui-textbox"  style="width:60px">
	  </td>
	  <td>
	  <label width="40px">��¥</label>
	  <br>
	  <input id="acc_start_date" name="acc_start_date" class="easyui-datebox"  required="required">
	  </td>
	  <td>
	  <label width="40px">~</label>
	  </td>
	  <td>
	  <label width="40px"></label>
	  <br>
	  <input id="acc_end_date" name="acc_end_date" class="easyui-datebox" required="required">
	  </td>
	 </tr>
	 <!--  -->
	 <tr>
	 <td>
	    <label width="30px">�����ݾ�</label>  
	    <br>  
	    <input id="contract_price" name="contract_price" class="easyui-numberbox" style="width:60px">
	  </td>
	  <td>
	  <label width="40px"></label>  
	    <br>  
	    <input id="contract_price_end" name="contract_price_end" class="easyui-numberbox" style="width:60px">
	  </td>
	  <td>
	  <label width="30px">�ο�</label>
	  <br>
	  <select id="headcount" name="headcount" class="easyui-combobox" style="width:90px;">
    <option value="1�ν�">1�ν�</option>
    <option value="1~2��">1~2��</option>
    <option value="3~4�ν�">3~4�ν�</option>
    <option value="8�ν�">8�ν�</option>
    <option value="12~18�ν�">12~18�ν�</option>
</select>
	  </td>
	  <td>
	  <label width="50px">��űⰣ</label>
	  <br>
	  <input id="auc_start_date" name="auc_start_date" class="easyui-datebox" required="required">
	  </td>
	  <td>
	  <label width="40px">~</label>
	  </td>
	  <td>
	  <label width="40px"></label>
	  <br>
	  <input id="auc_end_date" name="auc_end_date" class="easyui-datebox" required="required">
	  <!--  -->
	  <br>
<td colspan="2">
          <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="a_search()">��� ���!</a>
      </td>
	  <!--  -->
	  
	  
	  </td>
	 </tr>
	
</table>
</div>
 </form>
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  ----------------------------------------->
<!----------------------------------��Ʈ  -----------------------------------------> 
<div id="p2" class="easyui-panel" title="��Ʈ" 
        style="width:800px;height:250px;padding:10px;background:#fafafa;"
        data-options="iconCls:'icon-save',closable:true,
                collapsible:true,minimizable:true,maximizable:true">
<table>
<form id="f_jibnawa1Ins">
<tr>
    <td>
	 <label width="50px">����</label>
	 <br>
	 <input id="location" name="location" class="easyui-searchbox" style="width:60px">
	</td>
	  <td>
	  <label width="50px">��������</label>
	 <br>
	 <input id="detaillocation" name="detaillocation" class="easyui-searchbox"  style="width:60px">
	  </td>
	  <td>
	  <label width="50px">��¥</label>
	  <br>
	  <input id="ds" type="date" class="easyui-datebox" currentText="Today" required="required">
	  </td>
	  <td>
	  <label width="50px">~</label>
	  </td>
	  <td>
	  <label width="50px"></label>
	  <br>
	  <input id="de" type="date" class="easyui-datebox" currentText="Today" required="required">
	  </td>
	 </tr>
	 <!--  -->
	 <tr>
	 <td>
	    <label width="50px">�����ݾ�</label>  
	    <br>  
	    <input type="newValue" class="easyui-numberbox" value="5000" data-options="min:0,precision:1" style="width:60px">
	  </td>
	  <td>
	  <label width="50px"></label>  
	    <br>  
	    <input type="newValue" class="easyui-numberbox" value="700000" data-options="min:0,precision:1" style="width:60px">
	  </td>
	  <td>
	  <label width="50px">�ο�</label>
	  <br>
	  <select id="np" class="easyui-combobox" name="people" style="width:100px;">
    <option value="aa">1�ν�</option>
    <option>1~2��</option>
    <option>3~4�ν�</option>
    <option>8�ν�</option>
    <option>12~18�ν�</option>
</select>
	  </td>
	  <td>
	  <label width="50px">��űⰣ</label>
	  <br>
	  <input id="wa" type="date" class="easyui-datebox" currentText="Today" required="required">
	  </td>
	  <td>
	  <label width="50px">~</label>
	  </td>
	  <td>
	  <label width="50px"></label>
	  <br>
	  <input id="wa" type="date" class="easyui-datebox" currentText="Today" required="required">
	  <br>
	  <td colspan="2">
          <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="a1_search()">��� ���</a>
      <!-- <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">easyui</a> -->
      </td>
	  </td>
</tr>
</form>
</table>
</div>
</body>
</html>