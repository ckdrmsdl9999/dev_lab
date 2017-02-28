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
	//ObjectInputStream ois = null;//듣기 할 때
	//ObjectOutputStream oos = null;//말하기 할 때
	ChattingClient cc;
	JPanel roomList_south  = new JPanel(new GridLayout(1, 2));
	String cols[] 			= {"대화방 리스트"};
	String data[][]			= new String[0][1];
	DefaultTableModel dtm_room = new DefaultTableModel(data,cols);
	JTable jt_room	= new JTable(dtm_room);
	JScrollPane jsp_roomList = new JScrollPane(jt_room
				,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
				,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//VERTICAL_SCROLLBAR_AS_NEEDED는 필요할때 보여주세요.)
	JButton room_make = new JButton("만들기");
	JButton room_remove = new JButton("지우기");
	Test test ;
	Socket socket = null;
	public ChattingClientTab2(ChattingClient cc){
		this.cc=cc;
		roomList = new JPanel();
		room_make.addActionListener(this);
		initDisplay();
	}
	//채팅창 오른쪽 방목록 화면
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
//만들기 버튼누르면 만들어치는 팝업창
class Test extends JFrame{
	JPanel jp = new JPanel(); // 패널 초기화
	JButton jb = new JButton("만들기"); // 버튼 초기화
	JLabel jl_room = new JLabel("채팅방 이름"); // 레이블 초기화
	JLabel jl = new JLabel("인원수"); // 레이블 초기화
	JTextField tf_room = new JTextField(10); // 텍스트필드 초기화
	JTextField tf = new JTextField(2); // 텍스트필드 초기화
	public Test(ChattingClientTab2 tab2){
		jb.addActionListener(tab2);	
		jp.add(jl_room); // jp라는 패널에 jl라는 레이블 추가
		jp.add(tf_room); // jp라는 패널에 tf라는 텍스트필드 추가
		jp.add(jl); // jp라는 패널에 jl라는 레이블 추가
		jp.add(tf); // jp라는 패널에 tf라는 텍스트필드 추가
		jp.add(jb); // jp라는 패널에 jb라는 버튼 추가
		add(jp); // JFrame에 jp라는 패널 추가		
		setSize(400, 80); // 윈도우의 크기 가로x세로
		setVisible(true); // 창을 보여줄떄 true, 숨길때 falsess		
	}
	public Test(ChattingClient cc){
		jb.addActionListener(cc);	
		jp.add(jl_room); // jp라는 패널에 jl라는 레이블 추가
		jp.add(tf_room); // jp라는 패널에 tf라는 텍스트필드 추가
		jp.add(jl); // jp라는 패널에 jl라는 레이블 추가
		jp.add(tf); // jp라는 패널에 tf라는 텍스트필드 추가
		jp.add(jb); // jp라는 패널에 jb라는 버튼 추가
		add(jp); // JFrame에 jp라는 패널 추가		
		setSize(400, 80); // 윈도우의 크기 가로x세로
		setVisible(true); // 창을 보여줄떄 true, 숨길때 false
		this.setLocationRelativeTo(null);
		
	}
}
