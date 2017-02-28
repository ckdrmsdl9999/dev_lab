package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.util.DBConnectionMgr;
import com.vo.DeptVO;

/*******************************************************************************
 * 오라클 서버에 자바코드를 활용하여 접속해 보기
 * 1.드라이버 클래스를 로딩한다.
 * 2.물리적으로 떨어져 있는 서버와 연결통로를 확보한다.
 *   IP주소, PORT, SID
 * 3.쿼리문을 가지고 오라클 서버로 갈 전령객체를 생성한다.
 * 4.오라클서버에게 처리 요청한다.
 * 5.오라클 서버에서 처리된 결과를 출력    
 ******************************************************************************/
public class OracleDBTest {

	public static void main(String[] args) {
	//변수선언
		final String _URL = "jdbc:oracle:thin:@192.168.0.46:1522:orcl11";
		final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
		final String _USER = "scott";
		final String _PW = "tiger";
		String sql = "SELECT deptno, dname, loc FROM dept";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs   = null;
		try {
			//드라이버클래스를 메모리에 올리기.
			Class.forName(_DRIVER);
			//연결통로 확보하기
			con = DriverManager.getConnection
										(_URL, _USER, _PW);
			//전령객체 메모리에 로딩하기
			stmt = con.createStatement();
			//SELECT문 처리 요청 메소드
			//ResultSet은 오라클의 커서를 조작하는데 필요한 메소드를 소유하고 있다.
			rs = stmt.executeQuery(sql);
			//rs.next();//메소드 호출-리턴타입:boolean
			//System.out.println("======>"+rs.getString(2));
			//rs.next();
			DeptVO dvos[] = null;//여러개 로우를 담을 수 있다.
			DeptVO dvo = null;//한 개로우를 담는 객체
			Vector v = new Vector();
			while(rs.next()){
				dvo = new DeptVO();
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				dvo.setDeptno(deptno);
				dvo.setDname(dname);
				dvo.setLoc(loc);
				//System.out.println(deptno+" , "+dname+" , "+loc);
				v.add(dvo);
			}
			dvos = new DeptVO[v.size()]; 
			v.copyInto(dvos);
			for(int i=0;i<dvos.length;i++){
				DeptVO dbvo = dvos[i];
				System.out.println(dbvo.getDeptno()+" , "+dbvo.getDname()+" , "+dbvo.getLoc());
			}
		} catch (SQLException se) {
			System.out.println("[query] = "+sql);
			System.out.println(se.toString());
		} catch (Exception e){
			System.out.println(e.toString());
			e.printStackTrace();
		} finally{
			try {
				DBConnectionMgr.freeConnection(con, stmt, rs);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}












