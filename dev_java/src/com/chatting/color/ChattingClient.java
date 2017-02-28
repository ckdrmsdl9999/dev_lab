package com.chatting.color;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledDocument;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;
public class ChattingClient extends JFrame implements ActionListener {
	//선언부
	Socket socket = null;
	//대화명을 담을 변수 선언
	String nickName = null;
	//화면 배치하기 시작//
	JPanel jp_first = new JPanel();
	//JTextArea에는 부분 색상 적용이 불가합니다.
	//오직 텍스트로만 출력할 수 있습니다.
	//이미지를 처리할 수 없습니다.
	//텍스트도 그리는 개념으로 처리하는 클래스가 필요합니다.
//	JTextArea jta_display = new JTextArea();
	StyledDocument sd_display = new DefaultStyledDocument(new StyleContext());
	JTextPane jtp_display = new JTextPane(sd_display);
	JScrollPane jsp_display = new JScrollPane(jtp_display
			                     ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			                     ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel jp_first_south = new JPanel();
	JTextField jtf_msg = new JTextField();
	JButton jbtn_send = new JButton("전송");
	JPanel jp_second = new JPanel();
	String cols[] = {"대화명"};
	String data[][] = new String[0][1];
	DefaultTableModel dtm_room = new DefaultTableModel(data,cols);
	JTable jt_room = new JTable(dtm_room);
	JScrollPane jsp_room = new JScrollPane(jt_room
			                              ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
                                          ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel jp_second_south = new JPanel();
	JButton jbtn_whisper 	= new JButton("귓속말");
	JButton jbtn_change 	= new JButton("대화명변경");
	JButton jbtn_roomout 	= new JButton("나가기");
	JButton jbtn_close 		= new JButton("종료");
	JButton jbtn_fontColor	= new JButton("글자색");
	JButton jbtn_fontStyle	= new JButton("폰트스타일");
	JFrame jf_fontColor     = null;
	JTextField jtf_fontSize = new JTextField(5);
	JButton jbtn_bold = new JButton("굵은글씨");
	JButton jbtn_italic = new JButton("이탤릭체");
	//사용자가 선택한 색상 정보를 담을 변수 선언 - 서버로 전송할 때 색상정보도 전송
	static String fontColor = "0";//사용자가 선택한 색상정보 담기
	//사용자가 선택한 폰트 타입 담을 변수 선언
	static String fontType ="";
	//사용자가 선택한 폰트 사이즈 담을 변수 선언
	static int fontSize=12;
	ObjectInputStream	ois = null;//듣기
	ObjectOutputStream  oos = null;//말하기
	//화면 배치하기  끝//
	//생성자
	//1)화면처리
	//2)서버소켓 생성
	//3)클라이언트 소켓정보를 받아온다.
	//4)스레드 생성하고 start() 호출
	public ChattingClient(){
		//창닫기 버튼을 클릭했을 때
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				exitChat();
				System.exit(0);
			}
		});
		nickName = JOptionPane.showInputDialog("대화명을 입력하세요.");
		try {
			socket = new Socket("192.168.0.31",3000);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			//서버로 메시지 전송하기
			oos.writeObject(Protocol.ROOM_IN+"|"+nickName+"|"+fontColor);
			ChattingClientThread cct = new ChattingClientThread(this);
			cct.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//화면처리부
	public void initDisplay(){
		jtf_fontSize.addActionListener(this);
		jbtn_bold.addActionListener(this);
		jbtn_italic.addActionListener(this);
		jbtn_change.addActionListener(this);
		jbtn_whisper.addActionListener(this);
		jbtn_send.addActionListener(this);
		jbtn_close.addActionListener(this);
		jbtn_fontColor.addActionListener(this);
		jbtn_fontStyle.addActionListener(this);
		jbtn_roomout.addActionListener(this);
		jtf_msg.addActionListener(this);//이벤트 감지(JVM) - actionPerformed
		this.setLayout(new GridLayout(1,2));
		jp_first.setLayout(new BorderLayout());
		jp_first_south.setLayout(new BorderLayout());
		jp_first_south.add("Center", jtf_msg);
		jp_first_south.add("East", jbtn_send);
		jp_first.add("Center",jsp_display);
		jp_first.add("South", jp_first_south);
		jp_second.setLayout(new BorderLayout());
		jp_second_south.setLayout(new GridLayout(3,2));
		jp_second_south.add(jbtn_whisper);
		jp_second_south.add(jbtn_change);
		jp_second_south.add(jbtn_roomout);
		jp_second_south.add(jbtn_close);
		//insert here
		jp_second_south.add(jbtn_fontColor);
		jp_second_south.add(jbtn_fontStyle);
		jp_second.add("Center", jsp_room);
		jp_second.add("South", jp_second_south);
		this.add(jp_first);
		this.add(jp_second);
		this.setTitle(nickName+"님의 대화창");
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public void exitChat(){
		try{
			oos.writeObject(Protocol.ROOM_OUT+"|"+this.nickName+"|"+fontColor);
		}catch(Exception e){

		} 
    }	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();//이벤트가 감지된 컴포넌트의 주소번지를 담고
		String msg = jtf_msg.getText();//사용자가 입력한 메시지를 담는다.
		if(obj == jtf_msg || obj == jbtn_send){
			try {
				oos.writeObject(Protocol.MESSAGE+"|"+
						nickName+"|"+
						msg+"|"+fontColor+"|"+fontType+"|"+fontSize);
			} catch (Exception e) {
				// TODO: handle exception
			}
			jtf_msg.setText("");
		}///////////////end of 메시지 전송
		//대화명 변경버튼 클릭했을 때
		else if(obj == jbtn_change){
			//변경할 대화명 입력받기
			String afterName = JOptionPane.showInputDialog("변경할 대화명을 입력하세요.");
			//대화명이 널이거나 문자열의 길이가 1보다 작으면 처음부터 다시
			if(afterName == null || afterName.trim().length() < 1){
				JOptionPane.showMessageDialog(this
						                     , "변경할 대화명을 입력하세요"
						                     , "INFO"
						                     , JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			//메시지 전송
			try {
				//300|하하|나신입|하하님의 대화명이 나신입으로 변경
				oos.writeObject(Protocol.CHANGE+"|"+
						nickName+"|"+
						afterName+"|"+
						nickName+"님의 대화명이 "+afterName+"으로 변경"+"|"+fontColor);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}/////////// end of 대화명 변경 끝
		else if(obj == jbtn_whisper){
			//귓속말 상대를 선택(테이블)하기
			int row = jt_room.getSelectedRow();
			//상대를 선택하지 않았니? - 귓속말 상대를 선택하세요 메시지
			if(row == -1){
				JOptionPane.showMessageDialog(this
	                     , "귓속말 상대를 선택하세요"
	                     , "INFO"
	                     , JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			//상대를 선택했니? - 네
			else{
				//상대방의 이름
				//선택한 상대의 이름을 테이블에서 읽어와서 name변수에 담기
				String name = (String)dtm_room.getValueAt(row, 0);
				//System.out.println("상대이름:"+name);
			
			//만일 선택한 상대가 나 자신이면 다른 상대를 선택하세요
			//메시지 처리하기
				if(nickName.equals(name)){
					JOptionPane.showMessageDialog(this
		                     , "다른 상대를 선택하세요"
		                     , "INFO"
		                     , JOptionPane.INFORMATION_MESSAGE);
					return;					
				}
			//귓속말 입력받기
			String msg1 = 
					JOptionPane.showInputDialog
					(name+"님에게 보낼 메시지 입력하세요.");
			//귓속말 전송하기
			try {
				oos.writeObject(Protocol.WHISPER+"|"+
			                            nickName+"|"+
						                    name+"|"+
			                                    msg1+"|"+fontColor);
			} catch (Exception e) {
				// TODO: handle exception
			}
			}////////////end of else
			//사용자가 선택한 테이블의 상대정보 초기화 하기.
			jt_room.clearSelection();
		}////////////////end of 귓속말
		else if(obj == jbtn_close || obj == jbtn_roomout){
			exitChat();
			System.exit(0);
		}///////////////end of 메시지 전송		
		else if(obj == jbtn_fontColor){
			jf_fontColor = new JFrame();
			JColorChooser jcc_color 
							= new JColorChooser();
			ColorSelectionModel model = 
					jcc_color.getSelectionModel();
			ChangeListener listener = 
					new ChangeListener(){
						@Override
						public void stateChanged(ChangeEvent e) {
							Color forColor = jcc_color.getColor();
							fontColor = String.valueOf(forColor.getRGB());
							//System.out.println("사용자가 선택한 색상:"+fontColor);
						}	
			};
			model.addChangeListener(listener);
			jf_fontColor.add("Center",jcc_color);		
			jf_fontColor.setSize(600, 500);
			jf_fontColor.setVisible(true);
			System.out.println("색상:"+fontColor);
		}
		else if(obj == jbtn_fontStyle){
			JDialog jd_fontStyle = new JDialog();
			jd_fontStyle.setLayout(new GridLayout(1,4));
			JLabel jlb_fontSize = new JLabel("폰트크기");
			jd_fontStyle.add(jlb_fontSize);
			jd_fontStyle.add(jtf_fontSize);
			jd_fontStyle.add(jbtn_bold);
			jd_fontStyle.add(jbtn_italic);
			jd_fontStyle.setSize(400, 80);
			jd_fontStyle.setVisible(true);
		}
		//폰트 사이즈를 입력했을 때
		else if(obj==jtf_fontSize){
			fontSize = Integer.parseInt(jtf_fontSize.getText());
		}
		//폰트 타입을 BOLD선택했을 때
		else if(obj == jbtn_bold){
			fontType="Font.BOLD";//굵은글씨
		}
		//폰트 타입을 ITALIC선택했을 때
		else if(obj == jbtn_italic){
			fontType="Font.ITALIC";//이탤릭체
		}
	}////////////////////end of actionPerformed

	public static void main(String[] args) {
		ChattingClient cc =
				new ChattingClient();
		cc.initDisplay();
	}

}
