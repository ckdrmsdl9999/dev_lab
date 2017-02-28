

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
			//body: Object.toJSON({index:this.index, item:this.item})+"�� ���� �Ͻðڽ��ϱ�?",
					body: "�����ο� : " + num +"�� ������ : " + cost + " �� ���̵� : "+ id +"�� �� ���� �Ͻðڽ��ϱ�?",
			buttons:[
				{buttonValue:'Ȯ��', buttonClass:'Red W100', onClick:function(arg){
				
					alert(id);
					
					 location.href = "bidaction.kosmo?AUC_COMM_ID="+id;
					
					
				
				}},
				{buttonValue:'���', buttonClass:'Blue', onClick:function(arg){alert(arg);}, data:'data2'}
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
							
					
					
				   {key:"BID_EMAIL", label:"������ �̸���", width:"100", align:"center" },
				   {key:"AUC_COMM_ID", label:"���̵�", width:"100", align:"center"},
                            {key:"BID_COST", label:"������", width:"100", align:"center",formatter:"money"},
                            {key:"MEM_NUM", label:"�����ο�", width:"100", align:"center"},
                            {key:"AUC_START_DATE", label:"���� ��¥", width:"100", align:"center",formatter:"date"},
                            {key:"AUC_END_DATE", label:"üũ�ƿ� ��¥", width:"100", align:"center"},
				    {
                        key: "btns", label: "����", width: "100", align: "center", formatter: function () {
                      		//return '<button class="AXButton Red"  id="com-dialog-button-open" onclick="bidclick(' + this.index + "," + this.item.money + ');">�����ϱ�</button>';
                      		
                      		return '<button class="AXButton Red"  id="com-dialog-button-open" onclick="bidclick('+"'"+this.item.MEM_NUM+"'"+","+this.item.BID_COST
                      				
                      				+",'"
                      				+this.item.AUC_COMM_ID+"'"
                      			      
                      				+');">�����ϱ�</button>';
                      		
                      		/* return '<button class="AXButton Red"  id="com-dialog-button-open" onclick="bidclick('+this.index+","+this.item.money+",'"+this.item.MEM_EMAIL+"'"
                      				+');">�����ϱ�</button>'; */
                        	//  return '<button type="button" name="submit" onclick="fnObj.grid.deleteItem(' + this.index + ');">����<i class="axi axi-check-circle-o"></i></button>';
                    }		 //bidclick(' + this.index + "," + this.item.money +  " ,' "+    this.MEM_NICKNAME   + "'"         ')
                    }                       // '+ 150 , 150, '�г���'
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

            <h1>����������</h1>
            <h3>������ �ʺ� ���̰ų� �÷��� ������ ȯ���� ����� ������.</h3>
            <div id="AXGridTarget"></div>

        </div>
    </div>
</div>

</body>
</html>
