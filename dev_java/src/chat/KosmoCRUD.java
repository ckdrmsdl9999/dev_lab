package chat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBConnectionMgr;

public class KosmoCRUD {
 Connection con = null;//占쎈염野껉퀬�꽰嚥∽옙 
 PreparedStatement pstmt = null;//sql�눧占� 占쎌읈占쎈뼎
 ResultSet rs = null;
 DBConnectionMgr dbMgr = new DBConnectionMgr();
 //占쎌돳占쎌뜚揶쏉옙占쎌뿯 �뤃�뗭겱占쎈릭疫뀐옙
 //揶쏆뮇苑묋굜遺얜굡 - vo占쎈솭占쎄쉘 占쎌읅占쎌뒠
 
public String memberNickname(String ID){
		String nickname = null;
		con = dbMgr.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("Select NICKNAME from Kosmo_mem where id = '"+ID+"'");
		try {
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
				while(rs.next()){
					nickname = rs.getString("NICKNAME");
			}
		} catch (SQLException se) {
			System.out.println("[[query]] 占쎈뼄占쎈솭" + sql);
			// TODO: handle exception
		} finally{
			DBConnectionMgr.freeConnection(con, pstmt);
		}
		return nickname;
	}
public String memberID(String NICKNAME){
		String id = null;
		con = dbMgr.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("Select ID from Kosmo_mem where NICKNAME = '" + NICKNAME + "'");
		try {
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				id = rs.getString("ID");
			}	
		} catch (SQLException se) {
			System.out.println("[[query]] 占쎈뼄占쎈솭" + sql);
		} finally {
			DBConnectionMgr.freeConnection(con, pstmt);
		}
		return id;
	}
public String memberfind(String ID,String m_Hint1_q, String m_Hint2_q, 
        String m_Hint1_a , String m_Hint2_a ){
		int result = 0;

		String HINT1_Q = null;
		String HINT1_A = null;
		String HINT2_Q = null;
		String HINT2_A = null;
		String PW = null;

		con = dbMgr.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("Select HINT1_Q,HINT1_A,HINT2_Q,HINT2_A,PW " + "from Kosmo_mem where id = '" + ID + "'");
		try {
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				HINT1_Q = rs.getString("HINT1_Q");
				HINT1_A = rs.getString("HINT1_A");
				HINT2_Q = rs.getString("HINT2_Q");
				HINT2_A = rs.getString("HINT2_A");
				PW = rs.getString("PW");

				/*
				 * System.out.println(HINT1_Q); System.out.println(HINT2_Q);
				 * System.out.println(HINT1_A); System.out.println(HINT2_A);
				 */
			}
		} catch (SQLException se) {
			System.out.println("[[query]] 占쎈뼄占쎈솭" + sql);
		} finally {
			DBConnectionMgr.freeConnection(con, pstmt);
		}

		if (HINT1_Q.equals(m_Hint1_q) && HINT2_Q.equals(m_Hint2_q) && HINT1_A.equals(m_Hint1_a)
				&& HINT2_A.equals(m_Hint2_a)) // �뿬湲� �닚�꽌諛붽퓭�빞�븿
		{
			return PW;
		} else {
			System.out.println("�엺�듃臾몄씠 �씪移섑븯吏� �븡�뒿�땲�떎. �떎�떆�엯�젰�븯�꽭�슂!");
			return null;
		}
	}
 
 
 public String memberLogin(String ID){
	 	String pw = null;
		con = dbMgr.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("Select pw from Kosmo_mem where id = '"+ID+"'");
		try {
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
				while(rs.next()){
				pw = rs.getString("PW");
			}
		} catch (SQLException se) {
			System.out.println("[[query]] 占쎈뼄占쎈솭" + sql);
			// TODO: handle exception
		} finally{
			DBConnectionMgr.freeConnection(con, pstmt);
		}
		return pw;
	}
 
 public String nicknameCheak(String nickname){
	 	String pw = null;
		con = dbMgr.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("Select pw from Kosmo_mem where nickname = '"+nickname+"'");
		try {
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
				while(rs.next()){
				pw = rs.getString("PW");
			}
		} catch (SQLException se) {
			System.out.println("[[query]] 占쎈뼄占쎈솭" + sql);
			// TODO: handle exception
		} finally{
			DBConnectionMgr.freeConnection(con, pstmt);
		}
		return pw;
	}
 
 
 
 public void memberState(String id, int state){
	 int result=0;//row揶쏉옙 �빊遺쏙옙占쎈┷占쎈�占쎌뱽 占쎈르 �뵳�뗪쉘揶쏉옙
	 con = dbMgr.getConnection();//DBConnectionMgr占쎌벥 getConnection()占쎌깈�빊�뮉釉�疫뀐옙
	 StringBuilder sql = new StringBuilder();
	 sql.append("UPDATE KOSMO_MEM set STATE = '"+state+"' where id = '"+id+"'");
	 try {
	  pstmt = con.prepareStatement(sql.toString());//db占쎄퐣甕곤옙 sql占쎌읈占쎈뼎
	  result = pstmt.executeUpdate();
	  if(result ==1) System.out.println("STATE 蹂�寃� �꽦怨�");
	 } catch (SQLException se) {
	  System.out.println("[[query]]"+sql);
	 } finally{
		 DBConnectionMgr.freeConnection(con, pstmt);
	 }
	} 
 
 
 
 public String memberStateCheck(String ID){
	 	String state = null;
		con = dbMgr.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("Select STATE from Kosmo_mem where id = '"+ID+"'");
		try {
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
				while(rs.next()){
					state = rs.getString("STATE");
			}
		} catch (SQLException se) {
			System.out.println("[[query]] 占쎈뼄占쎈솭" + sql);
			// TODO: handle exception
		} finally{ 
			DBConnectionMgr.freeConnection(con, pstmt);
		}
		return state;
	}
 
 
	public void NicknameChange(String id, String new_nickname) {
		int result = 0;// row揶쏉옙 �빊遺쏙옙占쎈┷占쎈�占쎌뱽 占쎈르 �뵳�뗪쉘揶쏉옙
		con = dbMgr.getConnection();// DBConnectionMgr占쎌벥 getConnection()占쎌깈�빊�뮉釉�疫뀐옙
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE KOSMO_MEM set NICKNAME = '" + new_nickname + "' where NICKNAME = '" + id + "'");
		try {
			pstmt = con.prepareStatement(sql.toString());// db占쎄퐣甕곤옙 sql占쎌읈占쎈뼎

			result = pstmt.executeUpdate();
			if (result == 1)
				System.out.println("�땳�꽕�엫 蹂�寃� �꽦怨�");
		} catch (SQLException se) {
			System.out.println("[[query]]" + sql);
		} finally {
			DBConnectionMgr.freeConnection(con, pstmt);
		}
	}
	public void memberInsert(MemberVO mvo) {
		String ID = mvo.getID();
		String PW = mvo.getPW();
		String NAME = mvo.getNAME();
		String NICKNAME = mvo.getNICKNAME();
		String ADDRESS = mvo.getADDRESS();
		String HP = mvo.getHP();
		String GENDER = mvo.getGENDER();
		String BIRTHDAY = mvo.getBIRTHDAY();
		String HINT1_Q = mvo.getHINT1_Q();
		String HINT1_A = mvo.getHINT1_A();
		String HINT2_Q = mvo.getHINT2_Q();
		String HINT2_A = mvo.getHINT2_A();
		// String REGISTERDATE = mvo.getREGISTERDATE();
		String ADMIN = "0";
		String STATE = "0";

		System.out.println(ID);
		System.out.println(PW);
		System.out.println(NAME);
		System.out.println(NICKNAME);
		System.out.println(ADDRESS);
		System.out.println(HP);
		System.out.println(GENDER);
		System.out.println(BIRTHDAY);
		System.out.println(HINT1_Q);
		System.out.println(HINT1_A);
		System.out.println(HINT2_Q);
		System.out.println(HINT2_A);
		System.out.println(ADMIN);
		System.out.println(STATE);
	 
  int result=0;//row揶쏉옙 �빊遺쏙옙占쎈┷占쎈�占쎌뱽 占쎈르 �뵳�뗪쉘揶쏉옙
  con = dbMgr.getConnection();//DBConnectionMgr占쎌벥 getConnection()占쎌깈�빊�뮉釉�疫뀐옙
  StringBuilder sql = new StringBuilder();
  sql.append("INSERT INTO SCOTT.kosmo_mem(REGISTERDATE,ID,PW,NAME,NICKNAME,ADDRESS,HP, GENDER, BIRTHDAY,HINT1_q, HINT1_a, HINT2_q, HINT2_a,ADMIN,STATE)");
  sql.append("VALUES(TO_CHAR(sysdate,'YYYY-MM-DD'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
   
  try {
   pstmt = con.prepareStatement(sql.toString());//db占쎄퐣甕곤옙 sql占쎌읈占쎈뼎
   int i=1;
   pstmt.setString(i++, ID);
   pstmt.setString(i++, PW);
   pstmt.setString(i++, NAME);
   pstmt.setString(i++, NICKNAME);
   pstmt.setString(i++, ADDRESS);
   pstmt.setString(i++, HP);
   pstmt.setString(i++, GENDER);
   pstmt.setString(i++, BIRTHDAY);
   pstmt.setString(i++, HINT1_Q);
   pstmt.setString(i++, HINT1_A);
   pstmt.setString(i++, HINT2_Q);
   pstmt.setString(i++, HINT2_A);
   pstmt.setString(i++, ADMIN);
   pstmt.setString(i++, STATE);
   
   result = pstmt.executeUpdate();
   if(result ==1) System.out.println("占쎄땜占쎌뿯 占쎄쉐�⑨옙");
  } catch (SQLException se) {
   System.out.println("[[query]]"+sql);
  } finally{
	  DBConnectionMgr.freeConnection(con, pstmt);
  }
 }

 public static void main(String[] args) {
  KosmoCRUD mCRUD = new KosmoCRUD();
//mCRUD.memberInsert("jisung", "wltjdWKd", "A", "A","A", "A", "A", "A","A", "A", "A", "A","A");
// mCRUD.NicknameChange("jslee","吏��꽦吏�333");
//System.out.println(mCRUD.memberNickname("jslee"));
 // System.out.println(mCRUD.memberStateCheck("jslee"));
  
 System.out.println(mCRUD.memberfind("yj3022", "醫뗭븘�븯�뒗 罹먮┃�꽣�뒗?", "媛��옣 醫뗭븘�븯�뒗 �쓬�떇��?", "�뀑�뀑�뀑�뀑", "�뀑�뀑�뀑�뀑�뀑"));
 }
} 