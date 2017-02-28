package pro_03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class ChattingClientTab1 extends JPanel  implements ActionListener  {
	ChattingClient cc=null;
	JPanel chattList =null;
	JLabel roomManager = new JLabel("���� : ");
	JLabel roomName = new JLabel("������ : ");
	JLabel attend = new JLabel("�ο� : ");
	JLabel roomManager1 ;
	JLabel roomName1 ;
	JLabel attend1 ;
	JPanel chattList_south  = new JPanel(new GridLayout(2, 2));
	JButton jbtn_whisper ;
	JButton jbtn_change;
	JButton jbtn_roomout;
	JButton jbtn_close;
	String cols[] 			= {"��ȭ��"};
	String data[][]			= new String[0][1];
	DefaultTableModel dtm_room;
	JPanel jp_second_north  = new JPanel();
	JTable jt_room	;
	JScrollPane jsp_room;//VERTICAL_SCROLLBAR_AS_NEEDED�� �ʿ��Ҷ� �����ּ���.)
	public ChattingClientTab1(ChattingClient cc){
		this.cc =cc;
		chattList = new JPanel();
		jbtn_whisper 	= new JButton("�ӼӸ�");
//		jbtn_change 	= new JButton("��ȭ�� ����");
		jbtn_roomout 	= new JButton("�泪����");
		jbtn_close 		= new JButton("����");
		jbtn_whisper.addActionListener(this);
//		jbtn_change.addActionListener(this);
		jbtn_roomout.addActionListener(this);
		jbtn_close.addActionListener(this);
		dtm_room = new DefaultTableModel(data,cols);
		jt_room	= new JTable(dtm_room);
		 jsp_room = new JScrollPane(jt_room
					,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
					,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//VERTICAL_SCROLLBAR_AS_NEEDED�� �ʿ��Ҷ� �����ּ���.)
		this.initDisplay();
	}
	//ä��â ������ ä�� ������ ȭ��
	public void initDisplay(){
		jp_second_north.setPreferredSize(new Dimension(200, 50));
		jsp_room.setPreferredSize(new Dimension(200, 400));
		jp_second_north.add(roomManager);
		roomName1 = new JLabel("");
		jp_second_north.add(roomName1);
		jp_second_north.add(roomName);
		roomName1 = new JLabel("");
		jp_second_north.add(roomName1);
		jp_second_north.add(attend);
		attend1 = new JLabel("");
		jp_second_north.add(attend1);
		chattList_south.add(jbtn_whisper);
//		chattList_south.add(jbtn_change);
		chattList_south.add(jbtn_roomout);
		chattList_south.add(jbtn_close);
		chattList.add("North", jp_second_north);
		chattList.add("Center", jsp_room);
		chattList.add("South", chattList_south);

		chattList.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtn_whisper){
			String sendName = (String) dtm_room.getValueAt(jt_room.getSelectedRow(),0);
			//�Ǽ��� �ڵ�
			if (sendName == null || sendName.trim().length() < 1) {
				// ��븦 �����ߴ�? - ��
				JOptionPane.showMessageDialog(this, "�ӼӸ� �� ������ �����Ͻÿ�.", "Info", JOptionPane.INFORMATION_MESSAGE);

			} else if (cc.nickName.equals(sendName)) {
				// ���� ������ ��밡 �� �ڽ��̸� �ٸ� ��븦 �����ϼ���
				JOptionPane.showMessageDialog(this, "�ڽſ��� �ӼӸ��� ���� �� �����ϴ�.", "Error", JOptionPane.ERROR_MESSAGE);

			} else {

				// �ӼӸ� �Է¹ޱ�
				String msg1 = JOptionPane.showInputDialog(sendName + "�Կ��� ���� �޽��� �Է��ϼ���.");
				// �ӼӸ� �����ϱ�
				try {
					if (!(msg1 == null)) {
						cc.oos.writeObject(Protocol.WHISPER + "|" + cc.nickName + "|" + sendName + "|" + msg1);
						// �޽��� ó���ϱ�
						this.cc.jta_display.append("@" + sendName + "�Կ��� ���� �ӼӸ� : " + msg1 + "\n");
					}
				} catch (Exception ea) {
					// TODO: handle exception
				}
			}
			/* ����
			 * if(sendName==null||sendName.trim().length()<1){
			 
				JOptionPane.showMessageDialog(this, "�ӼӸ� �� ������ �����ϼ���","INFO",JOptionPane.INFORMATION_MESSAGE);
				return;	
			}
			
			if(cc.nickName==sendName){
				JOptionPane.showMessageDialog(this, "�ٸ� ��븦 �Է��ϼ���","INFO",JOptionPane.INFORMATION_MESSAGE);
			}
			
			String msg1 = JOptionPane.showInputDialog(sendName+"���� ���� �Ӹ��� �Է��ϼ���");
		try {
			this.cc.oos.writeObject(Protocol.WHISPER+"|"+
					cc.nickName+"|"+sendName+"|"+msg1);
		} catch (IOException ea) {
			ea.printStackTrace();
		}*/
		}else if(e.getSource()==jbtn_change){
			System.out.println("jbtn_change");
		}
		else if(e.getSource()==jbtn_roomout){
			try {
				this.cc.oos.writeObject(Protocol.ROOM_OUT + "|" + cc.nickName);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource()==jbtn_close){
			System.out.println("jbtn_close");
			System.exit(0);
		}
		
	}
}