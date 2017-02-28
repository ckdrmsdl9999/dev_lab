package com.ch2;
/**********************************************
 * 자바 API 흉내내기
 * @author kosmo000
 *
 *********************************************/
public class CarApp {
	void test(){
		//insert here - parseInt()적용해 보기
//		double d=Double.parseDouble("10");
//		타입 i = 타입.parseInt(값);
		int i = Integer.parseInt("100");
//		int i1 = Integer.parseInt("안녕");
		//Integer.parseInt("안녕");
//		int i2 = Integer.parseInt(3.14);
//		int i3 = Integer.parseInt("hello");
		//Integer.parseInt("hello");
//		int i4 = Integer.parseInt("-10");
		//Integer.parseInt("-10");
		System.out.println("변수 i:"+i);//100
/*		System.out.println("변수 i1:"+i1);//에러->예외
		System.out.println("변수 i3:"+i3);
		System.out.println("변수 i4:"+i4);*/
	}
	public static void main(String[] args) {
		//test메소드 호출하기
		/*
		 * 내안(CarApp)에 구현되어 있다하더라도
		 * non-static메소드는 static영역(main)에서
		 * 직접 호출은 불가하다.
		 * 해결방법
		 * 객체를 생성한 후 주소번지를 이용하면 호출가능
		 * carApp.test();
		 */
		CarApp carApp = new CarApp();
		carApp.test();
		Sonata myCar = new Sonata();
		double d=Double.parseDouble("10");
		Sonata.speedDown();
		System.out.println(d+20);//30.0
		myCar.speedUp();
	}

}
