package com.ch7;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
//import java.awt.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.util.DBConnectionMgr;
import com.vo.DeptVO;

public class DeptApp extends JFrame {
	//선언부
	//화면에 테이블 추가하기
	//테이블 폼 지원하는 클래스 - JTable
	//테이블에 데이터셋을 지원하는 클래스 - DefaultTableModel(자료구조:Vector, Object[][])
	//테이블에 출력결과가 많을 때 - 스크롤바 - JScrollPane(속지)
	//DefaultTableModel - JTable - JScollPane붙이기 - 인스턴스화하는 순서 중요하다.
	//DefaultTableModel에 헤더 구성하기
	String header[] = {"부서번호","부서명","지역"};
	String rows[][] = new String[0][0];
	DefaultTableModel 	dtm_dept = new DefaultTableModel(rows,header);
	JTable 				jt_dept  = new JTable(dtm_dept);
	JScrollPane 		jsp_dept = new JScrollPane(jt_dept);
	//버튼 추가 - 부서관리를 위한 버튼 (조회(select),입력(insert),수정(update),삭제(delete))
	//버튼을 배치하기 위한 속지를 추가
	JPanel 		jp_button = new JPanel();
	JButton		jbtn_sel  = new JButton("조회");
	JButton		jbtn_ins  = new JButton("입력");
	JButton		jbtn_upd  = new JButton("수정");
	JButton		jbtn_del  = new JButton("삭제");
	//생성자
	public DeptApp(){
		System.out.println("DeptApp 디폴트 생성자 호출 성공");
		//getDeptList();//단위테스트
	}
	//메소드
	// List(인터페이스) deptList = new Vector구현체 클래스();
	public DeptVO[] getDeptList(){
		DeptVO[] dvos = null;
		Vector v = new Vector();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT deptno, dname, loc FROM dept");
		DBConnectionMgr dbMgr = new DBConnectionMgr();
		java.sql.Connection con = null;//연결통로
		Statement stmt = null;//전령
		ResultSet rs   = null;//커서이동시
		DeptVO dvo = null;
		try {
			con = dbMgr.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql.toString());
			//System.out.println(rs.next());//true
			while(rs.next()){
				dvo = new DeptVO(rs.getInt("deptno")
						        ,rs.getString("dname")
						        ,rs.getString("loc"));
				v.add(dvo);
			}
			dvos = new DeptVO[v.size()];
			v.copyInto(dvos);//Vector담긴 정보를 dvos배열에 담기
			///System.out.println(deptList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dvos;
	}
	//화면처리하기
	public void initDisplay(){
		System.out.println("initDisplay 호출 성공");
		//속지에 버튼 4개 배치하기
		jp_button.add(jbtn_sel);
		jp_button.add(jbtn_ins);
		jp_button.add(jbtn_upd);
		jp_button.add(jbtn_del);
		//JFrame의 중앙에 테이블 배치하기
		FlowLayout f = new FlowLayout();
		f.setAlignment(FlowLayout.LEFT);
		jp_button.setLayout(f);
		/* DefaultTableModel에 getDeptList처리 결과 담기 */
		DeptVO[] dvos = getDeptList();
		//System.out.println("누가냐~ 넌1? "+list.get(0).getClass());
		//System.out.println("누가냐~ 넌2? ");
		for(int i=0;i<dvos.length;i++){
			Vector oneRow = new Vector();
			oneRow.add(dvos[i].getDeptno());
			oneRow.add(dvos[i].getDname());
			oneRow.add(dvos[i].getLoc());
			dtm_dept.addRow(oneRow);
		}
		this.add("Center", jsp_dept);
		this.add("North",jp_button);
		this.setSize(400, 300);
		this.setVisible(true);
	}
	//메인메소드(시작점:main thread)
	public static void main(String[] args) {
		DeptApp dApp = new DeptApp();
		dApp.initDisplay();
	}

}
