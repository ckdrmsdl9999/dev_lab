package pro_03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//import com.vo.AddressVO;

public class ChattingClientTab3 extends JFrame implements ActionListener {
	List<ChatmemberVO> cVO;
	ChattingClient cc;
	String id;
	String nickname;
	String e_mail;
	int gender;
	JLabel labelID;
	JTextField txtID;
	JLabel labelPw;
	JTextField txtPw;
	JLabel labelPw_con;
	JTextField txtPw_con;
	JLabel labelnick;
	JTextField txtnick;
	JLabel labelGender;
	JComboBox comboGender;
	JLabel labelE_mail;
	JTextField txtE_mail;
	JLabel labelComment;
	JTextArea txtComment;
	JLabel labelRegDate;
	JTextField txtRegDate;
	JScrollPane scrollPane;
	JPanel panel;
	JPanel panelBtn;
	Font font;
	JButton jbtn_ok = new JButton("수정");
	JButton jbtn_delete = new JButton("탈퇴");

	// 채팅창 오른쪽 프로필 화면
	public ChattingClientTab3(ChattingClient chattingClient) {
		this.cc=chattingClient;
		System.out.println("ChattingClientTab3 호출");
		// 데이터 칼럼명을 보여줄 레이블을 정의합니다.
		labelID = new JLabel("ID");
		labelPw = new JLabel("비밀번호 ");
		labelPw_con = new JLabel("비밀번호 확인 ");
		labelnick = new JLabel("닉네임 ");
		labelGender = new JLabel("성별 ");
		labelE_mail = new JLabel("E-mail ");

		labelID.setFont(font);
		labelPw.setFont(font);
		labelPw_con.setFont(font);
		labelnick.setFont(font);
		labelGender.setFont(font);
		labelE_mail.setFont(font);

		// 데이터를 보여줄 텍스트 필드등을 정의합니다.
		txtID = new JTextField(20);
		txtPw = new JPasswordField(20);
		txtPw_con = new JPasswordField(20);
		txtnick = new JTextField(20);
		txtE_mail = new JTextField(20);
		txtComment = new JTextArea(3, 20);
		txtRegDate = new JTextField(20);

		String[] genderList = { "남자", "여자" };
		comboGender = new JComboBox(genderList);

		panel = new JPanel();
		// Layout manager를 사용하지 않고 직접 컴포넌트들의 위치를 정해줍니다.
		panel.setLayout(null);

		labelID.setBounds(20, 20, 80, 20);
		txtID.setBounds(120, 20, 80, 20);
		txtID.setEditable(false);

		labelPw.setBounds(20, 50, 80, 20);
		txtPw.setBounds(120, 50, 80, 20);

		labelPw_con.setBounds(20, 80, 80, 20);
		txtPw_con.setBounds(120, 80, 80, 20);

		labelnick.setBounds(20, 110, 80, 20);
		txtnick.setBounds(120, 110, 80, 20);

		labelGender.setBounds(20, 140, 80, 20);
		comboGender.setBounds(120, 140, 80, 20);
		comboGender.setFont(new java.awt.Font("굴림", 0, 12));
		comboGender.setEditable(false);

		labelE_mail.setBounds(20, 170, 80, 20);
		txtE_mail.setBounds(120, 170, 80, 20);

		jbtn_ok.setBounds(30, 450, 80, 20);
		jbtn_delete.setBounds(120, 450, 80, 20);
		
		// 컴포넌트들을 패널에 붙입니다.
		panel.add(labelID);
		panel.add(txtID);
		panel.add(labelPw);
		panel.add(txtPw);
		panel.add(labelPw_con);
		panel.add(txtPw_con);
		panel.add(labelnick);
		panel.add(txtnick);
		panel.add(labelGender);
		panel.add(comboGender);
		panel.add(labelE_mail);
		panel.add(txtE_mail);
		panel.add(jbtn_ok);
		panel.add(jbtn_delete);

		jbtn_ok.addActionListener(this);
		jbtn_delete.addActionListener(this);
		panelBtn = new JPanel();

		
	}


	public void receive(List<ChatmemberVO> pVO) {
		this.cVO = pVO;
		System.out.println("tab3 리시브 호출");
		System.out.println("????????????" + pVO);
		System.out.println("!!!!!!!!!!!!" + cVO);
		id = cVO.get(0).getId();
		nickname = cVO.get(0).getNickname();
		e_mail = cVO.get(0).getE_mail();
		gender = Integer.parseInt(cVO.get(0).getGender());
		txtID.setText(cc.cVO.get(0).getId());
		txtnick.setText(nickname);
		txtE_mail.setText(e_mail);
		comboGender.setSelectedIndex(gender);;
		System.out.println("tab3 리시브 호출{}{}{}{}{}{}" + id);
		System.out.println("tab3 리시브 호출{}{}{}{}{}{}" + nickname);
		System.out.println("tab3 리시브 호출{}{}{}{}{}{}" + e_mail);
	
	}

	// public static void main(String[] args) {
	// new ChattingClientTab3(null);
	// }
	@Override
	public void actionPerformed(ActionEvent e) {
		Object a = e.getSource();
		ChatmemberVO cVO = new ChatmemberVO();
		Chat_Control cc = new Chat_Control();
		PasswordTest pt = new PasswordTest();
		ChatDao cd = new ChatDao();
		if (a == jbtn_ok) {
			System.out.println("수정 호출 성공");
			cVO.setId(txtID.getText());
			cVO.setCommand("nick_check");
			cc.send(cVO);
			int result = new ChatDao().id_check(cVO);
			if(txtPw_con.getText().equals(txtPw.getText())){
				if(!(txtPw.getText().equals(""))){
			if(1==result){
				cVO.setCommand("change");
				cVO.setId(txtID.getText());
				cVO.setPassword(pt.SHA256(this.txtPw.getText()));
				cVO.setNickname(this.txtnick.getText());
				cVO.setE_mail(txtE_mail.getText());
				String gender = String.valueOf(comboGender.getSelectedIndex());
				cVO.setGender(gender);
				new Chat_Control().send(cVO);
				int account = cd.change(cVO);
				System.out.println("account+_+_+_+_+_+_+_+"+account);
						if(1==account){
							JOptionPane.showMessageDialog(this, "회원정보가 수정되었습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(this, "회원정보 수정이 실패했습니다.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
					}
					
				}else{
					JOptionPane.showMessageDialog(this, "비밀번호는 공백으로 수정 할 수 없습니다.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}////////////////////////////////jbtn_ok end
		else if(a == jbtn_delete){
			int count = 0;
			int confirm = JOptionPane.showConfirmDialog(null, "회원탈퇴시 모든 정보는 삭제처리되며 대화방이 종료됩니다.", "회원탈퇴", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			System.err.println(JOptionPane.YES_OPTION+"yes");
			System.err.println(JOptionPane.NO_OPTION+"no");
			if(0==confirm){
				cVO.setCommand("delete");
				cVO.setId(this.txtID.getText());
				int delete = cd.delete(cVO);
				new Chat_Control().send(cVO);
				if(1==delete){
					JOptionPane.showMessageDialog(this, "회원탈퇴가 처리되었습니다. 이용해 주셔서 감사합니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
			}else if(1==confirm){
				JOptionPane.showMessageDialog(this, "취소되었습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}
}
