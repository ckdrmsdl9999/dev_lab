package com.ch6;
/***************************************************************
 * 1.�����ڸ� ������ �� �ֳ���?
 * 2.������ �����ڸ� ������ �� �ֳ���?
 * ����
 * ����Ʈ �����ڴ� JVM���� �����ȴ�.
 * �Ķ���Ͱ� �ִ� �����ڴ� �������� �� ����.
 * �Ķ���͸� ���� �����ڰ� �� ���� �����ϸ� ����Ʈ �����ڴ�
 * �������� �ʽ��ϴ�.
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
