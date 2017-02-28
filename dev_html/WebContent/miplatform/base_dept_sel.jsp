<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*, com.util.DBConnectionMgr" %>   
<%@ page import="com.tobesoft.platform.*" %> 
<%@ page import="com.tobesoft.platform.data.*" %> 
<%! //디클러레이션 - 전역변수, 메소드선언
	public String rsGet(ResultSet rs, String id) throws Exception
	{
		if(rs.getString(id)==null) return "";
		else return rs.getString(id);
	}
%>
<% //스크립틀릿
    //자바에서 일어난 에러메시지들을 마이플랫폼 화면에서 확인할 때
	VariableList vl = new VariableList();//마이플랫폼에서 제공객체
	//마이플랫폼에서 제공하는 Dataset을 담을 수 있는 객체 제공.
	DatasetList dl =new DatasetList();
	String char_set = "utf-8";
	//JDBC API를 활용하여 DB연동하기
	/*********** JDBC Connection ************/
	Connection 			con 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet				rs			= null;
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	StringBuilder sql = new StringBuilder();
	sql.append("SELECT deptno, dname, loc FROM dept");
	try{
	con = dbMgr.getConnection();
	pstmt = con.prepareStatement(sql.toString());
	rs = pstmt.executeQuery();
	/************* Dataset 생성 ***************/
	Dataset ds_dept = new Dataset("ds_dept",char_set);
	/************* Dataset header 초기화 ***************/
	ds_dept.addColumn("deptno", ColumnInfo.CY_COLINFO_INT, 10);
	ds_dept.addColumn("dname", ColumnInfo.CY_COLINFO_STRING, 40);
	ds_dept.addColumn("loc", ColumnInfo.CY_COLINFO_STRING, 40);
	while(rs.next()){
		int row = ds_dept.appendRow();
		ds_dept.setColumn(row, "deptno", new Variant(rsGet(rs,"deptno")));
		ds_dept.setColumn(row, "dname", new Variant(rsGet(rs,"dname")));
		ds_dept.setColumn(row, "loc", new Variant(rsGet(rs,"loc")));
	}
	/**************** 생성된 Dataset을 DatasetList 추가 ****************/
	dl.addDataset("ds_dept", ds_dept);
	/**************** 변수를 VariableList에 추가 ****************/
	vl.addStr("ErrorCode", "0");
	vl.addStr("ErrorMsg","SUCCESS");
	}catch(SQLException se){
		
	}catch(Exception e){
		
	}finally{
		DBConnectionMgr.freeConnection(con, pstmt, rs);
	}
	/************* 결과 xml생성 및 Web Server로 보내기 ************/
	out.clear();
	out = pageContext.pushBody();
	out.clearBuffer();
	PlatformResponse pRes = 
			new PlatformResponse(response
					                         ,PlatformRequest.XML
					                         ,char_set);
	pRes.sendData(vl,dl);
%> 



