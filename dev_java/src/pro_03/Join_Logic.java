package pro_03;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Join_Logic {
	public Object oos;

	public Join_Logic(){
		try{		
			Socket socket = new Socket("192.168.0.46",3000);		
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		}catch(Exception e) {
		
		}
	}
}
