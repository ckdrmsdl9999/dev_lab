<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.List,com.vo.jibnawaSubidVO,java.util.HashMap"%>
<%@page import="com.google.gson.Gson"%>
<%
List<HashMap<String,Object>>suList=
(List<HashMap<String,Object>>)request.getAttribute("suList");
Gson g = new Gson();
String jsonsubid= g.toJson(suList);
out.print(jsonsubid);
%>