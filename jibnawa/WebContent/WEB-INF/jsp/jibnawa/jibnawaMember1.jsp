<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, com.jibnawa.member.JibnawaMemberVO"%>
<%@ page import="org.json.simple.JSONValue"%>
<%
	List<JibnawaMemberVO> jibnawaMember = 
	(List<JibnawaMemberVO>)request.getAttribute("jibnawaMember");
	String jsonJib = JSONValue.toJSONString(jibnawaMember);
	out.print(jsonJib);
%>
<title>Insert title here</title>
</head>
<body>111111111111111111111111111
</body>
</html>