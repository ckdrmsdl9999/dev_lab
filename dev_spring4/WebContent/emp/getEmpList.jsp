<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="com.vo.EmpVO" %> 
    <%
/* 	int result = -1;
	
   
		result =(int) request.getAttribute("result"); */
	
		EmpVO eVO  = new EmpVO();
		
		if(request.getAttribute("eVO")!=null)
		{
		eVO  =
		(EmpVO)request.getAttribute("eVO");
		
		}
		String msg = null;
		if(request.getParameter("msg")!=null){
			msg = (String) request.getParameter("msg");
			out.print(msg);
		}
		
		
		int result = -1;
		if(request.getParameter("result")!=null){
			result = Integer.parseInt(request.getParameter("result"));
		}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
function searchALL(){
   //����ڰ� ������ �μ���ȣ�� ���� ���� ����
   var vdeptno="";
   var vdeptnos=[];
   var rows=$("#grid_emp").datagrid('getSelections');
   alert(rows);//Object,Object,Object
   //����ڰ� ������ �μ���ȣ�� �迭�� ���
   for(var i=0;i<rows.length;i++){
      vdeptnos.push(rows[i].deptno);
   } 
   //�迭�� ��� ���� ����غ���
   for(var i=0;i<rows.length;i++){
      //10,30...���ڿ� �޸��� ���̴ٰ� �� ���������� ������ �ʽ��ϴ�.
      if(i==(rows.length-1)){
         vdeptno +=vdeptnos[i];
      }
      //�ڿ� ���� �� ���� ��쿡�� �޸��� �ٿ��ش�.
      else{
         vdeptno +=vdeptnos[i]+",";
      }
   }
   //10,30,40
   alert("vdeptno:"+vdeptno);
   
   location.href="./getEmpList2.kosmo?deptno="+vdeptno;
   
}
function empnoSearch(){ 
   
}
function enameSearch(){
   
}
function jobSearch(){
   
}
function saverow(row){
   
	
	alert("dd");
	
/*	var a =$("#grid_emp").datagrid('getSelected');   
	alert(row);
	alert(a.empno);
	   alert(row.datagrid('getSelected')); */
}
function cancelrow(){
   $("#grid_emp").datagrid('cancelEdit',getRowIndex(target));
}
</script>
</head>
<body>
<script type="text/javascript">

/* $.fn.datebox.defaults.formatter = function(date)
{
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
    m = ((m < 10) ? '0' : 0) + m;
    d = ((d < 10) ? '0' : 0) + d;
    return y + '' + m + '' + d;
}; */
$.fn.datebox.defaults.formatter = function(date) {
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	var d = date.getDate();
	return  y + '-' + (m < 10 ? '0' + m : m) + '-' + (d < 10 ? '0' + d : d);
	};
	$.fn.datebox.defaults.parser = function(s){
	   var t = Date.parse(s);
	   if (!isNaN(t)){ 
	      return new Date(t);
	   } else {
	      return new Date();
	   }
	}

</script>
<script type="text/javascript">
$(document).ready(function(){
	

var vresult = <%=result%>
	
	
	var vmsg = <%=msg%>
	
//	alert(vmsg);


	if(vresult==1)
		$("#dlg_empInsSuccess").dialog('open');
		else if(vresult==0)
		$("#dlg_empInsFail").dialog('open'); 
	
   /*������ �׸��� �ʱ�ȭ ����  */
   $("#grid_emp").datagrid({
   //url:"./empList.json"
   url:"./getEmpList.kosmo"
      ,columns:[[
         {field:'empno',title:'�����ȣ',width:80,align:'center',editor:'text'}
         ,{field:'ename',title:'�����',width:100,align:'center',editor:'text'}
         ,{field:'job',title:'JOB',width:120,align:'center',editor:'text'}
         ,{field:'hiredate',title:'�Ի�����',width:120,align:'center',editor:'text'}
         ,{field:'deptno',title:'�μ���ȣ',width:80,align:'center',   
            formatter:function(value,row){
            return row.deptno||value;
         },
         editor:{
            type:'combobox'
         ,options:{
            valueField:'DEPTNO',//���� ������ �Ѿ�� �ʵ�
            textField:'DEPTNO',//ȭ�鿡 ��µǴ� �ʵ�
            url:'../dept/getDeptnoList.kosmo',
            required:true
            
         }////////////////////end of options
         }/////////////////////////end of editor
            }
         ,{field:'dname',title:'�μ���',width:100,align:'center',editor:'text'}
         ,{field:'action',title:'Action',width:100,align:'center',
         formatter:function(value,row,index){
            if(row.editing){
             var s ='<a href="#" onClick="saverow('+this+')">Save</a>&nbsp';
             var c ='<a href="#" onClick="cancelrow(this)">Cancel</a>';
              return s+c;
             }
            else{
                var e='<a href="#" onClick="editrow(this)">Edit</a>&nbsp';
                 var d='<a href="#" onClick="deleterow(this)">Delete</a>';
                 return e+d;
                }
      }//////////////////end of formatter
   }/////////////////////end of action
         ]],
         onEndEdit:function(index,row){
            var ed = $(this).datagrid('getEditor', {
               index: index,
               field: 'dname'
            });
            row.dname = $(ed.target).combobox('getText');
         },
         onBeforeEdit:function(index,row){
            row.editing = true;
            $(this).datagrid('refreshRow', index);
         },
         onAfterEdit:function(index,row){
            row.editing = false;
            $(this).datagrid('refreshRow', index);
         },
         onCancelEdit:function(index,row){
            row.editing = false;
            $(this).datagrid('refreshRow', index);
         }   
   /* ,data: [
      {empno:'6000', ename:'�̼���',job:'����',hiredate:'2009-10-25',deptno:40,dname:'�ؿܿ���'}
      ,{empno:'7000', ename:'������',job:'����',hiredate:'2009-10-25',deptno:40,dname:'�ؿܿ���'}
      ] */
   });

   /*������ �׸��� �ʱ�ȭ ��  */
});///////////////////////////////////end of ready
function getRowIndex(target){
   var tr=$(target).closest('tr.datagrid-row');
   return parseInt(tr.attr('datagrid-row-index'));
}
function editrow(target){
   $("#grid_emp").datagrid('beginEdit',getRowIndex(target));
}

function empInsert(){
	$("#dlg_empIns").dialog('open').dialog('setTitle','������');
}
function empUpdate(){
	var row=$("#grid_emp").datagrid('getSelections');
	
	//alert(row.length);
	
	if(row == null || row.length>1){
		
		alert("������ �ο� �ϳ��� �����ϼ���");
		return;		
	}
	
	
	
	
	
	
	//alert(row.deptno);
	
	$("#uempno").textbox('readonly', true);
	$("#uempno").textbox('setValue', row[0].empno);
	$("#uename").textbox('setValue', row[0].ename);
	$("#ujob").textbox('setValue', row[0].job);
	$("#umgr").textbox('setValue', row[0].mgr);
	$("#uhiredate").textbox('setValue', row[0].hiredate);
	$("#usal").textbox('setValue', row[0].sal);
	$("#ucomm").textbox('setValue', row[0].comm);
	
	
	
	$('#udeptno').combobox({
	    url:'../dept/getDeptnoList.kosmo'
	   ,valueField:'DEPTNO'
 	   ,textField:'DEPTNO'
 	   ,	onLoadSuccess: function(){
 		   
	 		  $(this).combobox('select',row[0].deptno);
	 		
 	   }
	});
	
	
	 
	
	$("#dlg_empUpd").dialog('open').dialog('setTitle','�������');
 


}

function dlg_empUpdAction(){

	alert("�������");
	$("#f_empUpd").attr("method","POST");
	$("#f_empUpd").attr("action","./empUpdate.kosmo");
	$("#f_empUpd").submit();

}



function insertAction()
{
	$("#f_empIns").attr("method","POST");
	$("#f_empIns").attr("action","./empInsert.kosmo");
	$("#f_empIns").submit();
}



function proc_salupdate()
{
	
	$.messager.confirm('Confirm','���� ����� �޿��� ����Ͻðڽ��ϱ�?',function(r){
	      if(r){
	         var row =$("#grid_emp").datagrid('getSelected');//�ο쿡 ���� Object
	         //����ڰ� ������ �ο쿡 ���� Object�� �̿��ϸ� field�� ������ �� �ִ�.
	         if(row==null){
	            alert("������ ����� �����ϼ���");
	            return;
	         }
	
	var v_empno = row.empno;
	
	alert(v_empno);
	
	location.href = "./proc_salupdate.kosmo?empno="+v_empno;
	
	
	}
	   });
}



function deleterow(target){
	
   $.messager.confirm('Confirm','���� �����Ͻðڽ��ϱ�?',function(r){
      if(r){
         var row =$("#grid_emp").datagrid('getSelected');//�ο쿡 ���� Object
         //����ڰ� ������ �ο쿡 ���� Object�� �̿��ϸ� field�� ������ �� �ִ�.
         if(row==null){
            alert("������ ����� �����ϼ���");
            return;
         }
      
         
         var vempno="";
  	   var vempnos=[];
  	   var rows=$("#grid_emp").datagrid('getSelections');
  	   alert(rows);//Object,Object,Object
  	   //����ڰ� ������ �μ���ȣ�� �迭�� ���
  	   for(var i=0;i<rows.length;i++){
  	      vempnos.push(rows[i].empno);
  	   } 
  	   //�迭�� ��� ���� ����غ���
  	   for(var i=0;i<rows.length;i++){
  	      //10,30...���ڿ� �޸��� ���̴ٰ� �� ���������� ������ �ʽ��ϴ�.
  	      if(i==(rows.length-1)){
  	         vempno +=vempnos[i];
  	      }
  	      //�ڿ� ���� �� ���� ��쿡�� �޸��� �ٿ��ش�.
  	      else{
  	         vempno +=vempnos[i]+",";
  	      }
  	   }
  	   //10,30,40
  	   alert("vempno:"+vempnos);
        
         
         alert("����ڰ� ������ �����ȣ:"+vempno);
         location.href="./empDelete.kosmo?empno="+vempno;//������ ��û(���۹��:get)
         //ȭ��󿡼��� ���� �ȴ�.-������ ���� selectó�� �� ���̹Ƿ� �ǹ̰� ����.
      //   $("#grid_emp").datagrid('deleteRow',getRowIndex(target));
      }
   });
}
</script>
<!--���� �߰��ϱ� ����-->
<!-- ���̺��� ���� �߰��� ���� ������Ϲ�ư -->
<div id="tbar_empList">
<!-- �˻� ���� �߰� ȭ�� �Դϴ�.  -->
<form id="f_search">
   <table>
      <tr>
         <td width="140px">
         <label width="80px">�����ȣ</label>

         <input id="empno" name="empno" class="easyui-searchbox" data-options="prompt:'�����ȣ', searcher:empnoSearch" style="width:60px">
         </td>
         <td width="180px">
         <label width="70px">�����</label>
         <input id="ename" name="ename" class="easyui-searchbox" data-options="prompt:'�����', searcher:enameSearch" style="width:110px">
         </td>
         <td width="180px">
         <label width="70px">JOB</label>
         <input id="job" name="job" class="easyui-searchbox" data-options="prompt:'JOB', searcher:jobSearch" style="width:110px">
         </td>
      </tr>
      <tr>
         <td colspan="4">
          <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="searchALL()">�����ȸ</a>
          <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="empUpdate()">�������</a>
         <a href="#" class="easyui-linkbutton" iconCls="icon-man" plain="true" onClick="empInsert()">������</a>
         <a href="#" class="easyui-linkbutton" iconCls="icon-man" plain="true" onClick="proc_salupdate()">��� �޿� �λ�</a>
         <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="deleterow()">�������</a>         
         </td>
      </tr>      
   </table>
</form>   
<!-- �˻� ���� �߰� ȭ�� �Դϴ�.  -->   
</div>
<!--���� �߰��ϱ� ��-->
<!-- ���̺� �׸��� -->
<table id="grid_emp" toolbar="tbar_empList"class="easyui-datagrid"title="������"style="width:1000px;height:400px">
</table>



<!--  ���̺� ���̾�α�â ���� -->

<div id="dlg_empIns"  data-options="iconCls:'icon-man'"  buttons="#dlg_buttons" class="easyui-dialog" closed="true" style="width:600px">
<!-- ������ ����ڰ� �Է��� ������ �����մϴ�.(form�������� ó���ϱ�) -->
	<form id="f_empIns" style="margin:0;padding:20px 50px"> 	
 	<div style="margin-bottom:10px">
 	<input id="cb_deptno" name="empno" label="�����ȣ :" style="width:100%"  class="easyui-textbox" 
 	<%-- data-options="
        valueField: 'deptno',
        textField: 'deptno',
        url: 'getDeptnoList.kosmo',
        onSelect: function(rec){
			<!-- alert(rec.DEPTNO); -->
        }" --%>>
 	</div>
 	<div style="margin-bottom:10px">
 	<input name="ename" class="easyui-textbox" label="����� : " style="width:100%" >
 	</div>
 	<div style="margin-bottom:10px">
 	<input name="job" class="easyui-textbox" label="JOB : " style="width:100%">
 	</div>
 	<div style="margin-bottom:10px">
 	<input name="mgr" class="easyui-textbox" label="MGR �ڵ� : " style="width:100%">
 	</div>
 	 <div style="margin-bottom:10px">
 	<input id="dd"name="hiredate" required="required" class="easyui-datebox" label="������� : " style="width:100%">
 	</div> 
 <!-- 	<div id="cc" class="easyui-calendar" label="�������"style="width:180px;height:180px;"></div> -->
 	<div style="margin-bottom:10px">
 	<input name="sal" class="easyui-textbox" label="sal : " style="width:100%">
 	</div>
 	<div style="margin-bottom:10px">
 	<input name="comm" class="easyui-textbox" label="comm : " style="width:100%">
 	</div>
 		 	<div style="margin-bottom:10px">
 	<input id="cb_deptno" name="deptno" label="�μ���ȣ :" style="width:100%"  class="easyui-combobox" 
  data-options="
        valueField: 'DEPTNO',
        textField: 'DNAME',
        url: '../dept/getDeptnoList.kosmo',
        onSelect: function(rec){
			<!-- alert(rec.DEPTNO); -->
        }" >
 	</div>
 	</form>	
 </div>
 <div id="dlg_buttons">
	<a href="#" class="easyui-linkbutton c1" iconCls="icon-ok" plain="true" onClick="insertAction()" style="width:90px">����</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_empIns').dialog('close')" style="width:90px">���</a>
</div>
<!-- ��� ������ ������ ȭ�� �Դϴ�.  ����  -->
<div id="dlg_empInsSuccess" buttons="#dlg_buttons2" class="easyui-dialog" closed="true" style="width:300px">
	<label>��ϼ����Ͽ����ϴ�.</label>
</div>
 <div id="dlg_buttons2">
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_empInsSuccess').dialog('close')" style="width:90px">�ݱ�</a>
</div>
<!-- ��� ���н� ������ ȭ�� �Դϴ�.  ����  -->
<div id="dlg_empInsFail" buttons="#dlg_buttons3" class="easyui-dialog" closed="true" style="width:300px">
	<label>��Ͻ����Ͽ����ϴ�.</label>
</div>
 <div id="dlg_buttons3">
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_empInsFail').dialog('close')" style="width:90px">�ݱ�</a>
</div>





<!--  ������Ʈ -->


<div id="dlg_empUpd"  data-options="iconCls:'icon-man'"  buttons="#dlg_buttons" class="easyui-dialog" closed="true" style="width:600px">
<!-- ������ ����ڰ� �Է��� ������ �����մϴ�.(form�������� ó���ϱ�) -->
	<form id="f_empUpd" style="margin:0;padding:20px 50px"> 	
 	<div style="margin-bottom:10px">
 	<input id="uempno" name="empno" label="�����ȣ :" style="width:100%"  class="easyui-textbox" required="true">
 	</div>
 	<div style="margin-bottom:10px">
 	<input id="uename" name="ename" class="easyui-textbox" label="����� : " style="width:100%" required="true" >
 	</div>
 	<div style="margin-bottom:10px">
 	<input id="ujob"  name="job" class="easyui-textbox" label="JOB : " style="width:100%" required="true" >
 	</div>
 	<div style="margin-bottom:10px">
 	<input id="umgr"  name="mgr" class="easyui-textbox" label="MGR �ڵ� : " style="width:100%" required="true">
 	</div>
 	 <div style="margin-bottom:10px">
 	<input id="uhiredate" name="hiredate" required="required" class="easyui-datebox" label="������� : " style="width:100%" required="true">
 	</div> 
 <!-- 	<div id="cc" class="easyui-calendar" label="�������"style="width:180px;height:180px;"></div> -->
 	<div style="margin-bottom:10px">
 	<input id="usal"  name="sal" class="easyui-textbox" label="sal : " style="width:100%" required="true" >
 	</div>
 	<div style="margin-bottom:10px">
 	<input id="ucomm" name="comm" class="easyui-textbox" label="comm : " style="width:100%" required="true">
 	</div>
 		 	<div style="margin-bottom:10px">
 	<input id="udeptno" name="deptno" label="�μ���ȣ :" style="width:100%"  class="easyui-combobox" >
 	</div>
 	</form>	
 </div>
 <div id="dlg_buttons">
	<a href="#" class="easyui-linkbutton c1" iconCls="icon-ok" plain="true" onClick="dlg_empUpdAction()" style="width:90px">����</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_empUpd').dialog('close')" style="width:90px">���</a>
</div>
<!-- ��� ������ ������ ȭ�� �Դϴ�.  ����  -->
<div id="dlg_empUpdSuccess" buttons="#dlg_buttons2" class="easyui-dialog" closed="true" style="width:300px">
	<label>��ϼ����Ͽ����ϴ�.</label>
</div>
 <div id="dlg_buttons2">
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_empUpdSuccess').dialog('close')" style="width:90px">�ݱ�</a>
</div>
<!-- ��� ���н� ������ ȭ�� �Դϴ�.  ����  -->
<div id="dlg_empUpdFail" buttons="#dlg_buttons3" class="easyui-dialog" closed="true" style="width:300px">
	<label>��Ͻ����Ͽ����ϴ�.</label>
</div>
 <div id="dlg_buttons3">
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_empInsFail').dialog('close')" style="width:90px">�ݱ�</a>
</div>


</body>
</html>