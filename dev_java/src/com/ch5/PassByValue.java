package com.ch5;
/********************************************************************************
 * �Ķ���Ϳ� ���ؼ�.....
 * 1)PassByValue ���
 * 2)CallByValue ���
 *******************************************************************************/
public class PassByValue {
	int a;//0
	int b;//0
	//���� a�� ���� b�� ���������̴�.
	void methodA(int a, int b){//PassByValue-���� ���� ȣ��-�����ȴ�.
		System.out.println(a+" , "+b);//10 , 20
		this.a = a;
		this.b = b;
		methodB(a,b);
	}
	int[] methodA2(int a, int b){//PassByValue-���� ���� ȣ��-�����ȴ�.
		int is[] = new int[2];
		is[0] = a;
		is[1] = b;
		return is;
	}
	//methodA�� �Ķ������ ���� a�� �� ���� b�� ���� methodB������ ����ϰ� �ʹ�.
	//�����?
	//1)�������� ����� ����?
	//2)�Ķ���͸� �̿��� ����?
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
