package com.ch5;

public class ArrayTest {
	//����� - �������� ����
	//��� :  ����ο����� ����� �ʱ�ȭ�� ������ �ڵ��� �� ����.
	//       ����� �ʱ�ȭ�� �ѹ��� �ؾ� �Ѵ�.
	int i = 10;
	int is[] = new int[5];
	double ds[] = {1.5,1.3,1.8};
/*	int i;
	i = 10;
	int is[] = null;
	is = new int[7]; ����*/	
	//�޼ҵ� ����
	int[] methodA(){
		int x;
		x = 10;
		int is[] = null;
		is = new int[7];
		//insert here - �迭 ds�� ����� ������ ����Ͻÿ�.
		return is;
	}
	int[] methodB(int is[]){
	//methodA�� ����� �迭 is�� �ʱ�ȭ �Ͻÿ�.
	//�ʱⰪ�� ������� ....
		is[0] = 3;
		is[1] = 4;
		is[2] = 5;
		is[3] = 6;
		is[4] = 7;
		is[5] = 8;
		is[6] = 9;
		return is;
	}
	void methodBPrint(int is[]){
	//�� �迭�� �ʱ�ȭ�� ���� ����Ͻÿ�.	
		for(int x=0;x<is.length;x++){
			System.out.println("is["+x+"]"+is[x]);
		}
	}
	//main�޼ҵ� ����
	public static void main(String[] args) {
	//insert here
		//�������� i�� ����Ͻÿ�.
		ArrayTest at = new ArrayTest();
		/*******************************
		 * 
		 ******************************/
		int is[] = at.methodA();
		//at.methodB(is);
		is = at.methodB(is);
		at.methodBPrint(is);
		System.out.println("===========================================");
		System.out.println(at.i);//10
		//����ο� �ִ� is�迭�� ������ ����Ͻÿ�.
		System.out.println(at.is[0]);//0
		System.out.println(at.is[1]);//0
		System.out.println(at.is[2]);//0
		System.out.println(at.is[3]);//0
		System.out.println(at.is[4]);//0
		for(int x=0;x<at.is.length;x++){
			System.out.println(at.is[x]);//0~4
		}
	}

}
