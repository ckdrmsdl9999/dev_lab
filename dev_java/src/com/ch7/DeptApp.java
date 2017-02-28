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
	//�����
	//ȭ�鿡 ���̺� �߰��ϱ�
	//���̺� �� �����ϴ� Ŭ���� - JTable
	//���̺� �����ͼ��� �����ϴ� Ŭ���� - DefaultTableModel(�ڷᱸ��:Vector, Object[][])
	//���̺� ��°���� ���� �� - ��ũ�ѹ� - JScrollPane(����)
	//DefaultTableModel - JTable - JScollPane���̱� - �ν��Ͻ�ȭ�ϴ� ���� �߿��ϴ�.
	//DefaultTableModel�� ��� �����ϱ�
	String header[] = {"�μ���ȣ","�μ���","����"};
	String rows[][] = new String[0][0];
	DefaultTableModel 	dtm_dept = new DefaultTableModel(rows,header);
	JTable 				jt_dept  = new JTable(dtm_dept);
	JScrollPane 		jsp_dept = new JScrollPane(jt_dept);
	//��ư �߰� - �μ������� ���� ��ư (��ȸ(select),�Է�(insert),����(update),����(delete))
	//��ư�� ��ġ�ϱ� ���� ������ �߰�
	JPanel 		jp_button = new JPanel();
	JButton		jbtn_sel  = new JButton("��ȸ");
	JButton		jbtn_ins  = new JButton("�Է�");
	JButton		jbtn_upd  = new JButton("����");
	JButton		jbtn_del  = new JButton("����");
	//������
	public DeptApp(){
		System.out.println("DeptApp ����Ʈ ������ ȣ�� ����");
		//getDeptList();//�����׽�Ʈ
	}
	//�޼ҵ�
	// List(�������̽�) deptList = new Vector����ü Ŭ����();
	public DeptVO[] getDeptList(){
		DeptVO[] dvos = null;
		Vector v = new Vector();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT deptno, dname, loc FROM dept");
		DBConnectionMgr dbMgr = new DBConnectionMgr();
		java.sql.Connection con = null;//�������
		Statement stmt = null;//����
		ResultSet rs   = null;//Ŀ���̵���
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
			v.copyInto(dvos);//Vector��� ������ dvos�迭�� ���
			///System.out.println(deptList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dvos;
	}
	//ȭ��ó���ϱ�
	public void initDisplay(){
		System.out.println("initDisplay ȣ�� ����");
		//������ ��ư 4�� ��ġ�ϱ�
		jp_button.add(jbtn_sel);
		jp_button.add(jbtn_ins);
		jp_button.add(jbtn_upd);
		jp_button.add(jbtn_del);
		//JFrame�� �߾ӿ� ���̺� ��ġ�ϱ�
		FlowLayout f = new FlowLayout();
		f.setAlignment(FlowLayout.LEFT);
		jp_button.setLayout(f);
		/* DefaultTableModel�� getDeptListó�� ��� ��� */
		DeptVO[] dvos = getDeptList();
		//System.out.println("������~ ��1? "+list.get(0).getClass());
		//System.out.println("������~ ��2? ");
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
	//���θ޼ҵ�(������:main thread)
	public static void main(String[] args) {
		DeptApp dApp = new DeptApp();
		dApp.initDisplay();
	}

}
