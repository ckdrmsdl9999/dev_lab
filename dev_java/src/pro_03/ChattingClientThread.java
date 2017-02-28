package pro_03;

import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;

public class ChattingClientThread extends Thread {
	ChattingClient cc= null;
	ChattingClient ccSvae= null;
	ChattingClientTab2 cct2=null;
	boolean cstRommChk;
	int rowCount=0;
	public ChattingClientThread(ChattingClient cc){
		this.cc = cc;
		this.ccSvae=cc;
	}
	//서버에서 밀한 내용을 듣기만 하는 곳입니다.
	public void run(){//start메소드를 호출 받고, 서버에서 받ㅇ
		String message = "";
		boolean isStop = false;
		int protocol =0;

		while(!isStop){
			try {
				message =(String)cc.ois.readObject();
			//message = 100|하하
			StringTokenizer st = null;
			if(message != null){
				st = new StringTokenizer(message,"|");
				protocol = Integer.parseInt(st.nextToken());//100이 썰리겟다
			}
			switch(protocol){
			case Protocol.ROOM_IN:{
				//insert here - 대화명 가져오기	
				String nickName = st.nextToken();
				boolean	maxFull= Boolean.valueOf(st.nextToken()).booleanValue();
				if(!maxFull){
					this.cc.initDisplay();
					Vector<String> v_name = new Vector<String>();
					v_name.add(nickName);
					this.cc.tab1.dtm_room.addRow(v_name);
					this.cc.tab1.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
						public void adjustmentValueChanged(AdjustmentEvent e) {
							JScrollBar src = (JScrollBar) e.getSource();
							src.setValue(src.getMaximum());
						}     
					});	
				//화면에 하하님이 입장하였습니다. 출력하기
					this.cc.jta_display.append("#####"+nickName+"님이 입장하였습니다.#####\n");
					this.cc.jta_display.setCaretPosition(cc.jta_display.getDocument().getLength());
				}else{
					JOptionPane.showMessageDialog(this.cc, "이미 인원이 다 찼습니다..", "Error", JOptionPane.ERROR_MESSAGE);
				}
				//화면에 하하님이 입장하였습니다. 출력하기
			}break;
			case Protocol.MESSAGE:{
				 String nickName = st.nextToken();
			     String msg = st.nextToken();
			     cc.jta_display.append(nickName+" : "+msg+"\n");
			     cc.jta_display.setCaretPosition(cc.jta_display.getDocument().getLength());
			}break;
			case Protocol.WHISPER:{
			       String nickName = st.nextToken();
			       String otherName =st.nextToken();
			       String msg1 = st.nextToken();
			       
			       cc.jta_display.append(nickName+"님이 "+otherName+"님에게 "+msg1+"\n");
			}break;
			case Protocol.CHANGE:{}break;
			case Protocol.ROOM_OUT:{
				String nickName = st.nextToken();
				this.cc.jta_display.append("#####"+nickName+"님이 퇴장하였습니다.#####\n");
				this.cc.jta_display.setCaretPosition(cc.jta_display.getDocument().getLength());
				if(nickName.equals(cc.nickName)){
					this.cc.getContentPane().removeAll();
					this.cc.remove(this.cc.jp_first);
					this.cc.remove(this.cc.jp_tabPanel);
					this.cc.room_list_panel.remove(this.cc.jbtn_room_make);
					this.cc.room_list_panel.remove(this.cc.jbtn_room_in);
					this.cc.test_panel2.removeAll();
					this.cc.jsp_display.remove(this.cc.jta_display);
					this.cc.jp_first.remove(this.cc.jsp_display);
					this.cc.room_list_panel.removeAll();
					this.cc.mainPage(nickName);
				}else{
					Vector<String> nickNameList = new Vector<String>();
					nickNameList.add(nickName);
					for(int i=0; i<this.cc.tab1.jt_room.getRowCount();i++){
						if(this.cc.tab1.jt_room.getValueAt(i, 0).equals(nickName)){
							this.cc.tab1.dtm_room.removeRow(i);
						}
					}
				}
			}break;
			case Protocol.CLOSE:{}break;
			case Protocol.ROOM_MASTER:{}break;
			case Protocol.ROOM_MAKE:{
				String title =st.nextToken();
				String np = st.nextToken();
				String max =st.nextToken();
				Vector<String> nickNameList = new Vector<String>();
				Vector<String> roomList = new Vector<String>();
				nickNameList.add(this.cc.nickName);
				roomList.add(title+"  |  "+np+" / "+max);
				this.cc.initDisplay();
				this.cc.tab1.dtm_room.addRow(nickNameList);
				this.cc.jta_display.append("#####"+this.cc.nickName+"님이 입장하였습니다.#####\n");
				this.cc.tab1.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			        public void adjustmentValueChanged(AdjustmentEvent e) {
			            JScrollBar src = (JScrollBar) e.getSource();
			            src.setValue(src.getMaximum());
			        }     
			    });
				this.cc.jta_display.setCaretPosition(cc.jta_display.getDocument().getLength());
				//화면에 하하님이 입장하였습니다. 출력하기
				}break;
			case Protocol.ROOM_LIST:{
				int size =Integer.parseInt(st.nextToken());
				if(this.cc.data==null){
					this.cc.data =new String[size][2];
				}
				String title =st.nextToken();
				String np = st.nextToken();
				String max =st.nextToken();
				if(size>this.rowCount){
					this.cc.data[rowCount][0]=title;
					this.cc.data[rowCount][1]=np+" / "+max;
					String roomInfo=this.cc.data[rowCount][0]+" | "+this.cc.data[rowCount][1];
					if(this.cc.tab2!=null){
						Vector<String> roomList = new Vector<String>();
						roomList.add(roomInfo);
						this.cc.tab2.dtm_room.addRow(roomList);
					}
					this.rowCount++;
				}
				if(size==this.rowCount){
					this.rowCount=0;
				}
				/*
				this.cc.jsp_roomList.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			        	public void adjustmentValueChanged(AdjustmentEvent e) {
			        		JScrollBar src = (JScrollBar) e.getSource();
			        		src.setValue(src.getMaximum());
			        		}     
						});*/
					}break;
			case Protocol.ROOM_CHANGE:{
				int  roomListSize =Integer.parseInt(st.nextToken());
				if(!this.cstRommChk){
					this.cc.tab2.dtm_room.setRowCount(0);
					this.cstRommChk=true;
				}
				if(this.cstRommChk){
					String title =st.nextToken();
					String np = st.nextToken();
					String max =st.nextToken();
					Vector<String> nickNameList = new Vector<String>();
					Vector<String> roomList = new Vector<String>();
					nickNameList.add(this.cc.nickName);
					roomList.add(title+"  |  "+np+"/"+max);
					this.cc.tab2.dtm_room.addRow(roomList);
				}
				if(roomListSize== this.cc.tab2.dtm_room.getRowCount()){
					this.cstRommChk=false;
				}
				
			}break;
				}
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
