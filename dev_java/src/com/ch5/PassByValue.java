package com.ch5;
/********************************************************************************
 * 파라미터에 대해서.....
 * 1)PassByValue 방식
 * 2)CallByValue 방식
 *******************************************************************************/
public class PassByValue {
	int a;//0
	int b;//0
	//변수 a와 변수 b는 지역변수이다.
	void methodA(int a, int b){//PassByValue-값에 의한 호출-복제된다.
		System.out.println(a+" , "+b);//10 , 20
		this.a = a;
		this.b = b;
		methodB(a,b);
	}
	int[] methodA2(int a, int b){//PassByValue-값에 의한 호출-복제된다.
		int is[] = new int[2];
		is[0] = a;
		is[1] = b;
		return is;
	}
	//methodA에 파라미터인 변수 a값 과 변수 b의 값을 methodB에서도 사용하고 싶다.
	//어떡하지?
	//1)전역변수 사용해 볼까?
	//2)파라미터를 이용해 볼까?
	//insert here - 
	void methodB(){
		System.out.println(a+" , "+b);//10 , 20
	}
	void methodB(int a, int b){
		System.out.println("methodB(int a, int b):"+a+" , "+b);//10 , 20
	}
	public static void main(String[] args) {
		PassByValue pv = new PassByValue();
		//pv.methodA(10, 20);
		//pv.methodB();//0 , 0  | 10 , 20
 		int is[] = pv.methodA2(10, 20);
		for(int i=0;i<is.length;i++){
			System.out.println("is["+i+"]="+is[i]);
		}
	}

}
