<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.List,com.vo.jibnawaTenderVO,java.util.HashMap"%>
<%@page import="com.google.gson.Gson"%>
<%
List<HashMap<String,Object>>tenderList=
(List<HashMap<String,Object>>)request.getAttribute("tenderList");
Gson g = new Gson();
String jsontender= g.toJson(tenderList);
out.print(jsontender);
%>