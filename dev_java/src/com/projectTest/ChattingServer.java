package com.projectTest;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChattingServer extends JFrame implements Runnable {
	//�����
	//Ŭ���̾�Ʈ ������ ������ �޾��ִ� 
	//���� �����ϱ�
	ServerSocket server = null;
	//���� �޽����� �ְ� ���� �� ����� ����
	Socket client = null;
	//�������Ͽ� ������ ���� Ŭ���̾�Ʈ ��
	//����ڵ鿡 ���� ������ ��� �� �ڷᱸ��
	//Vector ���
	List<ChattingServerThread> chatList = null;
	ChattingServerThread csThread = null;
	JTextArea jta_display 	= new JTextArea();
	JScrollPane jsp_display	= 
			new JScrollPane(jta_display
					       ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
					       ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//������
	//1)ȭ��ó��
	//2)�������� ����
	//3)Ŭ���̾�Ʈ ���������� �޾ƿ´�.
	//4)������ �����ϰ� start() ȣ��
	public ChattingServer(){
		initDisplay();	
	}
	//ȭ��ó����
	public void initDisplay(){
		this.add("Center",jsp_display);
		this.setTitle("�α� ���â-������");
		this.setSize(500, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		ChattingServer cs = 
				new ChattingServer();
/*		Thread th = new Thread(cs);
		th.start();*/
		new Thread(cs).start();
	}
	@Override
	public void run() {
		//insert here
		chatList = new Vector<ChattingServerThread>();
		boolean isStop = false;
		try {
			server = new ServerSocket(3000);
			while(!isStop){
				client = server.accept();
				jta_display.append(
						client.toString()+"\n");
				csThread = new ChattingServerThread(this);
				csThread.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
}
