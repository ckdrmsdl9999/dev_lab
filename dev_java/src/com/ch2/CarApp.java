package com.ch2;
/**********************************************
 * �ڹ� API �䳻����
 * @author kosmo000
 *
 *********************************************/
public class CarApp {
	void test(){
		//insert here - parseInt()������ ����
//		double d=Double.parseDouble("10");
//		Ÿ�� i = Ÿ��.parseInt(��);
		int i = Integer.parseInt("100");
//		int i1 = Integer.parseInt("�ȳ�");
		//Integer.parseInt("�ȳ�");
//		int i2 = Integer.parseInt(3.14);
//		int i3 = Integer.parseInt("hello");
		//Integer.parseInt("hello");
//		int i4 = Integer.parseInt("-10");
		//Integer.parseInt("-10");
		System.out.println("���� i:"+i);//100
/*		System.out.println("���� i1:"+i1);//����->����
		System.out.println("���� i3:"+i3);
		System.out.println("���� i4:"+i4);*/
	}
	public static void main(String[] args) {
		//test�޼ҵ� ȣ���ϱ�
		/*
		 * ����(CarApp)�� �����Ǿ� �ִ��ϴ���
		 * non-static�޼ҵ�� static����(main)����
		 * ���� ȣ���� �Ұ��ϴ�.
		 * �ذ���
		 * ��ü�� ������ �� �ּҹ����� �̿��ϸ� ȣ�Ⱑ��
		 * carApp.test();
		 */
		CarApp carApp = new CarApp();
		carApp.test();
		Sonata myCar = new Sonata();
		double d=Double.parseDouble("10");
		Sonata.speedDown();
		System.out.println(d+20);//30.0
		myCar.speedUp();
	}

}
