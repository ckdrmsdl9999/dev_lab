package com.projectTest;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ChattingClientThread extends Thread {
	ChattingClient cc = null;
	/////
	ImageIcon img1 = new ImageIcon(getClass().getResource("0.jpg"));
	Image reimg1 = img1.getImage();  //ImageIcon�� Image�� ��ȯ.
	Image rreimg1 = reimg1.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg1 = new ImageIcon(rreimg1); //Image�� ImageIcon ����
	
	ImageIcon img2 = new ImageIcon(getClass().getResource("1.jpg"));
	Image reimg2 = img2.getImage();  //ImageIcon�� Image�� ��ȯ.
	Image rreimg2 = reimg2.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg2 = new ImageIcon(rreimg2); //Image�� ImageIcon ����
	
	ImageIcon img3 = new ImageIcon(getClass().getResource("2.jpg"));
	Image reimg3 = img3.getImage();  //ImageIcon�� Image�� ��ȯ.
	Image rreimg3 = reimg3.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg3 = new ImageIcon(rreimg3); //Image�� ImageIcon ����
	
	ImageIcon img4 = new ImageIcon(getClass().getResource("3.jpg"));
	Image reimg4 = img4.getImage();  //ImageIcon�� Image�� ��ȯ.
	Image rreimg4 = reimg4.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg4 = new ImageIcon(rreimg4); //Image�� ImageIcon ����
	
	ImageIcon img5 = new ImageIcon(getClass().getResource("4.jpg"));
	Image reimg5 = img5.getImage();  //ImageIcon�� Image�� ��ȯ.
	Image rreimg5 = reimg5.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg5 = new ImageIcon(rreimg5); //Image�� ImageIcon ����
	
	ImageIcon img6 = new ImageIcon(getClass().getResource("5.jpg"));
	Image reimg6 = img6.getImage();  //ImageIcon�� Image�� ��ȯ.
	Image rreimg6 = reimg6.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg6 = new ImageIcon(rreimg6); //Image�� ImageIcon ����
	
	ImageIcon img7 = new ImageIcon(getClass().getResource("6.jpg"));
	Image reimg7 = img7.getImage();  //ImageIcon�� Image�� ��ȯ.
	Image rreimg7 = reimg7.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg7 = new ImageIcon(rreimg7); //Image�� ImageIcon ����
	
	ImageIcon img8 = new ImageIcon(getClass().getResource("7.jpg"));
	Image reimg8 = img8.getImage();  //ImageIcon�� Image�� ��ȯ.
	Image rreimg8 = reimg8.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg8 = new ImageIcon(rreimg8); //Image�� ImageIcon ����
	
	ImageIcon img9 = new ImageIcon(getClass().getResource("8.jpg"));
	Image reimg9 = img9.getImage();  //ImageIcon�� Image�� ��ȯ.
	Image rreimg9 = reimg9.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg9 = new ImageIcon(rreimg9); //Image�� ImageIcon ����
	
	public ChattingClientThread(ChattingClient cc){
		this.cc = cc;
	}
	public SimpleAttributeSet makeAttribute(String fontColor)
	{
		SimpleAttributeSet sas = new SimpleAttributeSet();
		//��Ʈ �÷�
		sas.addAttribute(StyleConstants.ColorConstants.Foreground
				       , new Color(Integer.parseInt(fontColor)));
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
					Vector<String> v_name = new Vector<String>();
					v_name.add(nickName);
					cc.dtm_room.addRow(v_name);
					cc.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			            public void adjustmentValueChanged(AdjustmentEvent e) {
			                JScrollBar src = (JScrollBar) e.getSource();
			                src.setValue(src.getMaximum());
			            }     
			        });
					SimpleAttributeSet sas = makeAttribute(fontColor);
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
				//200|����|���� ���͵��ұ�?|��������
	            case Protocol.MESSAGE:{//�Ϲݴ�ȭ-���ڰ� ��ȭ
	               String nickName = st.nextToken();
	               String msg = st.nextToken();
	               String fontColor = st.nextToken();
	               SimpleAttributeSet sas = makeAttribute(fontColor);
	               //JOptionPane.showMessageDialog(cc, fontColor, "INFO", JOptionPane.INFORMATION_MESSAGE);
	               //200|����|���� ���͵��ұ�?|�������� ����ϱ�
	               try {
	            	   msg = msg.trim();
	            	   if(msg.equals("/����")){
                           cc.jtp_display.insertIcon(rrreimg1);
                           cc.sd_display.insertString(cc.sd_display.getLength(),"\n"+ "["+nickName+"]"+"\n", sas);
                        }
                        else if(msg.equals("/����")){
                              cc.jtp_display.insertIcon(rrreimg2);
                              cc.sd_display.insertString(cc.sd_display.getLength(),"\n"+ "["+nickName+"]"+"\n", sas);
                           }
                        else if(msg.equals("/��")){
                              cc.jtp_display.insertIcon(rrreimg3);
                              cc.sd_display.insertString(cc.sd_display.getLength(),"\n"+ "["+nickName+"]"+"\n", sas);
                           }
                        else if(msg.equals("/�ɽ�")){
                              cc.jtp_display.insertIcon(rrreimg4);
                              cc.sd_display.insertString(cc.sd_display.getLength(),"\n"+ "["+nickName+"]"+"\n", sas);
                           }
                        else if(msg.equals("/����")){
                              cc.jtp_display.insertIcon(rrreimg5);
                              cc.sd_display.insertString(cc.sd_display.getLength(),"\n"+ "["+nickName+"]"+"\n", sas);
                           }
                        else if(msg.equals("/������")){
                              cc.jtp_display.insertIcon(rrreimg6);
                              cc.sd_display.insertString(cc.sd_display.getLength(),"\n"+ "["+nickName+"]"+"\n", sas);
                           }
                        else if(msg.equals("/����")){
                              cc.jtp_display.insertIcon(rrreimg7);
                              cc.sd_display.insertString(cc.sd_display.getLength(),"\n"+ "["+nickName+"]"+"\n", sas);
                           }
                        else if(msg.equals("/���Ҿ�")){
                              cc.jtp_display.insertIcon(rrreimg8);
                              cc.sd_display.insertString(cc.sd_display.getLength(),"\n"+ "["+nickName+"]"+"\n", sas);
                           }
                        else if(msg.equals("/����")){
                              cc.jtp_display.insertIcon(rrreimg9);
                              cc.sd_display.insertString(cc.sd_display.getLength(),"\n"+ "["+nickName+"]"+"\n", sas);
                        } 
                        else {
		                     cc.sd_display.insertString(cc.sd_display.getLength()
                                     , "["+nickName+"]"+msg+"\n"
                                     , sas);
                        }
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
					SimpleAttributeSet sas = makeAttribute(fontColor);
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
					SimpleAttributeSet sas = makeAttribute(fontColor);
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
				//insert here - ���� ����� ȭ�鿡 ����� �ش�.
					SimpleAttributeSet sas = makeAttribute(fontColor);
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
				case Protocol.EMOTICON : {
					String nickName = st.nextToken();
					Object msg = st.nextToken();
					String fontColor = st.nextToken();
					SimpleAttributeSet sas = makeAttribute(fontColor);
					msg =(Object)rrreimg1;
					try{
						cc.sd_display.insertString(cc.sd_display.getLength()
				                 , "["+nickName+"]"+msg+"\n"
				                 , sas);
					cc.jtp_display.setCaretPosition(cc.jtp_display.getDocument().getLength());
					}
					catch (Exception e){
						
					}
					}
				//500|����|��������
				case Protocol.CLOSE:{//�����ư ������ ��
					//�������� �Ѿ�� �޽��� -  500|����	
					//insert here - ��ȭ���� �޾ƿ´�.
						String name = st.nextToken();
						String fontColor = st.nextToken();
					//insert here - ���� ����� ȭ�鿡 ����� �ش�.
						SimpleAttributeSet sas = makeAttribute(fontColor);
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
