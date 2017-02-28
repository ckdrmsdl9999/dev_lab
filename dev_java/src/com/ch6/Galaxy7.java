package com.ch6;
/*****************************************************************************************
 * 값을 호출하는 방법
 * 1)call by value(원시타입) - 복사본
 * 2)pass by value(참조타입) - 원본
 * 생성자를 호출하는 방법
 * new Galaxy7();
 * new Galaxy7(true);
 * new Galaxy7(true,false);
 * new Galaxy7(true,false,"골드");
 ****************************************************************************************/
public class Galaxy7 {
	boolean power;//false
	boolean wifi;//false
	String color;//null
	//생성자도 non-static영역이므로 내안에 있는 변수
	//혹은 메소드를 객체생성없이 직접 호출할 수 있다.
	public Galaxy7(){//디폴트 생성자에서 전역변수에 대한 초기화 
		//생성자 호출
		System.out.println("생성자 호출 성공");
		power = false;
		wifi = false;
		color = "흰색";
		isOnOff();
	}
	public Galaxy7(boolean power){
		//power = true;
		this.power = power;
	}
	public Galaxy7(boolean power, boolean wifi){
		
	}
	public Galaxy7(boolean power, boolean wifi, String color){
		
	}
	public boolean isOnOff(){
		System.out.println("isOnOff 호출 성공");
		if(power) power = false;
		else power = true;
		return power;
	}
	public boolean isWifi(){
		if(wifi) wifi = false;
		else wifi = true;
		return wifi;
	}
	//메소드 오버라이딩.
	public String toString(){
		String name = "나는 갤러시7 입니다.";
		return name;
	}
}
