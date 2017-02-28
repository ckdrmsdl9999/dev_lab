package com.ch6;
class Father1{
	Father1(){
	}
	Father1(Test1 t){}
	void go(){
		System.out.println("go메소드 호출 성공");
	}
}
class Sun1{
	Sun1(Father1 fa){
		fa.go();
	}
}
public class Test1 {
	Father1 fa = new Father1(this);
	public Test1(){
		new Test1(this);
		Father1 fa = new Father1();
		Sun1 su = new Sun1(fa);
	}
	public Test1(Test1 t){
		System.out.println("Test(Test t)호출 성공");
	}
	//20-21-15-16-3-4-17-10-11
	public static void main(String[] args) {
		new Test1();
	}
}
