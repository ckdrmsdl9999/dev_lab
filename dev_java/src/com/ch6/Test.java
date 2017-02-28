package com.ch6;
class Father{
	Father(){
	}
	void go(){
		System.out.println("go메소드 호출 성공");
	}
}
class Sun{
	Sun(Father fa){
		fa.go();
	}
}
public class Test {
	public Test(){
		Father fa = new Father();
		Sun su = new Sun(fa);
	}
	//20-21-15-16-3-4-17-10-11
	public static void main(String[] args) {
		new Test();
	}
}
