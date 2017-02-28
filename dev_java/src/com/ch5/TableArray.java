package com.ch5;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.util.DBConnectionMgr;
import com.vo.MemberVO;

public class TableArray extends JFrame implements ActionListener {
	JPanel jp_north = new JPanel();
	String data[][] = new String[0][0];
	String cols[] = new String[]{"ID","대화명","성별"};
	DefaultTableModel dtm = new DefaultTableModel(data,cols);
	JTable jtb = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jtb);
	JButton jbtns[] = new JButton[4];
	String jbtn_label[] = new String[]{"배열","벡터","DB","지우기"};
	String datas[][]={
			{"test","이순신","남자"}
		   ,{"haha","김유신","남자"}
	       ,{"apple","유관순","여자"}
	};
	String datas2[][]={
			{"test2","이순신2","남자"}
		   ,{"haha2","김유신2","남자"}
	       ,{"apple2","유관순2","여자"}
	};	
	public void initDisplay(){
		jp_north.setLayout(new GridLayout(1,4));
		for(int i=0;i<jbtns.length;i++){
			jbtns[i] = new JButton(jbtn_label[i]);
			jp_north.add(jbtns[i]);
			jbtns[i].addActionListener(this);
		}
		jtb.getTableHeader().setReorderingAllowed(false);
		jtb.getColumnModel().getColumn(0).setPreferredWidth(130);
		jtb.getColumnModel().getColumn(1).setPreferredWidth(150);
		jtb.getColumnModel().getColumn(2).setPreferredWidth(70);
		this.add("North",jp_north);
		this.add("Center",jsp);
		this.setSize(350,200);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		TableArray ta = new TableArray();
		ta.initDisplay();
	}
	public void clear(){
		while(dtm.getRowCount()>0){//data가 존재하니?
			dtm.removeRow(0);
		}		
	}
	public Vector<MemberVO> getMemberList()
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnectionMgr dbMgr = new DBConnectionMgr();
		Vector<MemberVO> memList = new Vector<MemberVO>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT mem_id, mem_name, gender");
		sql.append(" FROM member");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			MemberVO mvo = null;
			while(rs.next()){
				mvo = new MemberVO();
				mvo.setMem_id(rs.getString("mem_id"));
				mvo.setMem_name(rs.getString("mem_name"));
				mvo.setGender(rs.getString("gender"));
				memList.add(mvo);
			}
		} catch (SQLException se) {
			System.out.println("[[query]]"+sql.toString());
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			DBConnectionMgr.freeConnection(con, pstmt);
		}
		return memList;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		String label = ae.getActionCommand();//배열, 벡터, 지우기
		if("배열".equals(label)){
			clear();
			for(int i=0;i<datas.length;i++){
				dtm.addRow(datas[i]);
			}
		}
		else if("벡터".equals(label)){
			clear();
			//insert here
			for(int i=0;i<datas2.length;i++){
				Vector<String> v_temp = new Vector<String>();
				v_temp.add(datas2[i][0]);
				v_temp.add(datas2[i][1]);
				v_temp.add(datas2[i][2]);
				dtm.addRow(v_temp);
			}
		}	
		else if("DB".equals(label)){
			clear();
			Vector<MemberVO> memList = getMemberList();
			//System.out.println("size : "+memList.size());
			//insert here
			for(int i=0;i<memList.size();i++){
				MemberVO mvo = memList.get(i);
				Vector<String> imsi = new Vector<String>();
				imsi.add(mvo.getMem_id());
				imsi.add(mvo.getMem_name());
				imsi.add(mvo.getGender());
				dtm.addRow(imsi);
			}
		}
		else if("지우기".equals(label)){
			clear();
		}
	}

}







