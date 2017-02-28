package com.ch2;
/***********************************************
 * 변수를 선언할 수 있다. 어디에?
 * 메인메소드는 entry point이다. - 메인쓰레드라고 말할 수 있다.
 * 메인메소드는 반드시
 * public:접근제한자 
 * static:정적이다. 공유된다.
 * 변수앞에 쓸 수 있다.
 * 메소드앞에 쓸 수 있다.
 * 객체 생성(HelloWorld hw = new HelloWorld();)
 * 없이 사용할 수 있다.
 * void : 리턴값이 없다. 반환값이 없다.
 * 메소드 이름이 main이다.
 * 메소드의 종류 - 사용자 정의 메소드, 제공되는 메소드
 * String[] args - 배열이다.
 * 배열은 참조형 변수이다.-호출하면 주소번지가 출력된다(16진수)
 **********************************************/
public class VariableTest2 {
	static void go(int x){
		x=2;
		System.out.println(x);//2
	}
	static void go(double x){
		System.out.println(x);
	}
	public static void main(String[] args) {
		int x = 1;//1
		int y = x;//1
		int z;//지역변수
		z = 5;
		y = y + z;
		System.out.println(z);
		VariableTest2.go(10);
		go(10.5);
		System.out.println(args);
		System.out.println("args[0]:"+args[0]);
		System.out.println("args[1]:"+args[1]);
		go(Integer.parseInt(args[0]));
	}

}
