package com.ch5;
class Sonata{
	int speed;
}
public class CallByValue {
	Sonata himCar = new Sonata();
	void methodA(Sonata myCar){
		//insert here - speed�� ��?
		System.out.println(myCar.speed);//100
		//System.out.println(this.speed);//100
		System.out.println(himCar.speed);//0
		methodB(myCar);
	}
	void methodB(Sonata himCar){
		//myCar�� ����ϰ� �;��?
		//insert here - speed�� 100 ��µǵ��� �غ��ÿ�.
		//myCar , herCar, himCar(0)
	    System.out.println(himCar.speed);//0
	}
	//12-13(CallByValue)-14(Sonata)-15(��������speed 0->100)-16(�޼ҵ�ȣ��-�Ķ���ͷ� �ּҹ���)
	public static void main(String[] args) {
		CallByValue cv = new CallByValue();
		Sonata herCar = new Sonata();
		herCar.speed = 100;
		cv.methodA(herCar);
	}

}
