<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript">
	alert("등록되었습니다.");
	opener.parent.location.href="./getDeptList.jsp";
	self.close();
</script>