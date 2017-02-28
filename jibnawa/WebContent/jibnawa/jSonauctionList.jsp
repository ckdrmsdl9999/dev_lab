<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.List,com.vo.jibnawaAuctionVO,java.util.HashMap"%>
<%@page import="com.google.gson.Gson"%>
<%
List<HashMap<String,Object>> auctionList =(List<HashMap<String,Object>>)request.getAttribute("auctionList");
Gson g = new Gson();
String jsonauctionList= g.toJson(auctionList);
out.print(jsonauctionList);
%>