package com.chatting;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JScrollBar;

public class ChattingClientThread extends Thread {
	ChattingClient cc = null;
	public ChattingClientThread(ChattingClient cc){
		this.cc = cc;
	}
	//run�޼ҵ�� �������� ���� ������ ��⸸ �ϴ� ���Դϴ�.
	//Ŭ���̾�Ʈ�� ���ϱ�� �̺�Ʈ(ChattingClient)���� ó�� �մϴ�.
	public void run(){
		String message = "";
		boolean isStop = false;
		while(!isStop){
			try {
				//message =  100|����
				message = (String)cc.ois.readObject();
				StringTokenizer st = null;
				int protocol = 0;
				if(message !=null){
					st = new StringTokenizer(message,"|");
					protocol = Integer.parseInt(st.nextToken());//100
				}
				switch(protocol){
				case Protocol.ROOM_IN:{
					//insert here - ��ȭ�� ��������
					String nickName = st.nextToken();
					Vector<String> v_name = new Vector<String>();
					v_name.add(nickName);
					cc.dtm_room.addRow(v_name);
					cc.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			            public void adjustmentValueChanged(AdjustmentEvent e) {
			                JScrollBar src = (JScrollBar) e.getSource();
			                src.setValue(src.getMaximum());
			            }     
			        });					
					//ȭ�鿡 ���ϴ��� �����Ͽ����ϴ�. ����ϱ�
					cc.jta_display.append("#####"+nickName+"���� �����Ͽ����ϴ�.#####\n");
					cc.jta_display.setCaretPosition(cc.jta_display.getDocument().getLength());
				}break;
				case Protocol.MESSAGE:{//�Ϲݴ�ȭ-���ڰ� ��ȭ
					String nickName = st.nextToken();
					String msg = st.nextToken();
					cc.jta_display.append("["+nickName+"] "+msg+"\n");
					cc.jta_display.setCaretPosition(cc.jta_display.getDocument().getLength());
				}break;
				case Protocol.WHISPER:{//�ӼӸ�-1:1 ��ȭ
					String nickName = st.nextToken();
					String otherName = st.nextToken();
					String msg1 = st.nextToken();
					//insert here - ������� ȭ�鿡 �ӼӸ� ����ϱ�
					cc.jta_display.append(nickName+"���� "+otherName+"�Կ��� "+msg1+"\n");
					cc.jta_display.setCaretPosition(cc.jta_display.getDocument().getLength());
				}break;
				case Protocol.CHANGE:{//��ȭ����
					//������ȭ�� ��������
					String nickName = st.nextToken();
					//���� ��ȭ�� ��������
					String afterName = st.nextToken();
					//���̺� ��ȭ�� �����ϱ�
					for(int i=0;i<cc.dtm_room.getRowCount();i++){
					//��ȭ�� �������� ���� ���̺��� ������ ��ȭ���� �޴´�.
						String cname = (String)cc.dtm_room.getValueAt(i, 0);
						if(nickName.equals(cname)){
							//������ ��ȭ������ ���̺��� ��ȭ���� �����Ѵ�.
							cc.dtm_room.setValueAt(afterName, i, 0);
							break;
						}
					}
					//�޽��� ����ϱ�
					cc.jta_display.append(nickName+"���� ��ȭ���� "+afterName+"���� ����"+"\n");
					cc.jta_display.setCaretPosition(cc.jta_display.getDocument().getLength());
					//ä�� �˾�â�� Ÿ��Ʋ �ٿ��� ��ȭ���� �����Ѵ�.
					if(nickName.equals(cc.nickName)){
						cc.setTitle(afterName+"���� ��ȭâ");
						cc.nickName = afterName;
					}
					
				}break;
				case Protocol.ROOM_OUT: {//�泪����
				//�������� �Ѿ�� �޽��� -  500|����	
				//insert here - ��ȭ���� �޾ƿ´�.
					String name = st.nextToken();
				//insert here - ���� ����� ȭ�鿡 ����� �ش�.
					cc.jta_display.append(name+"���� �����Ͽ����ϴ�.");
				//insert here - ���̺��� ������ ������� �̸��� �������ش�.
					for(int i=0;i<cc.dtm_room.getRowCount();i++){
						String n1 = (String)cc.dtm_room.getValueAt(i, 0);
						if(name.equals(n1)){//������ ����� ���� ����� ã�ƶ�~~~~
							cc.dtm_room.removeRow(i);
						}
					}
				}break;
				case Protocol.CLOSE:{//�����ư ������ ��
					//�������� �Ѿ�� �޽��� -  500|����	
					//insert here - ��ȭ���� �޾ƿ´�.
						String name = st.nextToken();
					//insert here - ���� ����� ȭ�鿡 ����� �ش�.
						cc.jta_display.append(name+"���� �����Ͽ����ϴ�."+"\n");
					//insert here - ���̺��� ������ ������� �̸��� �������ش�.
						for(int i=0;i<cc.dtm_room.getRowCount();i++){
							String n1 = (String)cc.dtm_room.getValueAt(i, 0);
							if(name.equals(n1)){//������ ����� ���� ����� ã�ƶ�~~~~
								cc.dtm_room.removeRow(i);
							}
						}					
				}break;
				}////////////////////end of switch
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
