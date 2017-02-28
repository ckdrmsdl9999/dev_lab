package com.design;

public class DuckSimulation {

	public static void main(String[] args) {
		//MallardDuck md = new MallardDuck();//다형성을 누릴 수 없다.
		Duck mdDuck = new MallardDuck();//권장사항-결합도가 낮아지는 코드 만들 수 있다.
		mdDuck.performFly();
		mdDuck = new WoodDuck();
		mdDuck.performFly();
		mdDuck = new RubberDuck();
		mdDuck.performFly();
	}

}
