

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, com.vo.BookVO" %> 
<%@ page import="com.google.gson.Gson" %>    
<%
	List<BookVO> bookList = 
	(List<BookVO>)request.getAttribute("bookList");
	Gson g = new Gson();
	String jsonBook = g.toJson(bookList);
	out.print(jsonBook);
%>