<%@ language="VBScript" CODEPAGE="65001" %>
<%
Session.CodePage  = 65001
Response.CharSet  = "UTF-8"
Response.AddHeader "Pragma","no-cache"
Response.AddHeader "cache-control", "no-staff"
Response.Expires  = -1

pageNo = request.form("pageNo")

%>
{
	result:"ok",
	list:[
		<% for z=1 to 20 %>
		{no:<%=pageNo%><%=z%>, title:"AXGrid ����° �� �Դϴ�.", writer:"��⿵", regDate:"2013-01-18", img:"img/<%=z%>.jpg", desc:"myGrid.setList �� ù��° ���� list json ���� ���� ��", price:123000, amount:2},
		<% next %>
	],
	page:{
		pageNo:<%=pageNo%>,
		<% if pageNo = 2 then %>
		pageCount:100,	
		<% else %>
		pageCount:200,	
		<% end if %>
		
		listCount:20
	},
	msg:""
}