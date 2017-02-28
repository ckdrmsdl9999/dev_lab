<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.net.URLDecoder"%>
<%
	boolean sigin = false;
	String cname = null;//서버에서 로컬 PC에 저장해둔 쿠키 문서에서 읽어온 사용자 이름을 담을 변수
	boolean mailChk = false;//서버에서 로컬 PC에 저장해둔 쿠키 문서에서 읽어온 사용자 이름을 담을 변수
	Cookie[] cookies = request.getCookies();
	if(cookies !=null && cookies.length > 0){
		for(int i=0;i<cookies.length;i++){
			if("cname".equals(cookies[i].getName())){
				cname = URLDecoder.decode(cookies[i].getValue(),"utf-8");
			}
			if("mailChk".equals(cookies[i].getName())){
				String mail = URLDecoder.decode(cookies[i].getValue(),"utf-8");
				mailChk= Boolean.valueOf(mail).booleanValue();
				
			}
			if("sigin".equals(cookies[i].getName())){
				String siginChk = URLDecoder.decode(cookies[i].getValue(),"utf-8");
				sigin= Boolean.valueOf(siginChk).booleanValue();
				if(sigin==true){ %>
					<script type="text/javascript">
						parent.myModal.close();
					</script>
				<%}
			}
		}
	}
	out.print("쿠키에 담은 이름 : "+mailChk);
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="../../js/jquery-1.11.1.js"></script>
<title>SIGIN</title>
<script type="text/javascript">
//function sigin(){ 
//	$("#sigin_form").attr("method","post");
//	$("#sigin_form").attr("action","./sigin.do");
//	$("#sigin_form").submit();
	//	alert("==========================");
	/*
		var str = $("#sigin_form").serialize();
		alert(str);

		$.ajax({
			type:"POST",
			url:"./sigin.do",
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			data: str,
			datatype:"json",
			success: function(data) {
				alert(data.result);			
			},
			error: function(e) {
				alert("에러발생");
			}			
		});
		*/

//}
</script>
</head>
<body>
	<script type="text/javascript">
	
	//$(document).ready(function (){
	//		$("#mail_chk_btn").click(function (){
	//			alert("============");
	//		$("#mail_chk").attr("method","get");
	//		$("#mail_chk").attr("action","./sigin.do");
	//		$("#mail_chk").submit();//전송 index.jsp -> MemberFrontController(doService:logout.mfc식별)			
	//	});
	//});
		function b_search(){
		$("#mail_chk").attr("method","POST");
		$("#mail_chk").attr("action","./sigin.do");
		$("#mail_chk").submit();		
	}
		function sigin(){
			$("#sigin").attr("method","POST");
			$("#sigin").attr("action","./sigin.do");
			$("#sigin").submit();		
		}
</script>
	<%
//로그인을 하기 전 화면
//쿠키에서 읽어온 이름이 없니?
	//if(cname ==null)
	//{
		if(mailChk==false||cname==null ){
%>
	<h1>메일확인</h1>
	<form id="mail_chk">
		<span class="name">E-mail</span> <input type="text" name="mem_email"
			id="mem_email" placeholder="e-mail"> <input type="button"
			onclick="b_search()" id="mail_chk_btn" value="메일확인">
	</form>
	<%
	
		}else if(mailChk==true||cname!=null){ %>

	<h1>회원가입</h1>
	<form id="sigin">
		<span class="name">E-mail</span> <input type="text" name="mem_email"
			id="mem_email" placeholder="e-mail"></br> <span class="name">Password</span>
		<input type="text" name="mem_pw" id="mem_pw" placeholder="password">
		</br> <span class="name">mem_name</span> <input type="text" name="mem_name"
			id="mem_name" placeholder=""> </br> <span class="name">mem_nickname</span>
		<input type="text" name="mem_nickname" id="mem_nickname"
			placeholder=""></br> <span class="name">mem_div</span> <input
			type="text" name="mem_div" id="mem_div" placeholder=""> </br> <span
			class="name">mem_phone</span> <input type="text" name="mem_phone_f"
			size="4" id="mem_phone_f" placeholder="">- <input type="text"
			name="mem_phone_m" size="4" id="mem_phone_m" placeholder="">-
		<input type="text" name="mem_phone_e" size="4" id="mem_phone_e"
			placeholder=""></br> <input type="button" onclick="sigin()"
			id="sigin_btn" value="회원가입">
	</form>
	<%}%>

</body>
</html>