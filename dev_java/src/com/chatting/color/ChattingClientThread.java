package com.chatting.color;

import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ChattingClientThread extends Thread {
	ChattingClient cc = null;
	public ChattingClientThread(ChattingClient cc){
		this.cc = cc;
	}
	public SimpleAttributeSet makeAttribute(String style[])
	{
		SimpleAttributeSet sas = new SimpleAttributeSet();
		//��Ʈ �÷�
		sas.addAttribute(StyleConstants.ColorConstants.Foreground
				       , new Color(Integer.parseInt(style[0])));
		
		//��Ʈ Ÿ��
		switch(style[1]){
		case "Font.ITALIC":
			sas.addAttribute(StyleConstants.CharacterConstants.Italic, true);
			break;
		case "Font.BOLD":
			sas.addAttribute(StyleConstants.CharacterConstants.Bold, true);
			break;		
		}
		//��Ʈ ������
		sas.addAttribute(StyleConstants.CharacterConstants.Size, Integer.parseInt(style[2]));
		return sas;
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
					String fontColor = st.nextToken();
					String style[] = new String[3];
					style[0] = fontColor;
					Vector<String> v_name = new Vector<String>();
					v_name.add(nickName);
					cc.dtm_room.addRow(v_name);
					cc.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			            public void adjustmentValueChanged(AdjustmentEvent e) {
			                JScrollBar src = (JScrollBar) e.getSource();
			                src.setValue(src.getMaximum());
			            }     
			        });
					SimpleAttributeSet sas = makeAttribute(style);
					//ȭ�鿡 ���ϴ��� �����Ͽ����ϴ�. ����ϱ�
					try {
						cc.sd_display.insertString(cc.sd_display.getLength()
								                 , "#####"+nickName+"���� �����Ͽ����ϴ�.#####\n"
								                 , sas);
					} catch (Exception e) {
						// TODO: handle exception
					}
					cc.jtp_display.setCaretPosition(cc.sd_display.getLength());
				}break;
				//200|����|���� ���͵��ұ�?|��������
				case Protocol.MESSAGE:{//�Ϲݴ�ȭ-���ڰ� ��ȭ
					//200|���ʺ�|�׽�Ʈ|0
					String nickName = st.nextToken();//���ʺ�
					String msg = st.nextToken();//�׽�Ʈ
					String fontColor = st.nextToken();//0
					String fontType = st.nextToken();
					String fontSize = st.nextToken();
					String style[] = new String[3];
					style[0] = fontColor;
					style[1] = fontType;
					style[2] = fontSize;
					SimpleAttributeSet sas = makeAttribute(style);
					//JOptionPane.showMessageDialog(cc, fontColor, "INFO", JOptionPane.INFORMATION_MESSAGE);
					//200|����|���� ���͵��ұ�?|�������� ����ϱ�
					try {
						cc.sd_display.insertString(cc.sd_display.getLength()
								                 , "["+nickName+"]"+msg+"\n"
								                 , sas);
					} catch (Exception e) {
						// TODO: handle exception
					}
					cc.jtp_display.setCaretPosition(cc.sd_display.getLength());
				}break;
				//300|����|������|���� ��ȭ����?|��������
				case Protocol.WHISPER:{//�ӼӸ�-1:1 ��ȭ
					String nickName = st.nextToken();
					String otherName = st.nextToken();
					String msg1 = st.nextToken();
					String fontColor = st.nextToken();
					String style[] = new String[3];
					style[0] = fontColor;
					SimpleAttributeSet sas = makeAttribute(style);
					try {
						cc.sd_display.insertString(cc.sd_display.getLength()
								                 , nickName+"���� "+otherName+"����"
						                          +msg1+"\n"
								                 , sas);
					} catch (Exception e) {
						// TODO: handle exception
					}
					cc.jtp_display.setCaretPosition(cc.sd_display.getLength());
				}break;
				
				case Protocol.CHANGE:{//��ȭ����
					//������ȭ�� ��������
					String nickName = st.nextToken();
					//���� ��ȭ�� ��������
					String afterName = st.nextToken();
					String msg = st.nextToken();
					String fontColor = st.nextToken();
					String style[] = new String[3];
					style[0] = fontColor;
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
					SimpleAttributeSet sas = makeAttribute(style);
					try {
						cc.sd_display.insertString(cc.sd_display.getLength()
								                 , msg+"\n"
								                 , sas);
					} catch (Exception e) {
						// TODO: handle exception
					}
					cc.jtp_display.setCaretPosition(cc.sd_display.getLength());					
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
					String fontColor = st.nextToken();
					String style[] = new String[3];
					style[0] = fontColor;
				//insert here - ���� ����� ȭ�鿡 ����� �ش�.
					SimpleAttributeSet sas = makeAttribute(style);
					try {
						cc.sd_display.insertString(cc.sd_display.getLength()
								                 , name+"���� �����Ͽ����ϴ�."+"\n"
								                 , sas);
					} catch (Exception e) {
						// TODO: handle exception
					}
					cc.jtp_display.setCaretPosition(cc.sd_display.getLength());						
				//insert here - ���̺��� ������ ������� �̸��� �������ش�.
					for(int i=0;i<cc.dtm_room.getRowCount();i++){
						String n1 = (String)cc.dtm_room.getValueAt(i, 0);
						if(name.equals(n1)){//������ ����� ���� ����� ã�ƶ�~~~~
							cc.dtm_room.removeRow(i);
						}
					}
				}break;
				//500|����|��������
				case Protocol.CLOSE:{//�����ư ������ ��
					//�������� �Ѿ�� �޽��� -  500|����	
					//insert here - ��ȭ���� �޾ƿ´�.
						String name = st.nextToken();
						String fontColor = st.nextToken();
						String style[] = new String[3];
						style[0] = fontColor;
					//insert here - ���� ����� ȭ�鿡 ����� �ش�.
						SimpleAttributeSet sas = makeAttribute(style);
						try {
							cc.sd_display.insertString(cc.sd_display.getLength()
									                 , name+"���� �����Ͽ����ϴ�."+"\n"
									                 , sas);
						} catch (Exception e) {
							// TODO: handle exception
						}
						cc.jtp_display.setCaretPosition(cc.sd_display.getLength());							
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
