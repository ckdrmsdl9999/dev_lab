package com.ch7;

public class CarSimulation {

	public static void main(String[] args) {
		Car myCar = new Sonata();//������� - ���������� �� �ִ�.
		//�ܵ����δ� �ν��Ͻ�ȭ �� �� ����.
		//�߻�Ŭ������ �ݵ�� ����ü Ŭ������ ������ �Ѵ�.
//		Car himCar = new Car();�ҹ��̴�.
		//Sonata herCar = new Sonata();
		myCar.stop();
		//herCar.stop();
		//�Ʒ��ڵ忡�� myCar��� super�� ����� �� ����.
		System.out.println(myCar.speed);//�θ�Ŭ��������ȣ��
		System.out.println(myCar.wheelNum);//�θ�Ŭ��������ȣ��
//		System.out.println(myCar.carColor);
//		System.out.println(herCar.carColor);
		//myCar = herCar;
		//herCar = myCar;
		//System.out.println(myCar.meCar.carColor);
	}

}




