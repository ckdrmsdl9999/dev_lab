<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List" %> 
<%@ page import="com.google.gson.Gson" %>   
<%
	List<HashMap<String,Object>> mlocalList = 
	(List<HashMap<String,Object>>)request.getAttribute("mainLocal");
	Gson g = new Gson();
	String gsonDept = g.toJson(mlocalList);
	out.print(gsonDept);
%>