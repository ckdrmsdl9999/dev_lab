package com.ch7;

public class Lion extends Mammal {
	public Lion(){
		super(2,4);
		System.out.println("Lion����Ʈ ������ ȣ�� ����");
	}
	public Lion(int eyes, int legs){
		//super(eyes,legs);
		System.out.println("Lion eyes, legs�� ���� ������ ȣ�� ����");
		this.eyes = eyes;
		this.legs = legs;
	}
	@Override
	public void display() {
		System.out.println("���� ���� �Դϴ�.");
	}
	@Override
	public void show() {
		System.out.println("���� 120m�Ÿ����� �� �� �ִ�.");
	}
	@Override
	public void go() {
		System.out.println("���� 1�ð��� 1.4km�� ���� �� �ִ�.");
	}

}
