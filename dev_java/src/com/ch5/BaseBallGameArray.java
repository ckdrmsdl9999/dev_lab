package com.ch5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGameArray implements ActionListener {
	//�����
	//�޴��� �߰��ϱ�
	JMenuBar 	jmb 	= new JMenuBar();
	JMenu 		jm_file = new JMenu("����");
	JMenuItem	jmi_new = new JMenuItem("������");
	JMenuItem	jmi_dap = new JMenuItem("����");
	JMenuItem	jmi_exit = new JMenuItem("����");
	//JFrame�� �ڹٿ��� �����ϴ� Ŭ���� �Դϴ�.
//	javax.swing.JFrame jf_game = new javax.swing.JFrame();
	JFrame jf_game = new JFrame();
	//JFrame�� ���� ���� �� �� �����ϰ� �����ϱ�
	JPanel jp_center = new JPanel();
	//��ġ-jp_center������ �߾ӿ� ��ġ����
	JTextArea jta_display = new JTextArea();
	//JTextArea�� ��ũ�� �� �߰��ϱ�
	JScrollPane jsp_display = new JScrollPane(jta_display);
	//��ġ-jp_center������ ���ʿ� ��ġ����
	JTextField jtf_input = new JTextField();
	JPanel jp_east = new JPanel();
	//�����ӹ�ư, �����ư, ������ư, �����ư-> jp_east������ ��ġ�� ����.
	JButton jbtns[] = new JButton[4];
	String btn_label[] = {"������","����","�����","����"};
	Font f = new Font("Thoma",Font.BOLD,14);
	int count = 0;//��������
	//ȭ��ó�� �ϱ�
	public void initDisplay(){
		java.lang.System.out.println("initDisplay ȣ�� ����");
		//�޴�������, �޴�, �޴��� �߰��ϱ�
		jm_file.add(jmi_new);
		jm_file.add(jmi_dap);
		jm_file.add(jmi_exit);
		jmb.add(jm_file);
		jf_game.setJMenuBar(jmb);
		jp_east.setLayout(new GridLayout(4,1,2,2));
		for(int i=0;i<jbtns.length;i++){
			jbtns[i] = new JButton(btn_label[i]);
			//��ư�� ��Ʈ �����ϱ�
			jbtns[i].setFont(f);
			//jp_east������ ��ư 4�� ���̱�
			jp_east.add(jbtns[i]);		
		}
		//�̺�Ʈ �ҽ��� �̺�Ʈ ó���� ����ϴ� �ڵ鷯 Ŭ������ ����
		jbtns[2].addActionListener(this);//this=>BaseBallGame=>actionPerformed�޼ҵ尡 ���ȿ� ���� ��
		jtf_input.addActionListener(this);
		jbtns[3].addActionListener(this);
		jp_center.setLayout(new BorderLayout(0,20));
		//jp_center.setBackground(Color.BLUE);
		//jp_east.setBackground(Color.GREEN);
		//jp_center������ jta_display�� �߾ӿ� ��ġ�ϰ�
		//jp_center������ jtf_input�� ��ġ����.
		jp_center.add("Center",jsp_display);
		jp_center.add("South",jtf_input);

		//��ư�� ���� ������
		jbtns[0].setBackground(new Color(158,9,9));
		jbtns[0].setForeground(new Color(212,212,212));
		jbtns[1].setBackground(new Color(19,99,57));
		jbtns[1].setForeground(new Color(212,212,212));
		jbtns[2].setBackground(new Color(7,84,170));
		jbtns[2].setForeground(new Color(212,212,212));
		jbtns[3].setBackground(new Color(54,54,54));
		jbtns[3].setForeground(new Color(212,212,212));

		jf_game.setBackground(new Color(214,211,206));
		//���� �� ���� JFrame�� ���̱�
		jf_game.add("Center",jp_center);
		jf_game.add("East",jp_east);
		String title = "�߱����ڰ���-�迭";
		jf_game.setTitle(title);
		jf_game.setSize(300,350);
		jf_game.setVisible(true);
	}
	//�� ���� �ϱ�
	
	//�̺�Ʈ ó�� �ϱ�
	
	//���θ޼ҵ�
	//20-21-22-11-12
	public static void main(String[] args) {
		BaseBallGameArray bGame = new BaseBallGameArray();
		bGame.initDisplay();//�޼ҵ� ȣ��
	}
	//actionPerformed�޼ҵ�� �ݹ�޼ҵ�
	@Override 
	public void actionPerformed(ActionEvent ae) {
		//�̺�Ʈ�� �߻��� ������Ʈ�� �ּҹ��� �������� - � ��ư�� ������?
		Object obj = ae.getSource();//������ư�� �ּҹ��� ��������
		//System.out.println(jbtns[2]+" , "+ae.getSource());
		//����� ��ư�� Ŭ������ �� ȣ��
		if(obj==jbtns[2]){
			jta_display.setText("");
		}
		//����ڰ� ���� �Է��ϰ� ���� ���� �� ȣ��
		else if(obj==jtf_input){
			String user = jtf_input.getText();
			jta_display.append(++count+"."+user+" : "+"0�� 0��"+"\n");
			jtf_input.setText("");
		}
		//���� ��ư�� Ŭ������ �� ȣ��
		else if(obj==jbtns[3]){
			System.exit(0);//�ڹٰ���ӽŰ� ������� �����.
		}
	}
}
