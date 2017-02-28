package com.ch4;

public class BreakTest {
	void forToWhile()
	{
		int i=0;
		int hap=0;
		while(i<100){
			++i;
			System.out.println(i);
			hap = hap+i;//if문 앞에 있을 때 50까지 연산
			if(i==50){
				break;//16라인이 실행된다.
			}///////end of if
			System.out.println
			("break문을 만나게 되면 출력되지 않습니다.");
		}///////////end of while
		System.out.println("여기");
		System.out.println("hap ===> "+hap);		
	}
	public static void main(String[] args) {
		int i=0;
		int hap=0;
		BreakTest bt = new BreakTest();
		bt.forToWhile();
/*		for(i=1;i<101;i++){
			System.out.println(i);
			hap = hap+i;//if문 앞에 있을 때 50까지 연산
			//카운트 변수가 50이면 for문 탈출하기
			if(i==50){
			//break문을 만나게 되면 반복문을 탈출	
				break;//16라인이 실행된다.
			}///////end of if
			//hap = hap+i;50인 경우 연산이 안된다.
			System.out.println
			("break문을 만나게 되면 출력되지 않습니다.");
		}///////////end of for
		System.out.println("여기");
		System.out.println("hap ===> "+hap);
 */		
		
	}

}
