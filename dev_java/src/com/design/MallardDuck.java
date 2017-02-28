package com.design;

public class MallardDuck extends Duck {
	//insert here
	public MallardDuck(){
	//무엇을 초기화 할 것인가? 또는 무엇을 결정할 것인가?
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}
	@Override
	public void display() {
		System.out.println("나는 청둥오리입니다.");
	}

}
