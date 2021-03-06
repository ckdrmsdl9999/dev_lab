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
	Connection con = null;//연결통로 
	PreparedStatement pstmt = null;//SQL문 전달
	ResultSet rs = null;
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	//회원가입 구현하기
	//개선코드 - VO패턴 적용
	public int memberInsert(String mem_id, String mem_pw, String mem_name, String mem_tel){
		int result = 0;//row가 추가되었을 때 리턴값.
		con = dbMgr.getConnection();//DBConnectionMgr의 getConnection()호출하기
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO SCOTT.member(no,mem_id,mem_pw,mem_name,mem_tel)");
		sql.append(" VALUES(seq_member_no.nextval,?,?,?,?)");
		try {
			pstmt = con.prepareStatement(sql.toString());//DB서버 sql전달
			int i=1;
			pstmt.setString(i++, mem_id);
			pstmt.setString(i++, mem_pw);
			pstmt.setString(i++, mem_name);
			pstmt.setString(i++, mem_tel);
			result = pstmt.executeUpdate();
			if(result ==1) System.out.println("삽입 성공");
		} catch (SQLException se) {
			System.out.println("[[query]]"+sql);
		} finally{
			DBConnectionMgr.freeConnection(con, pstmt);
		}
		return result;
	}
	/************************************************************************************
	 * 회원목록 조회하기
	 * @return List<MemberVO>
	 * 작성자 : 김용관
	 * 설  명 : 회원가입된 회원들의 명단을 가져옵니다.
	 ***********************************************************************************/
	public List<MemberVO> getMemberList()
	{
		List<MemberVO> memList = new ArrayList<MemberVO>();
		con = dbMgr.getConnection();
		StringBuilder sql = new StringBuilder();
		//ORM솔루션 - xml문서에 관리한다. 왜? 버전관리쉽다. 유지보수용이, sql문만 따로 관리
		sql.append("SELECT no, mem_id, mem_pw, mem_name, mem_tel FROM member");
		try {
			//PreparedStatement pstmt = new PreparedStatement();
			pstmt = con.prepareStatement(sql.toString());
			//ResultSet rs = new ResultSet();
			//ResultSet으로 커서를 조작할 수 있다.
			//인터페이스는 추상메소드를 가지고 있다.
			//rs.next():boolean -커서를 다음으로 이동해주세요.
			//rs.previous(), rs.isFirst():boolean, rs.absolute(3);, rs.isLast(),,,,
			//커서를 조작하여 메모리에 올려진 로우정보들을 저장소(자료구조:List,Map)에 담는다.
			rs = pstmt.executeQuery();
			MemberVO mvo = null;///VO안에는 변수가 선언되어 있다. 한번에 한건만 담을 수 있다.
			/********** 자료구조에 담는 구간 시작 *********/
			while(rs.next()){
				mvo = new MemberVO();
				mvo.setNo(rs.getInt("no"));
				mvo.setMem_id(rs.getString("mem_id"));
				mvo.setMem_pw(rs.getString("mem_pw"));
				mvo.setMem_name(rs.getString("mem_name"));
				mvo.setMem_tel(rs.getString("mem_tel"));
				memList.add(mvo);
			}
			/********** 자료구조에 담는 구간 끝 *********/
			System.out.println("로우 수 : "+memList.size());
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
	//커서 조작하기
	public int memberSize(){
		int rowcount = 0;
		con = dbMgr.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT no, mem_id, mem_pw, mem_name, mem_tel FROM member");
		try {
			//TYPE_SCROLL_SENSITIVE - 커서를 순차적으로 이동
			//TYPE_SCROLL_INSENSITIVE - 커서를 비순차적으로 이동
			//CONCUR_UPDATABLE - update문을 사용하지 않고 직접 값을 수정할 수 있다.
			pstmt = con.prepareStatement(sql.toString()
					                    ,ResultSet.TYPE_SCROLL_SENSITIVE
					                    ,ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();//커서의 위치는 테이블에 top에 위치한다.	
			rs.last();//커서의 위치를 한개로우씩 이동하여 맨 끝까지 간다.
			rowcount = rs.getRow();
			rs.beforeFirst();//커서의 위치를 원래 대로 이동시킴.
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
			//Console에 출력하기
			//JTable - DefaultTableModel
			//MiplatForm -  DataSet
			//Grid
			//HTML
			System.out.println(mvo.getMem_id()+", "+mvo.getMem_name());
		}
	}
	public static void main(String[] args) {
		MemberCRUD mCRUD = new MemberCRUD();
		//mCRUD.memberInsert("haha", "123", "강감찬", "02-456-7852");
		//mCRUD.getMemberList();
		System.out.println("로우의 수 : "+mCRUD.memberSize());
	}

}








