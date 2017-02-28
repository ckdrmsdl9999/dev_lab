package com.ch7;

public class MammalTest {

	public static void main(String[] args) {
//		Mammal myMam = new Mammal();에러
//heap메모리영역에 로딩한다.(필드나 메소드 누릴 수 있다.)
//생성자가 호출 된다.(생성자안에서는 인스턴스화 없이 호출가능)		
		Mammal myMam1 = new Tiger();//super();
		Mammal myMam2 = new Lion();//super(2,4);
		myMam1.show();
		myMam2.show();
		System.out.println("===============[다형성 확인 끝]=============");
		//insert here - 멤버변수 출력하기
		System.out.println("myMam1.eyes:"+myMam1.eyes);//0
		System.out.println("myMam1.speed:"+myMam1.speed);//0
		myMam2.speed = 10;
		myMam2.stop();
		System.out.println("myMam2.speed:"+myMam2.speed);//0
		//Mammal생성자를 호출해보세요.
	}

}
