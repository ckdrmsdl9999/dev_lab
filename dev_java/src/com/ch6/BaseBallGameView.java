package com.ch6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGameView {
	String path = this.getClass().getResource("").getPath();
	//��ü�� ���԰��� �ذ��ϱ�
	BaseBallGameLogic bgLogic = new BaseBallGameLogic(this);
	BaseBallGameEvent bgEvent = new BaseBallGameEvent(this, bgLogic);
	//�޴��� �߰��ϱ�
	JMenuBar 	jmb 	= new JMenuBar();
	JMenu 		jm_file = new JMenu("����");
	ImageIcon myIcon = new ImageIcon(path+"new.gif");
	JMenuItem	jmi_new = new JMenuItem("������",myIcon);
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
	JButton jbt_new = new JButton("������");
	JButton jbt_dap = new JButton("����");
	JButton jbt_clear = new JButton("�����");
	JButton jbt_exit = new JButton("����");
	Font f = new Font("Thoma",Font.BOLD,14);	

	public BaseBallGameView(){
		bgLogic.nanSu();
		System.out.println("path:"+path);
	}
	//ȭ��ó�� �ϱ�
	public void initDisplay(){
		java.lang.System.out.println("initDisplay ȣ�� ����");
		//jmi_new.setIcon(myIcon);
		//�޴�������, �޴�, �޴��� �߰��ϱ�
		jm_file.add(jmi_new);
		jm_file.add(jmi_dap);
		jm_file.add(jmi_exit);
		jmb.add(jm_file);
		jf_game.setJMenuBar(jmb);
		//�̺�Ʈ �ҽ��� �̺�Ʈ ó���� ����ϴ� �ڵ鷯 Ŭ������ ����
		jbt_new.addActionListener(bgEvent);
		jbt_dap.addActionListener(bgEvent);
		jmi_dap.addActionListener(bgEvent);
		jbt_clear.addActionListener(bgEvent);//bgEvent=>BaseBallGame=>actionPerformed�޼ҵ尡 ���ȿ� ���� ��
		jtf_input.addActionListener(bgEvent);
		jbt_exit.addActionListener(bgEvent);
		jp_center.setLayout(new BorderLayout(0,20));
		jp_east.setLayout(new GridLayout(4,1,2,2));
		//jp_center.setBackground(Color.BLUE);
		//jp_east.setBackground(Color.GREEN);
		//jp_center������ jta_display�� �߾ӿ� ��ġ�ϰ�
		//jp_center������ jtf_input�� ��ġ����.
		jp_center.add("Center",jsp_display);
		jp_center.add("South",jtf_input);
		//��ư�� ��Ʈ �����ϱ�
		jbt_new.setFont(f);
		jbt_dap.setFont(f);
		jbt_clear.setFont(f);
		jbt_exit.setFont(f);
		//��ư�� ���� ������
		jbt_new.setBackground(new Color(158,9,9));
		jbt_new.setForeground(new Color(212,212,212));
		jbt_dap.setBackground(new Color(19,99,57));
		jbt_dap.setForeground(new Color(212,212,212));
		jbt_clear.setBackground(new Color(7,84,170));
		jbt_clear.setForeground(new Color(212,212,212));
		jbt_exit.setBackground(new Color(54,54,54));
		jbt_exit.setForeground(new Color(212,212,212));
		//jp_east������ ��ư 4�� ���̱�
		jp_east.add(jbt_new);
		jp_east.add(jbt_dap);
		jp_east.add(jbt_clear);
		jp_east.add(jbt_exit);
		jf_game.setBackground(new Color(214,211,206));
		//���� �� ���� JFrame�� ���̱�
		jf_game.add("Center",jp_center);
		jf_game.add("East",jp_east);
		String title = "�߱����ڰ���";
		Image img= new ImageIcon(path+"ball.jpg").getImage();
		jf_game.setIconImage(img);
		jf_game.setTitle(title);
		jf_game.setSize(300,350);
		jf_game.setVisible(true);
	}///////////// end of initDisplay() ///////////////
	public static void main(String[] args) {
		BaseBallGameView bgView = new BaseBallGameView();
		bgView.initDisplay();
	}

}