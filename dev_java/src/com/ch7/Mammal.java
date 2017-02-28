package com.ch7;
/*****************************************************************************************
 * 학습목표
 * 1.추상 클래스의 필요성에 대해 말할 수 있다.
 * 2.추상 클래스를 구현할 수 있다.(코딩규칙)
 * 3.다형성을 코드에 적용할 수 있다.
 * :선언부와 생성부의 클래스가 다를 때 생성부에 오는 클래스 타입에 따라
 *  똑같은 메소드를 호출하더라도 클래스마다 다르게 동작한다.
 * 복습
 * this, super, super(), this(), super(2,4), this(2,4)
 *
 ****************************************************************************************/
public abstract class Mammal {
	int eyes;
	int legs;
	int speed;
	//질문:추상클래스는 단독으로 인스턴스화 할 수 없다고 한다.
	//그렇다면 추상클래스의 생성자는 언제 호출 되지?
	//구현체 클래스의 생성자 호출될 때 먼저 호출 된다.
	//이것으로 알 수 있는 것
	//부모생성자가 먼저 호출 되므로 오버라이딩 규칙을 준수했는지 
	//문법적인 체크가 가능하지 않을까?
	public Mammal(){//추상클래스도 생성자 가질 수 있다.
		System.out.println("Mammal 디폴트 생성자 호출");
	}
	public Mammal(int eyes, int legs){//파라미터를 갖는 생성자
		System.out.println("Mammal 파라미터 생성자 호출");
		this.eyes = eyes;
		this.legs = legs;
	}
	//사자나 호랑이의 외모구현하기
	public abstract void display();//추상메소드
	//사자나 호랑이의 시각구현
	public abstract void show();//추상메소드
	//사자나 호랑이의 걷기구현
	public abstract void go();//추상메소드
	//사자나 호랑이의 정지기능 구현
	public void stop(){//일반메소드
		speed -=1;//speed = speed-1;
		if(speed>0) speed = 0;
	}
}
