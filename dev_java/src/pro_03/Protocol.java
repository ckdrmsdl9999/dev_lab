package pro_03;

public class Protocol {
//대화방 입장	
	public final static int ROOM_IN  = 100;//접근제한자 모두함께 쓰고싶어요 public 상수넣을거에요 final 
//일반 대화
	public final static int MESSAGE  = 200;
//귓속말
	public final static int WHISPER  = 250;
//대화명 변경
	public final static int CHANGE   = 300;
//대화방 나가기	
	public final static int ROOM_OUT = 400;
//종료	
	public final static int CLOSE 	 = 500;
	//추가 내용
	public final static int ROOM_MASTER 	 = 600;
	public final static int ROOM_MAKE	 = 700;
	public final static int ROOM_LIST	 = 800;
	public final static int ROOM_CHANGE	 = 900;
}
