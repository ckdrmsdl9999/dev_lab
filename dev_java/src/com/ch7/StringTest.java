package com.ch7;

public class StringTest {

	public static void main(String[] args) {
		String str = "hello";
		System.out.println(str.replace('l', 'L'));
		System.out.println(str);
		str = str.replace('l', 'L');
		System.out.println(str);
		String tmp = "java";//1
		System.out.println("1:"+tmp);
		tmp +=" hello";//2 tmp = tmp+" hello"
		System.out.println("2:"+tmp);
		tmp +=" world!!";//3
		System.out.println("3:"+tmp);
		System.out.println("=========================");
		StringBuilder sb = new StringBuilder("hello");
		sb.append(" java");
		System.out.println(sb);
		
	}

}
