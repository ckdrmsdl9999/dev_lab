package com.base;
/***********************************************
 * 변수의 선언방법을 알고 있다.
 * 타입 변수명 =(대입연산자:==)값;
 * 내일 이야기할 주제 : 변수의 종류(전역변수,지역변수), 변수의 타입
 * 변수명은 예약어를 사용할 수 없다.
 * int class = 10;
 * int int  =  100;
 * 변수명은 숫자로 시작할 수 없다.
 * 특수문자는 _와 $사용가능하다.
 * 변수의 사용방법
 * :타입을 사용할 필요는 없다.
 * :직접 값을 사용하지 않는다.-변수명을 사용한다.
 * 변수의 사용 목적에 대해 말할 수 있다.
 * 재사용할 수 있다.
 * 주소번지보다 기억하기 쉽다.
 * 일괄처리할 수 있다.
 * :하나만 변경하더라도 전체를 다 변경가능하다.
 * 변수가 갖는 장애
 * :한번에 하나만 담을 수 있다. 
 * :같은 타입만 담을 수 있다.
 * ->동시에 두 가지값 유지 불가하다.
 * 변수의 장애를 해결하는 방법 - 배열
 ***********************************************/
public class HelloWorld {
	//선언부
	//정수타입을 담을 수 있는 공간을 할당해 주세요.
	//공간-메모리공간(주소번지:229540번지)-기억어렵다.
	//숫자이므로 기억이 어렵고 직관적이지 않다.
	//숫자 대신 변수명을 사용하기로 한다.
	static int x = 10;
	//insert here - 변수 y를 선언하시오.
	static int y = 20;
	//생성자
	
	//사용자 정의 추가 메소드 구현
	void go(){//사용자 정의 메소드
		System.out.println("go메소드 호출 성공");
	}
	//메인 메소드 선언 및 구현-exe파일로 만들 수 있다.
	//실행할 수 있다.
	public static void main(String[] args) {
		System.out.println("Hello World!!!");
		System.out.println(10);//상수취급을 받는다.
		System.out.println(10);
		System.out.println(10);
		System.out.println(10);
		x = 30;
		//insert here - 변수 x 사용하기
		System.out.println(x);//10->30
		System.out.println(y);//20
		System.out.println(x+y);//30->50
		//insert here - 두 수의 곱을 계산한 결과를 출력
		System.out.println(x*y);//600
	}
}



