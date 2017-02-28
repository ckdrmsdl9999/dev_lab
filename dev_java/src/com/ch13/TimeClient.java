package com.ch13;

import java.io.ObjectInputStream;
import java.net.Socket;

public class TimeClient extends Thread {
	public void run(){
		//타임서버에 접속할 소켓
		Socket socket = null;
		//타임서버에서 전송하는 시간 정보 읽어오기
		ObjectInputStream ois = null;
		//서버로 부터 들은 시간 정보를 담을 변수
		String s_time = null;
		try {
			socket = new Socket("127.0.0.1",2008);
			ois = new ObjectInputStream(socket.getInputStream());
			while((s_time=(String)ois.readObject())!=null){
				System.out.println(s_time);
				try {
					sleep(1000);
				} catch (InterruptedException ie) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			System.out.println("타임 서버에 접속할 수 없습니다.");
		}
		
	}
	public static void main(String[] args) {
		TimeClient tc = new TimeClient();
		tc.start();
	}

}
