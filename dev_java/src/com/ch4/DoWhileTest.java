package com.ch4;

public class DoWhileTest {
	int is[] = new int[3];
	void test(){
		for(int i=0;i<10;i++){
			is[0] = (int)(Math.random()*10);
			do{
				is[1] = (int)(Math.random()*10);
			}while(is[0]==is[1]);
			do{
				is[2] = (int)(Math.random()*10);
			}while(is[0]==is[2] || is[1]==is[2]);			
			System.out.println("ä���� ���ڸ� ���ڴ�? ===>"+is[0]+is[1]+is[2]);
		}
	}
	public static void main(String[] args) {
	//���� �� ��? - intŸ���� ���� 3�� �����ϱ�
		int fir = 0;
		int sec = 0;
		int thir = 0;
	//do~while���� �� ��	
		fir = (int)(Math.random()*10);
		do{
			sec = (int)(Math.random()*10);
		}while(fir==sec);
		do{
			thir = (int)(Math.random()*10);
		}while(fir==thir || sec==thir);
//		}while(ù��° ���ڿ� ����° ���ڰ� ����? || �ι�° ���ڿ� ����° ���ڰ� ����?);
		System.out.println("ä���� ���ڸ� ���ڴ�? ===>"+fir+sec+thir);
		System.out.println("===============================================");
		DoWhileTest dwt = new DoWhileTest();
		dwt.test();
	}
}






