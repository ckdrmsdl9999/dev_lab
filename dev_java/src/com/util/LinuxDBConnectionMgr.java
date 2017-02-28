package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class LinuxDBConnectionMgr {
	final String _URL 		= "jdbc:oracle:thin:@192.168.0.69:1521:xe";
	final String _DRIVER 	= "oracle.jdbc.driver.OracleDriver";
	final String _USER 		= "hr";
	final String _PW 		= "tiger";
	Connection con = null;//물리적으로 떨어져 있는 DB서버와 연결통로 확보할 때
	static LinuxDBConnectionMgr dbMgr = null;
	public static LinuxDBConnectionMgr getInstance(){
		if(dbMgr == null) dbMgr = new LinuxDBConnectionMgr();
		return dbMgr;
	}
	public Connection getConnection(){
		try {
			Class.forName(_DRIVER);
			con = DriverManager.getConnection(_URL, _USER, _PW);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return con;
	}
}
