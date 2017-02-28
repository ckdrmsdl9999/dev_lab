package com.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class DBConnectionMgr {
	final String _URL 		= "jdbc:oracle:thin:@192.168.0.39:1521:orcl";
	final String _DRIVER 	= "oracle.jdbc.driver.OracleDriver";
	final String _USER 		= "scott";
	final String _PW 		= "tiger";
	Connection con = null;//물리적으로 떨어져 있는 DB서버와 연결통로 확보할 때
	public Connection getConnection(){
		try {
			Class.forName(_DRIVER);//ClassNotFoundException
			con = DriverManager.getConnection(_URL, _USER, _PW);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return con;
	}
	//사용한 자원 반납하기
	//자원 반납할 때는 생성한 역순으로 반납합니다.
	//Statement(정적쿼리문), PreparedStatement(동적쿼리문), CallableStatement(프로시저시)
	//select일 때 자원 반납하기
	public static void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs){
		try {
			if(rs!=null) rs.close();
			if(pstmt !=null) pstmt.close();
			if(con !=null) con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void freeConnection(Connection con, PreparedStatement pstmt){
		try {
			if(pstmt !=null) pstmt.close();
			if(con !=null) con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}		
	public static void freeConnection(Connection con, Statement stmt, ResultSet rs){
		try {
			if(rs!=null) rs.close();
			if(stmt !=null) stmt.close();
			if(con !=null) con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void freeConnection(Connection con, Statement stmt){
		try {
			if(stmt !=null) stmt.close();
			if(con !=null) con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}	
}









