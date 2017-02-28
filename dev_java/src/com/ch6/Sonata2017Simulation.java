package com.ch6;

public class Sonata2017Simulation {

	public static void main(String[] args) {
		//new Sonata2017();
		Sonata2017 myCar = new Sonata2017(4,100,"ÆÄ¶û");
		Sonata2017 herCar = new Sonata2017(4,0,"»¡°­");
		Sonata2017 himCar = new Sonata2017(4,10,"°ËÁ¤");
//		Sonata2017.door = 4;
		himCar.door = 5;
		System.out.println(myCar.wheelNum+", "
		                  +herCar.wheelNum+", "
				          +himCar.wheelNum);
		Sonata2017 meCar = himCar;
		System.out.println("meCar.wheelNum:"+meCar.wheelNum);
		//insert here
		System.out.println(myCar.door+", "
                          +herCar.door+", "
		                  +himCar.door);		
	}

}
