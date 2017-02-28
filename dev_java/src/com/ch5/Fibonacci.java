package com.ch5;

public class Fibonacci {

	public static void main(String[] args) {
		int a1 =1;//두 개앞에 값을 담는 변수
		int a2 = 1;//하나 앞에 값을 담는 변수
		int a3 = 0;
		System.out.print(a1+" "+a2+" ");
		for(int i=0;i<18;i++){
			a3 = a2 + a1;
			System.out.print(a3+" ");
			a1 = a2;//두개 앞에값을 두개 앞에 변수에 담고(치환)
			a2 = a3;//11번에 결과값은 하나 앞에 변수에 담는다.
		}
	}

}
