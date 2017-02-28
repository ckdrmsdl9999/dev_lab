package com.ch5;

import java.util.StringTokenizer;

public class ArrayTest4 {
	String msg1 = "200#������#���� ���͵� �ұ�?";
	String msg2 = "200#���ϵ�#���� 8���� �";
	String msg3 = "200#��Ÿ��#���ƿ�";
	String msg4 = "300#��Ÿ��#����#�츮 ��б�?";
	String msgs[] = new String[4];
	String tmsgs[][] = {
			{"200","������","���� ���͵� �ұ�?"}
		   ,{"200","���ϵ�","���� 8���� �"}
		   ,{"200","��Ÿ��","���ƿ�"}
		   ,{"300","��Ÿ��","����","�츮 ��б�?"}
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
	void tmsgsPrint(){//�迭 tmsgs ����غ���
		for(int i=0;i<tmsgs.length;i++){
			for(int j=0;j<tmsgs[i].length;j++){
				System.out.println(tmsgs[i][j]);
			}
		}
	}
	//���� 4�� �޽��� �迭�� �ʱ�ȭ �غ���
	String[] msgInit(){
		msgs[0] = msg1;
		msgs[1] = msg2;
		msgs[2] = msg3;
		msgs[3] = msg4;
		return msgs;
	}
	//String ��ü�迭�� �ʱ�ȭ�� �� ����� ����
	void getMsgListPrint(){
		for(int i=0;i<msgs.length;i++){
			System.out.println(msgs[i]);
		}
	}
	//����
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
/*		String str = "500|������|�츮 ���� ����?";
		StringTokenizer st = new StringTokenizer(str,"|");
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.countTokens());//3
*/	}

}
