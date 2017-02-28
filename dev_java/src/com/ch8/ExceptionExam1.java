package com.ch8;

import com.ch7.Sonata;
/*
 * try..catch블록은 예외가 발생할 가능성이 있는 코드를 실행문으로 담는다.
 * 만일 예외상황이 발생하지 않으면 없는 것과 같다.
 * try..catch블록을 사용하면 문제가 발생하더라도 무조건 실행되어야 할 코드가 있거나
 * 정상적인 종료로 유도할 수 있다.
 * 멀티 블록을 사용할 경우에는 하위클래스 먼저 상위클래스 나중 작성한다.
 * 예외 클래스 이름을 모를 때는 최상위 클래스인 Exception으로 catch블럭을 작성해서
 * 메시지를 출력해 봅니다.(e.toString(), e.getMessage())
 */
public class ExceptionExam1 {
	public ExceptionExam1(){
		try {
			showNumberFormatException("안녕");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	void showNumberFormatException(String input)// "0", "100", "박명희", null
	{
		int in = 0;
			in = Integer.parseInt(input);
		System.out.println("사용자가 입력한 값:"+in);
	}
/*	void showNumberFormatException(String input)// "0", "100", "박명희", null
	{
		int in = 0;
		try {
			in = Integer.parseInt(input);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("사용자가 입력한 값:"+in);
	}*/
	public static void main(String[] args) {
		//insert here - 연출해 보기
		new ExceptionExam1();
		Sonata myCar = null;//null인 상태에서는 아직 주소번지가 할당 되지 않았다.
		try {
			System.out.println(myCar.speed);
			myCar.come();
/*		} catch (NullPointerException ne) {
			System.out.println(ne.toString());*/
			
		} catch (Exception e){
			System.out.println(e.toString());
		}
		System.out.println("여기~~~");
	}

}
