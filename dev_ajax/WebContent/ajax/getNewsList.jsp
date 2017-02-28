<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, com.vo.NewsVO" %>
<%!
	int x = 1;
	public String loopProcess(String[] list){
		StringBuilder sb = new StringBuilder();
		sb.append("<table border='1'>");
		for(int i=0;i<list.length;i++){
			sb.append(list[i]);
			//sb.append("<tr><td>"+list[i]+"</td></tr>");
		}
		sb.append("</table>");
		return sb.toString();
	}
%>
<%
	List<NewsVO> newsList = (List<NewsVO>)request.getAttribute("newsList");
/* 	String news1 [] = {"1","2","3"};
	String news2 [] = {"4","5","6"};
	String news3 [] = {"7","8","9"}; */
	String news1 [] = new String[3];
	String news2 [] = new String[3];
	String news3 [] = new String[3];
	//insert here
	int i1=0;
	int i2=0;
	int i3=0;	
	for(int i=0;i<newsList.size();i++){
		NewsVO nvo = newsList.get(i);
		if(i1<3){
			news1[i1] = "<tr>";
			if(nvo.getN_img()!=null && nvo.getN_img().length()>1){
				news1[i1]+="<td><img width='50' height='75' src='../images/"+nvo.getN_img()+"'></td>";
			}else{
				news1[i1]+="<td>&nbsp;</td>";
			}
			news1[i1]+="<td>"+nvo.getN_title()+"["+nvo.getN_writer()+"]</td></tr>";
			i1++;
		}
 		else if(i2<3){
			news2[i2] = "<tr>";
			if(nvo.getN_img()!=null && nvo.getN_img().length()>1){
				news2[i2]+="<td><img width='50' height='75' src='../images/"+nvo.getN_img()+"'></td>";
			}else{
				news2[i2]+="<td>&nbsp;</td>";
			}
			news2[i2]+="<td>"+nvo.getN_title()+"["+nvo.getN_writer()+"]</td></tr>";
			i2++;
		}
		else if(i3<3){
			news3[i3] = "<tr>";
			if(nvo.getN_img()!=null && nvo.getN_img().length()>1){
				news3[i3]+="<td><img width='50' height='75' src='../images/"+nvo.getN_img()+"'></td>";
			}else{
				news3[i3]+="<td>&nbsp;</td>";
			}
			news3[i3]+="<td>"+nvo.getN_title()+"["+nvo.getN_writer()+"]</td></tr>";
			i3++;
		}
	}///////////////////// end of for ///////////////////
	
	//out.print(nvo.getN_title()+"<br>");//제목1, 제목2, 제목3
	String outStr = "";
	switch(x){
	case 1:{
		outStr = loopProcess(news1);
		x++;
		break;
	}
	case 2:{
		outStr = loopProcess(news2);
		x++;
		break;
	}
	case 3:{
		outStr = loopProcess(news3);
		x++;
		break;
	}	
	default:{
		x = 1;
		break;
	}
	}//// end of switch
	out.clear();//출력버퍼에 담긴 내용을 비운다.- 8kb
	out.print(outStr);//브라우저에 쓰기-브라우저가 인터프리터한다.
%>