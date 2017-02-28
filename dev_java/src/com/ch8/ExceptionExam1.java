package com.ch8;

import com.ch7.Sonata;
/*
 * try..catch����� ���ܰ� �߻��� ���ɼ��� �ִ� �ڵ带 ���๮���� ��´�.
 * ���� ���ܻ�Ȳ�� �߻����� ������ ���� �Ͱ� ����.
 * try..catch����� ����ϸ� ������ �߻��ϴ��� ������ ����Ǿ�� �� �ڵ尡 �ְų�
 * �������� ����� ������ �� �ִ�.
 * ��Ƽ ����� ����� ��쿡�� ����Ŭ���� ���� ����Ŭ���� ���� �ۼ��Ѵ�.
 * ���� Ŭ���� �̸��� �� ���� �ֻ��� Ŭ������ Exception���� catch���� �ۼ��ؼ�
 * �޽����� ����� ���ϴ�.(e.toString(), e.getMessage())
 */
public class ExceptionExam1 {
	public ExceptionExam1(){
		try {
			showNumberFormatException("�ȳ�");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	void showNumberFormatException(String input)// "0", "100", "�ڸ���", null
	{
		int in = 0;
			in = Integer.parseInt(input);
		System.out.println("����ڰ� �Է��� ��:"+in);
	}
/*	void showNumberFormatException(String input)// "0", "100", "�ڸ���", null
	{
		int in = 0;
		try {
			in = Integer.parseInt(input);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("����ڰ� �Է��� ��:"+in);
	}*/
	public static void main(String[] args) {
		//insert here - ������ ����
		new ExceptionExam1();
		Sonata myCar = null;//null�� ���¿����� ���� �ּҹ����� �Ҵ� ���� �ʾҴ�.
		try {
			System.out.println(myCar.speed);
			myCar.come();
/*		} catch (NullPointerException ne) {
			System.out.println(ne.toString());*/
			
		} catch (Exception e){
			System.out.println(e.toString());
		}
		System.out.println("����~~~");
	}

}
