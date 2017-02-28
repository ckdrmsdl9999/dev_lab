package com.ch5;

public class PrideSimulation {
	void prideInfo(Pride pride){
		System.out.println(pride.speed+" , "+pride.carName+" , "+pride.wheelNum);
	}
	//Pride클래스 타입의 배열 선언하기.
	void prideInfoList(Pride cars[]){
		for(int i=0;i<cars.length;i++){
			Pride meCar = cars[i];
			System.out.println(meCar.speed+" , "+meCar.carName+" , "+meCar.wheelNum);
		}
	}
	public static void main(String[] args) {
		Pride myCar = new Pride();
		myCar.speed = 100;
		myCar.carName = "프라이드 2015년형";
		myCar.wheelNum = 4;
		Pride herCar = new Pride();
		herCar.speed = 120;
		herCar.carName = "프라이드 2016년형";
		herCar.wheelNum = 5;
		Pride himCar = new Pride();
		himCar.speed = 140;
		himCar.carName = "프라이드 2017년형";
		himCar.wheelNum = 6;
		//insert here - prideInfo메소드를 호출하여 
		//speed 120, carName 프라이드 2016년형, wheelNum 5를 출력하시오.
		PrideSimulation ps = new PrideSimulation();
		ps.prideInfo(herCar);
		ps.prideInfo(myCar);
		ps.prideInfo(himCar);
		Pride cars[] = new Pride[3];
		cars[0] = herCar;
		cars[1] = myCar;
		cars[2] = himCar;
		ps.prideInfoList(cars);
	}

}









