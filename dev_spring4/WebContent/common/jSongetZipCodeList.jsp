<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.HashMap" %> 
<%@ page import="org.json.simple.JSONValue" %>   
<%



List<HashMap> commonList = 
//getAttribute("jibnawaMember"); ��  controller.java ���� //pMap.addAttribute("jibnawaMember",jibnawaMember);�� �����ϰ� ���߱�
(List<HashMap>)request.getAttribute("commonList");

	String jsonZipcode = JSONValue.toJSONString(commonList);
	out.print(jsonZipcode);
%>