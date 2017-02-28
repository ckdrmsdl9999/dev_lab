package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class member2 extends JFrame implements ActionListener {
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
	ButtonGroup bg;
	JComboBox mem_comboBox;
	JComboBox mem_comboBox_1;
	JTextField tf_birth;
	JLabel lblYyyyd;
	JPasswordField tf_pw22;
	JPasswordField tf_pw1;

	JButton jb_nick_check;
	JButton jb_id_check;

	int ch = 0;

	KosmoCRUD kc = new KosmoCRUD();

	public void Meminit() {

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
		mem_comboBox.setModel(new DefaultComboBoxModel(new String[] { "", "\uC5B4\uBA38\uB2C8\uC758 \uACE0\uD5A5\uC740?",
				"\uC88B\uC544\uD558\uB294 \uCE90\uB9AD\uD130\uB294?",
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

		bg = new ButtonGroup();
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
	@Override
	public void actionPerformed(ActionEvent e) {
		if (jb_ok.equals(e.getSource())) {
			System.out.println(tf_pw1.getText().trim());
			System.out.println(tf_pw22.getText().trim());

			if (tf_pw1.getText().trim().equals(tf_pw22.getText().trim())) {

				MemberVO mv = new MemberVO();
				mv.setID(mem_tf_id.getText());
				mv.setPW(tf_pw1.getText());
				mv.setNICKNAME(mem_tf_nickname.getText());
				mv.setNAME(mem_tf_name.getText());
				mv.setGENDER(getSelectedButtonText(bg));
				mv.setHP(mem_tf_hp.getText());
				mv.setADDRESS(mem_tf_address.getText());
				mv.setHINT1_Q(mem_comboBox.getSelectedItem().toString());
				mv.setHINT1_A(mem_tf_hint_a1.getText());
				mv.setHINT2_Q(mem_comboBox_1.getSelectedItem().toString());
				mv.setHINT2_A(mem_tf_hint_a2.getText());

				KosmoCRUD kc = new KosmoCRUD();
				kc.memberInsert(mv);

				System.out.println("媛��엯�꽦怨�");
				this.dispose();
			}
			else
				System.out.print("두비빌번호가 달름");
			// this.dispose();
			// System.out.println(mv.hashCode());

		} else if (jb_cancel.equals(e.getSource())) {
				this.dispose();
		}

		else if (jb_id_check.equals(e.getSource())) {
				String id = mem_tf_id.getText();

			if (mem_tf_id.getText().trim().toString().isEmpty() == false &&
				mem_tf_id.getText().length() > 3 && null == (kc.memberLogin(id))) {
				System.out.println(mem_tf_id.getText() + "사용가능아이디");
				jb_id_check.setEnabled(false);
				mem_tf_id.setEnabled(false);
				ch++;
				if (ch == 2) {
					jb_ok.setEnabled(true);
				}
			} else {
				System.out.print("사용불가아이디");
			}
		} else if (jb_nick_check.equals(e.getSource())) {

			if (mem_tf_nickname.getText().trim().toString().isEmpty() == false &&

				mem_tf_nickname.getText().length() > 3
				&& null == (kc.nicknameCheak(mem_tf_nickname.getText().trim().toString()))) {
				System.out.println(mem_tf_nickname.getText() + "사용가능 닉네임");
				jb_nick_check.setEnabled(false);
				mem_tf_nickname.setEnabled(false);
				ch++;

				if (ch == 2) {

					jb_ok.setEnabled(true);

				}

			} else {

				System.out.print("사용불가 닉네임");

			}

		}

	}

	public static void main(String args[]) {

		member2 m2 = new member2();

		m2.Meminit();

	}

}
