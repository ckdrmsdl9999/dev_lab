package com.ch2;

public class VariableTest {

	public static void main(String[] args) {
		//insert here - 변수 두 개 선언하기
		int x = 1;
		int y = 2;
		//insert here - 두 수의 합을 담을 변수 선언하기
		int result = 0;
		//insert here - 두 수의 합 결과를 result변수에 담기
		result = x+y;//3
		System.out.println("두 수의 합:"+result);//3
		//insert here - 첫번째에서 두번째 변수의 값을
		//뺀 후에 결과값을 result변수에 담아보세요.
		result = x-y;//-1
		System.out.println("두 수의 차:"+result);//-1
		//result = 0;주석으로 하면 result값이 -1로
		//초기화 되어있어서 1부터 5까지의 합이 14가 되고
		//result=0을 주석처리 안하면
		//result의 초기화가 0으로 되어 아래 계산결과에
		//영향을 미치지 않는다.
		for(int i=1;i<=5;i=i+1){
			result = result+i;
		}
/*		result = result +1;
		result = result +2;
		result = result +3;
		result = result +4;
		result = result +5;*/
		System.out.println
		("1부터5까지의합은:"+result);//15
	}

}





