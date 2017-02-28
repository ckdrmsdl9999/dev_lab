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
<title>사원목록</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
function searchALL(){
   //사용자가 선택한 부서번호를 담을 변수 선언
   var vdeptno="";
   var vdeptnos=[];
   var rows=$("#grid_emp").datagrid('getSelections');
   alert(rows);//Object,Object,Object
   //사용자가 선택한 부서번호를 배열에 담기
   for(var i=0;i<rows.length;i++){
      vdeptnos.push(rows[i].deptno);
   } 
   //배열에 담긴 정보 출력해보기
   for(var i=0;i<rows.length;i++){
      //10,30...값뒤에 콤마를 붙이다가 맨 마지막에는 붙이지 않습니다.
      if(i==(rows.length-1)){
         vdeptno +=vdeptnos[i];
      }
      //뒤에 값이 더 있을 경우에는 콤마를 붙여준다.
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
	
   /*데이터 그리드 초기화 시작  */
   $("#grid_emp").datagrid({
   //url:"./empList.json"
   url:"./getEmpList.kosmo"
      ,columns:[[
         {field:'empno',title:'사원번호',width:80,align:'center',editor:'text'}
         ,{field:'ename',title:'사원명',width:100,align:'center',editor:'text'}
         ,{field:'job',title:'JOB',width:120,align:'center',editor:'text'}
         ,{field:'hiredate',title:'입사일자',width:120,align:'center',editor:'text'}
         ,{field:'deptno',title:'부서번호',width:80,align:'center',   
            formatter:function(value,row){
            return row.deptno||value;
         },
         editor:{
            type:'combobox'
         ,options:{
            valueField:'DEPTNO',//실제 서버에 넘어가는 필드
            textField:'DEPTNO',//화면에 출력되는 필드
            url:'../dept/getDeptnoList.kosmo',
            required:true
            
         }////////////////////end of options
         }/////////////////////////end of editor
            }
         ,{field:'dname',title:'부서명',width:100,align:'center',editor:'text'}
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
      {empno:'6000', ename:'이순신',job:'영업',hiredate:'2009-10-25',deptno:40,dname:'해외영업'}
      ,{empno:'7000', ename:'김유신',job:'영업',hiredate:'2009-10-25',deptno:40,dname:'해외영업'}
      ] */
   });

   /*데이터 그리드 초기화 끝  */
});///////////////////////////////////end of ready
function getRowIndex(target){
   var tr=$(target).closest('tr.datagrid-row');
   return parseInt(tr.attr('datagrid-row-index'));
}
function editrow(target){
   $("#grid_emp").datagrid('beginEdit',getRowIndex(target));
}

function empInsert(){
	$("#dlg_empIns").dialog('open').dialog('setTitle','사원등록');
}
function empUpdate(){
	var row=$("#grid_emp").datagrid('getSelections');
	
	//alert(row.length);
	
	if(row == null || row.length>1){
		
		alert("수정할 로우 하나를 선택하세요");
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
	
	
	 
	
	$("#dlg_empUpd").dialog('open').dialog('setTitle','사원수정');
 


}

function dlg_empUpdAction(){

	alert("사원수정");
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
	
	$.messager.confirm('Confirm','정말 사원의 급여를 상승하시겠습니까?',function(r){
	      if(r){
	         var row =$("#grid_emp").datagrid('getSelected');//로우에 대한 Object
	         //사용자가 선택한 로우에 대한 Object를 이용하면 field에 접근할 수 있다.
	         if(row==null){
	            alert("삭제할 사원을 선택하세요");
	            return;
	         }
	
	var v_empno = row.empno;
	
	alert(v_empno);
	
	location.href = "./proc_salupdate.kosmo?empno="+v_empno;
	
	
	}
	   });
}



function deleterow(target){
	
   $.messager.confirm('Confirm','정말 삭제하시겠습니까?',function(r){
      if(r){
         var row =$("#grid_emp").datagrid('getSelected');//로우에 대한 Object
         //사용자가 선택한 로우에 대한 Object를 이용하면 field에 접근할 수 있다.
         if(row==null){
            alert("삭제할 사원을 선택하세요");
            return;
         }
      
         
         var vempno="";
  	   var vempnos=[];
  	   var rows=$("#grid_emp").datagrid('getSelections');
  	   alert(rows);//Object,Object,Object
  	   //사용자가 선택한 부서번호를 배열에 담기
  	   for(var i=0;i<rows.length;i++){
  	      vempnos.push(rows[i].empno);
  	   } 
  	   //배열에 담긴 정보 출력해보기
  	   for(var i=0;i<rows.length;i++){
  	      //10,30...값뒤에 콤마를 붙이다가 맨 마지막에는 붙이지 않습니다.
  	      if(i==(rows.length-1)){
  	         vempno +=vempnos[i];
  	      }
  	      //뒤에 값이 더 있을 경우에는 콤마를 붙여준다.
  	      else{
  	         vempno +=vempnos[i]+",";
  	      }
  	   }
  	   //10,30,40
  	   alert("vempno:"+vempnos);
        
         
         alert("사용자가 선택한 사원번호:"+vempno);
         location.href="./empDelete.kosmo?empno="+vempno;//서버에 요청(전송방식:get)
         //화면상에서만 삭제 된다.-삭제후 새로 select처리 할 것이므로 의미가 없다.
      //   $("#grid_emp").datagrid('deleteRow',getRowIndex(target));
      }
   });
}
</script>
<!--툴바 추가하기 시작-->
<!-- 테이블내에 툴바 추가해 보기 도서등록버튼 -->
<div id="tbar_empList">
<!-- 검색 조건 추가 화면 입니다.  -->
<form id="f_search">
   <table>
      <tr>
         <td width="140px">
         <label width="80px">사원번호</label>

         <input id="empno" name="empno" class="easyui-searchbox" data-options="prompt:'사원번호', searcher:empnoSearch" style="width:60px">
         </td>
         <td width="180px">
         <label width="70px">사원명</label>
         <input id="ename" name="ename" class="easyui-searchbox" data-options="prompt:'사원명', searcher:enameSearch" style="width:110px">
         </td>
         <td width="180px">
         <label width="70px">JOB</label>
         <input id="job" name="job" class="easyui-searchbox" data-options="prompt:'JOB', searcher:jobSearch" style="width:110px">
         </td>
      </tr>
      <tr>
         <td colspan="4">
          <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="searchALL()">사원조회</a>
          <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="empUpdate()">사원수정</a>
         <a href="#" class="easyui-linkbutton" iconCls="icon-man" plain="true" onClick="empInsert()">사원등록</a>
         <a href="#" class="easyui-linkbutton" iconCls="icon-man" plain="true" onClick="proc_salupdate()">사원 급여 인상</a>
         <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="deleterow()">사원삭제</a>         
         </td>
      </tr>      
   </table>
</form>   
<!-- 검색 조건 추가 화면 입니다.  -->   
</div>
<!--툴바 추가하기 끝-->
<!-- 테이블 그리기 -->
<table id="grid_emp" toolbar="tbar_empList"class="easyui-datagrid"title="사원목록"style="width:1000px;height:400px">
</table>



<!--  테이블끝 다이얼로그창 시작 -->

<div id="dlg_empIns"  data-options="iconCls:'icon-man'"  buttons="#dlg_buttons" class="easyui-dialog" closed="true" style="width:600px">
<!-- 서버로 사용자가 입력한 정보를 전송합니다.(form전송으로 처리하기) -->
	<form id="f_empIns" style="margin:0;padding:20px 50px"> 	
 	<div style="margin-bottom:10px">
 	<input id="cb_deptno" name="empno" label="사원번호 :" style="width:100%"  class="easyui-textbox" 
 	<%-- data-options="
        valueField: 'deptno',
        textField: 'deptno',
        url: 'getDeptnoList.kosmo',
        onSelect: function(rec){
			<!-- alert(rec.DEPTNO); -->
        }" --%>>
 	</div>
 	<div style="margin-bottom:10px">
 	<input name="ename" class="easyui-textbox" label="사원명 : " style="width:100%" >
 	</div>
 	<div style="margin-bottom:10px">
 	<input name="job" class="easyui-textbox" label="JOB : " style="width:100%">
 	</div>
 	<div style="margin-bottom:10px">
 	<input name="mgr" class="easyui-textbox" label="MGR 코드 : " style="width:100%">
 	</div>
 	 <div style="margin-bottom:10px">
 	<input id="dd"name="hiredate" required="required" class="easyui-datebox" label="고용일자 : " style="width:100%">
 	</div> 
 <!-- 	<div id="cc" class="easyui-calendar" label="고용일자"style="width:180px;height:180px;"></div> -->
 	<div style="margin-bottom:10px">
 	<input name="sal" class="easyui-textbox" label="sal : " style="width:100%">
 	</div>
 	<div style="margin-bottom:10px">
 	<input name="comm" class="easyui-textbox" label="comm : " style="width:100%">
 	</div>
 		 	<div style="margin-bottom:10px">
 	<input id="cb_deptno" name="deptno" label="부서번호 :" style="width:100%"  class="easyui-combobox" 
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
	<a href="#" class="easyui-linkbutton c1" iconCls="icon-ok" plain="true" onClick="insertAction()" style="width:90px">저장</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_empIns').dialog('close')" style="width:90px">취소</a>
</div>
<!-- 등록 성공시 제공될 화면 입니다.  시작  -->
<div id="dlg_empInsSuccess" buttons="#dlg_buttons2" class="easyui-dialog" closed="true" style="width:300px">
	<label>등록성공하였습니다.</label>
</div>
 <div id="dlg_buttons2">
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_empInsSuccess').dialog('close')" style="width:90px">닫기</a>
</div>
<!-- 등록 실패시 제공될 화면 입니다.  시작  -->
<div id="dlg_empInsFail" buttons="#dlg_buttons3" class="easyui-dialog" closed="true" style="width:300px">
	<label>등록실패하였습니다.</label>
</div>
 <div id="dlg_buttons3">
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_empInsFail').dialog('close')" style="width:90px">닫기</a>
</div>





<!--  업데이트 -->


<div id="dlg_empUpd"  data-options="iconCls:'icon-man'"  buttons="#dlg_buttons" class="easyui-dialog" closed="true" style="width:600px">
<!-- 서버로 사용자가 입력한 정보를 전송합니다.(form전송으로 처리하기) -->
	<form id="f_empUpd" style="margin:0;padding:20px 50px"> 	
 	<div style="margin-bottom:10px">
 	<input id="uempno" name="empno" label="사원번호 :" style="width:100%"  class="easyui-textbox" required="true">
 	</div>
 	<div style="margin-bottom:10px">
 	<input id="uename" name="ename" class="easyui-textbox" label="사원명 : " style="width:100%" required="true" >
 	</div>
 	<div style="margin-bottom:10px">
 	<input id="ujob"  name="job" class="easyui-textbox" label="JOB : " style="width:100%" required="true" >
 	</div>
 	<div style="margin-bottom:10px">
 	<input id="umgr"  name="mgr" class="easyui-textbox" label="MGR 코드 : " style="width:100%" required="true">
 	</div>
 	 <div style="margin-bottom:10px">
 	<input id="uhiredate" name="hiredate" required="required" class="easyui-datebox" label="고용일자 : " style="width:100%" required="true">
 	</div> 
 <!-- 	<div id="cc" class="easyui-calendar" label="고용일자"style="width:180px;height:180px;"></div> -->
 	<div style="margin-bottom:10px">
 	<input id="usal"  name="sal" class="easyui-textbox" label="sal : " style="width:100%" required="true" >
 	</div>
 	<div style="margin-bottom:10px">
 	<input id="ucomm" name="comm" class="easyui-textbox" label="comm : " style="width:100%" required="true">
 	</div>
 		 	<div style="margin-bottom:10px">
 	<input id="udeptno" name="deptno" label="부서번호 :" style="width:100%"  class="easyui-combobox" >
 	</div>
 	</form>	
 </div>
 <div id="dlg_buttons">
	<a href="#" class="easyui-linkbutton c1" iconCls="icon-ok" plain="true" onClick="dlg_empUpdAction()" style="width:90px">저장</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_empUpd').dialog('close')" style="width:90px">취소</a>
</div>
<!-- 등록 성공시 제공될 화면 입니다.  시작  -->
<div id="dlg_empUpdSuccess" buttons="#dlg_buttons2" class="easyui-dialog" closed="true" style="width:300px">
	<label>등록성공하였습니다.</label>
</div>
 <div id="dlg_buttons2">
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_empUpdSuccess').dialog('close')" style="width:90px">닫기</a>
</div>
<!-- 등록 실패시 제공될 화면 입니다.  시작  -->
<div id="dlg_empUpdFail" buttons="#dlg_buttons3" class="easyui-dialog" closed="true" style="width:300px">
	<label>등록실패하였습니다.</label>
</div>
 <div id="dlg_buttons3">
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_empInsFail').dialog('close')" style="width:90px">닫기</a>
</div>


</body>
</html>