package com.ch4;
class Sonata{
	int speed;
	String carName;
	int speedUp(){
		speed = speed + 1;
		return speed;
	}
}
public class SonataSimulation {

	public static void main(String[] args) {
		Sonata myCar = new Sonata();
		System.out.println("myCar.speed : "+myCar.speed);
		myCar = new Sonata();
		myCar.speedUp();
		System.out.println("herCar.speed : "+myCar.speed);
	}

}
