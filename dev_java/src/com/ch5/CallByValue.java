package com.ch5;
class Sonata{
	int speed;
}
public class CallByValue {
	Sonata himCar = new Sonata();
	void methodA(Sonata myCar){
		//insert here - speed는 얼마?
		System.out.println(myCar.speed);//100
		//System.out.println(this.speed);//100
		System.out.println(himCar.speed);//0
		methodB(myCar);
	}
	void methodB(Sonata himCar){
		//myCar를 사용하고 싶어요?
		//insert here - speed에 100 출력되도록 해보시오.
		//myCar , herCar, himCar(0)
	    System.out.println(himCar.speed);//0
	}
	//12-13(CallByValue)-14(Sonata)-15(전역변수speed 0->100)-16(메소드호출-파라미터로 주소번지)
	public static void main(String[] args) {
		CallByValue cv = new CallByValue();
		Sonata herCar = new Sonata();
		herCar.speed = 100;
		cv.methodA(herCar);
	}

}
