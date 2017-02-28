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
		//폰트 컬러
		sas.addAttribute(StyleConstants.ColorConstants.Foreground
				       , new Color(Integer.parseInt(style[0])));
		
		//폰트 타입
		switch(style[1]){
		case "Font.ITALIC":
			sas.addAttribute(StyleConstants.CharacterConstants.Italic, true);
			break;
		case "Font.BOLD":
			sas.addAttribute(StyleConstants.CharacterConstants.Bold, true);
			break;		
		}
		//폰트 사이즈
		sas.addAttribute(StyleConstants.CharacterConstants.Size, Integer.parseInt(style[2]));
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
				case Protocol.MESSAGE:{//일반대화-다자간 대화
					//200|나초보|테스트|0
					String nickName = st.nextToken();//나초보
					String msg = st.nextToken();//테스트
					String fontColor = st.nextToken();//0
					String fontType = st.nextToken();
					String fontSize = st.nextToken();
					String style[] = new String[3];
					style[0] = fontColor;
					style[1] = fontType;
					style[2] = fontSize;
					SimpleAttributeSet sas = makeAttribute(style);
					//JOptionPane.showMessageDialog(cc, fontColor, "INFO", JOptionPane.INFORMATION_MESSAGE);
					//200|하하|오늘 스터디할까?|색상정보 출력하기
					try {
						cc.sd_display.insertString(cc.sd_display.getLength()
								                 , "["+nickName+"]"+msg+"\n"
								                 , sas);
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
					String style[] = new String[3];
					style[0] = fontColor;
					SimpleAttributeSet sas = makeAttribute(style);
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
					String style[] = new String[3];
					style[0] = fontColor;
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
					SimpleAttributeSet sas = makeAttribute(style);
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
					String style[] = new String[3];
					style[0] = fontColor;
				//insert here - 퇴장 사실을 화면에 출력해 준다.
					SimpleAttributeSet sas = makeAttribute(style);
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
				//500|하하|색상정보
				case Protocol.CLOSE:{//종료버튼 눌렀을 때
					//서버에서 넘어온 메시지 -  500|하하	
					//insert here - 대화명을 받아온다.
						String name = st.nextToken();
						String fontColor = st.nextToken();
						String style[] = new String[3];
						style[0] = fontColor;
					//insert here - 퇴장 사실을 화면에 출력해 준다.
						SimpleAttributeSet sas = makeAttribute(style);
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
