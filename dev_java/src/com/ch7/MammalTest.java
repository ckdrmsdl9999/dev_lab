package com.ch7;

public class MammalTest {

	public static void main(String[] args) {
//		Mammal myMam = new Mammal();����
//heap�޸𸮿����� �ε��Ѵ�.(�ʵ峪 �޼ҵ� ���� �� �ִ�.)
//�����ڰ� ȣ�� �ȴ�.(�����ھȿ����� �ν��Ͻ�ȭ ���� ȣ�Ⱑ��)		
		Mammal myMam1 = new Tiger();//super();
		Mammal myMam2 = new Lion();//super(2,4);
		myMam1.show();
		myMam2.show();
		System.out.println("===============[������ Ȯ�� ��]=============");
		//insert here - ������� ����ϱ�
		System.out.println("myMam1.eyes:"+myMam1.eyes);//0
		System.out.println("myMam1.speed:"+myMam1.speed);//0
		myMam2.speed = 10;
		myMam2.stop();
		System.out.println("myMam2.speed:"+myMam2.speed);//0
		//Mammal�����ڸ� ȣ���غ�����.
	}

}
