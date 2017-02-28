package pro_03;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;


import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JoinMember extends JFrame implements ActionListener {

	JPanel contentPane;
	JTextField IDText;
	JTextField PWText;
	JTextField rePWText;
	JTextField nickNameText;
	JTextField EmailText;
	JComboBox comboGender;
	JButton nickcheck;
	int count =0;
	int count1 =0;

	JButton OIB; // ���̵� �ߺ��˻� ��ư
	JButton ConfirmB;// ȸ������â Ȯ�� ��ư
	/**
	 * Launch the application.
	 */

	public JoinMember() {

		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("ȸ������");

		IDText = new JTextField();
		IDText.setBounds(82, 18, 160, 35);
		contentPane.add(IDText);
		IDText.setColumns(10);

		PWText = new JPasswordField();
		PWText.setBounds(82, 77, 160, 35);
		contentPane.add(PWText);
		PWText.setColumns(10);

		rePWText = new JPasswordField();
		rePWText.setBounds(82, 133, 160, 35);
		contentPane.add(rePWText);
		rePWText.setColumns(10);

		nickNameText = new JTextField();
		nickNameText.setBounds(82, 244, 160, 35);
		contentPane.add(nickNameText);
		nickNameText.setColumns(10);

		OIB = new JButton("ID �ߺ�üũ");
		OIB.setFont(new Font("����", Font.PLAIN, 16));
		OIB.setBounds(269, 20, 133, 37);
		OIB.addActionListener(this);
		contentPane.add(OIB);
		
		nickcheck = new JButton("�г��� �ߺ�üũ");
		nickcheck.setFont(new Font("����", Font.PLAIN, 13));
		nickcheck.setBounds(269, 245, 140, 37);
		nickcheck.addActionListener(this);
		contentPane.add(nickcheck);

		ConfirmB = new JButton("\uD655\uC778");
		ConfirmB.setBounds(134, 353, 153, 37);
		ConfirmB.addActionListener(this);
		contentPane.add(ConfirmB);

		JLabel label = new JLabel("ID");
		label.setBounds(25, 21, 28, 29);
		contentPane.add(label);

		JLabel label_1 = new JLabel("PW");
		label_1.setBounds(25, 80, 35, 29);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("�г���");
		label_2.setFont(new Font("����", Font.PLAIN, 20));
		label_2.setBounds(10, 249, 63, 29);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\uC131\uBCC4");
		label_3.setBounds(25, 301, 53, 29);
		contentPane.add(label_3);

		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setFont(new Font("����", Font.PLAIN, 17));
		lblEmail.setBounds(12, 195, 63, 29);
		contentPane.add(lblEmail);

		EmailText = new JTextField();
		EmailText.setColumns(10);
		EmailText.setBounds(82, 189, 160, 35);
		contentPane.add(EmailText);

		String[] genderList = { "����", "����" };
		comboGender = new JComboBox(genderList);

		comboGender.setBounds(85, 305, 150, 20);
		comboGender.setFont(new java.awt.Font("����", 0, 12));

		contentPane.add(comboGender);
	}


	public String getGender() {
		if (comboGender.getSelectedItem().equals("����")) {
			return "0";
		} else {
			return "1";
		}
	};

	public void setGender(String strGender) {
		if ("0".equals(strGender))
			comboGender.setSelectedItem("����");
		else
			comboGender.setSelectedItem("����");
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		ChatmemberVO cVO = new ChatmemberVO();
		Chat_Control cc = new Chat_Control();
		if (obj == OIB) {
			cVO.setId(IDText.getText());
			cVO.setCommand("id_check");
			cc.send(cVO);
			int result = new ChatDao().id_check(cVO);
			if(1==result){
				JOptionPane.showMessageDialog(this, "�̹� �ִ� ID �Դϴ�.", "Error", JOptionPane.ERROR_MESSAGE);
			}else if(IDText.getText().equals("")){
				JOptionPane.showMessageDialog(this, "ID�� �Է��Ͻÿ�.", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(this, "��� ������ ID �Դϴ�.", "Info", JOptionPane.INFORMATION_MESSAGE);
				count++;
			}

		}
		else if (obj == nickcheck) {
			cVO.setId(nickNameText.getText());
			cVO.setCommand("nick_check");
			cc.send(cVO);
			int result = new ChatDao().id_check(cVO);
			if(1==result){
				JOptionPane.showMessageDialog(this, "�̹� �ִ� �г����Դϴ�. �Դϴ�.", "Error", JOptionPane.ERROR_MESSAGE);
			}else if(nickNameText.getText().equals("")){
				JOptionPane.showMessageDialog(this, "�г����� �Է��Ͻÿ�.", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(this, "��� ������ �г��� �Դϴ�.", "Info", JOptionPane.INFORMATION_MESSAGE);
				count1++;
			}

		}
		else if (obj == ConfirmB) {
			if(0<count && 0<count1){
					if(PWText.getText().equals(rePWText.getText())){
						PasswordTest pt = new PasswordTest();
						cVO.setCommand("join");
						cVO.setE_mail(EmailText.getText());
						cVO.setId(IDText.getText());
						cVO.setPassword(pt.SHA256(PWText.getText()));
						cVO.setNickname(nickNameText.getText());
						cVO.setGender(getGender());
						cc.send(cVO);
						JOptionPane.showMessageDialog(this, "ȸ�������� �����Ͽ����ϴ�.", "Info", JOptionPane.INFORMATION_MESSAGE);
						this.dispose();
					}else{
						JOptionPane.showMessageDialog(this, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			else if (0<count||0<count1){
				JOptionPane.showMessageDialog(this, "ID �ߺ� ��ȸ�� Ȯ���� �ּ���.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(this, "�г��� �ߺ� ��ȸ�� Ȯ���� �ּ���.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}