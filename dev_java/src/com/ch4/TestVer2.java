package com.ch4;

public class TestVer2 {

	public static void main(String[] args) {
		int i=0;
		int hap = 0;
		for(i=1;i<=5;i=i+1){//1->2->3->4-5
//		for(i=1;i<=5;i=i+2){
			System.out.println("i:"+i);
			hap = hap + i;
			System.out.println("inner for hap:"+hap);//1->3->6->10->15
		}
		System.out.println("outter for hap:"+hap);//15
		System.out.println("====================");
		//insert here
		//위에서 선언한 변수 재사용하기 - 초기화
		//문제:1부터 100까지 세면서 짝수의 합 출력하기
//		if(1==1){
		System.out.println(10%2);//0
		if(i%2==0){
			System.out.println("i는 얼마니? "+i);
		}
		//초기화 문제 해결하기
		i = 0;
		hap = 0;
		//합의 공식을 여러번 반복수행하기 위해 반복문필요
		for(i=1;i<101;i=i+1){
			//합의 공식은 짝수일때만 수행되어야 하므로
			//조건식 필요
//			if(너 짝수니?){
			if(i%2==0){
				hap = hap + i;
			}//////////end of if /////////////
		}//////////////end of for ////////////
		//1부터 100까지 짝수의 합을 출력하면
		System.out.println
		("1부터 100까지 짝수의 합 : "+hap);
	}

}
