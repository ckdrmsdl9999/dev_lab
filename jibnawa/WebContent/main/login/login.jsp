<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.net.URLDecoder, com.vo.JibnawaMemberVO"%>
<% JibnawaMemberVO login = (JibnawaMemberVO)session.getAttribute("login"); %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript"
	src="http://cdno.axisj.com/axisj/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="http://cdno.axisj.com/axisj/dist/AXJ.min.js"></script>

<style type="text/css">
.modalProgramTitle {
	height: 49px;
	line-height: 49px;
	color: #282828;
	font-size: 14px;
	font-weight: bold;
	padding-left: 15px;
	border-bottom: 1px solid #ccc;
}

.modalButtonBox {
	padding: 10px;
	border-top: 1px solid #ccc;
}
</style>
<script>
    /**
     * Require Files for AXISJ UI Component...
     * Based		: jQuery
     * Javascript 	: AXJ.js, AXModal.js
     * CSS			: AXJ.css
     */
    var pageID = "AXModal";
    var myModal = new AXModal();
	function test(){
		$("#login").attr("method","POST");
		$("#login").attr("action","./login.do");
		$("#login").submit();	
	}
</script>

	<%if(login==null){ %>
		<h1>로그인</h1>
		<form id="login">
			<span class="name">E-mail</span> <input type="text" name="mem_email"
				id="mem_email" placeholder="e-mail"></br> <span class="name">Password</span>
			<input type="text" name="mem_pw" id="mem_pw" placeholder="password">
			</br>

			<div class="ax-funcs">
				<button type="button" id="login_btn" onclick="test()"
					class="AXButtonLarge Blue">&nbsp;&nbsp;로그인&nbsp;&nbsp;</button>
			</div>
		</form>
	<% }else{%>
		<script type="text/javascript">	
			parent.location.reload();
		</script>
	<%  }%>



