package com.ch5;

public class ArrayParameter {
	void methodA(int fir, int sec, int thir){
		System.out.println(fir);
		System.out.println(sec);
		System.out.println(thir);
	}
	//�Ķ���Ϳ� ���� is�迭�̸��� �Ķ���Ϳ� ����Ǿ����Ƿ� ���������� ������ ���´�.
	//���� main�޼ҵ忡���� ����� �� ����.
	void methodB(int[] is){
		for(int i=0;i<is.length;i++){
			System.out.println(is[i]);
		}
	}
	public static void main(String[] args) {
		//insert here - methodA ȣ�� �ϱ�, methodB ȣ���ϱ�
		ArrayParameter ap = new ArrayParameter();
		ap.methodA(10, 100, 1000);
		//is�迭�� �����ϰ� ������ ������.
		int is[] = new int[3];
		is[0] = 5;
		is[1] = 15;
		is[2] = 25;
		ap.methodB(is);
	}

}
