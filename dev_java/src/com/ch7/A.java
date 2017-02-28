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
		System.out.println("methodA ȣ�� ����");
	}
	//����ó���� �������� �� �� �ִ�.
	void methodB(){
		A a = null;
		try {
			int i = Integer.parseInt(null);
			//�տ� �ڵ忡�� ���� ���ܰ� �߻������Ƿ� �Ʒ� �ڵ�� �����ȸ��
			//���� ���Ѵ�.
			a.methodA();
		} catch (NumberFormatException ne){
			System.out.println(ne.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println(e.getMessage());
		}
		System.out.println("����");
	}
	public static void main(String[] args){
		new A();
	}

}


