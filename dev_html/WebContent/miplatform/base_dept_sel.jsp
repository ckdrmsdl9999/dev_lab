<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*, com.util.DBConnectionMgr" %>   
<%@ page import="com.tobesoft.platform.*" %> 
<%@ page import="com.tobesoft.platform.data.*" %> 
<%! //��Ŭ�����̼� - ��������, �޼ҵ弱��
	public String rsGet(ResultSet rs, String id) throws Exception
	{
		if(rs.getString(id)==null) return "";
		else return rs.getString(id);
	}
%>
<% //��ũ��Ʋ��
    //�ڹٿ��� �Ͼ �����޽������� �����÷��� ȭ�鿡�� Ȯ���� ��
	VariableList vl = new VariableList();//�����÷������� ������ü
	//�����÷������� �����ϴ� Dataset�� ���� �� �ִ� ��ü ����.
	DatasetList dl =new DatasetList();
	String char_set = "utf-8";
	//JDBC API�� Ȱ���Ͽ� DB�����ϱ�
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
	/************* Dataset ���� ***************/
	Dataset ds_dept = new Dataset("ds_dept",char_set);
	/************* Dataset header �ʱ�ȭ ***************/
	ds_dept.addColumn("deptno", ColumnInfo.CY_COLINFO_INT, 10);
	ds_dept.addColumn("dname", ColumnInfo.CY_COLINFO_STRING, 40);
	ds_dept.addColumn("loc", ColumnInfo.CY_COLINFO_STRING, 40);
	while(rs.next()){
		int row = ds_dept.appendRow();
		ds_dept.setColumn(row, "deptno", new Variant(rsGet(rs,"deptno")));
		ds_dept.setColumn(row, "dname", new Variant(rsGet(rs,"dname")));
		ds_dept.setColumn(row, "loc", new Variant(rsGet(rs,"loc")));
	}
	/**************** ������ Dataset�� DatasetList �߰� ****************/
	dl.addDataset("ds_dept", ds_dept);
	/**************** ������ VariableList�� �߰� ****************/
	vl.addStr("ErrorCode", "0");
	vl.addStr("ErrorMsg","SUCCESS");
	}catch(SQLException se){
		
	}catch(Exception e){
		
	}finally{
		DBConnectionMgr.freeConnection(con, pstmt, rs);
	}
	/************* ��� xml���� �� Web Server�� ������ ************/
	out.clear();
	out = pageContext.pushBody();
	out.clearBuffer();
	PlatformResponse pRes = 
			new PlatformResponse(response
					                         ,PlatformRequest.XML
					                         ,char_set);
	pRes.sendData(vl,dl);
%> 



