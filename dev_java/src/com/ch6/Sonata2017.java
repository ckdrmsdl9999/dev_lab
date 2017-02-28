package com.ch6;
/***************************************************************
 * 1.생성자를 구현할 수 있나요?
 * 2.적당한 생성자를 선택할 수 있나요?
 * 정리
 * 디폴트 생성자는 JVM에서 제공된다.
 * 파라미터가 있는 생성자는 제공받을 수 없다.
 * 파라미터를 갖는 생성자가 한 개라도 존재하면 디폴트 생성자는
 * 제공되지 않습니다.
 **************************************************************/
public class Sonata2017 {
	String carColor = null;
	int wheelNum = 0;
	int speed = 0;
	static int door = 0;
	public Sonata2017(){
		door = 4;
	}
	public Sonata2017(int wheelNum, int speed, String carColor){
		this.carColor = carColor;
		this.wheelNum = wheelNum;
		this.speed = speed;
	}	
	public Sonata2017(int speed, String carColor){
		this.carColor = carColor;
		this.speed = speed;
	}	
}
