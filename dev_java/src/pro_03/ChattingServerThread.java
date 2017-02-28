package pro_03;


import java.awt.BorderLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthSpinnerUI;

import org.omg.Messaging.SyncScopeHelper;

public class ChattingServerThread  extends Thread{
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	ChattingServer cs;
	ChattingClient cc;
	String roomName;
	Room room;
	Vector<ChattingServerThread> chatList = null;
	Vector<String> userList = null;
	String chatName;
	int protocol=0;
	public ChattingServerThread(ChattingServer cs) {
		this.cs = cs;		
		try{
			oos = new ObjectOutputStream(cs.client.getOutputStream());
			ois = new ObjectInputStream(cs.client.getInputStream());
			String message = (String)ois.readObject();
			cs.jta_display.append(message+"\n");
			cs.jta_display.setCaretPosition(cs.jta_display.getDocument().getLength());
			StringTokenizer st = new StringTokenizer(message, "|");
			protocol = Integer.parseInt(st.nextToken());
		}catch(Exception e){
		}
	}
	public ChattingServerThread(ChattingClient cc) {
		this.cc = cc;
	}
	public void broadCastting(String message){
		int count =0;
		synchronized (this) {
			for(Room room:this.cs.chatList){		
				System.out.println(room.getTitle()+"   ===   "+this.roomName);
				if(room.title.equals(this.roomName)){
					for(ChattingServerThread cst :room.chatList){
						cst.send(message);
					}
				}
			}
		}
	}
	
	public void send(String message){		
		try{
			oos.writeObject(message);
		}catch(Exception e){
			JOptionPane.showMessageDialog(cs
					, "send log"
					, "Error"
					, JOptionPane.ERROR_MESSAGE);
		}
	}

	public void run(){//지연 처리, 기다림 저용가능,우선 순위를 둘수 있다.		
		boolean isStop = false;
		String message ;
		try{
			run_start:
				while (!isStop){
				   message = (String)ois.readObject();
				   StringTokenizer st =null;
				   cs.jta_display.append(message);
					cs.jta_display.setCaretPosition(cs.jta_display.getDocument().getLength());
					
					int protocol =0;
					if(message!=null){
						st =new StringTokenizer(message, "|");
						protocol =Integer.parseInt(st.nextToken());
					}
					switch(protocol){
					case Protocol.ROOM_IN:{
						int rowNum = Integer.parseInt(st.nextToken());
						this.chatName = st.nextToken();
						this.roomName= st.nextToken();
						int max,np=0;
						for(Room room:this.cs.chatList){			
							if(room.title.equals(this.roomName)){
								max = room.getMax();
								np=room.chatList.size();
								if(!room.maxFull){
									for(int i=0;i<room.userList.size();i++){
										this.send(Protocol.ROOM_IN+"|"+room.userList.get(i)+"|"+"false");
									}
									room.userList.add(this.chatName);
									room.chatList.add(this);
									broadCastting(Protocol.ROOM_IN+"|"+this.chatName+"|"+"false" );
									if(room.getMax()==room.userList.size()){
										room.maxFull=true;
									}
								}else{
									this.send(Protocol.ROOM_IN+"|"+this.chatName+"|"+"true");
								}
							}
						}
						for(Room room:this.cs.chatList){	
							//this.send(Protocol.ROOM_CHANGE+"|"+this.cs.chatList.size()+"|"+room.getTitle()+"|"+room.chatList.size()+ "|"+room.getMax());
							for(ChattingServerThread cst : room.chatList){
								for(Room roomInfo:this.cs.chatList){	
										cst.send(Protocol.ROOM_CHANGE+"|"+this.cs.chatList.size()+"|"+roomInfo.getTitle()+"|"+roomInfo.chatList.size()+ "|"+roomInfo.getMax());

									}
								}
						}
					}break;
					case Protocol.MESSAGE:{
						String nickName =st.nextToken();
						String msg = st.nextToken();
						broadCastting(Protocol.MESSAGE+"|"+
						              nickName+"|"+
											msg);
					}break;
					case Protocol.CHANGE:{
						String nickName =st.nextToken();
						String newNickName =st.nextToken();	
						broadCastting(Protocol.CHANGE+"|"+nickName+"|"+newNickName);				        
					}break;
					case Protocol.WHISPER:{
						String nickName = st.nextToken();//보내는 넘
						//insert here - 받는 넘
						String otherName = st.nextToken();
						//귓속말로 보내진 메시지
						String msg1 = st.nextToken();
						//insert here
						//chatList에서 상대이름과 cst의 chatName을 비교하여
						//같으면 그에게만 메시지를 전송합니다.
						for(Room room:this.cs.chatList){
							if(room.getTitle().equals(this.roomName)){
								for(ChattingServerThread cst:room.chatList){
									if(otherName.equals(cst.chatName)){
										cst.send(Protocol.WHISPER+"|"+
							                     nickName+"|"+
									            otherName+"|"+
									                  msg1);
										break;
									}
								}
							}
						}
						//상대에게 가는 메시지	
						this.send(Protocol.WHISPER+"|"+
							nickName+"|"+
							otherName+"|"+
							               msg1);
					}break;
					case Protocol.ROOM_OUT:{						
						for(Room room:this.cs.chatList){
							if(room.getTitle().equals(this.roomName)){
								room.maxFull=false;
								broadCastting(Protocol.ROOM_OUT+"|"+this.chatName);
								room.chatList.remove(this);
								room.userList.remove(this.chatName);	
								if(room.chatList.size()==0){
									this.cs.chatList.remove(room);
								}
							}
							//this.send(Protocol.ROOM_OUT+"|"+this.chatName+"|"+this.cs.chatList.size()+"|"+room.getTitle()+"|"+room.chatList.size()+ "|"+roomInfo.getMax());
						}
						for(Room room:this.cs.chatList){	
							//this.send(Protocol.ROOM_CHANGE+"|"+this.cs.chatList.size()+"|"+room.getTitle()+"|"+room.chatList.size()+ "|"+room.getMax());
							for(ChattingServerThread cst : room.chatList){
								for(Room roomInfo:this.cs.chatList){	
										cst.send(Protocol.ROOM_CHANGE+"|"+this.cs.chatList.size()+"|"+roomInfo.getTitle()+"|"+roomInfo.chatList.size()+ "|"+roomInfo.getMax());
									}
							}
						}
						
					}break;
					case Protocol.CLOSE:{}break;
					//채팅 방만들기
					case Protocol.ROOM_MAKE:{
						room =new Room();
						this.chatName =  st.nextToken();
						room.setUserList(this.chatName);
						this.roomName =st.nextToken();
						room.setTitle(this.roomName);
						int max =Integer.parseInt(st.nextToken());  
						room.setMax(max);
						room.setChatList(this);
						room.maxFull=false;
						this.cs.chatList.add(room);
						//동일한 아이디로 채팅만 있는지 확인
						this.send(Protocol.ROOM_MAKE+"|"+this.roomName+"|"+room.chatList.size()+ "|"+max);
						for(Room room:this.cs.chatList){	
							//this.send(Protocol.ROOM_CHANGE+"|"+this.cs.chatList.size()+"|"+room.getTitle()+"|"+room.chatList.size()+ "|"+room.getMax());
							for(ChattingServerThread cst : room.chatList){
								for(Room roomInfo:this.cs.chatList){	
										cst.send(Protocol.ROOM_CHANGE+"|"+this.cs.chatList.size()+"|"+roomInfo.getTitle()+"|"+roomInfo.chatList.size()+ "|"+roomInfo.getMax());

									}
								}
						}
					}break;
					//처음 로그인 후 채팅방 리스트 확인
					case Protocol.ROOM_LIST:{
						for(Room room:this.cs.chatList){	
							//this.send(Protocol.ROOM_CHANGE+"|"+this.cs.chatList.size()+"|"+room.getTitle()+"|"+room.chatList.size()+ "|"+room.getMax());
							for(ChattingServerThread cst : room.chatList){
								for(Room roomInfo:this.cs.chatList){	
										this.send(Protocol.ROOM_LIST+"|"+this.cs.chatList.size()+"|"+roomInfo.getTitle()+"|"+roomInfo.chatList.size()+ "|"+roomInfo.getMax());
									}
								}
						}
					}break;
					}
				}
		}catch(Exception e){
		}
	}
	private Socket elementAt(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	private int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}

