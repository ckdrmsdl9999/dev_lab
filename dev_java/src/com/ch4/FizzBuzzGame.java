package com.ch4;

public class FizzBuzzGame {

	public static void main(String[] args) {
		int i = 1;
	//1���� 100���� ����
	//�ֻ����� 5�� ������	
		for(i=1;i<=100;i++){
			//i=1;
			if((i%5==0)&&(i%7==0))//fizzbuzz�� ����Ͻÿ�.
			{
				System.out.println("fizzbuzz");
			}
			else if(i%5==0)//fizz�� ����Ͻÿ�.
			{
				System.out.println("fizz");
				
			}
			else if(i%7==0)//buzz�� ����Ͻÿ�.
			{
				System.out.println("buzz");
				
			}
			else//���ڸ� ������ּ���.
			{
				System.out.println(i);
				
			}
		}
	}

}
