package com.base;

public class V2 {
	int x;//전역변수
	static int y;
	void go(){
		
	}
	static void come(){
		
	}
	public static void main(String[] args) {
		V2 v = new V2();
		System.out.println(v.x);
		System.out.println(y);
//		go();에러
		v.go();//합법
		come();
	}

}
