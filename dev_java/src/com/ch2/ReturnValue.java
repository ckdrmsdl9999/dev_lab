package com.ch2;
/***********************************************
 * 접근제한자 (static) 리턴타입 메소드이름(파라미터){}
 * 메소드 구현시 리턴타입을 결정해야 합니다.
 * 1) void 
 * 2) 원시타입 혹은 참조형 타입이 올 수 있다.
 **********************************************/
public class ReturnValue {
	static void go(){
		System.out.println("10");//10
	}
	static int come(){
		int x = 100;
		return x;
//		return 10;
	}
	public static void main(String[] args) {
		System.out.print(1);
		System.out.print(2);
		System.out.println(10);
		System.out.println(20);
		System.out.println("================");
		//메소드 호출하기
		//insert here - go();
		//결론:리턴타입이 void인 경우에는 변수에 
		//메소드의 처리 결과값을 받을 수 없다.
		int x = 5;
		go();
		//리턴타입이 void일 경우에는 호출결과로 
		//넘겨 받을 값이 없다.
		//x = go();
		//insert here - come();
		//결론:리턴타입이 int인 경우에는 변수에 
		//메소드의 처리 결과값을 받을 수 있다.
		x = come();
		System.out.println(x);//100
	}

}
