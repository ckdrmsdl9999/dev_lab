<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.HashMap, org.json.simple.JSONValue
,com.google.gson.Gson" %>
<%
	List<HashMap<String,Object>> RegioncodeList = 
	(List<HashMap<String,Object>>)request.getAttribute("RegioncodeList");
	Gson g = new Gson();
	String jsonJibnawa = JSONValue.toJSONString(RegioncodeList);
	out.print(jsonJibnawa);
%>
