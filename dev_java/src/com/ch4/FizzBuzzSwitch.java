package com.ch4;

public class FizzBuzzSwitch {

	public static void main(String[] args) {
		int i = 0;
		for(i=1;i<=100;i++){
			switch(i%35){
			//35�� ������ �������� ���
			case 0:
				System.out.println("fizzbuzz");
				break;
			//5�� ������ �������� ���
			case 5: case 10: case 15: case 20:
			case 25: case 30:
				System.out.println("fizz");
				break;
			//7�� ������ �������� ���
			case 7: case 14: case 21: case 28:	
			//���ڸ� �״�� ����ϱ�	
				System.out.println("buzz");
				break;
			default:
				System.out.println(i);
			}/////////end of switch
		}/////////////end of for
	}/////////////////end of main
}/////////////////////end of FizzBuzzSwitch
