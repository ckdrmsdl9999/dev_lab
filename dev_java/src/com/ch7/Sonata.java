package com.ch7;

import java.io.IOException;

/****************************************************************
 * �ڹٿ����� ���� �̸��� �޼ҵ带 �ߺ������� �� �ִ�.
 * 1)�޼ҵ� �����ε�
 * :�ݵ�� ���� �̸� �� ��
 * 2)�޼ҵ� �������̵� 
 * :�ݵ�� ���� �̸��̰� �׸��� ���� ��Ӱ��迡 �־�� �Ѵ�.
 * 
 ***************************************************************/
public class Sonata extends Car implements Volume{
	String carColor = null;
	public int speed = 10;
	public Sonata(){
		//this();
		//this(5);
		super(15);
		System.out.println(speed+", "+this.speed+", "+super.speed);
		//this();
//		super();//super�����ڸ� �̿��ؼ� ������ ȣ���� �� �ڵ� �� �տ� �;� �Ѵ�.
		System.out.println("Sonata : "+this.speed);//Sonata�� speed���
		System.out.println("Car : "+super.speed);//Car�� speed���
	}
	public Sonata(int speed){
		this.speed = speed;//���:���������� �Ѿ�� ���� ���������� ġȯ�ϱ�
	}
	@Override
	public String toString(){
		return "���� �ҳ�Ÿ�Դϴ�.";
	}
	@Override
	//protected void come(){}�� ���� ���������ڴ� �Ұ�
	public void come(){}
	public void come(int i){
		
	}
	@Override
	public void stop() {
		speed = 0;
	}
	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void volumeDown() throws NullPointerException, Exception {
		// TODO Auto-generated method stub
		
	}
}
