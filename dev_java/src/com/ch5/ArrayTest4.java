package com.ch5;

import java.util.StringTokenizer;

public class ArrayTest4 {
	String msg1 = "200#나신입#오늘 스터디 할까?";
	String msg2 = "200#나일등#저녁 8시쯤 어때";
	String msg3 = "200#달타냥#좋아요";
	String msg4 = "300#달타냥#엘사#우리 사귈까?";
	String msgs[] = new String[4];
	String tmsgs[][] = {
			{"200","나신입","오늘 스터디 할까?"}
		   ,{"200","나일등","저녁 8시쯤 어때"}
		   ,{"200","달타냥","좋아요"}
		   ,{"300","달타냥","엘사","우리 사귈까?"}
	};
	void tmsgsInit(){
		StringTokenizer st = null;
		for(int i=0;i<tmsgs.length;i++){
			for(int j=0;j<tmsgs[i].length;j++){
				st = new StringTokenizer(tmsgs[i][j],"#");
				String temp = st.nextToken();
				tmsgs[i][j] = temp;
			}
		}		
	}
	void tmsgsPrint(){//배열 tmsgs 출력해보기
		for(int i=0;i<tmsgs.length;i++){
			for(int j=0;j<tmsgs[i].length;j++){
				System.out.println(tmsgs[i][j]);
			}
		}
	}
	//위에 4개 메시지 배열에 초기화 해보기
	String[] msgInit(){
		msgs[0] = msg1;
		msgs[1] = msg2;
		msgs[2] = msg3;
		msgs[3] = msg4;
		return msgs;
	}
	//String 객체배열에 초기화된 값 출력해 보기
	void getMsgListPrint(){
		for(int i=0;i<msgs.length;i++){
			System.out.println(msgs[i]);
		}
	}
	//샘플
	String[] stringToArray(){
		StringTokenizer st = new StringTokenizer(msg1,"#");
		String msg1s[] = new String[st.countTokens()];
		String fir = st.nextToken();
		msg1s[0] = fir;
		String sec = st.nextToken();
		msg1s[1] = sec;
		String thi = st.nextToken();
		msg1s[2] = thi;
		return msg1s;
	}
	
	public static void main(String[] args) {
		ArrayTest4 at4 = new ArrayTest4();
		String temp[] = at4.stringToArray();
		for(String str:temp){
			System.out.println(str);
		}
/*		String str = "500|강감찬|우리 오늘 볼까?";
		StringTokenizer st = new StringTokenizer(str,"|");
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.countTokens());//3
*/	}

}
