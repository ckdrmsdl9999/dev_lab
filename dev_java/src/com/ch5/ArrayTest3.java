package com.ch5;

public class ArrayTest3 {

	public static void main(String[] args) {
		ArrayTest2 at2 = new ArrayTest2();
		at2.methodB();//is�迭�� �ʱ�ȭ�� ����ϴ� �޼ҵ�
		at2.methodBPrint();//0,0,0,0,0 -> 3,4,5,6,7
		//is�迭�� ���� �ʱ�ȭ �Ͻÿ�.
		at2.is[0] = 13;
		at2.is[1] = 14;
		at2.is[2] = 15;
		at2.is[3] = 16;
		at2.is[4] = 17;
		//is�迭�� ������ ��� �Ͻÿ�.
		at2.methodBPrint();
		System.out.println("===================================================");
		ArrayTest2 at3 = new ArrayTest2();
		at3.methodBPrint();
	}
}
