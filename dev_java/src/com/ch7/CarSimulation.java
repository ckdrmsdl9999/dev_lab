package com.ch7;

public class CarSimulation {

	public static void main(String[] args) {
		Car myCar = new Sonata();//권장사항 - 다형성누릴 수 있다.
		//단독으로는 인스턴스화 할 수 없다.
		//추상클래스는 반드시 구현체 클래스를 가져야 한다.
//		Car himCar = new Car();불법이다.
		//Sonata herCar = new Sonata();
		myCar.stop();
		//herCar.stop();
		//아래코드에서 myCar대신 super를 사용할 수 없다.
		System.out.println(myCar.speed);//부모클래스변수호출
		System.out.println(myCar.wheelNum);//부모클래스변수호출
//		System.out.println(myCar.carColor);
//		System.out.println(herCar.carColor);
		//myCar = herCar;
		//herCar = myCar;
		//System.out.println(myCar.meCar.carColor);
	}

}




