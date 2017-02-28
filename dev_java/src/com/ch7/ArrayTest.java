package com.ch7;

public class ArrayTest {
	int rows = 0;
	int is[] = new int[rows];
	public ArrayTest(){
		System.out.println(is);
		//System.out.println(is[0]);
		int rows = 4;
		is = new int[rows];
		System.out.println(is[0]);
	}
	public static void main(String[] args) {
		new ArrayTest();
	}

}
