<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.net.URLDecoder"%>
<%
	boolean sigin = false;
	String cname = null;//�������� ���� PC�� �����ص� ��Ű �������� �о�� ����� �̸��� ���� ����
	boolean mailChk = false;//�������� ���� PC�� �����ص� ��Ű �������� �о�� ����� �̸��� ���� ����
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
	out.print("��Ű�� ���� �̸� : "+mailChk);
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
				alert("�����߻�");
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
	//		$("#mail_chk").submit();//���� index.jsp -> MemberFrontController(doService:logout.mfc�ĺ�)			
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
//�α����� �ϱ� �� ȭ��
//��Ű���� �о�� �̸��� ����?
	//if(cname ==null)
	//{
		if(mailChk==false||cname==null ){
%>
	<h1>����Ȯ��</h1>
	<form id="mail_chk">
		<span class="name">E-mail</span> <input type="text" name="mem_email"
			id="mem_email" placeholder="e-mail"> <input type="button"
			onclick="b_search()" id="mail_chk_btn" value="����Ȯ��">
	</form>
	<%
	
		}else if(mailChk==true||cname!=null){ %>

	<h1>ȸ������</h1>
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
			id="sigin_btn" value="ȸ������">
	</form>
	<%}%>

</body>
</html>