package pro_03;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

//import com.sun.org.apache.xpath.internal.Arg;

public class ChattingClient extends JFrame implements ActionListener {
	List<ChatmemberVO> cVO;
	JPanel room_list_panel 	= new JPanel(new BorderLayout());
	JPanel test_panel2 	= new JPanel(new GridLayout(1, 2));
	JPanel jp_tabPanel		= new JPanel();
//	<선언부>
	Socket socket = null;//클라이언트에 대한 소켓을 받아오는 애(서버에 대한 것도 받지만!)
	String nickName;//대화명을 담을 변수 선언
//	화면 배치하기 시작
	JPanel jp_first 		= new JPanel();
	JTextArea jta_display;
	JScrollPane jsp_display;//VERTICAL_SCROLLBAR_AS_NEEDED는 필요할때 보여주세요.
	
	String cols[] 			= {"대화방 제목","인원"};
	String data[][]	;
	DefaultTableModel dtm_room;
	JTable jt_room	;
	JScrollPane jsp_roomList;//VERTICAL_SCROLLBAR_AS_NEEDED는 필요할때 보여주세요.)
	JPanel jp_first_south 	= new JPanel();
	JTextField jtf_msg 		= new JTextField();
	JButton jbtn_send 		= new JButton("전송");
	JButton jbtn_room_make;
	JButton jbtn_room_make1		= new JButton("방만들기");
	JButton jbtn_room_in;
	ChattingClientTab1 tab1=null;
	ChattingClientTab2 tab2=null;
	ChattingClientTab3 tab3=null;
	ObjectInputStream ois = null;//듣기 할 때
	JTabbedPane tab;	
	ObjectOutputStream oos = null;//말하기 할 때 
	String roomTittle;
	Test  test;
	boolean loginChk=false;
//------------------------화면 배치하기 끝--------------------------------------
//		<생성자>
//		 1.화면처리
//		 2.서버소켓을 생성
//		 3.client소켓 정보를 받아온다
//		 4.Thread생성, Start()호출
	public ChattingClient(){//<생성자>		
		try {
			socket = new Socket("192.168.0.31",3000);		
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeObject(Protocol.ROOM_LIST+"|");
			ChattingClientThread cct = new ChattingClientThread(this);
			cct.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//		로그인 후 채팅방 리스트 화면
public void mainPage(String nickname){
	//public  void mainPage(){
		//int random = (int) (Math.random() * 100); 
		//this.nickName+=random;
		this.tab = new JTabbedPane();	
		this.tab1= new ChattingClientTab1(this);
		this.tab2= new ChattingClientTab2(this);
		this.tab3= new ChattingClientTab3(this);
		this.jbtn_send.addActionListener(this);
		try {
			oos.writeObject(Protocol.ROOM_LIST+"|");
			this.jta_display = new JTextArea();
			this.jsp_display =
						new JScrollPane(jta_display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
										,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 dtm_room = new DefaultTableModel(this.data,cols);
		 jt_room	= new JTable(dtm_room);
		 jsp_roomList = new JScrollPane(jt_room
					,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
					,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jbtn_room_make		= new JButton("방만들기");
		jbtn_room_in		= new JButton("방들어가기");
		jbtn_room_make.addActionListener(this);
		jbtn_room_in.addActionListener(this);
		this.setSize(800,500);
		this.jsp_roomList.setPreferredSize(new Dimension(800, 433));
		this.test_panel2.add("South",jbtn_room_make);
		this.test_panel2.add("South",jbtn_room_in);
		this.room_list_panel.add("North",jsp_roomList);
		this.room_list_panel.add("South",test_panel2);
		this.add("Center",room_list_panel);
		this.jsp_roomList.setVisible(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public void receive(List<ChatmemberVO> pVO) {
		tab = new JTabbedPane();	
		this.tab1= new ChattingClientTab1(this);
		this.tab2= new ChattingClientTab2(this);
		this.tab3= new ChattingClientTab3(this);
		this.jbtn_send.addActionListener(this);
		this.cVO = pVO;
		this.nickName = this.cVO.get(0).getNickname();
		this.tab3.receive(cVO);				//이것 때문에 3일 고생함.
	}
	// 채팅방에 들어갔을 때 화면
	public void initDisplay(){
		this.remove(this.room_list_panel);
		this.setLayout(new BorderLayout());
		this.setLayout(new GridLayout(1,2));
		jtf_msg.requestFocus();
		jtf_msg.addActionListener(this);
		jp_first.setLayout(new BorderLayout());
		jp_first_south.setLayout(new BorderLayout());
		jp_first_south.add("Center", jtf_msg);
		jp_first_south.add("East", jbtn_send);
		jp_first.add("Center",this.jsp_display);
		jp_first.add("South",jp_first_south);		  
		tab.add("채팅 참여자", this.tab1.chattList);
		tab.add("방 목록", this.tab2.roomList);
		tab.add("프로필", this.tab3.panel);
		jp_tabPanel.setLayout(new BorderLayout());
		jp_tabPanel.add(tab);
		this.add(jp_first);
			this.add(jp_tabPanel);
			this.setTitle(nickName+"님의 대화창");
			this.setSize(500,600);
			this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();//이벤트가 감지된 컴포넌트의 주소번지를 담고
	      if( obj == jbtn_send||obj == jtf_msg){
	    	  String msg = jtf_msg.getText();//사용자가 입력한 메시지를 담는다.
	         try {
	            this.oos.writeObject(Protocol.MESSAGE+"|"+
	                              this.nickName+"|"+
	                              msg);
	         } catch (Exception e) {
	            // TODO: handle exception
	         }
	         jtf_msg.setText("");//텍스트 초기화
	      }else if(obj == jbtn_room_make){
	    	   test= new Test(this);
	    	   jbtn_room_make1.addActionListener(this);
	    	   jbtn_room_make1=test.jb;
	    	   //채팅방 만들기 버튼 액션
	      }else if(obj == jbtn_room_make1){
	    	  try {
					oos.writeObject(Protocol.ROOM_MAKE+"|"+
							nickName+"|"+
					      test.tf_room.getText()+"|"+test.tf.getText()
					       );
					
					test.dispose();
				} catch (IOException ea) {
					// TODO Auto-generated catch block
					ea.printStackTrace();
				}
	      }else if(obj==jbtn_room_in){
	    	  this.roomTittle = (String) dtm_room.getValueAt(this.jt_room.getSelectedRow(),0);
	    	  String roomMax = (String) dtm_room.getValueAt(this.jt_room.getSelectedRow(),1);
	    	  StringTokenizer st = new StringTokenizer(roomMax," / ");
	    	  int max1 =Integer.parseInt(st.nextToken());
	    	  int max2 =Integer.parseInt(st.nextToken());
	    	  if(max1<max2){
	    		  try {
	    			  oos.writeObject(Protocol.ROOM_IN+"|"+this.jt_room.getSelectedRow()+"|"+this.nickName+"|"+this.roomTittle+"|");
	    		  } catch (IOException ea) {
	    			  ea.printStackTrace();
	    		  }
	    	  }else{
	    		  JOptionPane.showMessageDialog(this, "이미 인원이 다 찼습니다..", "Error", JOptionPane.ERROR_MESSAGE);
	    	  }
	     }
	 } 
}

