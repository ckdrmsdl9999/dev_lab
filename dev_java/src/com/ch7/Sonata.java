package com.ch7;

import java.io.IOException;

/****************************************************************
 * 자바에서는 같은 이름의 메소드를 중복정의할 수 있다.
 * 1)메소드 오버로딩
 * :반드시 같은 이름 일 때
 * 2)메소드 오버라이딩 
 * :반드시 같은 이름이고 그리고 서로 상속관계에 있어야 한다.
 * 
 ***************************************************************/
public class Sonata extends Car implements Volume{
	String carColor = null;
	public int speed = 10;
	public Sonata(){
		//this();
		//this(5);
		super(15);
		System.out.println(speed+", "+this.speed+", "+super.speed);
		//this();
//		super();//super수정자를 이용해서 생성자 호출할 때 코드 맨 앞에 와야 한다.
		System.out.println("Sonata : "+this.speed);//Sonata의 speed출력
		System.out.println("Car : "+super.speed);//Car의 speed출력
	}
	public Sonata(int speed){
		this.speed = speed;//기억:지역변수에 넘어온 값을 전역변수에 치환하기
	}
	@Override
	public String toString(){
		return "나는 소나타입니다.";
	}
	@Override
	//protected void come(){}더 좁은 접근제한자는 불가
	public void come(){}
	public void come(int i){
		
	}
	@Override
	public void stop() {
		speed = 0;
	}
	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void volumeDown() throws NullPointerException, Exception {
		// TODO Auto-generated method stub
		
	}
}
