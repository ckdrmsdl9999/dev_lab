package com.ch5;

public class ArrayParameter {
	void methodA(int fir, int sec, int thir){
		System.out.println(fir);
		System.out.println(sec);
		System.out.println(thir);
	}
	//파라미터에 사용된 is배열이름은 파라미터에 선언되었으므로 지역변수의 성격을 갖는다.
	//따라서 main메소드에서는 사용할 수 없다.
	void methodB(int[] is){
		for(int i=0;i<is.length;i++){
			System.out.println(is[i]);
		}
	}
	public static void main(String[] args) {
		//insert here - methodA 호출 하기, methodB 호출하기
		ArrayParameter ap = new ArrayParameter();
		ap.methodA(10, 100, 1000);
		//is배열을 선언하고 생성해 보세요.
		int is[] = new int[3];
		is[0] = 5;
		is[1] = 15;
		is[2] = 25;
		ap.methodB(is);
	}

}
