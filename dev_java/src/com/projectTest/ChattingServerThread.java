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
	
	
	//이모티콘 변수
		ImageIcon img1 = new ImageIcon(getClass().getResource("0.jpg"));
		Image reimg1 = img1.getImage();  //ImageIcon을 Image로 변환.
		Image rreimg1 = reimg1.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
		ImageIcon rrreimg1 = new ImageIcon(rreimg1); //Image로 ImageIcon 생성
	
	
	
	public ChattingServerThread(ChattingServer cs) {
	//파라미터로 넘어온 ChattingServer를 다른 메소드에서도 사용하려면 
	//멤버변수 선언 후 초기화를 합니다.
		this.cs = cs;
		try {
			oos = new ObjectOutputStream(cs.client.getOutputStream());
			ois = new ObjectInputStream(cs.client.getInputStream());
			String message = (String)ois.readObject();
			cs.jta_display.append(message+"\n");
			//메시지가 추가 될때 마다 화면 이동처리하기
			cs.jta_display.setCaretPosition(cs.jta_display.getDocument().getLength());
			//100|하하|색상정보
			StringTokenizer st = new StringTokenizer(message,"|");
			st.nextToken();//100
			chatName = st.nextToken();//하하
			fontColor = st.nextToken();//색상정보-상수
			//이후 참가자에게도 대화명을 알려 주어야 한다.
			/*	개선 for문 - 자료구조나 배열에 있는 정보 모두를 사용하고 싶을 때 사용합니다.
			 *  for([1]:[2]){
			 *  [1]:자료구조일때는 제네릭 타입을 작성합니다. List<ChattingServerThread>
			 *     :배열일때는 배열 타입을 작성합니다.
			 *  [2]:자료구조 혹은 배열안에 저장된 타입을 작성합니다.
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
			//message=100|하하
			this.broadCasting(message);//100|하하
		} catch (Exception e) {
			cs.jta_display.append("Exception : "+e.toString()+"\n");
		}
	}
	//대화방에 참여한 모든 친구들에게 메시지 출력하기
	public void broadCasting(String message){
		synchronized(this){//동기화 블록
			for(ChattingServerThread cst:cs.chatList){
				cst.send(message);
			}
		}
	}
	//클라이언트로 부터 읽어온 메시지를 출력한다.
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
	public void run(){//지연,기다림,우선순위
		boolean isStop = false;
		try {
			run_start:
			while(!isStop){
				//300|하하|나신입|하하님의 대화명이 나신입으로 변경
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
					String nickName = st.nextToken();//보내는 넘
					//insert here - 받는 넘
					String otherName = st.nextToken();
					//귓속말로 보내진 메시지
					String msg1 = st.nextToken();
					String fontColor = st.nextToken();
					//insert here
					//chatList에서 상대이름과 cst의 chatName을 비교하여
					//같으면 그에게만 메시지를 전송합니다.
					for(ChattingServerThread cst:cs.chatList){
						if(otherName.equals(cst.chatName)){
						//상대에게 가는 메시지	
							cst.send(Protocol.WHISPER+"|"+
				                     nickName+"|"+
						            otherName+"|"+
						                  msg1+"|"+fontColor);
							break;
						}
					}
					//나한테 오는 메시지
					this.send(Protocol.WHISPER+"|"+
					                     nickName+"|"+
							            otherName+"|"+
							                  msg1+"|"+fontColor);
				}break;				
				case Protocol.CHANGE:{
					String nickName = st.nextToken();
					String afterName = st.nextToken();
					//String msg = nickName+"님의 대화명이 "+afterName+"으로 변경";
					String msg = st.nextToken();
					String fontColor = st.nextToken();
					this.chatName = afterName;
					//insert here
					broadCasting(Protocol.CHANGE+"|"+
					                     nickName+"|"+
					                     afterName+"|"+
							                  msg+"|"+fontColor);
				}break;
				case Protocol.ROOM_OUT:{//500|하하
					String name = st.nextToken();
					String fontColor = st.nextToken();
					//Vector에서 그 사람을 삭제한다.
					//ChattingServerThread에서 this는 현재 접속한 사용자에 대한 정보를
					//가지고 있고 cst는 현재 서버에 접속해 있는 사용자 하나하나를 구분할
					//수 있다.
					KosmoCRUD kc = new KosmoCRUD();
					String id = kc.memberID(name);
					kc.memberState(id, 0);
					
					cs.chatList.remove(this);
					//다른 사람들에게도 알린다.
					this.broadCasting(Protocol.ROOM_OUT+"|"+name+"|"+fontColor);
					//더 이상 서버스레드의 관리 대상이 아니므로 while문 블럭을 탈출시킨다.
					break run_start;
				}///////////end of 나가기 혹은 종료
				}///////////end of switch 
			}///////////////end of while
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}









