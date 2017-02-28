package com.ch5;
//
public class ThisTest {
	int a;
	void methodA(){
		this.a = 200;
		System.out.println(a);//0-> 100 -> 200
	}
	public static void main(String[] args) {
		//수정자 This는 자신 자신을 가리키는 예약어입니다.
		ThisTest tt = new ThisTest();
		tt.a = 100;
//		this.a = 100;
		tt.methodA();
	}

}
