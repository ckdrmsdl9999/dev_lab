package com.projectTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import chat.KosmoCRUD;
import chat.MemberVO;
import chat.member2;

public class Client extends JFrame implements ActionListener {
	// Login 변수
	JPanel login_jp;
	JTextField id_jtf;
	JLabel jl_ip = new JLabel("IP");
	JLabel jl_port = new JLabel("PORT");
	JLabel jl_id = new JLabel("ID");
	JFrame jf_login = new JFrame("Login");
	JButton jb_logo = new JButton("이미지 로고");
	JButton jb_login = new JButton("로그인");
	JButton jb_idpw = new JButton("ID/PW 찾기");
	JButton jb_signin = new JButton("회원가입");
	JPasswordField pw_jtf = new JPasswordField();

	// 채팅 대기방 변수
	JPanel main_jp;
	JButton jb_room_ct = new JButton("방만들기");
	JButton jb_fr = new JButton("친구목록");
	JButton jb_room_enter = new JButton("방입장");
	JButton button_2 = new JButton("임의1");
	JButton jb_Pf = new JButton("환경설정");

	JList user_list = new JList(); // 접속자 리스트
	JList chat_list = new JList(); // 채팅방 리스트

	// 채팅방 변수
	JFrame jf_chat = new JFrame("채팅방");
	JPanel chat_jp;
	JTextField textField;
	JTextField textField_1;
	JButton jb_send = new JButton("전송");
	JLabel label;

	// 환경설정 변수
	JFrame jf_cs = new JFrame("환경설정");
	JPanel contentPane;
	JTextField txtKosmo;
	JButton jbt_ok = new JButton("확인");

	// 회원 가입 변수
	JFrame jf_member = new JFrame("회원가입");
	JPanel jp_member;
	JTextField mem_tf_id;
	JTextField mem_tf_hint_a1;
	JTextField mem_tf_hint_a2;
	JTextField mem_tf_name;
	JTextField mem_tf_hp;
	JTextField mem_tf_address;
	JTextField mem_tf_nickname;
	JLabel label_1;
	JLabel label_2;
	JLabel label_3;
	JLabel label_4;
	JLabel label_5;
	JLabel label_7;
	JButton jb_ok = new JButton("확인");
	JButton jb_cancel = new JButton("취소");
	ButtonGroup bg = new ButtonGroup();;
	JComboBox mem_comboBox;
	JComboBox mem_comboBox_1;
	JTextField tf_birth;
	JLabel lblYyyyd;
	JPasswordField tf_pw22;
	JPasswordField tf_pw1;

	JButton jb_nick_check;
	JButton jb_id_check;

	int ch = 0;

	// ID/PW 찾기 변수
	JFrame jf_pw_find = new JFrame("비밀번호 찾기");
	JPanel jp_pw_find;
	JTextField tf_id;
	JTextField tf_hint1_A;
	JTextField tf_hint2_A;
	JLabel jlb_hint1_A;
	JLabel jlb_hint2_Q;
	JLabel jlb_hint2_A;
	JComboBox comboBox;
	JComboBox comboBox_1;
	JButton jb_pw_find_ok = new JButton("확인");
	JButton jb_pw_find_cancel = new JButton("취소");
	JButton jb_id_find = new JButton("조회");

	// 네트워크를 위한 자원 변수
	Socket socket;
	final String ip = "127.0.0.1";
	final int port = 1107;
	String id = "";
	String pw = "";
	InputStream is;
	OutputStream os;
	DataInputStream dis;
	DataOutputStream dos;

	// 그 외 변수들
	Vector us_list = new Vector();
	Vector rm_list = new Vector();
	String Nickname = "";
	StringTokenizer st;
	KosmoCRUD kc = new KosmoCRUD();
	member2 mb = new member2();

	private Client() {
		LoginInit();
	}
	private void LoginInit() {
		String path = "src\\com\\projectTest\\";
		jb_logo = new JButton(new ImageIcon(path + "logo_1.png"));
		this.add(jb_logo);

		// 이벤트 핸들러
		jb_login.addActionListener(this);
		jb_idpw.addActionListener(this);
		jb_signin.addActionListener(this);

		jf_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf_login.setBounds(100, 50, 255, 369);  //255, 277
		// jf_login.setBounds(x, y, width, height);
		login_jp = new JPanel();
		login_jp.setBorder(new EmptyBorder(5, 5, 5, 5));
		jf_login.setContentPane(login_jp);
		login_jp.setLayout(null);

		jb_login.setBounds(130, 223, 97, 65);
		login_jp.add(jb_login);

		id_jtf = new JTextField();
		id_jtf.setBounds(12, 223, 97, 21);
		login_jp.add(id_jtf);
		id_jtf.setColumns(10);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(12, 208, 34, 15);
		login_jp.add(lblId);

		jb_idpw.setBounds(12, 298, 97, 23);
		login_jp.add(jb_idpw);

		jb_logo.setBounds(12, 10, 215, 180);
		login_jp.add(jb_logo);

		jb_signin.setBounds(130, 298, 97, 23);
		login_jp.add(jb_signin);

		pw_jtf.setBounds(12, 268, 97, 20);
		login_jp.add(pw_jtf);

		JLabel lblId_1 = new JLabel("PW");
		lblId_1.setBounds(12, 248, 24, 15);
		login_jp.add(lblId_1);

		jf_login.setVisible(true);
		jf_login.setResizable(true);
		jf_login.setLocation(300, 300);
	}
	private void MainInit() {
		jb_room_enter.addActionListener(this);
		jb_Pf.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 367);
		main_jp = new JPanel();
		main_jp.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(main_jp);
		main_jp.setLayout(null);

		user_list.setBounds(331, 121, 151, 170);
		main_jp.add(user_list);

		chat_list.setBounds(12, 121, 298, 170);
		main_jp.add(chat_list);

		JLabel label = new JLabel("접속자");
		label.setBounds(331, 96, 57, 15);
		main_jp.add(label);

		// jb_room_ct.setFont(new Font("굴림", Font.PLAIN, 10));
		jb_room_ct.setBounds(12, 20, 80, 55);
		main_jp.add(jb_room_ct);

		JLabel label_1 = new JLabel("방 리스트");
		label_1.setBounds(12, 96, 57, 15);
		main_jp.add(label_1);

		// jb_fr.setFont(new Font("굴림", Font.PLAIN, 10));
		jb_fr.setBounds(104, 20, 80, 55);
		main_jp.add(jb_fr);

		// button_1.setFont(new Font("굴림", Font.PLAIN, 10));
		jb_room_enter.setBounds(196, 20, 80, 55);
		main_jp.add(jb_room_enter);

		// button_2.setFont(new Font("굴림", Font.PLAIN, 10));
		button_2.setBounds(288, 20, 80, 55);
		main_jp.add(button_2);

		// jb_Pf.setFont(new Font("굴림", Font.PLAIN, 10));
		jb_Pf.setBounds(380, 20, 80, 55);
		main_jp.add(jb_Pf);
		this.setVisible(true);
		this.setResizable(false);
	}

	private void ChatInit() {
		jf_chat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf_chat.setBounds(100, 100, 500, 420);
		chat_jp = new JPanel();
		chat_jp.setBorder(new EmptyBorder(5, 5, 5, 5));
		jf_chat.setContentPane(chat_jp);
		chat_jp.setLayout(null);

		JList list = new JList();
		list.setBounds(336, 34, 136, 287);
		chat_jp.add(list);

		JLabel lblNewLabel = new JLabel("\uC811\uC18D\uC790");
		lblNewLabel.setBounds(336, 9, 136, 15);
		chat_jp.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(12, 331, 299, 41);
		chat_jp.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(12, 32, 299, 289);
		chat_jp.add(textField_1);
		textField_1.setColumns(10);

		jb_send.setBounds(336, 331, 136, 41);
		chat_jp.add(jb_send);

		label = new JLabel("\uCC44\uD305\uBC29");
		label.setBounds(12, 9, 57, 15);
		chat_jp.add(label);
		jf_chat.setVisible(true);

	}

	private void CSInit() {

		jf_cs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf_cs.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		jf_cs.setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("환경설정");

		JLabel lblNewLabel = new JLabel("\uBC84\uC804\uC815\uBCF4");
		lblNewLabel.setBounds(12, 116, 66, 15);
		contentPane.add(lblNewLabel);

		txtKosmo = new JTextField();
		txtKosmo.setText("kosmo_ver 1.6");
		txtKosmo.setBounds(141, 113, 116, 21);
		contentPane.add(txtKosmo);
		txtKosmo.setColumns(10);

		JButton jbn_logo = new JButton("Logo");
		jbn_logo.setBounds(12, 10, 410, 90);
		contentPane.add(jbn_logo);

		JComboBox cb_font = new JComboBox();
		cb_font.setModel(new DefaultComboBoxModel(new String[] { "", "맑은고딕", "굴림체", "엽서체", "견고딕" }));
		cb_font.setBounds(141, 144, 116, 21);
		contentPane.add(cb_font);

		JLabel label = new JLabel("\uAE00\uAF34");
		label.setBounds(12, 147, 57, 15);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\uCC44\uD305\uCC3D \uBC30\uACBD\uBCC0\uACBD");
		label_1.setBounds(12, 179, 105, 15);
		contentPane.add(label_1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "", "검정색", "흰색", "민트색", "파랑색", "회색" }));
		comboBox_1.setBounds(141, 176, 116, 21);
		contentPane.add(comboBox_1);

		JLabel label_2 = new JLabel("\uACE0\uAC1D\uC13C\uD130");
		label_2.setBounds(12, 213, 57, 15);
		contentPane.add(label_2);

		JLabel lblNewLabel_1 = new JLabel("010-4242-4632");
		lblNewLabel_1.setBounds(141, 213, 116, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblkosmo = new JLabel("(\uC8FC)KOSMO");
		lblkosmo.setForeground(Color.GRAY);
		lblkosmo.setBounds(190, 238, 67, 15);
		contentPane.add(lblkosmo);
		jf_cs.setVisible(true);

		jbt_ok.setBounds(297, 112, 125, 82);
		contentPane.add(jbt_ok);

	}

	private void PW_FindInit() {
		jf_pw_find.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf_pw_find.setBounds(100, 100, 386, 285);
		jp_pw_find = new JPanel();
		jp_pw_find.setBorder(new EmptyBorder(5, 5, 5, 5));
		jf_pw_find.setContentPane(jp_pw_find);
		jp_pw_find.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(25, 36, 57, 15);
		jp_pw_find.add(lblNewLabel);

		tf_id = new JTextField();
		tf_id.setBounds(105, 33, 142, 21);
		jp_pw_find.add(tf_id);
		tf_id.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "", "\uC5B4\uBA38\uB2C8\uC758 \uACE0\uD5A5\uC740?",
				"\uC88B\uC544\uD558\uB294 \uCE90\uB9AD\uD130\uB294?",
				"\uC5B4\uB838\uC744 \uB54C \uAC00\uC7A5 \uCE5C\uD588\uB358 \uCE5C\uAD6C\uC758 \uBCC4\uBA85\uC740?" }));
		comboBox.setBounds(105, 78, 224, 21);

		jp_pw_find.add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(
				new DefaultComboBoxModel(new String[] { "", "\uAC00\uC7A5 \uC88B\uC544\uD558\uB294 \uC74C\uC2DD\uC740?",
						"\uCC98\uC74C\uC73C\uB85C \uD63C\uC790 \uB5A0\uB098\uBCF8 \uC5EC\uD589\uC9C0?",
						"\uAC00\uC7A5 \uC88B\uC544\uD558\uB294 \uC560\uC644\uB3D9\uBB3C?",
						"\uAC00\uC7A5 \uAC10\uBA85 \uAE4A\uAC8C \uBCF8 \uC601\uD654\uB294?" }));
		comboBox_1.setBounds(105, 137, 224, 21);
		jp_pw_find.add(comboBox_1);

		tf_hint1_A = new JTextField();
		tf_hint1_A.setBounds(105, 109, 172, 21);
		jp_pw_find.add(tf_hint1_A);
		tf_hint1_A.setColumns(10);

		tf_hint2_A = new JTextField();
		tf_hint2_A.setBounds(105, 168, 172, 21);
		jp_pw_find.add(tf_hint2_A);
		tf_hint2_A.setColumns(10);

		JLabel jlb_hint1_Q = new JLabel("힌트1");
		jlb_hint1_Q.setBounds(25, 81, 57, 15);
		jp_pw_find.add(jlb_hint1_Q);

		jlb_hint1_A = new JLabel("힌트1 정답");
		jlb_hint1_A.setBounds(25, 112, 74, 15);
		jp_pw_find.add(jlb_hint1_A);

		jlb_hint2_Q = new JLabel("힌트2");
		jlb_hint2_Q.setBounds(25, 140, 57, 15);
		jp_pw_find.add(jlb_hint2_Q);

		jlb_hint2_A = new JLabel("힌트2 정답");
		jlb_hint2_A.setBounds(25, 171, 74, 15);
		jp_pw_find.add(jlb_hint2_A);

		jb_pw_find_ok.addActionListener(this);
		jb_pw_find_ok.setBounds(60, 214, 97, 23);
		jp_pw_find.add(jb_pw_find_ok);

		jb_pw_find_cancel.addActionListener(this);
		jb_pw_find_cancel.setBounds(210, 214, 97, 23);
		jp_pw_find.add(jb_pw_find_cancel);

		jb_id_find.setBounds(261, 32, 68, 23);
		jp_pw_find.add(jb_id_find);
		jb_id_find.addActionListener(this);

		jf_pw_find.setVisible(true);
		jf_pw_find.setLocation(600, 300);
	}

	private void Meminit() {
		jb_ok.addActionListener(this);
		jb_cancel.addActionListener(this);

		jf_member.setVisible(true);
		jf_member.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf_member.setBounds(100, 100, 438, 460);
		jp_member = new JPanel();
		jp_member.setBorder(new EmptyBorder(5, 5, 5, 5));
		jf_member.setContentPane(jp_member);
		jp_member.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(12, 38, 99, 15);
		jp_member.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1.setBounds(12, 63, 99, 15);
		jp_member.add(lblNewLabel_1);

		mem_tf_id = new JTextField();
		mem_tf_id.setBounds(110, 35, 150, 20);
		jp_member.add(mem_tf_id);
		mem_tf_id.setColumns(10);

		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		label.setBounds(12, 88, 96, 21);
		jp_member.add(label);

		label_1 = new JLabel("\uC774\uB984");
		label_1.setBounds(12, 155, 99, 15);
		jp_member.add(label_1);

		label_2 = new JLabel("\uC131\uBCC4");
		label_2.setBounds(12, 183, 99, 15);
		jp_member.add(label_2);

		label_3 = new JLabel("\uD578\uB4DC\uD3F0");
		label_3.setBounds(12, 236, 99, 15);
		jp_member.add(label_3);

		label_4 = new JLabel("\uD78C\uD2B81");
		label_4.setBounds(12, 285, 99, 15);
		jp_member.add(label_4);

		label_5 = new JLabel("\uD78C\uD2B82");
		label_5.setBounds(12, 340, 99, 15);
		jp_member.add(label_5);

		mem_comboBox = new JComboBox();
		mem_comboBox.setModel(new DefaultComboBoxModel(new String[] { "",
				"\uC5B4\uBA38\uB2C8\uC758 \uACE0\uD5A5\uC740?", "\uC88B\uC544\uD558\uB294 \uCE90\uB9AD\uD130\uB294?",
				"\uC5B4\uB838\uC744 \uB54C \uAC00\uC7A5 \uCE5C\uD588\uB358 \uCE5C\uAD6C\uC758 \uBCC4\uBA85\uC740?" }));
		mem_comboBox.setBounds(110, 285, 225, 20);
		jp_member.add(mem_comboBox);

		mem_comboBox_1 = new JComboBox();
		mem_comboBox_1.setModel(
				new DefaultComboBoxModel(new String[] { "", "\uAC00\uC7A5 \uC88B\uC544\uD558\uB294 \uC74C\uC2DD\uC740?",
						"\uCC98\uC74C\uC73C\uB85C \uD63C\uC790 \uB5A0\uB098\uBCF8 \uC5EC\uD589\uC9C0?",
						"\uAC00\uC7A5 \uC88B\uC544\uD558\uB294 \uC560\uC644\uB3D9\uBB3C?",
						"\uAC00\uC7A5 \uAC10\uBA85 \uAE4A\uAC8C \uBCF8 \uC601\uD654\uB294?" }));
		mem_comboBox_1.setBounds(110, 335, 225, 21);
		jp_member.add(mem_comboBox_1);

		mem_tf_hint_a1 = new JTextField();
		mem_tf_hint_a1.setBounds(110, 310, 225, 20);
		jp_member.add(mem_tf_hint_a1);
		mem_tf_hint_a1.setColumns(10);

		mem_tf_hint_a2 = new JTextField();
		mem_tf_hint_a2.setColumns(10);
		mem_tf_hint_a2.setBounds(110, 360, 225, 21);
		jp_member.add(mem_tf_hint_a2);

		mem_tf_name = new JTextField();
		mem_tf_name.setColumns(10);
		mem_tf_name.setBounds(110, 152, 150, 20);
		jp_member.add(mem_tf_name);

		mem_tf_hp = new JTextField();
		mem_tf_hp.setColumns(10);
		mem_tf_hp.setBounds(110, 233, 150, 20);
		jp_member.add(mem_tf_hp);

		JRadioButton radioButton = new JRadioButton("\uB0A8");
		radioButton.setBounds(110, 179, 68, 23);
		jp_member.add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("\uC5EC");
		radioButton_1.setBounds(190, 179, 68, 23);
		jp_member.add(radioButton_1);

		bg.add(radioButton);
		bg.add(radioButton_1);

		jb_ok.setBounds(110, 386, 97, 23);
		jp_member.add(jb_ok);

		jb_cancel.setBounds(238, 386, 97, 23);
		jp_member.add(jb_cancel);

		JLabel address = new JLabel("\uC8FC\uC18C");
		address.setBounds(12, 260, 99, 15);
		jp_member.add(address);

		mem_tf_address = new JTextField();
		mem_tf_address.setBounds(110, 260, 225, 20);
		jp_member.add(mem_tf_address);
		mem_tf_address.setColumns(10);

		JLabel label_6 = new JLabel("\uB2C9\uB124\uC784");
		label_6.setBounds(12, 119, 99, 15);
		jp_member.add(label_6);

		mem_tf_nickname = new JTextField();
		mem_tf_nickname.setBounds(110, 116, 150, 20);
		jp_member.add(mem_tf_nickname);
		mem_tf_nickname.setColumns(10);

		label_7 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		label_7.setBounds(12, 208, 57, 15);
		jp_member.add(label_7);

		tf_birth = new JTextField();
		tf_birth.setBounds(110, 205, 150, 20);
		jp_member.add(tf_birth);
		tf_birth.setColumns(10);

		lblYyyyd = new JLabel("ex)19871107");
		lblYyyyd.setBounds(266, 208, 99, 15);
		jp_member.add(lblYyyyd);

		jb_nick_check = new JButton("\uB2C9\uB124\uC784 \uC911\uBCF5\uD655\uC778");
		jb_nick_check.setBounds(282, 115, 128, 23);
		jp_member.add(jb_nick_check);

		jb_id_check = new JButton("\uC544\uC774\uB514 \uC911\uBCF5\uD655\uC778");
		jb_id_check.setBounds(282, 34, 128, 23);
		jp_member.add(jb_id_check);

		tf_pw22 = new JPasswordField();
		tf_pw22.setBounds(110, 87, 150, 20);
		jp_member.add(tf_pw22);

		tf_pw1 = new JPasswordField();
		tf_pw1.setBounds(110, 61, 150, 20);
		jp_member.add(tf_pw1);

		jb_nick_check.addActionListener(this);
		jb_id_check.addActionListener(this);

		jb_ok.setEnabled(false);
	}

	public String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				return button.getText();
			}
		}
		return null;
	}
	public static void main(String[] args) {
		new Client();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// 로그인 버튼을 눌렀니?
		if (obj == jb_login) {
			System.out.println("로그인 버튼 클릭");
			id = id_jtf.getText().trim(); // id 받아오는 부분
			pw = pw_jtf.getText().trim();

			String s_pw = kc.memberLogin(id);
			if (kc.memberStateCheck(id).equals("1")) {
				JOptionPane.showMessageDialog(this, "현재 접속중.", "INFO", JOptionPane.ERROR_MESSAGE);
			} else if (s_pw == null) {
				JOptionPane.showMessageDialog(this, "존재하지 않는 아이디입니다.", "INFO", JOptionPane.INFORMATION_MESSAGE);
			} else if (pw.equals(s_pw)) {
				String nickname = kc.memberNickname(id);
				ChattingClient cc = new ChattingClient(nickname);
				kc.memberState(id, 1);

				jf_login.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "암호를 확인하세요.", "INFO", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (obj == jb_signin) {
			System.out.println("회원가입 버튼 클릭");
			Meminit();
		} else if (obj == jb_Pf) {
			System.out.println("환경설정 버튼 클릭");
			CSInit();
		} else if (obj == jb_idpw) {
			System.out.println("ID/PW 찾기 버튼 클릭");
			PW_FindInit();
		}

		if (obj == jb_ok) {
			System.out.println(tf_pw1.getText().trim());
			System.out.println(tf_pw22.getText().trim());
			if (tf_pw1.getText().trim().equals(tf_pw22.getText().trim())) {

				MemberVO mv = new MemberVO();
				mv.setID(mem_tf_id.getText());
				mv.setPW(tf_pw1.getText());
				mv.setNICKNAME(mem_tf_nickname.getText());
				mv.setNAME(mem_tf_name.getText());
				mv.setGENDER(getSelectedButtonText(this.bg));
				mv.setHP(mem_tf_hp.getText());
				mv.setADDRESS(mem_tf_address.getText());
				mv.setHINT1_Q(mem_comboBox.getSelectedItem().toString());
				mv.setHINT1_A(mem_tf_hint_a1.getText());
				mv.setHINT2_Q(mem_comboBox_1.getSelectedItem().toString());
				mv.setHINT2_A(mem_tf_hint_a2.getText());

				KosmoCRUD kc = new KosmoCRUD();
				kc.memberInsert(mv);

				JOptionPane.showMessageDialog(this, "환영합니다.", "INFO", JOptionPane.ERROR_MESSAGE);

				jf_member.dispose();
			}
			else 
				JOptionPane.showMessageDialog(this, "비밀번호 불일치", "INFO", JOptionPane.ERROR_MESSAGE);

		}

		else if (obj == jb_pw_find_ok) {
			String ID = tf_id.getText();
			String HINT1_Q = comboBox.getSelectedItem().toString();
			String HINT1_A = tf_hint1_A.getText();
			String HINT2_Q = comboBox_1.getSelectedItem().toString();
			String HINT2_A = tf_hint2_A.getText();
			String PW = null;

			System.out.println(ID);
			System.out.println(HINT1_Q);
			System.out.println(HINT2_Q);
			System.out.println(HINT1_A);
			System.out.println(HINT2_A);

			PW = kc.memberfind(ID, HINT1_Q, HINT2_Q, HINT1_A, HINT2_A);
			if (PW != null) {
				JOptionPane.showMessageDialog(this, "당신 아이디의 암호는 " + PW + "입니다.", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "힌트문이 일치하지 않습니다. 다시 입력하세요", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (obj == jb_pw_find_cancel) {
			jf_pw_find.dispose();
		} else if (obj == jb_id_find) {
			String ID = tf_id.getText();
			System.out.println(ID);
			if (kc.memberLogin(ID) == null) {
				JOptionPane.showMessageDialog(this, "아이디 존재하지 않음", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "아이디 존재함", "INFO", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (obj == jb_id_check) {
			String id = mem_tf_id.getText();
			if (mem_tf_id.getText().trim().toString().isEmpty() == false && mem_tf_id.getText().length() > 3
					&& null == (kc.memberLogin(id))) {
				jb_id_check.setEnabled(false);
				mem_tf_id.setEnabled(false);
				ch++;
				if (ch == 2) {
					jb_ok.setEnabled(true);
				}
			} else {
				JOptionPane.showMessageDialog(this, "사용 불가능한 아이디", "INFO", JOptionPane.ERROR_MESSAGE);
			}
		}

		else if (obj == jb_nick_check) {
			if (mem_tf_nickname.getText().trim().toString().isEmpty() == false
					&& null == (kc.nicknameCheak(mem_tf_nickname.getText().trim().toString()))) {
				jb_nick_check.setEnabled(false);
				mem_tf_nickname.setEnabled(false);
				ch++;
				if (ch == 2) {
					jb_ok.setEnabled(true);
				}
			} else {
				JOptionPane.showMessageDialog(this, "사용 불가능한 닉네임", "INFO", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
