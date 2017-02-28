package pro_03;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ChattingClientTab2 extends JFrame  implements ActionListener  {
	JPanel roomList = null;
	//ObjectInputStream ois = null;//��� �� ��
	//ObjectOutputStream oos = null;//���ϱ� �� ��
	ChattingClient cc;
	JPanel roomList_south  = new JPanel(new GridLayout(1, 2));
	String cols[] 			= {"��ȭ�� ����Ʈ"};
	String data[][]			= new String[0][1];
	DefaultTableModel dtm_room = new DefaultTableModel(data,cols);
	JTable jt_room	= new JTable(dtm_room);
	JScrollPane jsp_roomList = new JScrollPane(jt_room
				,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
				,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//VERTICAL_SCROLLBAR_AS_NEEDED�� �ʿ��Ҷ� �����ּ���.)
	JButton room_make = new JButton("�����");
	JButton room_remove = new JButton("�����");
	Test test ;
	Socket socket = null;
	public ChattingClientTab2(ChattingClient cc){
		this.cc=cc;
		roomList = new JPanel();
		room_make.addActionListener(this);
		initDisplay();
	}
	//ä��â ������ ���� ȭ��
	public void initDisplay(){
		jsp_roomList.setPreferredSize(new Dimension(200, 400));
		roomList_south.add("Center",room_make);
		//roomList_south.add("Center",room_remove);
		roomList.add("Center",jsp_roomList);
		roomList.add("South",roomList_south);
		roomList.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==room_make){
				test = new Test(this); 			
		}
		if(e.getSource()==test.jb){
			 try {

					this.cc.oos.writeObject(Protocol.ROOM_MAKE+"|"+
							this.cc.nickName+"|"+
					      test.tf_room.getText()+"|"+test.tf.getText()
					       );
				} catch (IOException ea) {
					// TODO Auto-generated catch block
					ea.printStackTrace();
				}
			 //cc.initDisplay();
		}
		
	}
}
//����� ��ư������ �����ġ�� �˾�â
class Test extends JFrame{
	JPanel jp = new JPanel(); // �г� �ʱ�ȭ
	JButton jb = new JButton("�����"); // ��ư �ʱ�ȭ
	JLabel jl_room = new JLabel("ä�ù� �̸�"); // ���̺� �ʱ�ȭ
	JLabel jl = new JLabel("�ο���"); // ���̺� �ʱ�ȭ
	JTextField tf_room = new JTextField(10); // �ؽ�Ʈ�ʵ� �ʱ�ȭ
	JTextField tf = new JTextField(2); // �ؽ�Ʈ�ʵ� �ʱ�ȭ
	public Test(ChattingClientTab2 tab2){
		jb.addActionListener(tab2);	
		jp.add(jl_room); // jp��� �гο� jl��� ���̺� �߰�
		jp.add(tf_room); // jp��� �гο� tf��� �ؽ�Ʈ�ʵ� �߰�
		jp.add(jl); // jp��� �гο� jl��� ���̺� �߰�
		jp.add(tf); // jp��� �гο� tf��� �ؽ�Ʈ�ʵ� �߰�
		jp.add(jb); // jp��� �гο� jb��� ��ư �߰�
		add(jp); // JFrame�� jp��� �г� �߰�		
		setSize(400, 80); // �������� ũ�� ����x����
		setVisible(true); // â�� �����ً� true, ���涧 falsess		
	}
	public Test(ChattingClient cc){
		jb.addActionListener(cc);	
		jp.add(jl_room); // jp��� �гο� jl��� ���̺� �߰�
		jp.add(tf_room); // jp��� �гο� tf��� �ؽ�Ʈ�ʵ� �߰�
		jp.add(jl); // jp��� �гο� jl��� ���̺� �߰�
		jp.add(tf); // jp��� �гο� tf��� �ؽ�Ʈ�ʵ� �߰�
		jp.add(jb); // jp��� �гο� jb��� ��ư �߰�
		add(jp); // JFrame�� jp��� �г� �߰�		
		setSize(400, 80); // �������� ũ�� ����x����
		setVisible(true); // â�� �����ً� true, ���涧 false
		this.setLocationRelativeTo(null);
		
	}
}
