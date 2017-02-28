package com.ch5;

public class StringArrayTest1 {

	public static void main(String[] args) {
		String name[] = new String[3];
		name[0] = "Kim";
		name[1] = "Park";
		name[2] = "Yi";
		for(int i=0;i<name.length;i++){
			System.out.println(name[i]);
		}
		System.out.println("=================================");
		for(String str:name){
			System.out.println(str);
		}
		System.out.println("Kim".length());//3
		System.out.println("Park".length());//4
		System.out.println(name[1].length());//4
		//length는 원소의 갯수를 반환하고
		//length()은 문자열의 길이를 반환한다.
		char c1 = "Kim".charAt(0);//K
		char c2 = "Kim".charAt(1);//i
		char c3 = "Kim".charAt(2);//m
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		for(int x=0;x<name[1].length();x++){
			System.out.println(name[1].charAt(x));//P a r k
		}
		System.out.println(name.length);
		//String의 초기값은 null입니다. 왜? 객체타입이라서....
		String str[] = new String[5];
		System.out.println(str.length);
		for(String s:str){
			System.out.println(s);
		}
	}

}
