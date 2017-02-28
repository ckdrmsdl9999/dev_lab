package com.ch5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGame implements ActionListener {
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
	JButton jbt_new = new JButton("������");
	JButton jbt_dap = new JButton("����");
	JButton jbt_clear = new JButton("�����");
	JButton jbt_exit = new JButton("����");
	Font f = new Font("Thoma",Font.BOLD,14);
	int cnt = 0;//��������
	int com[] = new int[3];//���Ͱ� ä���� ���� ���
	int my[] = new int[3];//����ڰ� �Է��� �� ���
	public BaseBallGame(){
		nanSu();
	}
	//����ڰ� �Է��� ���ڸ� �޾Ƽ� �迭�� ��� ����
	/*********************************************************************************/
	//�������� �Է�
	void userInput(String input){
		if(input.length()!=3){
			JOptionPane.showMessageDialog(jf_game, "���ڸ� ���ڸ� �Է��ϼ���."
					                    , "INFO", JOptionPane.INFORMATION_MESSAGE);
			return;//userInput�޼ҵ� Ż��
		}		
		int temp = 0;
		temp = Integer.parseInt(input);
		my[0] = temp/100;//1
		my[1] = (temp%100)/10;//2
		my[2] = temp%10;//3		
	}//////////////// end of userInput /////////////////	 
	/*********************************************************************************/
	//���ڸ� ���� ü���ϴ� �޼ҵ� ����
	/**********************************************************************************/
	//���� 3�� ��������
	public void nanSu()
	{
		com[0] = (int)(Math.random()*10);
		do{
			com[1] = (int)(Math.random()*10);
		}while(com[0]==com[1]);
		do{
			com[2] = (int)(Math.random()*10);
		}while(com[0]==com[2] || com[1]==com[2]);
	}
	/**********************************************************************************/
	//ȭ��ó�� �ϱ�
	public void initDisplay(){
		java.lang.System.out.println("initDisplay ȣ�� ����");
		//�޴�������, �޴�, �޴��� �߰��ϱ�
		jm_file.add(jmi_new);
		jm_file.add(jmi_dap);
		jm_file.add(jmi_exit);
		jmb.add(jm_file);
		jf_game.setJMenuBar(jmb);
		//�̺�Ʈ �ҽ��� �̺�Ʈ ó���� ����ϴ� �ڵ鷯 Ŭ������ ����
		jbt_new.addActionListener(this);
		jbt_dap.addActionListener(this);
		jbt_clear.addActionListener(this);//this=>BaseBallGame=>actionPerformed�޼ҵ尡 ���ȿ� ���� ��
		jtf_input.addActionListener(this);
		jbt_exit.addActionListener(this);
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
		jf_game.setTitle(title);
		jf_game.setSize(300,350);
		jf_game.setVisible(true);
	}
	//�� ���� �ϱ�
	String Ya9Run()
	{
		int ball=0;
		int strike=0;	
		//////////// �� ���� ���� ////////////////
		for(int i=0; i<com.length; i++)
		{
			for(int j=0; j<my.length; j++)
			{
				//���ڰ� �����ϴ�? - true:�� Ȯ��
				if(com[i]==my[j]){
				//�ڸ��� ��ġ�ϴ�? - true:��Ʈ����ũ Ȯ��
					if(i==j){
						strike++;
					}
					else{
						ball++;
					}
				}
			}///////////out of end inner for
		}///////////////out of end outter for
		//////////// �� ���� �� /////////////////
	   if(strike==3)
	   {
		   return "�����Դϴ�.";
	   }
	   return strike+"��"+ball+"�� ���� �־��׿�";
	}/////////////// end of ya9Run /////////////////	
	//�̺�Ʈ ó�� �ϱ�
	
	//���θ޼ҵ�
	//20-21-22-11-12
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		BaseBallGame bGame = new BaseBallGame();
		bGame.initDisplay();//�޼ҵ� ȣ��
	}
	//actionPerformed�޼ҵ�� �ݹ�޼ҵ�
	@Override 
	public void actionPerformed(ActionEvent ae) {
		//�̺�Ʈ�� �߻��� ������Ʈ�� �ּҹ��� �������� - � ��ư�� ������?
		Object obj = ae.getSource();//������ư�� �ּҹ��� ��������
		//System.out.println(jbt_clear+" , "+ae.getSource());
		//����� ��ư�� Ŭ������ �� ȣ��
		if(obj==jbt_clear){
			jta_display.setText("");
		}
		//�����ӹ�ư�� Ŭ���ߴ�?
		else if(obj == jbt_new){
			cnt = 0;
			nanSu();
			jta_display.setText("");
			jtf_input.setText("");
			jtf_input.requestFocus();
		}
		//�����ư�� Ŭ���ߴ�?
		//�̺�Ʈ�ҽ��� �ּҹ����� �����ư�� �ּҹ����� ����?
		else if(obj==jbt_dap){
			System.out.println("==========�����ư Ŭ�� �׽�Ʈ==========");
			jta_display.append("������ "+com[0]
					                    +com[1]
					                    +com[2]+"\n");
		}
		//����ڰ� ���� �Է��ϰ� ���� ���� �� ȣ��
		else if(obj==jtf_input){
			String user = jtf_input.getText();//����ڰ� �Է��� ���ڸ� ���� ����ȴ�.
			userInput(user);	
			jta_display.append(++cnt+"."+user+" : "+Ya9Run()+"\n");
			jtf_input.setText("");
		}
		//���� ��ư�� Ŭ������ �� ȣ��
		else if(obj==jbt_exit){
			System.exit(0);//�ڹٰ���ӽŰ� ������� �����.
		}
	}///////////////////// end of actionPerformed ///////////////////////
}
