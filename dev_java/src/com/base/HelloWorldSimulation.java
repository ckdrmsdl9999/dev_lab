package com.base;
/***********************************************
 * �� �ڹٿ��� �ϴ°�?
 * ���뼺�� �̽ļ�
 * �н���ǥ
 * HelloWorld��ü���� ������ ������ 
 * HelloWorldSimulation���� ����� �� �ִ�.
 * Ȯ���� ����
 * ������ Ÿ���� ��� ������ Ÿ�԰� �޸� ȣ�� ���� ��
 * �ּҹ����� ����ϰ� �ȴ�.
 * ��������:
 * HelloWorld.java���� ������ ���� x����ϱ�
 * ->��°�� : x = 10;
 *
 **********************************************/
public class HelloWorldSimulation {
	public static void main(String[] args) {
		System.out.println("x=10");
		//insert here
		int x = 100;
		System.out.println("x="+x);//10
		System.out.println(10+20);//30
		System.out.println(10+""+20);//1020
		//insert here
		//���� hw�� HelloWorldŬ���� Ÿ���̴�.
		//Ŭ���� Ÿ�Ժ��� hw�� ȣ���ϸ� �ּҹ����� ���
		//���� x�� intŸ���̴�.
		//����Ÿ�� ���� x�� ȣ���ϸ� ���� ���
		HelloWorld hw = new HelloWorld();
		//@1db9742
		System.out.println("�ּҹ���:����������"+hw);
		//insert here-HelloWorld����� ���� x �����ϱ�
		System.out.println("x ����="+x);//100
		System.out.println("hw.x ����="+hw.x);//10
		hw.go();
	}
}










