package com.base;
/***********************************************
 * 꼭 자바여야 하는가?
 * 재사용성과 이식성
 * 학습목표
 * HelloWorld객체에서 선언한 변수를 
 * HelloWorldSimulation에서 사용할 수 있다.
 * 확인할 내용
 * 참조형 타입의 경우 원시형 타입과 달리 호출 했을 때
 * 주소번지를 출력하게 된다.
 * 도전과제:
 * HelloWorld.java에서 선언한 변수 x사용하기
 * ->출력결과 : x = 10;
 *
 **********************************************/
public class HelloWorldSimulation {
	public static void main(String[] args) {
		System.out.println("x=10");
		//insert here
		int x = 100;
		System.out.println("x="+x);//10
		System.out.println(10+20);//30
		System.out.println(10+""+20);//1020
		//insert here
		//변수 hw는 HelloWorld클래스 타입이다.
		//클래스 타입변수 hw는 호출하면 주소번지를 출력
		//변수 x는 int타입이다.
		//원시타입 변수 x는 호출하면 값을 출력
		HelloWorld hw = new HelloWorld();
		//@1db9742
		System.out.println("주소번지:참조형변수"+hw);
		//insert here-HelloWorld선언된 변수 x 참조하기
		System.out.println("x 변수="+x);//100
		System.out.println("hw.x 변수="+hw.x);//10
		hw.go();
	}
}










