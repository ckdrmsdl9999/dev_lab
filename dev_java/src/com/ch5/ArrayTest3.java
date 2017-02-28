package com.ch5;

public class ArrayTest3 {

	public static void main(String[] args) {
		ArrayTest2 at2 = new ArrayTest2();
		at2.methodB();//is배열의 초기화를 담당하는 메소드
		at2.methodBPrint();//0,0,0,0,0 -> 3,4,5,6,7
		//is배열을 새로 초기화 하시오.
		at2.is[0] = 13;
		at2.is[1] = 14;
		at2.is[2] = 15;
		at2.is[3] = 16;
		at2.is[4] = 17;
		//is배열의 값들을 출력 하시오.
		at2.methodBPrint();
		System.out.println("===================================================");
		ArrayTest2 at3 = new ArrayTest2();
		at3.methodBPrint();
	}
}
