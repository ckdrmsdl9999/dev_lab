

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.Map" %> 
<%@ page import="com.google.gson.Gson" %>    
<%
List<Map<String,Object>> jibnawaRauctionList =
	(List<Map<String,Object>>)request.getAttribute("jibnawaRauctionList");
	Gson g = new Gson();
	String jsonRauction = g.toJson(jibnawaRauctionList);
	
%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />


    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1.0, minimum-scale=1" />
	<title>AXGrid RWD - AXGrid</title>
	
	<script>

	
	
	
	function bidclick(num, cost, id){

		//alert(index + " : " + item);
		
		
		dialog.push({
			type: "Caution",
			//body: Object.toJSON({index:this.index, item:this.item})+"에 입찰 하시겠습니까?",
					body: "숙박인원 : " + num +"명 입찰가 : " + cost + " 원 아이디 : "+ id +"님 에 입찰 하시겠습니까?",
			buttons:[
				{buttonValue:'확인', buttonClass:'Red W100', onClick:function(arg){
				
					alert(id);
					
					 location.href = "bidaction.kosmo?AUC_COMM_ID="+id;
					
					
				
				}},
				{buttonValue:'취소', buttonClass:'Blue', onClick:function(arg){alert(arg);}, data:'data2'}
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
							
					
					
				   {key:"BID_EMAIL", label:"입찰자 이메일", width:"100", align:"center" },
				   {key:"AUC_COMM_ID", label:"아이디", width:"100", align:"center"},
                            {key:"BID_COST", label:"입찰가", width:"100", align:"center",formatter:"money"},
                            {key:"MEM_NUM", label:"숙박인원", width:"100", align:"center"},
                            {key:"AUC_START_DATE", label:"시작 날짜", width:"100", align:"center",formatter:"date"},
                            {key:"AUC_END_DATE", label:"체크아웃 날짜", width:"100", align:"center"},
				    {
                        key: "btns", label: "입찰", width: "100", align: "center", formatter: function () {
                      		//return '<button class="AXButton Red"  id="com-dialog-button-open" onclick="bidclick(' + this.index + "," + this.item.money + ');">입찰하기</button>';
                      		
                      		return '<button class="AXButton Red"  id="com-dialog-button-open" onclick="bidclick('+"'"+this.item.MEM_NUM+"'"+","+this.item.BID_COST
                      				
                      				+",'"
                      				+this.item.AUC_COMM_ID+"'"
                      			      
                      				+');">입찰하기</button>';
                      		
                      		/* return '<button class="AXButton Red"  id="com-dialog-button-open" onclick="bidclick('+this.index+","+this.item.money+",'"+this.item.MEM_EMAIL+"'"
                      				+');">입찰하기</button>'; */
                        	//  return '<button type="button" name="submit" onclick="fnObj.grid.deleteItem(' + this.index + ');">입찰<i class="axi axi-check-circle-o"></i></button>';
                    }		 //bidclick(' + this.index + "," + this.item.money +  " ,' "+    this.MEM_NICKNAME   + "'"         ')
                    }                       // '+ 150 , 150, '닉네임'
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
					  paging:true,
                      pageNo:1,
                      pageSize:100,
                      status:{formatter: null}
				}
			});
			
			
		     myGrid.setList(<%=jsonRauction%>);
             myGrid.setDataSet({});
             trace(myGrid.getSortParam());
			
			
			
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
