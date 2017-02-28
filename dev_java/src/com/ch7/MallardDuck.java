package com.ch7;

public class MallardDuck extends Duck {
	public MallardDuck(){
		
	}
	public MallardDuck(int eye, int leg){
		this.eye = eye;
		this.leg = leg;
	}
	@Override
	public void display() {
		System.out.println("나는 청둥오리입니다.");
	}
	public String display2() {
		//System.out.println("나는 청둥오리입니다.");
		return "나는 청둥오리입니다.";
	}
}
