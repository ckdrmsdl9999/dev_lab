<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.jibnawa.member.JibnawaMemberVO"%>
<%@ page import="org.json.simple.JSONValue"%>
<%
   //json 형식으로 파일 받아는 영역
	List<JibnawaMemberVO> deptList = 
	(List<JibnawaMemberVO>)request.getAttribute("jibnawaMember");
	String jsonJib = JSONValue.toJSONString(deptList);
%>


<!-- css block -->
<link rel="stylesheet" type="text/css" href="../axisj/ui/arongi/page.css" />
<link rel="stylesheet" type="text/css" href="../axisj/ui/arongi/AXJ.min.css" />

<style type="text/css">
</style>
<!-- css block -->

<!-- js block -->
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../axisj/dist/AXJ.min.js"></script>
<script type="text/javascript" src="../axisj/lib/AXGrid.js"></script>

    <link rel="shortcut icon" href="http://dev.axisj.com/ui/axisj.ico" type="image/x-icon" />
    <link rel="icon" href="http://dev.axisj.com/ui/axisj.ico" type="image/x-icon" />

    <link rel="stylesheet" type="text/css" href="http://cdno.axisj.com/axicon/axicon.min.css" />
    <link rel="stylesheet" type="text/css" href="http://cdno.axisj.com/axisj/ui/kakao/AXJ.min.css" id="axu-theme-axisj" />

    <script type="text/javascript" src="http://cdno.axisj.com/axisj/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="http://cdno.axisj.com/axisj/dist/AXJ.all.js"></script>

    <link rel="stylesheet" href="ui/cacao/admin.css" id="axu-theme-admin" />
    <link rel="stylesheet" href="ui/custom.css" />

    <script type="text/javascript" src="../js/admin.js"></script>
    <script type="text/javascript" src="../js/Chart.min.js"></script>




<!-- prettify block -->
<link type="text/css" rel="stylesheet" href="http://newdoc.axisj.com/styles/prettify-tomorrow.css">
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
        	this.search.bind();
            fnObj.grid.bind();

			jQuery("#AXInputSelector").bindSelector({
				appendable:true,
				options:[
					{optionValue:"mem_div_100", optionText:"관리자"},
					{optionValue:"mem_div_200", optionText:"업체"},
					{optionValue:"mem_div_300", optionText:"회원"}
				]
			});
			jQuery("#AXInputSelector").setConfigInput({
				onChange:function(){
					toast.push(Object.toJSON({targetID:this.targetID, options:this.options, selectedIndex:this.selectedIndex, selectedOption:this.selectedOption}));
				}
			});
        },
        bindEvent: function(){
            var _this = this;
            axdom("#ax-search-btn-search").bind("click", function(){
                _this.search.submit();
            });
        },
        search: {
            target: new AXSearch(),
            get: function(){ return this.target },
            bind: function(){
                var _this = this;
                this.target.setConfig({
                    targetID:"page-search-box",
                    theme : "AXSearch",
                    mediaQuery: {
                        mx:{min:0, max:767}, dx:{min:767}
                    },
                    onsubmit: function(){
                        // 버튼이 선언되지 않았거나 submit 개체가 있는 경우 발동 합니다.
                    },
                    rows:[{display:true, addClass:"", style:"", list:[
                            {label:"상태", labelWidth:"100", type:"selectBox", width:"", key:"selectbox", addClass:"", valueBoxStyle:"", value:"close",
                                options:[{optionValue:"all", optionText:"전체보기"}, {optionValue:"open", optionText:"공개"}, {optionValue:"close", optionText:"비공개"}],
                                AXBind:{
                                    type:"select", config:{
                                        onChange:function(){
                                            //toast.push();
                                        }
                                    }
                                }
                            },
                            {label:"등록일자", labelWidth:"", type:"inputText", width:"70", key:"inputText1", addClass:"secondItem", valueBoxStyle:"", value:"",
                                onChange: function(){alert();}
                            },
                            {label:"", labelWidth:"", type:"inputText", width:"90", key:"inputText2", addClass:"secondItem", valueBoxStyle:"padding-left:0px;", value:"",
                                AXBind:{
                                    type:"twinDate", config:{
                                        align:"right", valign:"top", startTargetID:"inputText1",
                                        onChange:function(){
                                        	
                                        }
                                    }
                                }
                            }
                        ]},
                        {display:true, addClass:"gray", style:"", list:[
                            {label:"판매자명", labelWidth:"100", type:"inputText", width:"", key:"inputText2", addClass:"", valueBoxStyle:"", value:""},
                            {label:"판매자 상품코드", labelWidth:"100", type:"inputText", width:"", key:"inputText3", addClass:"secondItem", valueBoxStyle:"", value:""}
                        ]}
                    ]
                });
            },
            submit: function(){
                var pars = this.target.getParam();
                toast.push("콘솔창에 파라미터 정보를 출력하였습니다.");
                trace(pars);
            }
        },
        grid: {
            target: new AXGrid(),
            bind: function(){
                window.myGrid = fnObj.grid.target;
                var getColGroup = function(){
                    return [
                         //   {key: "no", label: "번호", width: "60", align: "center", formatter: "checkbox"},
                            {
                                key: "btns", label: "삭제", width: "60", align: "center", formatter: function () {
                                return '<button type="button" name="delete" onclick="fnObj.grid.deleteItem(' + this.index + ');"><i class="axi axi-trash-o"></i></button>';
                            }
                            },
                            {key:"MEM_EMAIL", label:"MEM_EMAIL", width:"100", align:"center"},
                            {key:"MEM_NICKNAME", label:"MEM_NICKNAME", width:"100", align:"center"},
                            {key:"MEM_NAME", label:"MEM_NAME", width:"100", align:"center"},
                            {key:"MEM_DIV", label:"MEM_DIV", width:"100", align:"center",formatter: function () {
                                return '<input type="text" name="inputSelector" id="AXInputSelector"value="" class="AXInput" />';}
                            }
                    ];
                };
                myGrid.setConfig({
                    targetID : "AXGridTarget",
                    height:"auto",
                    colGroup : getColGroup(),
                    colHeadAlign: "center", // 헤드의 기본 정렬 값 ( colHeadAlign 을 지정하면 colGroup 에서 정의한 정렬이 무시되고 colHeadAlign : false 이거나 없으면 colGroup 에서 정의한 속성이 적용됩니다.
                    body : {
                        onclick: function(){
                           alert([this.c]);
                             toast.push(Object.values(this.item)[this.c]);
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
                myGrid.setList(<%=jsonJib%>, null, "reload");
                myGrid.setDataSet({});
                trace(myGrid.getSortParam());
            },

            //trace(myGrid.getSortParam());
        	deleteItem: function (index) {
            	$.Event(event).stopPropagation(); // 버튼클릭 이벤트가 row click 이벤트를 발생시키지 않도록 합니다.
            	var item = myGrid.list[index];
            	//List<JibnawaMemberVO> memDel = (List<JibnawaMemberVO>)request.setAttribute("test",$.param(item).dec());
            	//JSONObject jObject = new JSONObject();
            	//Object.toJSON(this.item);
            	//toast.push('deleteItem: ' + $.param(item).dec()[1]);
            
            	//var jObject = JSONValue.toJSONString(item);
            	var test = Object.values(item)[1];
            	location.href="./admin/memDelete.kosmo?mem_email="+test;
            	//location.href="./index.jsp";
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
    
    <div id=" grid0">
			<div  class="title">
				<h1>회원관리</h1>
			</div>

		    <div class="ax-search" id="page-search-box"></div>
			<div id="AXGridTarget"></div>

		</div>
    

		

