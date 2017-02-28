package com.design;

public abstract class Duck {
	FlyBehavior flyBehavior = null;
	QuackBehavior quackBehavior = null;
	public abstract void display();
	public void performFly(){
		flyBehavior.fly();
	}
	public void performQuack(){
		quackBehavior.quack();
	}
	public void swimming(){
		System.out.println
		("모든 오리는 물에 뜹니다. 가짜 오리도 물에 뜨죠.");
	}
}
