package com.ch5;

public class Fibonacci {

	public static void main(String[] args) {
		int a1 =1;//�� ���տ� ���� ��� ����
		int a2 = 1;//�ϳ� �տ� ���� ��� ����
		int a3 = 0;
		System.out.print(a1+" "+a2+" ");
		for(int i=0;i<18;i++){
			a3 = a2 + a1;
			System.out.print(a3+" ");
			a1 = a2;//�ΰ� �տ����� �ΰ� �տ� ������ ���(ġȯ)
			a2 = a3;//11���� ������� �ϳ� �տ� ������ ��´�.
		}
	}

}
