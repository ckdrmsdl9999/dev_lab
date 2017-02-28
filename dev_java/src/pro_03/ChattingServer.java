package pro_03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectStreamConstants;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChattingServer extends JFrame implements ActionListener, Runnable{
	ServerSocket server =null;
	Socket client =null;
	List<Room> chatList  =null;
	ChattingServerThread csThread=null;
	JTextArea jta_display =new JTextArea();
	JScrollPane jsp_display = new JScrollPane(jta_display, 
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	HashMap<String, Object[]> map;
	public ChattingServer(){
		initDisplay();
		   chatList =
				new Vector<Room>();
		 map = new HashMap<String , Object[]>();	
		boolean isStop = false;
		try{
			server = new ServerSocket(3000);
			while(!isStop){
				client = server.accept();
				jta_display.append(client.toString()+"\n");                
				csThread =
						new ChattingServerThread(this);
				csThread.start();
			}	
		}catch(Exception e){
		}
	}

	public void initDisplay(){
		this.add("Center",jsp_display);
		this.setTitle("로그 출력창-서버측");
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	public synchronized  int test(){
		return 0;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	} 
	
	public static void main(String args[] ){
		ChattingServer cs =new	ChattingServer();
		new Thread(cs).start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
	
}
