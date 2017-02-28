package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConnectionMgr;
import com.vo.MemberVO;

public class MemberCRUD {
	Connection con = null;//������� 
	PreparedStatement pstmt = null;//SQL�� ����
	ResultSet rs = null;
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	//ȸ������ �����ϱ�
	//�����ڵ� - VO���� ����
	public int memberInsert(String mem_id, String mem_pw, String mem_name, String mem_tel){
		int result = 0;//row�� �߰��Ǿ��� �� ���ϰ�.
		con = dbMgr.getConnection();//DBConnectionMgr�� getConnection()ȣ���ϱ�
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO SCOTT.member(no,mem_id,mem_pw,mem_name,mem_tel)");
		sql.append(" VALUES(seq_member_no.nextval,?,?,?,?)");
		try {
			pstmt = con.prepareStatement(sql.toString());//DB���� sql����
			int i=1;
			pstmt.setString(i++, mem_id);
			pstmt.setString(i++, mem_pw);
			pstmt.setString(i++, mem_name);
			pstmt.setString(i++, mem_tel);
			result = pstmt.executeUpdate();
			if(result ==1) System.out.println("���� ����");
		} catch (SQLException se) {
			System.out.println("[[query]]"+sql);
		} finally{
			DBConnectionMgr.freeConnection(con, pstmt);
		}
		return result;
	}
	/************************************************************************************
	 * ȸ����� ��ȸ�ϱ�
	 * @return List<MemberVO>
	 * �ۼ��� : ����
	 * ��  �� : ȸ�����Ե� ȸ������ ����� �����ɴϴ�.
	 ***********************************************************************************/
	public List<MemberVO> getMemberList()
	{
		List<MemberVO> memList = new ArrayList<MemberVO>();
		con = dbMgr.getConnection();
		StringBuilder sql = new StringBuilder();
		//ORM�ַ�� - xml������ �����Ѵ�. ��? ������������. ������������, sql���� ���� ����
		sql.append("SELECT no, mem_id, mem_pw, mem_name, mem_tel FROM member");
		try {
			//PreparedStatement pstmt = new PreparedStatement();
			pstmt = con.prepareStatement(sql.toString());
			//ResultSet rs = new ResultSet();
			//ResultSet���� Ŀ���� ������ �� �ִ�.
			//�������̽��� �߻�޼ҵ带 ������ �ִ�.
			//rs.next():boolean -Ŀ���� �������� �̵����ּ���.
			//rs.previous(), rs.isFirst():boolean, rs.absolute(3);, rs.isLast(),,,,
			//Ŀ���� �����Ͽ� �޸𸮿� �÷��� �ο��������� �����(�ڷᱸ��:List,Map)�� ��´�.
			rs = pstmt.executeQuery();
			MemberVO mvo = null;///VO�ȿ��� ������ ����Ǿ� �ִ�. �ѹ��� �ѰǸ� ���� �� �ִ�.
			/********** �ڷᱸ���� ��� ���� ���� *********/
			while(rs.next()){
				mvo = new MemberVO();
				mvo.setNo(rs.getInt("no"));
				mvo.setMem_id(rs.getString("mem_id"));
				mvo.setMem_pw(rs.getString("mem_pw"));
				mvo.setMem_name(rs.getString("mem_name"));
				mvo.setMem_tel(rs.getString("mem_tel"));
				memList.add(mvo);
			}
			/********** �ڷᱸ���� ��� ���� �� *********/
			System.out.println("�ο� �� : "+memList.size());
		} catch (SQLException se) {
			System.out.println("[[query]]"+sql);
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			DBConnectionMgr.freeConnection(con, pstmt, rs);
		}
		printMemberList(memList);
		return memList;
	}
	//Ŀ�� �����ϱ�
	public int memberSize(){
		int rowcount = 0;
		con = dbMgr.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT no, mem_id, mem_pw, mem_name, mem_tel FROM member");
		try {
			//TYPE_SCROLL_SENSITIVE - Ŀ���� ���������� �̵�
			//TYPE_SCROLL_INSENSITIVE - Ŀ���� ����������� �̵�
			//CONCUR_UPDATABLE - update���� ������� �ʰ� ���� ���� ������ �� �ִ�.
			pstmt = con.prepareStatement(sql.toString()
					                    ,ResultSet.TYPE_SCROLL_SENSITIVE
					                    ,ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();//Ŀ���� ��ġ�� ���̺� top�� ��ġ�Ѵ�.	
			rs.last();//Ŀ���� ��ġ�� �Ѱ��ο쾿 �̵��Ͽ� �� ������ ����.
			rowcount = rs.getRow();
			rs.beforeFirst();//Ŀ���� ��ġ�� ���� ��� �̵���Ŵ.
			System.out.println(rowcount);
		}catch(Exception e){
		}finally{
			DBConnectionMgr.freeConnection(con, pstmt, rs);
		}
		return rowcount;
	}
	//List -> MemberVO -> mem_id, mem_pw, mem_name.....
	public void printMemberList(List<MemberVO> memList){
		for(int i=0;i<memList.size();i++){//List
			MemberVO mvo = memList.get(i);
			//Console�� ����ϱ�
			//JTable - DefaultTableModel
			//MiplatForm -  DataSet
			//Grid
			//HTML
			System.out.println(mvo.getMem_id()+", "+mvo.getMem_name());
		}
	}
	public static void main(String[] args) {
		MemberCRUD mCRUD = new MemberCRUD();
		//mCRUD.memberInsert("haha", "123", "������", "02-456-7852");
		//mCRUD.getMemberList();
		System.out.println("�ο��� �� : "+mCRUD.memberSize());
	}

}








