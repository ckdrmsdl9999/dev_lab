package pro_03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Login extends JFrame implements ActionListener{

	private JPanel contentPane;
	String nickName = null;
	JButton LogB;//로그인 버튼
	JButton JoinMemB;//회원가입 버튼
	JButton guestBtn;//게스트 버튼
	JTextField idText;
	JTextField pwText;
	JoinMember jm;
	ChattingClient cc;
	ChatDao cd;
	boolean loginChk=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("로그인");
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(22, 94, 28, 29);
		contentPane.add(lblNewLabel);
		

		idText = new JTextField();
		idText.setBounds(96, 91, 233, 35);
		contentPane.add(idText);
		idText.setColumns(10);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setBounds(22, 153, 35, 29);
		contentPane.add(lblPw);
		
		pwText = new JPasswordField();
		pwText.setColumns(10);
		pwText.setBounds(96, 147, 233, 35);
		contentPane.add(pwText);
		
		LogB = new JButton("\uB85C\uADF8\uC778");
		LogB.setBounds(100, 261, 100, 30);
		contentPane.add(LogB);
		LogB.addActionListener(this);
		
		JoinMemB = new JButton("\uD68C\uC6D0\uAC00\uC785");
		JoinMemB.setBounds(230, 261, 100, 30);
		contentPane.add(JoinMemB);
		JoinMemB.addActionListener(this);
		//guestBtn = new JButton("Guest");
		//guestBtn.setBounds(283, 261, 100, 30);
		//contentPane.add(guestBtn);
		//guestBtn.addActionListener(this);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == LogB) {
			//ChattingClient cc =new ChattingClient();
			//cc.mainPage();
		//}	
			PasswordTest pt = new PasswordTest();
			//채팅창 인스턴스
			//로그인(DB에서 아이디 와 패스워드 확인)
			ChatmemberVO cVO = new ChatmemberVO();
			cVO.setCommand("login");
			cVO.setId(idText.getText());
			cVO.setPassword(pt.SHA256(pwText.getText()));
			new Chat_Control().send(cVO);
			int result1 = new ChatDao().id_check(cVO);
			int result2 = new ChatDao().login(cVO).size();
			if(1==result1){
				if(1==result2){
					JOptionPane.showMessageDialog(this, "로그인이 성공하였습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
					this.dispose();
					cc = new ChattingClient();
					List<ChatmemberVO> cd =new ChatDao().login(cVO);
					cc.mainPage(cd.get(0).getNickname());
					cc.receive(cd);
				}else{
					JOptionPane.showMessageDialog(this, "비밀번호가 틀렸습니다.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(this, "등록되지 않은 ID 입니다.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}	
		//회원 가입창 인스턴스
		if (e.getSource() == JoinMemB) {
			JoinMember join = new JoinMember();

		}
	}

}
