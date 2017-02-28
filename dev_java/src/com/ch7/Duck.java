package com.ch7;

import java.util.List;

/****************************************************************
 * 추상 클래스 선언하기
 * :단독으로 인스턴스화 할 수 없다.
 * :반드시 구현체 클래스를 가져야 한다.
 * 일반변수 가질 수 있다.
 * 일반메소드 가질 수 있다.
 * 추상메소드 가질 수 있다.
 ***************************************************************/
public abstract class Duck {
	int eye;
	int leg;
	public Duck(){
		
	}
	public abstract void display();
	public void swimming()
	{
		System.out.println("모든 오리는 물에 뜬다.");
	}
}
