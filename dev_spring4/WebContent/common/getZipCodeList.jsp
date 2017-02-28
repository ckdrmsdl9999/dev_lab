<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.HashMap"%>
<%@ page import="org.json.simple.JSONValue"%>

<%
   //json 형식으로 데이터 받기
	List<HashMap> commonList = 
	//getAttribute("jibnawaMember"); 는  controller.java 에서 //pMap.addAttribute("jibnawaMember",jibnawaMember);과 동일하게 맞추기
	(List<HashMap>)request.getAttribute("commonList");
	String jsonJib = JSONValue.toJSONString(commonList);
	
	
	
	//데이터를 그리드에 전달하는 부분 myGrid.setList(); 에서 json 데이터를 받아 줌  스크립트에서 JSP 변수를 받을 수 있게 보냄  예 myGrid.setList( < %= jsonJib % >);
%>



<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />


    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1.0, minimum-scale=1" />
	<title>AXGrid RWD - AXGrid</title>
	
	<script type="text/javascript">

	
	function deptnoSearch(){
		//사용자가 입력한 부서번호 가져오기
		var vdeptno = $("#deptno").val();
		console.log("사용자가 입력한 부서번호 : "+vdeptno);
		$('#tb_deptList').datagrid({
			url: "./getDeptList.kosmo?deptno="+vdeptno
		});
	}
	//부서명 조건 검색
	function dnameSearch(){
		var vdname = $("#dname").val();
		console.log("사용자가 입력한 부서명 : "+vdname);
		$('#tb_deptList').datagrid({
			url: "./getDeptList.kosmo?dname="+vdname
		});		
	}
	//지역 조건 검색
	function locSearch(){
		var vloc = $("#loc").val();
		console.log("사용자가 입력한 지역 : "+vloc);
		$('#tb_deptList').datagrid({
			url: "./getDeptList.kosmo?loc="+vloc
		});		
	}	
	//전체 조건 검색
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
			//body: Object.toJSON({index:this.index, item:this.item})+"에 입찰 하시겠습니까?",
					body: index+" 가격" + m + "에 입찰 하시겠습니까?",
			buttons:[
				{buttonValue:'확인', buttonClass:'Red W100', onClick:function(arg){alert(arg);}, data:'data1'},
				{buttonValue:'취소', buttonClass:'Blue', onClick:function(arg){alert(arg);}, data:'data2'},
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
			toast.push("토스트를 열었습니다. 잠시후 사라집니다.");
		});
		$("#com-dialog-open").click(function(){
			dialog.push("다이얼로그");
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
				// 브라우저 사이즈에 따른 changeGridView 설정
                mediaQuery: {
                    mx:{min:0, max:600}, dx:{min:600}
                },
				colGroup : [
				/* 	{key:"no", label:"번호", width:"40", align:"center"}, 
					{key:"money", label:"입찰 금액", width:"100", align:"center", formatter:"money"},
					{key:"date", label:"사용날짜", width:"200", align:"center"},
					{key:"person", label:"인원", width:"100", align:"center"},
					//{key:"writer", label:"업체정보", width:"100"}, */
					
					
					
				  {key:"UID_NO", label:"UID_NO", width:"100", align:"center"},
                            {key:"SIGU", label:"SIGU", width:"100", align:"center"},
                            {key:"ZDO", label:"ZDO", width:"100", align:"center"},
                            {key:"DONG", label:"DONG", width:"100", align:"center"},
                            {key:"BUNGI", label:"BUNGI", width:"100", align:"center"},
                            {key:"ZIPCODE", label:"BUNGI", width:"100", align:"center"},
                            {key:"APTNAME", label:"APTNAME", width:"100", align:"center"},
                            {key:"ADDRESS", label:"ADDRESS", width:"100", align:"center"},
				/*     {
                        key: "btns", label: "입찰", width: "100", align: "center", formatter: function () {
                      		//return '<button class="AXButton Red"  id="com-dialog-button-open" onclick="bidclick(' + this.index + "," + this.item.money + ');">입찰하기</button>';
                      		return '<button class="AXButton Red"  id="com-dialog-button-open" onclick="bidclick('+this.index+","+this.item.money+",'"+this.item.MEM_EMAIL+"'"
                      				+');">입찰하기</button>';
                        	//  return '<button type="button" name="submit" onclick="fnObj.grid.deleteItem(' + this.index + ');">입찰<i class="axi axi-check-circle-o"></i></button>';
                    }		 //bidclick(' + this.index + "," + this.item.money +  " ,' "+    this.MEM_NICKNAME   + "'"         ')
                    }                       // '+ 150 , 150, '닉네임' */
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
	        ajaxUrl:"./getZipCodeList.kosmo?dong=가산", ajaxPars:"str=1", onLoad:function(){
	         }
	 });
		     
		     
		     
		     
           /*   myGrid.setDataSet({});
             trace(myGrid.getSortParam()); */
			
			/* var list = [
		 	{no:1, title:"AXGrid 첫번째 줄 입니다.AXGrid 첫번째 줄 입니다.AXGrid 첫번째 줄 입니다.", 
					writer:"장기영", img:"img/1.jpg", desc:"많은 글을 담고 있는 내용 입니다. 자연스럽게 줄이 넘어가고 표현되는 것이 관건 입니다.",
					category:"액시스제이", date:"2014-04-02"
				}, // item
				{no:2, title:"AXGrid 두번째 줄 입니다.", writer:"장기영", img:"img/2.jpg", category:"액시스제이", date:"2014-04-02"},
				{no:3, title:"AXGrid 세번째 줄 입니다.", writer:"장기영", img:"img/3.jpg", category:"액시스제이", date:"2014-04-02"},
				{no:4, title:"AXGrid 세번째 줄 입니다.", writer:"장기영", img:"img/4.jpg", category:"액시스제이", date:"2014-04-02"},
				{no:5, title:"AXGrid 세번째 줄 입니다.", writer:"장기영", img:"img/5.jpg", category:"액시스제이", date:"2014-04-02"},
				{no:6, title:"AXGrid 세번째 줄 입니다.", writer:"장기영", img:"img/6.jpg", category:"액시스제이", date:"2014-04-02"},
				{no:7, title:"AXGrid 세번째 줄 입니다.", writer:"장기영", img:"img/7.jpg", category:"액시스제이", date:"2014-04-02"},
				{no:8, title:"AXGrid 첫번째 줄 입니다.", writer:"장기영", img:"img/8.jpg", category:"액시스제이", date:"2014-04-02"},
				{no:9, title:"AXGrid 두번째 줄 입니다.", writer:"장기영", img:"img/9.jpg", category:"액시스제이", date:"2014-04-02"},
				{no:10, title:"AXGrid 세번째 줄 입니다.", writer:"장기영", img:"img/10.jpg", category:"액시스제이", date:"2014-04-02"},
				{no:11, title:"AXGrid 세번째 줄 입니다.", writer:"장기영", img:"img/11.jpg", category:"액시스제이", date:"2014-04-02"},
				{no:12, title:"AXGrid 세번째 줄 입니다.", writer:"장기영", img:"img/12.jpg", category:"액시스제이", date:"2014-04-02"},
				{no:13, title:"AXGrid 세번째 줄 입니다.", writer:"장기영", img:"img/13.jpg", category:"액시스제이", date:"2014-04-02"},
				{no:14, title:"AXGrid 세번째 줄 입니다.", writer:"장기영", img:"img/14.jpg", category:"액시스제이", date:"2014-04-02"},
				{no:15, title:"AXGrid 두번째 줄 입니다.", writer:"장기영", img:"img/15.jpg", category:"액시스제이", date:"2014-04-02"},
				{no:16, title:"AXGrid 세번째 줄 입니다.", writer:"장기영", img:"img/16.jpg", category:"액시스제이", date:"2014-04-02"},
				{no:17, title:"AXGrid 세번째 줄 입니다.", writer:"장기영", img:"img/17.jpg", category:"액시스제이", date:"2014-04-02"},
				{no:18, title:"AXGrid 세번째 줄 입니다.", writer:"장기영", img:"img/18.jpg", category:"액시스제이", date:"2014-04-02"},
				{no:19, title:"AXGrid 세번째 줄 입니다.", writer:"장기영", img:"img/19.jpg", category:"액시스제이", date:"2014-04-02"}, 
				{no:1, money:"150000", writer:"최한진", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:2, money:"80000", writer:"윤우경", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:3, money:"70000", writer:"박명희", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:2, money:"80000", writer:"윤우경", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:3, money:"70000", writer:"박명희", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:2, money:"80000", writer:"윤우경", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:3, money:"70000", writer:"박명희", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:2, money:"80000", writer:"윤우경", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:3, money:"70000", writer:"박명희", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:2, money:"80000", writer:"윤우경", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:3, money:"70000", writer:"박명희", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:2, money:"80000", writer:"윤우경", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:3, money:"70000", writer:"박명희", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:2, money:"80000", writer:"윤우경", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:3, money:"70000", writer:"박명희", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:2, money:"80000", writer:"윤우경", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:3, money:"70000", writer:"박명희", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:2, money:"80000", writer:"윤우경", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:3, money:"70000", writer:"박명희", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:2, money:"80000", writer:"윤우경", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:3, money:"70000", writer:"박명희", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:2, money:"80000", writer:"윤우경", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:3, money:"70000", writer:"박명희", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:2, money:"80000", writer:"윤우경", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:3, money:"70000", writer:"박명희", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:2, money:"80000", writer:"윤우경", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:3, money:"70000", writer:"박명희", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:2, money:"80000", writer:"윤우경", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				,{no:3, money:"70000", writer:"박명희", date:"2017-01-27 ~ 2017-01-29", person:"3명"}
				
	
				
				
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

            <h1>입찰진행중</h1>
            <h3>브라우저 너비를 줄이거나 늘려서 반응형 환경을 만들어 보세요.</h3>
            <div id="AXGridTarget"></div>

        </div>
    </div>
</div>

</body>
</html>
