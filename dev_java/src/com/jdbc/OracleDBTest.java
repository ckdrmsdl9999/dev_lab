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
 * ����Ŭ ������ �ڹ��ڵ带 Ȱ���Ͽ� ������ ����
 * 1.����̹� Ŭ������ �ε��Ѵ�.
 * 2.���������� ������ �ִ� ������ ������θ� Ȯ���Ѵ�.
 *   IP�ּ�, PORT, SID
 * 3.�������� ������ ����Ŭ ������ �� ���ɰ�ü�� �����Ѵ�.
 * 4.����Ŭ�������� ó�� ��û�Ѵ�.
 * 5.����Ŭ �������� ó���� ����� ���    
 ******************************************************************************/
public class OracleDBTest {

	public static void main(String[] args) {
	//��������
		final String _URL = "jdbc:oracle:thin:@192.168.0.46:1522:orcl11";
		final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
		final String _USER = "scott";
		final String _PW = "tiger";
		String sql = "SELECT deptno, dname, loc FROM dept";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs   = null;
		try {
			//����̹�Ŭ������ �޸𸮿� �ø���.
			Class.forName(_DRIVER);
			//������� Ȯ���ϱ�
			con = DriverManager.getConnection
										(_URL, _USER, _PW);
			//���ɰ�ü �޸𸮿� �ε��ϱ�
			stmt = con.createStatement();
			//SELECT�� ó�� ��û �޼ҵ�
			//ResultSet�� ����Ŭ�� Ŀ���� �����ϴµ� �ʿ��� �޼ҵ带 �����ϰ� �ִ�.
			rs = stmt.executeQuery(sql);
			//rs.next();//�޼ҵ� ȣ��-����Ÿ��:boolean
			//System.out.println("======>"+rs.getString(2));
			//rs.next();
			DeptVO dvos[] = null;//������ �ο츦 ���� �� �ִ�.
			DeptVO dvo = null;//�� ���ο츦 ��� ��ü
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












