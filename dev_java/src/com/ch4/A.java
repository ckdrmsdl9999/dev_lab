package com.ch4;
/**********************************************
 * for문 안에서 선언된 변수는 for문 내에서만 접근할 수
 * 있다.
 *
 **********************************************/
public class A {

	public static void main(String[] args) {
		int i;
		int j;
		for(i=1;i<5;i++){
			System.out.println(i);//1 2 3 4 
		}
		System.out.println(i);//5
		j=0;
		if(j<5){
			
		}
	}

}
