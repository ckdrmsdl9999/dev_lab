<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, com.jibnawa.member.JibnawaMemberVO"%>
<%@ page import="org.json.simple.JSONValue"%>

<%
   //json 형식으로 데이터 받기
	List<JibnawaMemberVO> deptList = 
	//getAttribute("jibnawaMember"); 는  controller.java 에서 //pMap.addAttribute("jibnawaMember",jibnawaMember);과 동일하게 맞추기
	(List<JibnawaMemberVO>)request.getAttribute("jibnawaMember");
	String jsonJib = JSONValue.toJSONString(deptList);
	//데이터를 그리드에 전달하는 부분 myGrid.setList(); 에서 json 데이터를 받아 줌  스크립트에서 JSP 변수를 받을 수 있게 보냄  예 myGrid.setList( < %= jsonJib % >);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1.0, minimum-scale=1" />
<title>AXGrid - AXISJ</title>
<link rel="shortcut icon" href="../axisj/ui/axisj.ico" type="image/x-icon" />
<link rel="icon" href="../axisj/ui/axisj.ico" type="image/x-icon" />
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../axisj/ui/AXJ.png" />
<link rel="apple-touch-icon-precomposed" href="../axisj/ui/AXJ.png" />
<meta property="og:image" content="/samples/_img/axisj_sns.png" />
<meta property="og:site_name" content="Axis of Javascript - axisj.com" />
<meta property="og:description" id="meta_description"
	content="Javascript UI Library based on JQuery" />

<!-- css block -->
<link rel="stylesheet" type="text/css" href="../axisj/ui/arongi/page.css">
<link rel="stylesheet" type="text/css"
	href="../axisj/ui/arongi/AXJ.min.css" />

<style type="text/css">
</style>
<!-- css block -->

<!-- js block -->
<script type="text/javascript" src="../axisj/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../axisj/dist/AXJ.min.js"></script>
<script type="text/javascript" src="../axisj/lib/AXGrid.js"></script>
<script type="text/javascript" src="../axisj/page.js"></script>
<script type="text/javascript" src="pageTab.js"></script>
<!-- js block -->

<!-- prettify block -->
<link type="text/css" rel="stylesheet"
	href="http://newdoc.axisj.com/styles/prettify-tomorrow.css">
<script src="http://newdoc.axisj.com/scripts/prettify/prettify.js"></script>
<script src="http://newdoc.axisj.com/scripts/prettify/lang-css.js"></script>
<!-- prettify block -->
<script id="jscode">
    /**
     * Require Files for AXISJ UI Component...
     * Based        : jQuery
     * Javascript   : AXJ.js, AXGrid.js, AXInput.js, AXSelect.js
     * CSS          : AXJ.css, AXGrid.css, AXButton.css, AXInput.css, AXSelecto.css
     */
    var pageID = "autoHeight";
    var fnObj = {
        pageStart: function(){
            fnObj.grid.bind();
        },
        grid: {
            target: new AXGrid(),
            bind: function(){
                window.myGrid = fnObj.grid.target;
                var getColGroup = function(){
                	//JSON key name과 도일 하게 맞추기
                    return [
                            {key:"MEM_EMAIL", label:"MEM_EMAIL", width:"100", align:"center"},
                            {key:"MEM_PW", label:"MEM_PW", width:"100", align:"center"},
                            {key:"MEM_EMAIL", label:"MEM_EMAIL", width:"100", align:"center"},
                            {key:"MEM_NICKNAME", label:"MEM_EMAIL", width:"100", align:"center"},
                            {key:"MEM_PHONE_F", label:"MEM_PHONE_F", width:"100", align:"center"},
                            {key:"MEM_PHONE_M", label:"MEM_PHONE_M", width:"100", align:"center"},
                            {key:"MEM_PHONE_M", label:"MEM_PHONE_E", width:"100", align:"center"}
                    ];
                };
                myGrid.setConfig({
                    targetID : "AXGridTarget",
                    //sort:false, 정렬을 원하지 않을 경우 (tip
                    //fitToWidth:true, // 너비에 자동 맞춤
                    height:"auto",
                    colGroup : getColGroup(),
                    colHeadAlign: "center", // 헤드의 기본 정렬 값 ( colHeadAlign 을 지정하면 colGroup 에서 정의한 정렬이 무시되고 colHeadAlign : false 이거나 없으면 colGroup 에서 정의한 속성이 적용됩니다.
                    body : {
                        onclick: function(){
                            toast.push(Object.toJSON({index:this.index, r:this.r, c:this.c, item:this.item}));
                            //alert(this.list);
                            //alert(this.page);
                        },
                        /* ondblclick 선언하면 onclick 이벤트가 0.25 초 지연 발생 됩니다. 주의 하시기 바람니다. */
                        ondblclick: function(){
                            toast.push("더블클릭");
                            //toast.push(Object.toJSON({index:this.index, r:this.r, c:this.c, item:this.item}));
                            //alert(this.list);
                            //alert(this.page);
                        },
                        addClass: function(){
                            // red, green, blue, yellow, white, gray
                            if(this.index % 2 == 0){
                                return "blue";
                            }else{
                                return "white";
                            }
                        }
                    },
                    page: {
                        display: false,
                        paging: false
                    }
                });
                
                // JSON 담기
                myGrid.setList(<%=jsonJib%>);
                myGrid.setDataSet({});
                trace(myGrid.getSortParam());
            },
            getExcel: function(type){
                var obj = myGrid.getExcelFormat(type);
                trace(obj);
                $("#printout").html(Object.toJSON(obj));
            }
        }
    };
    jQuery(document.body).ready(function() {
        fnObj.pageStart();
    });
    </script>
</head>

<body>

	<div id="AXPage">

		<div id="AXPageBody" class="SampleAXSelect">
			<div id="demoPageTabTarget" class="AXdemoPageTabTarget"></div>
			<div class="AXdemoPageContent">

				<div id="grid0">
					<div class="title">
						<h1>AXGrid (autoHeight)</h1>
					</div>
					<h2>height 속성에 "auto" 값을 사용하면 그리드의 높이가 내용에 맞춰서 늘어납니다.</h2>

					<div id="AXGridTarget"></div>

					<div style="padding: 10px;">

						<input type="button" value="forExcel html" class="AXButton"
							onclick="fnObj.grid.getExcel('html');" /> <input type="button"
							value="forExcel json" class="AXButton"
							onclick="fnObj.grid.getExcel('json');" /> <input type="button"
							value="resetHeight : 300px" class="AXButton"
							onclick="$('#AXGridTarget').css({height:300});myGrid.resetHeight();" />
						<input type="button" value="resetHeight : 600px" class="AXButton"
							onclick="$('#AXGridTarget').css({height:600});myGrid.resetHeight();" />
					</div>
				</div>

				<pre id="pretty" class="prettyprint linenums"></pre>

				<div id="printout"></div>

			</div>
		</div>

	</div>

</body>
</html>
