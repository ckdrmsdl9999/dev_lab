package com.projectTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import chat.KosmoCRUD;

//import project.gridLayout;
public class ChattingClient extends JFrame implements ActionListener, KeyListener {
	ChattingClientThread cct;

	// 선언부
	Socket socket = null;
	// 대화명을 담을 변수 선언
	String nickName = null;
	// 화면 배치하기 시작//
	JPanel jp_first = new JPanel();
	// JTextArea에는 부분 색상 적용이 불가합니다.
	// 오직 텍스트로만 출력할 수 있습니다.
	// 이미지를 처리할 수 없습니다.
	// 텍스트도 그리는 개념으로 처리하는 클래스가 필요합니다.
	// JTextArea jta_display = new JTextArea();
	StyledDocument sd_display = new DefaultStyledDocument(new StyleContext());
	JTextPane jtp_display = new JTextPane(sd_display);
	JScrollPane jsp_display = new JScrollPane(jtp_display, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel jp_first_south = new JPanel();
	JTextPane jtf_msg = new JTextPane();
	JButton jbtn_send = new JButton("전송");
	JPanel jp_second = new JPanel();
	String cols[] = { "대화명" };
	String data[][] = new String[0][1];
	DefaultTableModel dtm_room = new DefaultTableModel(data, cols);
	JTable jt_room = new JTable(dtm_room);
	JScrollPane jsp_room = new JScrollPane(jt_room, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel jp_second_south = new JPanel();
	JButton jbtn_whisper = new JButton("귓속말");
	JButton jbtn_change = new JButton("대화명변경");
	JButton jbtn_roomout = new JButton("나가기");
	JButton jbtn_close = new JButton("종료");
	JButton jbtn_fontColor = new JButton("글자색");
	JButton jbtn_emoticon = new JButton("이모티콘");
//	JButton jbtn_photo = new JButton("사진전송");
	JFrame jf_fontColor = null;
	JPanel jp_emo = null;
	JFrame jf_emoticon = null;
	JFrame jf = new JFrame();
	JButton jbtns[] = new JButton[9];

	String jbtn_label[] = { "", "", "", "", "", "", "", "", "" };
	JButton jbtn = new JButton(jbtn_label[0]);
	// private Image img[];
	// String imgName = "";
	// String imgPath = "src/com/projectTest/";

	BufferedImage image[];

	String path = "src\\com\\projectTest\\";

	ImageIcon img1 = new ImageIcon(getClass().getResource("0.jpg"));
	Image reimg1 = img1.getImage(); // ImageIcon을 Image로 변환.
	Image rreimg1 = reimg1.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg1 = new ImageIcon(rreimg1); // Image로 ImageIcon 생성

	KosmoCRUD kc = new KosmoCRUD();

	// 사용자가 선택한 색상 정보를 담을 변수 선언 - 서버로 전송할 때 색상정보도 전송
	static String fontColor = "0";// 사용자가 선택한 색상정보 담기
	static String emoticon = "0";
	ObjectInputStream ois = null;// 듣기
	ObjectOutputStream oos = null;// 말하기
	// 화면 배치하기 끝//
	// 생성자
	// 1)화면처리
	// 2)서버소켓 생성
	// 3)클라이언트 소켓정보를 받아온다.
	// 4)스레드 생성하고 start() 호출

	public ChattingClient() {
	}

	public ChattingClient(String nickname) {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				exitChat();
				System.exit(0);
			}
		});
		this.nickName = nickname;
		try {
			socket = new Socket("192.168.0.39", 3000);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeObject(Protocol.ROOM_IN + "|" + nickName + "|" + fontColor);
			cct = new ChattingClientThread(this);
			cct.start();
			initDisplay();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 화면처리부
	public void initDisplay() {
		jbtn_change.addActionListener(this);
		jbtn_whisper.addActionListener(this);
		jbtn_send.addActionListener(this);
		jbtn_close.addActionListener(this);
		jbtn_fontColor.addActionListener(this);
		jbtn_emoticon.addActionListener(this);
		jbtn_roomout.addActionListener(this);
//		jbtn_photo.addActionListener(this);
		jtf_msg.addKeyListener(this);

		// jtf_msg.addActionListener(this);//이벤트 감지(JVM) - actionPerformed
		jtp_display.enable(false);
		this.setLayout(new GridLayout(1, 2));
		jp_first.setLayout(new BorderLayout());
		jp_first_south.setLayout(new BorderLayout());
		jp_first_south.add("Center", jtf_msg);
		jp_first_south.add("East", jbtn_send);
		jp_first.add("Center", jsp_display);
		jp_first.add("South", jp_first_south);
		jp_second.setLayout(new BorderLayout());
		jp_second_south.setLayout(new GridLayout(4, 2));
		jp_second_south.add(jbtn_whisper);
		jp_second_south.add(jbtn_change);
		jp_second_south.add(jbtn_close);
		// insert here
		jp_second_south.add(jbtn_fontColor);
		jp_second_south.add(jbtn_emoticon);
//		jp_second_south.add(jbtn_photo);
		jp_second_south.add(jbtn_roomout);
		jp_second.add("Center", jsp_room);
		jp_second.add("South", jp_second_south);
		this.add(jp_first);
		this.add(jp_second);
		this.setTitle(nickName + "님의 대화창");
		this.setSize(500, 400);
		this.setVisible(true);
		this.emoticon();
	}

	public void exitChat() {
		try {
			oos.writeObject(Protocol.ROOM_OUT + "|" + this.nickName + "|" + fontColor);
			String id = kc.memberID(this.nickName);
			kc.memberState(id, 0);
		} catch (Exception e) {
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();// 이벤트가 감지된 컴포넌트의 주소번지를 담고
		String msg = jtf_msg.getText();// 사용자가 입력한 메시지를 담는다.
		if (obj == jtf_msg || obj == jbtn_send) {
			try {
				oos.writeObject(Protocol.MESSAGE + "|" + nickName + "|" + msg + "|" + fontColor + "|" + emoticon);
			} catch (Exception e) {
				// TODO: handle exception
			}
			jtf_msg.setText("");
		} /////////////// end of 메시지 전송
			// 대화명 변경버튼 클릭했을 때
		else if (obj == jbtn_change) {
			// 변경할 대화명 입력받기

			String afterName = JOptionPane.showInputDialog("변경할 대화명을 입력하세요.");
			if (kc.nicknameCheak(afterName) != null) {
				JOptionPane.showMessageDialog(this, "중복되는 닉네임입니다.", "INFO", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			// 대화명이 널이거나 문자열의 길이가 1보다 작으면 처음부터 다시
			else if (afterName == null || afterName.trim().length() < 1) {
				JOptionPane.showMessageDialog(this, "변경할 대화명을 입력하세요", "INFO", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			// 메시지 전송
			try {
				// 300|하하|나신입|하하님의 대화명이 나신입으로 변경
				oos.writeObject(Protocol.CHANGE + "|" + nickName + "|" + afterName + "|" + nickName + "님의 대화명이 "
						+ afterName + "으로 변경" + "|" + fontColor);

				kc.NicknameChange(nickName, afterName);

			} catch (Exception e) {
				// TODO: handle exception
			}
		} /////////// end of 대화명 변경 끝
		else if (obj == jbtn_whisper) {
			// 귓속말 상대를 선택(테이블)하기
			int row = jt_room.getSelectedRow();
			// 상대를 선택하지 않았니? - 귓속말 상대를 선택하세요 메시지
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "귓속말 상대를 선택하세요", "INFO", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			// 상대를 선택했니? - 네
			else {
				// 상대방의 이름
				// 선택한 상대의 이름을 테이블에서 읽어와서 name변수에 담기
				String name = (String) dtm_room.getValueAt(row, 0);
				// System.out.println("상대이름:"+name);

				// 만일 선택한 상대가 나 자신이면 다른 상대를 선택하세요
				// 메시지 처리하기
				if (nickName.equals(name)) {
					JOptionPane.showMessageDialog(this, "다른 상대를 선택하세요", "INFO", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				// 귓속말 입력받기
				String msg1 = JOptionPane.showInputDialog(name + "님에게 보낼 메시지 입력하세요.");
				// 귓속말 전송하기
				try {
					oos.writeObject(Protocol.WHISPER + "|" + nickName + "|" + name + "|" + msg1 + "|" + fontColor);
				} catch (Exception e) {
					// TODO: handle exception
				}
			} //////////// end of else
				// 사용자가 선택한 테이블의 상대정보 초기화 하기.
			jt_room.clearSelection();
		} //////////////// end of 귓속말
		else if (obj == jbtn_close || obj == jbtn_roomout) {
			exitChat();
			System.exit(0);
		} /////////////// end of 메시지 전송
		else if (obj == jbtn_fontColor) {
			jf_fontColor = new JFrame();
			JColorChooser jcc_color = new JColorChooser();
			ColorSelectionModel model = jcc_color.getSelectionModel();
			ChangeListener listener = new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					Color forColor = jcc_color.getColor();
					fontColor = String.valueOf(forColor.getRGB());
					// System.out.println("사용자가 선택한 색상:"+fontColor);
				}
			};
			model.addChangeListener(listener);
			jf_fontColor.add("Center", jcc_color);
			jf_fontColor.setSize(600, 500);
			jf_fontColor.setVisible(true);
			System.out.println("색상:" + fontColor);
		} else if (obj == jbtn_emoticon) {
			jf.setSize(350, 350);
			jf.setVisible(true);
		}
		if (obj == jbtns[0]) {
			System.out.println("/흑흑");
			jtf_msg.setText("/흑흑");
			jf.dispose();
			msg = jtf_msg.getText();
			try {
				oos.writeObject(Protocol.EMOTICON + "|" + nickName + "|" + msg + "|" + fontColor);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if (obj == jbtns[1]) {
			System.out.println("/잘자");
			jtf_msg.setText("/잘자");
			jf.dispose();
			msg = jtf_msg.getText();
			try {
				oos.writeObject(Protocol.EMOTICON + "|" + nickName + "|" + msg + "|" + fontColor);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (obj == jbtns[2]) {
			System.out.println("/헙");
			jtf_msg.setText("/헙");
			jf.dispose();
			msg = jtf_msg.getText();

			try {
				oos.writeObject(Protocol.EMOTICON + "|" + nickName + "|" + msg + "|" + fontColor);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (obj == jbtns[3]) {
			System.out.println("/심심");
			jtf_msg.setText("/심심");
			jf.dispose();
			msg = jtf_msg.getText();
			try {
				oos.writeObject(Protocol.EMOTICON + "|" + nickName + "|" + msg + "|" + fontColor);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (obj == jbtns[4]) {
			System.out.println("/뭐지");
			jtf_msg.setText("/뭐지");
			jf.dispose();
			msg = jtf_msg.getText();

			try {
				oos.writeObject(Protocol.EMOTICON + "|" + nickName + "|" + msg + "|" + fontColor);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (obj == jbtns[5]) {
			System.out.println("/오케이");
			jtf_msg.setText("/오케이");
			jf.dispose();
			msg = jtf_msg.getText();

			try {
				oos.writeObject(Protocol.EMOTICON + "|" + nickName + "|" + msg + "|" + fontColor);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (obj == jbtns[6]) {
			System.out.println("/따봉");
			jtf_msg.setText("/따봉");
			jf.dispose();
			msg = jtf_msg.getText();
			try {
				oos.writeObject(Protocol.EMOTICON + "|" + nickName + "|" + msg + "|" + fontColor);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (obj == jbtns[7]) {
			System.out.println("/좋았어");
			jtf_msg.setText("/좋았어");
			jf.dispose();
			msg = jtf_msg.getText();

			try {
				oos.writeObject(Protocol.EMOTICON + "|" + nickName + "|" + msg + "|" + fontColor);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (obj == jbtns[8]) {
			System.out.println("/하하");
			jtf_msg.setText("/하하");
			jf.dispose();
			msg = jtf_msg.getText();

			try {
				oos.writeObject(Protocol.EMOTICON + "|" + nickName + "|" + msg + "|" + fontColor);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// http://adunhansa.tistory.com/36

	}//////////////////// end of actionPerformed

	public void emoticon() {
		jf.setLayout(new GridLayout(3, 3));
		jbtns[0] = new JButton(jbtn_label[0], new ImageIcon(path + "0.jpg"));
		jbtns[1] = new JButton(jbtn_label[1], new ImageIcon(path + "1.jpg"));
		jbtns[2] = new JButton(jbtn_label[2], new ImageIcon(path + "2.jpg"));
		jbtns[3] = new JButton(jbtn_label[3], new ImageIcon(path + "3.jpg"));
		jbtns[4] = new JButton(jbtn_label[4], new ImageIcon(path + "4.jpg"));
		jbtns[5] = new JButton(jbtn_label[5], new ImageIcon(path + "5.jpg"));
		jbtns[6] = new JButton(jbtn_label[6], new ImageIcon(path + "6.jpg"));
		jbtns[7] = new JButton(jbtn_label[7], new ImageIcon(path + "7.jpg"));
		jbtns[8] = new JButton(jbtn_label[8], new ImageIcon(path + "8.jpg"));

		jbtns[0].addActionListener(this);
		jbtns[1].addActionListener(this);
		jbtns[2].addActionListener(this);
		jbtns[3].addActionListener(this);
		jbtns[4].addActionListener(this);
		jbtns[5].addActionListener(this);
		jbtns[6].addActionListener(this);
		jbtns[7].addActionListener(this);
		jbtns[8].addActionListener(this);
		jbtn_emoticon.addActionListener(this);

		jf.add(jbtns[0]);
		jf.add(jbtns[1]);
		jf.add(jbtns[2]);
		jf.add(jbtns[3]);
		jf.add(jbtns[4]);
		jf.add(jbtns[5]);
		jf.add(jbtns[6]);
		jf.add(jbtns[7]);
		jf.add(jbtns[8]);
		jf.setResizable(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		String msg = jtf_msg.getText();
		if (e.getKeyCode() == 10) { //엔터의 keyCode()이 10 
			try {
				oos.writeObject(Protocol.MESSAGE + "|" + nickName + "|" + msg + "|" + fontColor + "|" + emoticon);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			jtf_msg.setText("");
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}