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

	// �����
	Socket socket = null;
	// ��ȭ���� ���� ���� ����
	String nickName = null;
	// ȭ�� ��ġ�ϱ� ����//
	JPanel jp_first = new JPanel();
	// JTextArea���� �κ� ���� ������ �Ұ��մϴ�.
	// ���� �ؽ�Ʈ�θ� ����� �� �ֽ��ϴ�.
	// �̹����� ó���� �� �����ϴ�.
	// �ؽ�Ʈ�� �׸��� �������� ó���ϴ� Ŭ������ �ʿ��մϴ�.
	// JTextArea jta_display = new JTextArea();
	StyledDocument sd_display = new DefaultStyledDocument(new StyleContext());
	JTextPane jtp_display = new JTextPane(sd_display);
	JScrollPane jsp_display = new JScrollPane(jtp_display, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel jp_first_south = new JPanel();
	JTextPane jtf_msg = new JTextPane();
	JButton jbtn_send = new JButton("����");
	JPanel jp_second = new JPanel();
	String cols[] = { "��ȭ��" };
	String data[][] = new String[0][1];
	DefaultTableModel dtm_room = new DefaultTableModel(data, cols);
	JTable jt_room = new JTable(dtm_room);
	JScrollPane jsp_room = new JScrollPane(jt_room, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel jp_second_south = new JPanel();
	JButton jbtn_whisper = new JButton("�ӼӸ�");
	JButton jbtn_change = new JButton("��ȭ����");
	JButton jbtn_roomout = new JButton("������");
	JButton jbtn_close = new JButton("����");
	JButton jbtn_fontColor = new JButton("���ڻ�");
	JButton jbtn_emoticon = new JButton("�̸�Ƽ��");
//	JButton jbtn_photo = new JButton("��������");
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
	Image reimg1 = img1.getImage(); // ImageIcon�� Image�� ��ȯ.
	Image rreimg1 = reimg1.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg1 = new ImageIcon(rreimg1); // Image�� ImageIcon ����

	KosmoCRUD kc = new KosmoCRUD();

	// ����ڰ� ������ ���� ������ ���� ���� ���� - ������ ������ �� ���������� ����
	static String fontColor = "0";// ����ڰ� ������ �������� ���
	static String emoticon = "0";
	ObjectInputStream ois = null;// ���
	ObjectOutputStream oos = null;// ���ϱ�
	// ȭ�� ��ġ�ϱ� ��//
	// ������
	// 1)ȭ��ó��
	// 2)�������� ����
	// 3)Ŭ���̾�Ʈ ���������� �޾ƿ´�.
	// 4)������ �����ϰ� start() ȣ��

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

	// ȭ��ó����
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

		// jtf_msg.addActionListener(this);//�̺�Ʈ ����(JVM) - actionPerformed
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
		this.setTitle(nickName + "���� ��ȭâ");
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
		Object obj = ae.getSource();// �̺�Ʈ�� ������ ������Ʈ�� �ּҹ����� ���
		String msg = jtf_msg.getText();// ����ڰ� �Է��� �޽����� ��´�.
		if (obj == jtf_msg || obj == jbtn_send) {
			try {
				oos.writeObject(Protocol.MESSAGE + "|" + nickName + "|" + msg + "|" + fontColor + "|" + emoticon);
			} catch (Exception e) {
				// TODO: handle exception
			}
			jtf_msg.setText("");
		} /////////////// end of �޽��� ����
			// ��ȭ�� �����ư Ŭ������ ��
		else if (obj == jbtn_change) {
			// ������ ��ȭ�� �Է¹ޱ�

			String afterName = JOptionPane.showInputDialog("������ ��ȭ���� �Է��ϼ���.");
			if (kc.nicknameCheak(afterName) != null) {
				JOptionPane.showMessageDialog(this, "�ߺ��Ǵ� �г����Դϴ�.", "INFO", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			// ��ȭ���� ���̰ų� ���ڿ��� ���̰� 1���� ������ ó������ �ٽ�
			else if (afterName == null || afterName.trim().length() < 1) {
				JOptionPane.showMessageDialog(this, "������ ��ȭ���� �Է��ϼ���", "INFO", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			// �޽��� ����
			try {
				// 300|����|������|���ϴ��� ��ȭ���� ���������� ����
				oos.writeObject(Protocol.CHANGE + "|" + nickName + "|" + afterName + "|" + nickName + "���� ��ȭ���� "
						+ afterName + "���� ����" + "|" + fontColor);

				kc.NicknameChange(nickName, afterName);

			} catch (Exception e) {
				// TODO: handle exception
			}
		} /////////// end of ��ȭ�� ���� ��
		else if (obj == jbtn_whisper) {
			// �ӼӸ� ��븦 ����(���̺�)�ϱ�
			int row = jt_room.getSelectedRow();
			// ��븦 �������� �ʾҴ�? - �ӼӸ� ��븦 �����ϼ��� �޽���
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "�ӼӸ� ��븦 �����ϼ���", "INFO", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			// ��븦 �����ߴ�? - ��
			else {
				// ������ �̸�
				// ������ ����� �̸��� ���̺��� �о�ͼ� name������ ���
				String name = (String) dtm_room.getValueAt(row, 0);
				// System.out.println("����̸�:"+name);

				// ���� ������ ��밡 �� �ڽ��̸� �ٸ� ��븦 �����ϼ���
				// �޽��� ó���ϱ�
				if (nickName.equals(name)) {
					JOptionPane.showMessageDialog(this, "�ٸ� ��븦 �����ϼ���", "INFO", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				// �ӼӸ� �Է¹ޱ�
				String msg1 = JOptionPane.showInputDialog(name + "�Կ��� ���� �޽��� �Է��ϼ���.");
				// �ӼӸ� �����ϱ�
				try {
					oos.writeObject(Protocol.WHISPER + "|" + nickName + "|" + name + "|" + msg1 + "|" + fontColor);
				} catch (Exception e) {
					// TODO: handle exception
				}
			} //////////// end of else
				// ����ڰ� ������ ���̺��� ������� �ʱ�ȭ �ϱ�.
			jt_room.clearSelection();
		} //////////////// end of �ӼӸ�
		else if (obj == jbtn_close || obj == jbtn_roomout) {
			exitChat();
			System.exit(0);
		} /////////////// end of �޽��� ����
		else if (obj == jbtn_fontColor) {
			jf_fontColor = new JFrame();
			JColorChooser jcc_color = new JColorChooser();
			ColorSelectionModel model = jcc_color.getSelectionModel();
			ChangeListener listener = new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					Color forColor = jcc_color.getColor();
					fontColor = String.valueOf(forColor.getRGB());
					// System.out.println("����ڰ� ������ ����:"+fontColor);
				}
			};
			model.addChangeListener(listener);
			jf_fontColor.add("Center", jcc_color);
			jf_fontColor.setSize(600, 500);
			jf_fontColor.setVisible(true);
			System.out.println("����:" + fontColor);
		} else if (obj == jbtn_emoticon) {
			jf.setSize(350, 350);
			jf.setVisible(true);
		}
		if (obj == jbtns[0]) {
			System.out.println("/����");
			jtf_msg.setText("/����");
			jf.dispose();
			msg = jtf_msg.getText();
			try {
				oos.writeObject(Protocol.EMOTICON + "|" + nickName + "|" + msg + "|" + fontColor);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if (obj == jbtns[1]) {
			System.out.println("/����");
			jtf_msg.setText("/����");
			jf.dispose();
			msg = jtf_msg.getText();
			try {
				oos.writeObject(Protocol.EMOTICON + "|" + nickName + "|" + msg + "|" + fontColor);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (obj == jbtns[2]) {
			System.out.println("/��");
			jtf_msg.setText("/��");
			jf.dispose();
			msg = jtf_msg.getText();

			try {
				oos.writeObject(Protocol.EMOTICON + "|" + nickName + "|" + msg + "|" + fontColor);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (obj == jbtns[3]) {
			System.out.println("/�ɽ�");
			jtf_msg.setText("/�ɽ�");
			jf.dispose();
			msg = jtf_msg.getText();
			try {
				oos.writeObject(Protocol.EMOTICON + "|" + nickName + "|" + msg + "|" + fontColor);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (obj == jbtns[4]) {
			System.out.println("/����");
			jtf_msg.setText("/����");
			jf.dispose();
			msg = jtf_msg.getText();

			try {
				oos.writeObject(Protocol.EMOTICON + "|" + nickName + "|" + msg + "|" + fontColor);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (obj == jbtns[5]) {
			System.out.println("/������");
			jtf_msg.setText("/������");
			jf.dispose();
			msg = jtf_msg.getText();

			try {
				oos.writeObject(Protocol.EMOTICON + "|" + nickName + "|" + msg + "|" + fontColor);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (obj == jbtns[6]) {
			System.out.println("/����");
			jtf_msg.setText("/����");
			jf.dispose();
			msg = jtf_msg.getText();
			try {
				oos.writeObject(Protocol.EMOTICON + "|" + nickName + "|" + msg + "|" + fontColor);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (obj == jbtns[7]) {
			System.out.println("/���Ҿ�");
			jtf_msg.setText("/���Ҿ�");
			jf.dispose();
			msg = jtf_msg.getText();

			try {
				oos.writeObject(Protocol.EMOTICON + "|" + nickName + "|" + msg + "|" + fontColor);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (obj == jbtns[8]) {
			System.out.println("/����");
			jtf_msg.setText("/����");
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
		if (e.getKeyCode() == 10) { //������ keyCode()�� 10 
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