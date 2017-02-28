package com.ch15;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class MyEditor extends JFrame implements ActionListener{
	//�����
	String path = "src\\com\\images\\";
	//�޴��� �߰��ϱ�
	JMenuBar jmb = new JMenuBar();
	JMenu	 jm_file = new JMenu("File");
	JMenuItem jmi_new = 
			new JMenuItem("New", new ImageIcon(path+"new.gif"));
	JMenuItem jmi_open = 
			new JMenuItem("Open", new ImageIcon(path+"open.gif"));
	JMenuItem jmi_save = 
			new JMenuItem("Save", new ImageIcon(path+"save.gif"));
	JSeparator js_file = new JSeparator();
	JMenuItem jmi_exit = 
			new JMenuItem("Exit", new ImageIcon(path+"exit.gif"));
	JMenu	 jm_edit = new JMenu("Edit");
	JMenuItem jmi_copy = 
			new JMenuItem("Copy", new ImageIcon(path+"copy.gif"));
	JMenuItem jmi_paste = 
			new JMenuItem("Paste", new ImageIcon(path+"paste.gif"));
	JMenuItem jmi_cut = 
			new JMenuItem("Cut", new ImageIcon(path+"cut.gif"));
	JTextArea jta_display = new JTextArea();
	JScrollPane jsp_display = new JScrollPane(jta_display);
	JFileChooser jfc = new JFileChooser();
	//������
	public MyEditor(){
		initDisplay();
	}
	//���̾� �α�â ����
	public void showDialog()
	{
		MyEditorDialog myDia = new MyEditorDialog(this);
		myDia.setResizable(false);
		Point poi = getLocation();
		poi.translate(70, 70);
		myDia.setLocation(poi);
		myDia.initDisplay();
	}
	//ȭ��ó����
	public void initDisplay(){
		//�͸� Ŭ������ �̺�Ʈ ó���ϱ�
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evt){
				System.exit(0);
			}
		});
		//this-MyEditor(ȭ������:JFrame|�̺�Ʈó��:ActionListener)
		//���ȿ� actionPerformed�� �����ߴٴ� ���̴�.
		//ActionListener��� �������̽��� ����ü Ŭ���� ����
		//ActionListener al = new MyEditor();
		//jmi_new.addActionListener(al);
		jmi_open.addActionListener(this);
		jmi_save.addActionListener(this);
		jmi_new.addActionListener(this);
		jmi_exit.addActionListener(this);
		jm_file.add(jmi_new);
		jm_file.add(jmi_open);
		jm_file.add(jmi_save);
		jm_file.add(js_file);
		jm_file.add(jmi_exit);
		jm_edit.add(jmi_copy);
		jm_edit.add(jmi_paste);
		jm_edit.add(jmi_cut);
		jm_file.setMnemonic('F');
		jm_edit.setMnemonic('E');
		jmb.add(jm_file);
		jmb.add(jm_edit);
		this.setJMenuBar(jmb);
		this.add("Center",jsp_display);
		this.setTitle("���� ���� �޸���");
		this.setSize(500, 300);
		this.setVisible(true);
	}
	//���θ޼ҵ�
	public static void main(String[] args) {
		new MyEditor();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj==jmi_open){//���� ���� ���ý�
			int intRet = jfc.showOpenDialog(this);
			//yes Ȥ�� ok��ư�� �������� ��
			if(intRet==JFileChooser.APPROVE_OPTION){
				//������ ���� ó���ϱ�
				FileReader fr = null;
				BufferedReader myReader = null;
				try {
					String strLine = null;
					//File��ü�� ���ϸ��� ��ü�� ������ִ� Ŭ����
					File myFile = jfc.getSelectedFile();
					//���õ� ������ ���� ��θ� �����Ͽ� BufferedReader
					//��ü�� �����ϱ�
/*					BufferedReader myReader = 
							new BufferedReader(
									new FileReader(myFile.getAbsolutePath()));*/
					fr = new FileReader(myFile.getAbsolutePath());
					myReader = new BufferedReader(fr);
					//�о���� �ؽ�Ʈ�� JTextArea�� ����
					jta_display.setText(myReader.readLine());
					//2�� ���Ĵ� ��ٲٱ� �ڵ带 �־� append�ϱ�
					while((strLine=myReader.readLine())!=null){
						jta_display.append("\n"+strLine);
					}
				} catch (IOException ie) {
					// TODO: handle exception
				} finally{
					try {
						if(myReader!=null) myReader.close();
						if(fr !=null) fr.close();
					} catch (IOException ie) {
						// TODO: handle exception
					}
				}
			}
		}
		//Save �޴� ������ ó��
		else if(obj==jmi_save){
			//System.out.println("����");
			save();
		}//////////////////////end of save
		else if(obj==jmi_new){//������ ó��
			showDialog();
			//jta_display.setText("");
		}
		else if(obj==jmi_copy){//�����ϱ� ó��
			jta_display.copy();
		}		
		else if(obj==jmi_paste){//�ٿ��ֱ� ó��
			jta_display.paste();
		}	
		else if(obj==jmi_cut){//�߶󳻱� ó��
			jta_display.cut();
		}	
		else if(obj==jmi_exit){
			System.exit(0);
		}
	}//////////////////////////end of actionPerformed
	public void save(){
		int intRet = jfc.showSaveDialog(this);
		if(intRet == JFileChooser.APPROVE_OPTION){
			//������ �����ϴ� ó��
			BufferedWriter myWriter = null;
			PrintWriter myPwriter = null;
			FileWriter myFwriter = null;
			try {
				File myFile = jfc.getSelectedFile();
				myFwriter = new FileWriter(myFile.getAbsolutePath());
				myWriter = new BufferedWriter(myFwriter);
				myPwriter = new PrintWriter(myWriter);
				myPwriter.write(jta_display.getText());
			} catch (Exception e) {
				// TODO: handle exception
			} finally{
				try {
					if(myPwriter!=null) myPwriter.close();
					if(myWriter!=null) myWriter.close();
					if(myFwriter!=null) myFwriter.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}		
	}
}







