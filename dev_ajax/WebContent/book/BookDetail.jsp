<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, com.vo.BookVO, java.util.ArrayList" %>    
<style type="text/css">


</style>

<table border="1"> 

<%
	List<BookVO> bookList = (List<BookVO>)request.getAttribute("bookList");
	//검색결과가 있니?
	if(bookList !=null){
	
			BookVO rbVO = bookList.get(0);
%>





<tr>
<td width="50px"  rowspan="4">이미지</td>
<td width="150px">저자 : <%=rbVO.getAb_author() %></td>
</tr>
<tr>
<td>출판사 : <%=rbVO.getAb_publisher() %></td>
</tr>
<tr>
<td>가격 : <%=rbVO.getAb_price() %> 원 </td>

<tr>
<td colspan="2" align="right">
<input type="button" value="닫기" onClick="subClose()">
</td>
</tr>
<%
	
	}/////////////end of if

%>	

</table>
