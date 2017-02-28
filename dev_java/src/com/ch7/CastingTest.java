package com.ch7;

import javax.swing.JButton;
/*
 * 서로 다른 타입을 맞추어 사용할 수 있다.
 * - 캐스팅연산자(상속관계), 형전환메소드(파라미터와 리턴타입)
 * Wrapper클래스
 * int - Integer
 * double - Double
 * float - Float
 * boolean - Boolean
 * long - Long
 */
public class CastingTest {
	void go(Object obj){
		if(obj instanceof String){
			
		}
		else if(obj instanceof JButton){
			
		}
		else if(obj instanceof Integer){
			
		}
	}
	public static void main(String[] args) {
		//insert here - go메소드 호출
		Integer it = new Integer(100);
		System.out.println("Integer it : "+it);
		int i = 10;
		i = it;//autoboxing
		int j = it.intValue();
		System.out.println("i : "+i);
		double d = 3.14;
		i = (int)d;
		double d1 = 1.5;
		d1 = i;
		Object obj = "이성계";
		String name = "이순신";
		name = (String)obj;
		name = obj.toString();
		obj = name;
		JButton jbtn_exit = new JButton("종료");
		Object obj1 = jbtn_exit;
		if(jbtn_exit instanceof JButton){//너 버튼타입이야
			System.out.println("JButton타입 입니다.");
		}else{
			System.out.println("JButton타입이 아니다.");
		}
		//if(name){}
		System.out.println(jbtn_exit.getClass());
		
		Object myObj = new Object();
		
	}

}






