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
			System.out.println("채번한 세자리 숫자는? ===>"+is[0]+is[1]+is[2]);
		}
	}
	public static void main(String[] args) {
	//변수 몇 개? - int타입의 변수 3개 선언하기
		int fir = 0;
		int sec = 0;
		int thir = 0;
	//do~while문은 두 번	
		fir = (int)(Math.random()*10);
		do{
			sec = (int)(Math.random()*10);
		}while(fir==sec);
		do{
			thir = (int)(Math.random()*10);
		}while(fir==thir || sec==thir);
//		}while(첫번째 숫자와 세번째 숫자가 같니? || 두번째 숫자와 세번째 숫자가 같니?);
		System.out.println("채번한 세자리 숫자는? ===>"+fir+sec+thir);
		System.out.println("===============================================");
		DoWhileTest dwt = new DoWhileTest();
		dwt.test();
	}
}






