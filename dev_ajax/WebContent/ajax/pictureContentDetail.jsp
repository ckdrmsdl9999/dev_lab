<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%@page import="java.util.List, com.vo.PictureVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1" borderColor="orange" width="400px">
<%   List<PictureVO> pictureDetail = (List<PictureVO>) request.getAttribute("pictureDetail"); 

PictureVO pVO = null;
PictureVO rpVO = pictureDetail.get(0);



%>
<tr>
<td width="200px" ><%=rpVO.getContent() %></td>
<td width="200px"><img src="<%=rpVO.getImgFile() %> " width="200" height="200"/></td>
</tr>

<tr>
<td colspan="2" align="right">
<input type="button" value="닫기" onClick="subClose()">
</td>
</tr>


</table>

</body>
</html>