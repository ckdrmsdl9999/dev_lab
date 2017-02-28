package com.ch7;

public class Lion extends Mammal {
	public Lion(){
		super(2,4);
		System.out.println("Lion디폴트 생성자 호출 성공");
	}
	public Lion(int eyes, int legs){
		//super(eyes,legs);
		System.out.println("Lion eyes, legs를 갖는 생성자 호출 성공");
		this.eyes = eyes;
		this.legs = legs;
	}
	@Override
	public void display() {
		System.out.println("나는 사자 입니다.");
	}
	@Override
	public void show() {
		System.out.println("나는 120m거리까지 볼 수 있다.");
	}
	@Override
	public void go() {
		System.out.println("나는 1시간에 1.4km를 걸을 수 있다.");
	}

}
