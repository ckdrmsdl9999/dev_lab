<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.HashMap"%>
<%@ page import="org.json.simple.JSONValue"%>

<%
   //json �������� ������ �ޱ�
	List<HashMap> commonList = 
	//getAttribute("jibnawaMember"); ��  controller.java ���� //pMap.addAttribute("jibnawaMember",jibnawaMember);�� �����ϰ� ���߱�
	(List<HashMap>)request.getAttribute("commonList");
	String jsonJib = JSONValue.toJSONString(commonList);
	
	
	
	//�����͸� �׸��忡 �����ϴ� �κ� myGrid.setList(); ���� json �����͸� �޾� ��  ��ũ��Ʈ���� JSP ������ ���� �� �ְ� ����  �� myGrid.setList( < %= jsonJib % >);
%>



<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />


    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1.0, minimum-scale=1" />
	<title>AXGrid RWD - AXGrid</title>
	
	<script type="text/javascript">

	
	function deptnoSearch(){
		//����ڰ� �Է��� �μ���ȣ ��������
		var vdeptno = $("#deptno").val();
		console.log("����ڰ� �Է��� �μ���ȣ : "+vdeptno);
		$('#tb_deptList').datagrid({
			url: "./getDeptList.kosmo?deptno="+vdeptno
		});
	}
	//�μ��� ���� �˻�
	function dnameSearch(){
		var vdname = $("#dname").val();
		console.log("����ڰ� �Է��� �μ��� : "+vdname);
		$('#tb_deptList').datagrid({
			url: "./getDeptList.kosmo?dname="+vdname
		});		
	}
	//���� ���� �˻�
	function locSearch(){
		var vloc = $("#loc").val();
		console.log("����ڰ� �Է��� ���� : "+vloc);
		$('#tb_deptList').datagrid({
			url: "./getDeptList.kosmo?loc="+vloc
		});		
	}	
	//��ü ���� �˻�
	function searchALL(){
		$('#tb_deptList').datagrid({
			url: "./getDeptList.kosmo"
		});		
	}

</script>
	
	
	
	<script>


	
	
	
	
	function bidclick(index, item, m){

		//alert(index + " : " + item);
		
		
		dialog.push({
			type: "Caution",
			//body: Object.toJSON({index:this.index, item:this.item})+"�� ���� �Ͻðڽ��ϱ�?",
					body: index+" ����" + m + "�� ���� �Ͻðڽ��ϱ�?",
			buttons:[
				{buttonValue:'Ȯ��', buttonClass:'Red W100', onClick:function(arg){alert(arg);}, data:'data1'},
				{buttonValue:'���', buttonClass:'Blue', onClick:function(arg){alert(arg);}, data:'data2'},
			//	{buttonValue:'button3', buttonClass:'Green', onClick:function(arg){alert(arg);}, data:'data3'}
			]
		});
		
		
	};
	
	
	
</script> 
	
	
	
    <link rel="shortcut icon" href="../axisj/ui/axisj.ico" type="image/x-icon" />
    <link rel="icon" href="../axisj/ui/axisj.ico" type="image/x-icon" />
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../axisj/ui/AXJ.png" />
    <link rel="apple-touch-icon-precomposed" href="../axisj/ui/AXJ.png" />
    <meta property="og:image" content="../axisj/samples/_img/axisj_sns.png" />
    <meta property="og:site_name" content="Axis of Javascript - axisj.com" />
    <meta property="og:description" id="meta_description" content="Javascript UI Library based on JQuery" />

    <!-- css block -->
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../axisj/ui/arongi/page.css">
    <link rel="stylesheet" type="text/css" href="../axisj/ui/arongi/AXJ.min.css">
  <link rel="stylesheet" type="text/css" href="http://cdno.axisj.com/axicon/axicon.min.css"/>

   <script type="text/javascript" src="../axisj/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="../axisj/dist/AXJ.min.js"></script>
<!--     <script type="text/javascript" src="../axisj/lib/AXCore.js"></script> -->
    <script type="text/javascript" src="../axisj/lib/AXGrid.js"></script>
 <!--    <script type="text/javascript" src="../page.js"></script>
    <script type="text/javascript" src="pageTab.js"></script>
     -->
    <!-- js block -->
    
    
<!--     <script>
	(function(){
		$("#com-toast-open").click(function(){
			toast.push("�佺Ʈ�� �������ϴ�. ����� ������ϴ�.");
		});
		$("#com-dialog-open").click(function(){
			dialog.push("���̾�α�");
		});
	})();
</script>
     -->
    
	
	<script type="text/javascript">
	var pageID = "AXGrid";
	var myGrid = new AXGrid();
	var itemSum = 0;
	var fnObj = {
		pageStart: function(){

			myGrid.setConfig({
				targetID : "AXGridTarget",
				theme : "AXGrid",
				//viewMode: "grid", // ["grid","icon","mobile"]
				// ������ ����� ���� changeGridView ����
                mediaQuery: {
                    mx:{min:0, max:600}, dx:{min:600}
                },
				colGroup : [
				/* 	{key:"no", label:"��ȣ", width:"40", align:"center"}, 
					{key:"money", label:"���� �ݾ�", width:"100", align:"center", formatter:"money"},
					{key:"date", label:"��볯¥", width:"200", align:"center"},
					{key:"person", label:"�ο�", width:"100", align:"center"},
					//{key:"writer", label:"��ü����", width:"100"}, */
					
					
					
				  {key:"UID_NO", label:"UID_NO", width:"100", align:"center"},
                            {key:"SIGU", label:"SIGU", width:"100", align:"center"},
                            {key:"ZDO", label:"ZDO", width:"100", align:"center"},
                            {key:"DONG", label:"DONG", width:"100", align:"center"},
                            {key:"BUNGI", label:"BUNGI", width:"100", align:"center"},
                            {key:"ZIPCODE", label:"BUNGI", width:"100", align:"center"},
                            {key:"APTNAME", label:"APTNAME", width:"100", align:"center"},
                            {key:"ADDRESS", label:"ADDRESS", width:"100", align:"center"},
				/*     {
                        key: "btns", label: "����", width: "100", align: "center", formatter: function () {
                      		//return '<button class="AXButton Red"  id="com-dialog-button-open" onclick="bidclick(' + this.index + "," + this.item.money + ');">�����ϱ�</button>';
                      		return '<button class="AXButton Red"  id="com-dialog-button-open" onclick="bidclick('+this.index+","+this.item.money+",'"+this.item.MEM_EMAIL+"'"
                      				+');">�����ϱ�</button>';
                        	//  return '<button type="button" name="submit" onclick="fnObj.grid.deleteItem(' + this.index + ');">����<i class="axi axi-check-circle-o"></i></button>';
                    }		 //bidclick(' + this.index + "," + this.item.money +  " ,' "+    this.MEM_NICKNAME   + "'"         ')
                    }                       // '+ 150 , 150, '�г���' */
				],
				   
				body : {			
					 onclick: function(){
						//toast.push(Object.toJSON({index:this.index, item:this.item}));
						//toast.push(this.item);
					//alert(Object.toJSON(this.item.money));
						//alert(this.item.person);
						//alert(this.page);
						
						
						 
						
						
					} 
				},
				page:{
					  paging:false,
                      pageNo:1,
                      pageSize:100,
                      status:{formatter: null}
				}
			});
			
			
		<%--     myGrid.setList(<%=jsonJib%>); --%>
		     
		     
	

		     
		myGrid.setList({
	        ajaxUrl:"./getZipCodeList.kosmo?dong=����", ajaxPars:"str=1", onLoad:function(){
	         }
	 });
		     
		     
		     
		     
           /*   myGrid.setDataSet({});
             trace(myGrid.getSortParam()); */
			
			/* var list = [
		 	{no:1, title:"AXGrid ù��° �� �Դϴ�.AXGrid ù��° �� �Դϴ�.AXGrid ù��° �� �Դϴ�.", 
					writer:"��⿵", img:"img/1.jpg", desc:"���� ���� ��� �ִ� ���� �Դϴ�. �ڿ������� ���� �Ѿ�� ǥ���Ǵ� ���� ���� �Դϴ�.",
					category:"�׽ý�����", date:"2014-04-02"
				}, // item
				{no:2, title:"AXGrid �ι�° �� �Դϴ�.", writer:"��⿵", img:"img/2.jpg", category:"�׽ý�����", date:"2014-04-02"},
				{no:3, title:"AXGrid ����° �� �Դϴ�.", writer:"��⿵", img:"img/3.jpg", category:"�׽ý�����", date:"2014-04-02"},
				{no:4, title:"AXGrid ����° �� �Դϴ�.", writer:"��⿵", img:"img/4.jpg", category:"�׽ý�����", date:"2014-04-02"},
				{no:5, title:"AXGrid ����° �� �Դϴ�.", writer:"��⿵", img:"img/5.jpg", category:"�׽ý�����", date:"2014-04-02"},
				{no:6, title:"AXGrid ����° �� �Դϴ�.", writer:"��⿵", img:"img/6.jpg", category:"�׽ý�����", date:"2014-04-02"},
				{no:7, title:"AXGrid ����° �� �Դϴ�.", writer:"��⿵", img:"img/7.jpg", category:"�׽ý�����", date:"2014-04-02"},
				{no:8, title:"AXGrid ù��° �� �Դϴ�.", writer:"��⿵", img:"img/8.jpg", category:"�׽ý�����", date:"2014-04-02"},
				{no:9, title:"AXGrid �ι�° �� �Դϴ�.", writer:"��⿵", img:"img/9.jpg", category:"�׽ý�����", date:"2014-04-02"},
				{no:10, title:"AXGrid ����° �� �Դϴ�.", writer:"��⿵", img:"img/10.jpg", category:"�׽ý�����", date:"2014-04-02"},
				{no:11, title:"AXGrid ����° �� �Դϴ�.", writer:"��⿵", img:"img/11.jpg", category:"�׽ý�����", date:"2014-04-02"},
				{no:12, title:"AXGrid ����° �� �Դϴ�.", writer:"��⿵", img:"img/12.jpg", category:"�׽ý�����", date:"2014-04-02"},
				{no:13, title:"AXGrid ����° �� �Դϴ�.", writer:"��⿵", img:"img/13.jpg", category:"�׽ý�����", date:"2014-04-02"},
				{no:14, title:"AXGrid ����° �� �Դϴ�.", writer:"��⿵", img:"img/14.jpg", category:"�׽ý�����", date:"2014-04-02"},
				{no:15, title:"AXGrid �ι�° �� �Դϴ�.", writer:"��⿵", img:"img/15.jpg", category:"�׽ý�����", date:"2014-04-02"},
				{no:16, title:"AXGrid ����° �� �Դϴ�.", writer:"��⿵", img:"img/16.jpg", category:"�׽ý�����", date:"2014-04-02"},
				{no:17, title:"AXGrid ����° �� �Դϴ�.", writer:"��⿵", img:"img/17.jpg", category:"�׽ý�����", date:"2014-04-02"},
				{no:18, title:"AXGrid ����° �� �Դϴ�.", writer:"��⿵", img:"img/18.jpg", category:"�׽ý�����", date:"2014-04-02"},
				{no:19, title:"AXGrid ����° �� �Դϴ�.", writer:"��⿵", img:"img/19.jpg", category:"�׽ý�����", date:"2014-04-02"}, 
				{no:1, money:"150000", writer:"������", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:2, money:"80000", writer:"�����", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:3, money:"70000", writer:"�ڸ���", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:2, money:"80000", writer:"�����", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:3, money:"70000", writer:"�ڸ���", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:2, money:"80000", writer:"�����", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:3, money:"70000", writer:"�ڸ���", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:2, money:"80000", writer:"�����", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:3, money:"70000", writer:"�ڸ���", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:2, money:"80000", writer:"�����", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:3, money:"70000", writer:"�ڸ���", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:2, money:"80000", writer:"�����", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:3, money:"70000", writer:"�ڸ���", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:2, money:"80000", writer:"�����", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:3, money:"70000", writer:"�ڸ���", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:2, money:"80000", writer:"�����", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:3, money:"70000", writer:"�ڸ���", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:2, money:"80000", writer:"�����", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:3, money:"70000", writer:"�ڸ���", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:2, money:"80000", writer:"�����", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:3, money:"70000", writer:"�ڸ���", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:2, money:"80000", writer:"�����", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:3, money:"70000", writer:"�ڸ���", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:2, money:"80000", writer:"�����", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:3, money:"70000", writer:"�ڸ���", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:2, money:"80000", writer:"�����", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:3, money:"70000", writer:"�ڸ���", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:2, money:"80000", writer:"�����", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				,{no:3, money:"70000", writer:"�ڸ���", date:"2017-01-27 ~ 2017-01-29", person:"3��"}
				
	
				
				
			];
			myGrid.setList(list);
			
			 */
			
		}
	
	
	
	
	
	
	};

    jQuery(document.body).ready(function(){fnObj.pageStart()});
	</script>
	<!-- js block -->
	
</head>
<body>

<div id="AXPage">

<div>
<img src="1.png" style="max-width: 100%; height: auto;">

</div>


    <div id="AXPageBody" class="SampleAXSelect">

        <div id="demoPageTabTarget" class="AXdemoPageTabTarget"></div>
        <div class="AXdemoPageContent">

            <h1>����������</h1>
            <h3>������ �ʺ� ���̰ų� �÷��� ������ ȯ���� ����� ������.</h3>
            <div id="AXGridTarget"></div>

        </div>
    </div>
</div>

</body>
</html>
