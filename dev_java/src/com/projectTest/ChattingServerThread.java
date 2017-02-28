package com.projectTest;

import java.awt.Image;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import chat.KosmoCRUD;

public class ChattingServerThread extends Thread {
	ChattingServer cs = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	String chatName = null;
	String fontColor = "0";
	
	
	//�̸�Ƽ�� ����
		ImageIcon img1 = new ImageIcon(getClass().getResource("0.jpg"));
		Image reimg1 = img1.getImage();  //ImageIcon�� Image�� ��ȯ.
		Image rreimg1 = reimg1.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
		ImageIcon rrreimg1 = new ImageIcon(rreimg1); //Image�� ImageIcon ����
	
	
	
	public ChattingServerThread(ChattingServer cs) {
	//�Ķ���ͷ� �Ѿ�� ChattingServer�� �ٸ� �޼ҵ忡���� ����Ϸ��� 
	//������� ���� �� �ʱ�ȭ�� �մϴ�.
		this.cs = cs;
		try {
			oos = new ObjectOutputStream(cs.client.getOutputStream());
			ois = new ObjectInputStream(cs.client.getInputStream());
			String message = (String)ois.readObject();
			cs.jta_display.append(message+"\n");
			//�޽����� �߰� �ɶ� ���� ȭ�� �̵�ó���ϱ�
			cs.jta_display.setCaretPosition(cs.jta_display.getDocument().getLength());
			//100|����|��������
			StringTokenizer st = new StringTokenizer(message,"|");
			st.nextToken();//100
			chatName = st.nextToken();//����
			fontColor = st.nextToken();//��������-���
			//���� �����ڿ��Ե� ��ȭ���� �˷� �־�� �Ѵ�.
			/*	���� for�� - �ڷᱸ���� �迭�� �ִ� ���� ��θ� ����ϰ� ���� �� ����մϴ�.
			 *  for([1]:[2]){
			 *  [1]:�ڷᱸ���϶��� ���׸� Ÿ���� �ۼ��մϴ�. List<ChattingServerThread>
			 *     :�迭�϶��� �迭 Ÿ���� �ۼ��մϴ�.
			 *  [2]:�ڷᱸ�� Ȥ�� �迭�ȿ� ����� Ÿ���� �ۼ��մϴ�.
			 *  }
			 */
/*			for(int i=0;i<cs.chatList.size();i++){
				ChattingServerThread cst = cs.chatList.get(i);
			}*/
			for(ChattingServerThread cst:cs.chatList){
				String currentName = cst.chatName;
				this.send(Protocol.ROOM_IN+"|"+currentName+"|"+fontColor);
			}
			//insert here
			cs.chatList.add(this);
			//message=100|����
			this.broadCasting(message);//100|����
		} catch (Exception e) {
			cs.jta_display.append("Exception : "+e.toString()+"\n");
		}
	}
	//��ȭ�濡 ������ ��� ģ���鿡�� �޽��� ����ϱ�
	public void broadCasting(String message){
		synchronized(this){//����ȭ ����
			for(ChattingServerThread cst:cs.chatList){
				cst.send(message);
			}
		}
	}
	//Ŭ���̾�Ʈ�� ���� �о�� �޽����� ����Ѵ�.
	public void send(String message)
	{
		try {
			oos.writeObject(message);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(cs
					                    , "send log", "Error"
					                    , JOptionPane.ERROR_MESSAGE); 
		}
	}
	@Override
	public void run(){//����,��ٸ�,�켱����
		boolean isStop = false;
		try {
			run_start:
			while(!isStop){
				//300|����|������|���ϴ��� ��ȭ���� ���������� ����
				String message = (String)ois.readObject();
				cs.jta_display.append(message+"\n");
				cs.jta_display.setCaretPosition(cs.jta_display.getDocument().getLength());
				StringTokenizer st = null;
				int protocol = 0;
				if(message!=null){
					st = new StringTokenizer(message,"|");
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol){
				case Protocol.MESSAGE:{
					String nickName = st.nextToken();
					String msg = st.nextToken();
					String fontColor = st.nextToken();
					String emoticon = st.nextToken();
					broadCasting(Protocol.MESSAGE+"|"+
					                     nickName+"|"+
							                  msg+"|"+fontColor+"|"+emoticon);
				}break;
				case Protocol.WHISPER:{
					String nickName = st.nextToken();//������ ��
					//insert here - �޴� ��
					String otherName = st.nextToken();
					//�ӼӸ��� ������ �޽���
					String msg1 = st.nextToken();
					String fontColor = st.nextToken();
					//insert here
					//chatList���� ����̸��� cst�� chatName�� ���Ͽ�
					//������ �׿��Ը� �޽����� �����մϴ�.
					for(ChattingServerThread cst:cs.chatList){
						if(otherName.equals(cst.chatName)){
						//��뿡�� ���� �޽���	
							cst.send(Protocol.WHISPER+"|"+
				                     nickName+"|"+
						            otherName+"|"+
						                  msg1+"|"+fontColor);
							break;
						}
					}
					//������ ���� �޽���
					this.send(Protocol.WHISPER+"|"+
					                     nickName+"|"+
							            otherName+"|"+
							                  msg1+"|"+fontColor);
				}break;				
				case Protocol.CHANGE:{
					String nickName = st.nextToken();
					String afterName = st.nextToken();
					//String msg = nickName+"���� ��ȭ���� "+afterName+"���� ����";
					String msg = st.nextToken();
					String fontColor = st.nextToken();
					this.chatName = afterName;
					//insert here
					broadCasting(Protocol.CHANGE+"|"+
					                     nickName+"|"+
					                     afterName+"|"+
							                  msg+"|"+fontColor);
				}break;
				case Protocol.ROOM_OUT:{//500|����
					String name = st.nextToken();
					String fontColor = st.nextToken();
					//Vector���� �� ����� �����Ѵ�.
					//ChattingServerThread���� this�� ���� ������ ����ڿ� ���� ������
					//������ �ְ� cst�� ���� ������ ������ �ִ� ����� �ϳ��ϳ��� ������
					//�� �ִ�.
					KosmoCRUD kc = new KosmoCRUD();
					String id = kc.memberID(name);
					kc.memberState(id, 0);
					
					cs.chatList.remove(this);
					//�ٸ� ����鿡�Ե� �˸���.
					this.broadCasting(Protocol.ROOM_OUT+"|"+name+"|"+fontColor);
					//�� �̻� ������������ ���� ����� �ƴϹǷ� while�� ������ Ż���Ų��.
					break run_start;
				}///////////end of ������ Ȥ�� ����
				}///////////end of switch 
			}///////////////end of while
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}








