package com.chatting.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Client extends JFrame {
	JTabbedPane jp = new JTabbedPane();
	WaitRoom wr = new WaitRoom();
	MessageRoom mr = new MessageRoom();
	public Client()
	{
		jp.addTab("����", wr);
		jp.addTab("��ȭ��", mr);
		jp.setSelectedIndex(1);
		this.add("Center", jp);
		this.setSize(600, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Client();
	}

}
