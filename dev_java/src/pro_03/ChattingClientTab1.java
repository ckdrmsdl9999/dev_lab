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
	JLabel roomManager = new JLabel("방장 : ");
	JLabel roomName = new JLabel("방제목 : ");
	JLabel attend = new JLabel("인원 : ");
	JLabel roomManager1 ;
	JLabel roomName1 ;
	JLabel attend1 ;
	JPanel chattList_south  = new JPanel(new GridLayout(2, 2));
	JButton jbtn_whisper ;
	JButton jbtn_change;
	JButton jbtn_roomout;
	JButton jbtn_close;
	String cols[] 			= {"대화명"};
	String data[][]			= new String[0][1];
	DefaultTableModel dtm_room;
	JPanel jp_second_north  = new JPanel();
	JTable jt_room	;
	JScrollPane jsp_room;//VERTICAL_SCROLLBAR_AS_NEEDED는 필요할때 보여주세요.)
	public ChattingClientTab1(ChattingClient cc){
		this.cc =cc;
		chattList = new JPanel();
		jbtn_whisper 	= new JButton("귓속말");
//		jbtn_change 	= new JButton("대화명 변경");
		jbtn_roomout 	= new JButton("방나가기");
		jbtn_close 		= new JButton("종료");
		jbtn_whisper.addActionListener(this);
//		jbtn_change.addActionListener(this);
		jbtn_roomout.addActionListener(this);
		jbtn_close.addActionListener(this);
		dtm_room = new DefaultTableModel(data,cols);
		jt_room	= new JTable(dtm_room);
		 jsp_room = new JScrollPane(jt_room
					,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
					,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//VERTICAL_SCROLLBAR_AS_NEEDED는 필요할때 보여주세요.)
		this.initDisplay();
	}
	//채팅창 오른쪽 채팅 참여자 화면
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
			//의석이 코드
			if (sendName == null || sendName.trim().length() < 1) {
				// 상대를 선택했니? - 네
				JOptionPane.showMessageDialog(this, "귓속말 할 유저를 선택하시오.", "Info", JOptionPane.INFORMATION_MESSAGE);

			} else if (cc.nickName.equals(sendName)) {
				// 만일 선택한 상대가 나 자신이면 다른 상대를 선택하세요
				JOptionPane.showMessageDialog(this, "자신에게 귓속말을 보낼 수 없습니다.", "Error", JOptionPane.ERROR_MESSAGE);

			} else {

				// 귓속말 입력받기
				String msg1 = JOptionPane.showInputDialog(sendName + "님에게 보낼 메시지 입력하세요.");
				// 귓속말 전송하기
				try {
					if (!(msg1 == null)) {
						cc.oos.writeObject(Protocol.WHISPER + "|" + cc.nickName + "|" + sendName + "|" + msg1);
						// 메시지 처리하기
						this.cc.jta_display.append("@" + sendName + "님에게 보낸 귓속말 : " + msg1 + "\n");
					}
				} catch (Exception ea) {
					// TODO: handle exception
				}
			}
			/* 원본
			 * if(sendName==null||sendName.trim().length()<1){
			 
				JOptionPane.showMessageDialog(this, "귓속말 할 유저를 선택하세요","INFO",JOptionPane.INFORMATION_MESSAGE);
				return;	
			}
			
			if(cc.nickName==sendName){
				JOptionPane.showMessageDialog(this, "다른 상대를 입력하세요","INFO",JOptionPane.INFORMATION_MESSAGE);
			}
			
			String msg1 = JOptionPane.showInputDialog(sendName+"에게 보낼 귓말을 입력하세요");
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