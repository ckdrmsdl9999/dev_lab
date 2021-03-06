package com.ch5;

public class TwoArrayTest1 {
	int is1[] = {1,2,3};
	//선언과 생성
	int tis[][] = new int[4][3];
	//선언과 생성 그리고 초기화
	int tis2[][] = {
					{1,2,3}
				   ,{4,5,6}
				   ,{7,8,9}
				   ,{10,11,12}
				   };
	void test2(int tis[][])
	{
		for(int i=0;i<tis.length;i++){//tis.length=4
			for(int j=0;j<tis[i].length;j++){//tis[i].length=3
				System.out.println("tis["+i+"]["+j+"]="+tis[i][j]);
			}
		}
		System.out.println("======================================");
		//insert here
		for(int i=0;i<tis2.length;i++){//tis.length=4
			for(int j=0;j<tis2[i].length;j++){//tis[i].length=3
				System.out.println("tis2["+i+"]["+j+"]="+tis2[i][j]);
			}
		}
		
	}
/*
 * 배열변수 선언시 배열기호가 뒤에 오면 뒤에 오는 변수는 배열이 아닌 변수이고
 * 배열기호가 앞에 오면 뒤에 오는 변수도 배열이 된다. 
 */
	void test(int[] is){
		for(int i=0;i<is.length;i++){
			System.out.println("is["+i+"]="+is[i]);//0 0 0
		}
		System.out.println("=======================================");
		///// 개선된 for문으로 처리하기
		for(int x:is){
			System.out.println(x);//0 0 0
		}
		System.out.println("=======================================");
		//배열 초기화 하기
		is[0] = 10;
		is[1] = 11;
		is[2] = 12;
		///// 개선된 for문으로 처리하기
		for(int x:is){
			System.out.println(x);//10 11 12
		}
		
	}
	public static void main(String[] args) {
		int i,j;
		int is[],js;
		int []is2,js2;
		js = 2;
		//js2 = 2;js2는 배열기호가 앞에 있으므로 배열입니다.
		//따라서 배열의 시작주소번지를 나타내므로 정수로 초기화 불가능
		js2 = new int[5];
		is = new int[3];
		TwoArrayTest1 tat1 = new TwoArrayTest1();
		tat1.test(is);
		tat1.test2(tat1.tis2);
	}

}
