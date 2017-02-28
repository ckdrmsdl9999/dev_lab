package com.design;

public class DuckSimulation {

	public static void main(String[] args) {
		//MallardDuck md = new MallardDuck();//�������� ���� �� ����.
		Duck mdDuck = new MallardDuck();//�������-���յ��� �������� �ڵ� ���� �� �ִ�.
		mdDuck.performFly();
		mdDuck = new WoodDuck();
		mdDuck.performFly();
		mdDuck = new RubberDuck();
		mdDuck.performFly();
	}

}
