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
	Image reimg1 = img1.getImage();  //ImageIcon을 Image로 변환.
	Image rreimg1 = reimg1.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg1 = new ImageIcon(rreimg1); //Image로 ImageIcon 생성
	
	ImageIcon img2 = new ImageIcon(getClass().getResource("1.jpg"));
	Image reimg2 = img2.getImage();  //ImageIcon을 Image로 변환.
	Image rreimg2 = reimg2.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg2 = new ImageIcon(rreimg2); //Image로 ImageIcon 생성
	
	ImageIcon img3 = new ImageIcon(getClass().getResource("2.jpg"));
	Image reimg3 = img3.getImage();  //ImageIcon을 Image로 변환.
	Image rreimg3 = reimg3.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg3 = new ImageIcon(rreimg3); //Image로 ImageIcon 생성
	
	ImageIcon img4 = new ImageIcon(getClass().getResource("3.jpg"));
	Image reimg4 = img4.getImage();  //ImageIcon을 Image로 변환.
	Image rreimg4 = reimg4.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg4 = new ImageIcon(rreimg4); //Image로 ImageIcon 생성
	
	ImageIcon img5 = new ImageIcon(getClass().getResource("4.jpg"));
	Image reimg5 = img5.getImage();  //ImageIcon을 Image로 변환.
	Image rreimg5 = reimg5.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg5 = new ImageIcon(rreimg5); //Image로 ImageIcon 생성
	
	ImageIcon img6 = new ImageIcon(getClass().getResource("5.jpg"));
	Image reimg6 = img6.getImage();  //ImageIcon을 Image로 변환.
	Image rreimg6 = reimg6.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg6 = new ImageIcon(rreimg6); //Image로 ImageIcon 생성
	
	ImageIcon img7 = new ImageIcon(getClass().getResource("6.jpg"));
	Image reimg7 = img7.getImage();  //ImageIcon을 Image로 변환.
	Image rreimg7 = reimg7.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg7 = new ImageIcon(rreimg7); //Image로 ImageIcon 생성
	
	ImageIcon img8 = new ImageIcon(getClass().getResource("7.jpg"));
	Image reimg8 = img8.getImage();  //ImageIcon을 Image로 변환.
	Image rreimg8 = reimg8.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg8 = new ImageIcon(rreimg8); //Image로 ImageIcon 생성
	
	ImageIcon img9 = new ImageIcon(getClass().getResource("8.jpg"));
	Image reimg9 = img9.getImage();  //ImageIcon을 Image로 변환.
	Image rreimg9 = reimg9.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	ImageIcon rrreimg9 = new ImageIcon(rreimg9); //Image로 ImageIcon 생성
	
	public ChattingClientThread(ChattingClient cc){
		this.cc = cc;
	}
	public SimpleAttributeSet makeAttribute(String fontColor)
	{
		SimpleAttributeSet sas = new SimpleAttributeSet();
		//폰트 컬러
		sas.addAttribute(StyleConstants.ColorConstants.Foreground
				       , new Color(Integer.parseInt(fontColor)));
		return sas;
	}
	//run메소드는 서버에서 말한 내용을 듣기만 하는 곳입니다.
	//클라이언트의 말하기는 이벤트(ChattingClient)에서 처리 합니다.
	public void run(){
		String message = "";
		boolean isStop = false;
		while(!isStop){
			try {
				//message =  100|하하
				message = (String)cc.ois.readObject();
				StringTokenizer st = null;
				int protocol = 0;
				if(message !=null){
					st = new StringTokenizer(message,"|");
					protocol = Integer.parseInt(st.nextToken());//100
				}
				switch(protocol){
				case Protocol.ROOM_IN:{
					//insert here - 대화명 가져오기
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
					//화면에 하하님이 입장하였습니다. 출력하기
					try {
						cc.sd_display.insertString(cc.sd_display.getLength()
								                 , "#####"+nickName+"님이 입장하였습니다.#####\n"
								                 , sas);
					} catch (Exception e) {
						// TODO: handle exception
					}
					cc.jtp_display.setCaretPosition(cc.sd_display.getLength());
				}break;
				//200|하하|오늘 스터디할까?|색상정보
				//200|하하|오늘 스터디할까?|색상정보
	            case Protocol.MESSAGE:{//일반대화-다자간 대화
	               String nickName = st.nextToken();
	               String msg = st.nextToken();
	               String fontColor = st.nextToken();
	               SimpleAttributeSet sas = makeAttribute(fontColor);
	               //JOptionPane.showMessageDialog(cc, fontColor, "INFO", JOptionPane.INFORMATION_MESSAGE);
	               //200|하하|오늘 스터디할까?|색상정보 출력하기
	               try {
	            	   msg = msg.trim();
	            	   if(msg.equals("/흑흑")){
                           cc.jtp_display.insertIcon(rrreimg1);
                           cc.sd_display.insertString(cc.sd_display.getLength(),"\n"+ "["+nickName+"]"+"\n", sas);
                        }
                        else if(msg.equals("/잘자")){
                              cc.jtp_display.insertIcon(rrreimg2);
                              cc.sd_display.insertString(cc.sd_display.getLength(),"\n"+ "["+nickName+"]"+"\n", sas);
                           }
                        else if(msg.equals("/헙")){
                              cc.jtp_display.insertIcon(rrreimg3);
                              cc.sd_display.insertString(cc.sd_display.getLength(),"\n"+ "["+nickName+"]"+"\n", sas);
                           }
                        else if(msg.equals("/심심")){
                              cc.jtp_display.insertIcon(rrreimg4);
                              cc.sd_display.insertString(cc.sd_display.getLength(),"\n"+ "["+nickName+"]"+"\n", sas);
                           }
                        else if(msg.equals("/뭐지")){
                              cc.jtp_display.insertIcon(rrreimg5);
                              cc.sd_display.insertString(cc.sd_display.getLength(),"\n"+ "["+nickName+"]"+"\n", sas);
                           }
                        else if(msg.equals("/오케이")){
                              cc.jtp_display.insertIcon(rrreimg6);
                              cc.sd_display.insertString(cc.sd_display.getLength(),"\n"+ "["+nickName+"]"+"\n", sas);
                           }
                        else if(msg.equals("/따봉")){
                              cc.jtp_display.insertIcon(rrreimg7);
                              cc.sd_display.insertString(cc.sd_display.getLength(),"\n"+ "["+nickName+"]"+"\n", sas);
                           }
                        else if(msg.equals("/좋았어")){
                              cc.jtp_display.insertIcon(rrreimg8);
                              cc.sd_display.insertString(cc.sd_display.getLength(),"\n"+ "["+nickName+"]"+"\n", sas);
                           }
                        else if(msg.equals("/하하")){
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
				//300|하하|나신입|오늘 영화볼까?|색상정보
				case Protocol.WHISPER:{//귓속말-1:1 대화
					String nickName = st.nextToken();
					String otherName = st.nextToken();
					String msg1 = st.nextToken();
					String fontColor = st.nextToken();
					SimpleAttributeSet sas = makeAttribute(fontColor);
					try {
						cc.sd_display.insertString(cc.sd_display.getLength()
								                 , nickName+"님이 "+otherName+"에게"
						                          +msg1+"\n"
								                 , sas);
					} catch (Exception e) {
						// TODO: handle exception
					}
					cc.jtp_display.setCaretPosition(cc.sd_display.getLength());
				}break;
				
				case Protocol.CHANGE:{//대화명변경
					//이전대화명 가져오기
					String nickName = st.nextToken();
					//변경 대화명 가져오기
					String afterName = st.nextToken();
					String msg = st.nextToken();
					String fontColor = st.nextToken();
					//테이블에 대화명 변경하기
					for(int i=0;i<cc.dtm_room.getRowCount();i++){
					//대화명 변경전에 현재 테이블에서 가져온 대화명을 받는다.
						String cname = (String)cc.dtm_room.getValueAt(i, 0);
						if(nickName.equals(cname)){
							//변경할 대화명으로 테이블내에 대화명을 변경한다.
							cc.dtm_room.setValueAt(afterName, i, 0);
							break;
						}
					}
					//메시지 출력하기
					SimpleAttributeSet sas = makeAttribute(fontColor);
					try {
						cc.sd_display.insertString(cc.sd_display.getLength()
								                 , msg+"\n"
								                 , sas);
					} catch (Exception e) {
						// TODO: handle exception
					}
					cc.jtp_display.setCaretPosition(cc.sd_display.getLength());					
					//채팅 팝업창에 타이틀 바에도 대화명을 변경한다.
					if(nickName.equals(cc.nickName)){
						cc.setTitle(afterName+"님의 대화창");
						cc.nickName = afterName;
					}
					
				}break;
				case Protocol.ROOM_OUT: {//방나가기
				//서버에서 넘어온 메시지 -  500|하하	
				//insert here - 대화명을 받아온다.
					String name = st.nextToken();
					String fontColor = st.nextToken();
				//insert here - 퇴장 사실을 화면에 출력해 준다.
					SimpleAttributeSet sas = makeAttribute(fontColor);
					try {
						cc.sd_display.insertString(cc.sd_display.getLength()
								                 , name+"님이 퇴장하였습니다."+"\n"
								                 , sas);
					} catch (Exception e) {
						// TODO: handle exception
					}
					cc.jtp_display.setCaretPosition(cc.sd_display.getLength());						
				//insert here - 테이블에서 퇴장한 사용자의 이름을 삭제해준다.
					for(int i=0;i<cc.dtm_room.getRowCount();i++){
						String n1 = (String)cc.dtm_room.getValueAt(i, 0);
						if(name.equals(n1)){//퇴장한 사람과 같은 사람을 찾아라~~~~
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
				//500|하하|색상정보
				case Protocol.CLOSE:{//종료버튼 눌렀을 때
					//서버에서 넘어온 메시지 -  500|하하	
					//insert here - 대화명을 받아온다.
						String name = st.nextToken();
						String fontColor = st.nextToken();
					//insert here - 퇴장 사실을 화면에 출력해 준다.
						SimpleAttributeSet sas = makeAttribute(fontColor);
						try {
							cc.sd_display.insertString(cc.sd_display.getLength()
									                 , name+"님이 퇴장하였습니다."+"\n"
									                 , sas);
						} catch (Exception e) {
							// TODO: handle exception
						}
						cc.jtp_display.setCaretPosition(cc.sd_display.getLength());							
					//insert here - 테이블에서 퇴장한 사용자의 이름을 삭제해준다.
						for(int i=0;i<cc.dtm_room.getRowCount();i++){
							String n1 = (String)cc.dtm_room.getValueAt(i, 0);
							if(name.equals(n1)){//퇴장한 사람과 같은 사람을 찾아라~~~~
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
