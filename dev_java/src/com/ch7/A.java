package com.ch7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A implements ActionListener {
	public A(){
		methodB();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	void methodA() throws NullPointerException{
		System.out.println("methodA 호출 성공");
	}
	//예외처리를 다중으로 할 수 있다.
	void methodB(){
		A a = null;
		try {
			int i = Integer.parseInt(null);
			//앞에 코드에서 먼저 예외가 발생했으므로 아래 코드는 실행기회를
			//갖지 못한다.
			a.methodA();
		} catch (NumberFormatException ne){
			System.out.println(ne.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println(e.getMessage());
		}
		System.out.println("여기");
	}
	public static void main(String[] args){
		new A();
	}

}


