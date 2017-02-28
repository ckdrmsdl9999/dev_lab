<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.net.URLDecoder, com.vo.JibnawaMemberVO,java.util.*"%>

<script type="text/javascript">
 function doSearch(){
	 
 }
 var pageID = "AXModal";
 var myModal = new AXModal();
 var fnObj = {
     pageStart: function () {
         myModal.setConfig({
             windowID: "myModalCT", width: 340,
             mediaQuery: {
                 mx: {min: 0, max: 367}, dx: {min: 367}
             },
             displayLoading: true,
             scrollLock: true
         });
     },
     login: function () {
         myModal.open({
				modalID:"modalDiv01",
				targetID:"modalContent",
             url: "login/login.jsp",
             
             //url:"/samples/AXgrid/index.html",
             pars: "a=false".queryToObject(),
             top: 100,
             closeByEscKey: true,
             options : function getReturnValue() {  

             },
             onclose: function(){
	
             }
         });
         
     },
     adminPage: function () {
    	 //Map adminPage = new HashMap();
		 //userInfo.put("page", "adminMain");
		 //request.setAttribute("adminPage", adminPage);
     },
     sigin: function () {
         myModal.open({
             url: "login/sigin.jsp",
             //url:"/samples/AXgrid/index.html",
             pars: "a=false".queryToObject(),
             top: 100,
             closeByEscKey: true,
             close: function close(){
            	 window.location.reload(true);
             }
         });
     },
     close: function () {
    	 myModal.close('modalDiv01');
     },
    
     acc_list: function () {
         myModal.open({
        	 //페이지 위치
             url: "../jibnawa/jibnawaMember.kosmo",
             //url:"/samples/AXgrid/index.html",
             pars: "a=1&b=2&c=3".queryToObject(),
             top: 100,
             width:800,
             closeByEscKey: true
         });
         
     }};

     function adminMainPage(){
      $.ajax({
        type : "POST",
        url : "admin/adminMain.jsp",
        dataType : "html",
        error : function() {
          alert('통신실패!!');
        },
        success : function(data) {
          $('#Context').html(data);
          window.location.reload(true);
        }
 
      });
    }
     function logOut(){
    	 <% session.invalidate(); %> 
    	 window.location.reload(true);
  	 }
</script>
<%	String login1=(String)request.getAttribute("loginChk");
if(login1=="true"){%>
	<script type="text/javascript">
	 var myModal = new AXModal();
	</script>
<%}%>
<%
   	Map userInfo  =(HashMap)request.getAttribute("userInfo");
    String mem_div =(String)userInfo.get("mem_div");
    String mem_nickname =(String)userInfo.get("mem_nickname");
	 if(mem_div=="c"){ %>
	 
		<div style="width: 100%;" align=center>
		<div class="bs-example" data-example-id="navbar-form">
			<nav class="navbar ">
				<div class="container-fluid"></div>
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" style="background-color: black"
							class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-2" aria-expanded="true">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Jibnawa</a>
					</div>
					<div class="navbar-collapse collapse in"
						id="bs-example-navbar-collapse-2" aria-expanded="true">
						<form class="navbar-form" style="text-align: center;" action = "index.jsp" 
							ole="search">							
							<div class="navbar-collapse collapse in"
								id="bs-example-navbar-collapse-2">
								<input type="text" class="form-control">
								<a type="" class="" id="login"
									style="margin-left: 10%;" ><%= mem_nickname %>관리자 님</a>
								<button type="button" class="btn btn-info"
									onclick="">입찰</button>
								<button type="button" class="btn btn-info" onclick="logOut()">로그아웃</button>
								<button type="button" class="btn btn-info" onclick="">회원탈퇴</button>
							</div>
						</form>
					</div>
				</div>
			</nav>
		</div>
	</div>
<%	}else if(mem_div=="a"){%>
	<div style="width: 100%;" align=center>
		<div class="bs-example" data-example-id="navbar-form">
			<nav class="navbar ">
				<div class="container-fluid"></div>
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" style="background-color: black"
							class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-2" aria-expanded="true">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Jibnawa</a>
					</div>
					<div class="navbar-collapse collapse in"
						id="bs-example-navbar-collapse-2" aria-expanded="true">
						<form class="navbar-form" style="text-align: center;" action = "index.jsp" 
							ole="search">							
							<div class="navbar-collapse collapse in"
								id="bs-example-navbar-collapse-2">
								<input type="text" class="form-control">
								<a type="" class="" id="login"
									style="margin-left: 10%;" ><%= mem_nickname %>관리자 님</a>
								<button type="button" class="btn btn-info"  name = "adminPage" id="join"
									onclick="adminMainPage()">관리자 메뉴</button>
								<button type="button" class="btn btn-info" onclick="logOut()">로그아웃</button>
								<button type="button" class="btn btn-info" onclick="">회원탈퇴</button>
							</div>

						</form>
					</div>
				</div>
			</nav>
		</div>
	</div>
<% }else if(mem_div=="m"){%>
	<div style="width: 100%;" align=center>
		<div class="bs-example" data-example-id="navbar-form">
			<nav class="navbar ">
				<div class="container-fluid"></div>
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" style="background-color: black"
							class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-2" aria-expanded="true">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Jibnawa</a>
					</div>
					<div class="navbar-collapse collapse in"
						id="bs-example-navbar-collapse-2" aria-expanded="true">
						<form class="navbar-form" style="text-align: center;" action = "index.jsp" 
							ole="search">							
							<div class="navbar-collapse collapse in"
								id="bs-example-navbar-collapse-2">
								<input type="text" class="form-control">
								<a type="" class="" id="login"
									style="margin-left: 10%;" ><%= mem_nickname %>관리자 님</a>
								<button type="button" class="btn btn-info"onclick="">경매내역</button>
								<button type="button" class="btn btn-info" onclick="logOut()">로그아웃</button>
								<button type="button" class="btn btn-info" onclick="">회원탈퇴</button>
							</div>
						</form>
					</div>
				</div>
			</nav>
		</div>
	</div>
<% }else{ %>
	<div style="width: 100%;" align=center>
		<div style="width: 100%;" align=center>
		<div class="bs-example" data-example-id="navbar-form">
			<nav class="navbar ">
				<div class="container-fluid"></div>
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" style="background-color: black"
							class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-2" aria-expanded="true">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Jibnawa</a>
					</div>
					<div class="navbar-collapse collapse in"
						id="bs-example-navbar-collapse-2" aria-expanded="true">
						<form class="navbar-form" style="text-align: center;" action = "index.jsp" 
							ole="search">							
							<div class="navbar-collapse collapse in"
								id="bs-example-navbar-collapse-2">
								<input type="text" class="form-control">

								<button type="button" class="btn btn-info"onclick="fnObj.login()">로그인</button>
								<button type="button" class="btn btn-info" onclick="fnObj.sigin()">회원가입</button>
							</div>
						</form>
					</div>
				</div>
			</nav>
		</div>
	</div>
	</div>
<%}%>
<div id="Context">