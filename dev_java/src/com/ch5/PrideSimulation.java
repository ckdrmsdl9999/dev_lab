package com.ch5;

public class PrideSimulation {
	void prideInfo(Pride pride){
		System.out.println(pride.speed+" , "+pride.carName+" , "+pride.wheelNum);
	}
	//PrideŬ���� Ÿ���� �迭 �����ϱ�.
	void prideInfoList(Pride cars[]){
		for(int i=0;i<cars.length;i++){
			Pride meCar = cars[i];
			System.out.println(meCar.speed+" , "+meCar.carName+" , "+meCar.wheelNum);
		}
	}
	public static void main(String[] args) {
		Pride myCar = new Pride();
		myCar.speed = 100;
		myCar.carName = "�����̵� 2015����";
		myCar.wheelNum = 4;
		Pride herCar = new Pride();
		herCar.speed = 120;
		herCar.carName = "�����̵� 2016����";
		herCar.wheelNum = 5;
		Pride himCar = new Pride();
		himCar.speed = 140;
		himCar.carName = "�����̵� 2017����";
		himCar.wheelNum = 6;
		//insert here - prideInfo�޼ҵ带 ȣ���Ͽ� 
		//speed 120, carName �����̵� 2016����, wheelNum 5�� ����Ͻÿ�.
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









