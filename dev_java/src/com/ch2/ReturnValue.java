package com.ch2;
/***********************************************
 * ���������� (static) ����Ÿ�� �޼ҵ��̸�(�Ķ����){}
 * �޼ҵ� ������ ����Ÿ���� �����ؾ� �մϴ�.
 * 1) void 
 * 2) ����Ÿ�� Ȥ�� ������ Ÿ���� �� �� �ִ�.
 **********************************************/
public class ReturnValue {
	static void go(){
		System.out.println("10");//10
	}
	static int come(){
		int x = 100;
		return x;
//		return 10;
	}
	public static void main(String[] args) {
		System.out.print(1);
		System.out.print(2);
		System.out.println(10);
		System.out.println(20);
		System.out.println("================");
		//�޼ҵ� ȣ���ϱ�
		//insert here - go();
		//���:����Ÿ���� void�� ��쿡�� ������ 
		//�޼ҵ��� ó�� ������� ���� �� ����.
		int x = 5;
		go();
		//����Ÿ���� void�� ��쿡�� ȣ������ 
		//�Ѱ� ���� ���� ����.
		//x = go();
		//insert here - come();
		//���:����Ÿ���� int�� ��쿡�� ������ 
		//�޼ҵ��� ó�� ������� ���� �� �ִ�.
		x = come();
		System.out.println(x);//100
	}

}
