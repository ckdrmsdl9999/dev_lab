package com.design;

public class MallardDuck extends Duck {
	//insert here
	public MallardDuck(){
	//������ �ʱ�ȭ �� ���ΰ�? �Ǵ� ������ ������ ���ΰ�?
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}
	@Override
	public void display() {
		System.out.println("���� û�տ����Դϴ�.");
	}

}
