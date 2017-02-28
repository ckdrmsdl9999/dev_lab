package com.ch4;
/***********************************************
 * 1.변수를 선언하고 초기화 할 수 있다. 
 * 2.변수를 이용하여 연산할 수 있다.
 * 3.필요한 변수의 갯수는 몇 개일까?
 * 4.3번에서 필요한 변수의 타입을 결정할 수 있다.
 * 5.내가 작성한 코드는 합리적인가?
 **********************************************/
public class Test {
	void methodA()
	{
		int i = 1;//1부터 5까지 카운트값을 담을 변수
		int hap = 0;//1부터 5까지의 합을 담을 변수
		hap = hap + i;//1
		i = i + 1;//hap=1 i=1
		hap = hap + i;//hap=3, i=2
		i = i + 1;//hap=3 i=3
		hap = hap + i;//hap=6, i=3
		i = i + 1;//hap=6 i=4
		hap = hap + i;//hap=10, i=4
		i = i + 1;//hap=10 i=5
		hap = hap + i;//hap=15, i=5
		System.out.println("1부터 5까지의 합은 "+hap);
	}
	public static void main(String[] args) {
		int i1 = 1;
		int i2 = 2;
		int i3 = 3;
		int i4 = 4;
		int i5 = 5;
		int hap = i1+i2+i3+i4+i5;
		System.out.println(i1+i2+i3+i4+i5);
		System.out.println(hap);
		//인스턴스화  A a = new A();
		Test t = new Test();
		t.methodA();
	}

}
