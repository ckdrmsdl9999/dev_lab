<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, com.vo.BookVO, java.util.ArrayList" %>    
<style type="text/css">


</style>

<table border="1"> 

<%
	List<BookVO> bookList = (List<BookVO>)request.getAttribute("bookList");
	//�˻������ �ִ�?
	if(bookList !=null){
	
			BookVO rbVO = bookList.get(0);
%>





<tr>
<td width="50px"  rowspan="4">�̹���</td>
<td width="150px">���� : <%=rbVO.getAb_author() %></td>
</tr>
<tr>
<td>���ǻ� : <%=rbVO.getAb_publisher() %></td>
</tr>
<tr>
<td>���� : <%=rbVO.getAb_price() %> �� </td>

<tr>
<td colspan="2" align="right">
<input type="button" value="�ݱ�" onClick="subClose()">
</td>
</tr>
<%
	
	}/////////////end of if

%>	

</table>
