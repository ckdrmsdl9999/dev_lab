package com.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.util.LinuxDBConnectionMgr;

/******************************************************************************************
 * �ν��Ͻ�ȭ
 * A a = new A();
 * A a = �޼ҵ��̸�();
 * 
 * A �޼ҵ��̸�(){}
 *
 *****************************************************************************************/
public class LinuxDBTest {

	public static void main(String[] args) {
		//LinuxDBConnectionMgr dbMgr = new LinuxDBConnectionMgr();
		LinuxDBConnectionMgr dbMgr = LinuxDBConnectionMgr.getInstance();
		String sql = "SELECT employee_id, first_name, last_name FROM employees";
		try {
			Connection con =dbMgr.getConnection();
			Statement stmt = con.createStatement();//�������� ������ �� ���� ����
		//ResultSet�� Ŀ���� �����ϴµ� �ʿ��� �޼ҵ带 �����ϰ� �ֽ��ϴ�.
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
