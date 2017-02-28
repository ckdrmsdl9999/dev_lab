package com.ch6;
/**********************************************
 * �̺�Ʈ ó�� ����
 * 1.�̺�Ʈ �ҽ�(����ȸ)�� �̺�Ʈ �߻���
 * ������ ��  �ִ� �������̽� ���� 
 * :�̺�Ʈ�� �Ͼ �̺�Ʈ �ҽ��� JVM�� ����
 * 2.�̺�Ʈ �߻��ÿ� ó���� ������
 *   �ݹ�޼ҵ��� actionPerformed�޼ҵ忡 ������
 *   �Ѵ�.
 * 3.�̺�Ʈ �ҽ�(����ȸ)�� �̺�Ʈ ó���� ����ϴ�
 *   Ŭ������ �����Ѵ�.  
 *********************************************/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class AddressBook implements ActionListener{
	static AddressBook adrBook = null;
	JFrame jf_book = new JFrame(); //ȭ�����
	AddressPopup apopup = new AddressPopup(this);
	JMenuBar jmb = new JMenuBar();
	
	JMenu jm_file = new JMenu("����");
	JMenuItem jmi_specific = new JMenuItem("����ȸ");
	JMenuItem jmi_input = new JMenuItem("�Է�");
	JMenuItem jmi_modify = new JMenuItem("����");
	JMenuItem jmi_delete = new JMenuItem("����");
	JSeparator js_file = new JSeparator();
	JMenuItem jmi_exit = new JMenuItem("����");
	
	JTextArea jta_display = new JTextArea("�׽�Ʈ");
	/********************************************************************************
	 * AddressPopup���� Ȯ�� ��ư�� Ŭ������ �� ȣ�� �� �޼ҵ� ����
	 * AddressPopupŬ������ AddressBook��ü�� ���� �ּҹ����� �ʿ��մϴ�.
	 *******************************************************************************/
	public void refresh(){
		jta_display.setText("���� ���ΰ�ħ �Ǿ���.");
	}
	
	public void initDisplay(){
		java.lang.System.out.println("initDisplay ȣ�⼺��");
		//this�� �̺�Ʈ ó���� ����ϴ� �̺�Ʈ �ڵ鷯 Ŭ�����̴�.
		//���⼭�� ���� actionPerformed�޼ҵ带 �����Ͽ����Ƿ�
		//�� �ڽ��� �̺�Ʈ ó���� ����ϴ� Ŭ������ �˴ϴ�.
		jmi_specific.addActionListener(this);
		jmi_input.addActionListener(this);
		jmi_exit.addActionListener(this);
		//�޴� �߰� - 2)ȭ�鿡 �ٿ��ֱ�
		jm_file.add(jmi_specific);
		jm_file.add(jmi_input);
		jm_file.add(jmi_modify);
		jm_file.add(jmi_delete);	
		jm_file.add(js_file);
		jm_file.add(jmi_exit);
		jmb.add(jm_file);
		jf_book.setJMenuBar(jmb);//����ȭ�鿡 �޴��� ������
		jf_book.add("Center",jta_display);
		String title = "�ּҷ�";
		jf_book.setTitle(title);		
		jf_book.setSize(500,300);//�޼ҵ� �ۿ��� ������ ȭ�鿡 ũ��ο�	
		jf_book.setVisible(true);//���̰� �ض�?
		//��ȣ �ȿ��� boolean�� �־�� �Ѵٰ� �����Ǿ� ����.
		

		
		
		
					
		//3)
		//�̺�Ʈ �ҽ��� �̺�Ʈ ó���� ����ϴ� �ڵ鷯 Ŭ������ ����
//		jmi_specific.addActionListener(this);//�̺�Ʈ�ҽ���.�ڵ鷯Ŭ����(�ּҹ���);		
	
		}

	public static void main(String[] args) {
/*		AddressBook ab = new AddressBook();
		ab.initDisplay();*/
		adrBook = new AddressBook();
		adrBook.initDisplay();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//����ȸ|�Է�|����|����
		//String jmi_label = null;
		String jmi_label = e.getActionCommand();//����ȸ|�Է�|����|����
		System.out.println("actionPerformed ȣ�� ����===>"+jmi_label+",�ֹ�:"+e.getSource());
		//����ȸ�� Ŭ���ߴ�?
		//if("����ȸ".equals(jmi_label)){
		if(jmi_specific==e.getSource()){	
		//if(jmi_label.equals("����ȸ")){	
			System.out.println("����ȸ~~~~");
			apopup.setTitle(jmi_label);
			apopup.initDisplay2();
		}
		//�Է��� Ŭ���ߴ�?
		else if(jmi_input==e.getSource()){	
		//if(jmi_label.equals("����ȸ")){	
			System.out.println("�Է�~~~~");
			apopup.setTitle(jmi_label);
			apopup.initDisplay2();
		}		
		//������ Ŭ���ߴ�?
		
		//������ Ŭ���ߴ�?
		//�� ����޴��������� Ŭ���ߴ�?
		else if(e.getSource()==jmi_exit){
			System.exit(0);//����ӽ��ϰ� ����� �����.
		}
	}

}












