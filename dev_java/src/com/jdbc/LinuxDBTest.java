package com.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.util.LinuxDBConnectionMgr;

/******************************************************************************************
 * 인스턴스화
 * A a = new A();
 * A a = 메소드이름();
 * 
 * A 메소드이름(){}
 *
 *****************************************************************************************/
public class LinuxDBTest {

	public static void main(String[] args) {
		//LinuxDBConnectionMgr dbMgr = new LinuxDBConnectionMgr();
		LinuxDBConnectionMgr dbMgr = LinuxDBConnectionMgr.getInstance();
		String sql = "SELECT employee_id, first_name, last_name FROM employees";
		try {
			Connection con =dbMgr.getConnection();
			Statement stmt = con.createStatement();//쿼리문을 가지고 갈 전령 생성
		//ResultSet은 커서를 조작하는데 필요한 메소드를 정의하고 있습니다.
		//next(), previous(), isFirst():boolean, isLast():boolean, absolute(3)
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getInt("employee_id")+", "
			                      +rs.getString("first_name")+", "
						          +rs.getString("last_name"));
			}
		} catch (Exception e) {
			System.out.println("Exception : "+e.toString());
		}
		
	}

}
