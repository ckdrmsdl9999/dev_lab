package MemberArray;

import com.vo.MemberVO;

public class MemberArray {
	MemberVO[] mvos = new MemberVO[3];
	Object objs[][] = new Object[5][3];
	public void memberVOInit(){
		MemberVO mvo = new MemberVO();
		mvo.setNo(1);
		mvo.setMem_id("test");
		mvo.setMem_name("ÀÌ¼ø½Å");
		mvo.setMem_pw("123");
		mvo.setMem_tel("02-355-1456");
		mvos[0] = mvo;
		mvo = new MemberVO();
		mvo.setNo(2);
		mvo.setMem_id("haha");
		mvo.setMem_name("±èÀ¯½Å");
		mvo.setMem_pw("456");
		mvo.setMem_tel("02-455-1456");
		mvos[1] = mvo;
		mvo = new MemberVO();
		mvo.setNo(2);
		mvo.setMem_id("apple");
		mvo.setMem_name("È«±æµ¿");
		mvo.setMem_pw("789");
		mvo.setMem_tel("02-655-1456");
		mvos[2] = mvo;
	}
	public void objectArray(){
		objs[0] = new Integer[]{1,2,3};
		objs[1] = new String[]{"test","haha","apple"};
		objs[2] = new String[]{"±èÀ¯½Å","ÀÌ¼ø½Å","È«±æµ¿"};
		objs[3] = new String[]{"123","456","789"};
		objs[4] = new String[]{"02-355-1456","02-455-1456","02-655-1456"};		
	}
	public static void main(String[] args) {
		MemberArray ma = new MemberArray();
		ma.memberVOInit();
		for(MemberVO mvo:ma.mvos){
			System.out.println(mvo.getNo()+", "
					          +mvo.getMem_id()+", "
					          +mvo.getMem_name()+", "
					          +mvo.getMem_pw()+", "
					          +mvo.getMem_tel());
		}
		System.out.println("==================================");
		ma.objectArray();
		for(int i=0;i<ma.objs[0].length;i++){
			for(int j=0;j<ma.objs.length;j++){
				System.out.print(ma.objs[j][i]+", ");				
			}
			System.out.println();
		}
	}////////////////end of main
}////////////////////end of MemberArray






