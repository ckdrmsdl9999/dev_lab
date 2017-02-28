<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.HashMap" %> 
<%@ page import="org.json.simple.JSONValue" %>   
<%



List<HashMap> commonList = 
//getAttribute("jibnawaMember"); 는  controller.java 에서 //pMap.addAttribute("jibnawaMember",jibnawaMember);과 동일하게 맞추기
(List<HashMap>)request.getAttribute("commonList");

	String jsonZipcode = JSONValue.toJSONString(commonList);
	out.print(jsonZipcode);
%>