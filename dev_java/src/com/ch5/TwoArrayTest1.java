package com.ch5;

public class TwoArrayTest1 {
	int is1[] = {1,2,3};
	//����� ����
	int tis[][] = new int[4][3];
	//����� ���� �׸��� �ʱ�ȭ
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
 * �迭���� ����� �迭��ȣ�� �ڿ� ���� �ڿ� ���� ������ �迭�� �ƴ� �����̰�
 * �迭��ȣ�� �տ� ���� �ڿ� ���� ������ �迭�� �ȴ�. 
 */
	void test(int[] is){
		for(int i=0;i<is.length;i++){
			System.out.println("is["+i+"]="+is[i]);//0 0 0
		}
		System.out.println("=======================================");
		///// ������ for������ ó���ϱ�
		for(int x:is){
			System.out.println(x);//0 0 0
		}
		System.out.println("=======================================");
		//�迭 �ʱ�ȭ �ϱ�
		is[0] = 10;
		is[1] = 11;
		is[2] = 12;
		///// ������ for������ ó���ϱ�
		for(int x:is){
			System.out.println(x);//10 11 12
		}
		
	}
	public static void main(String[] args) {
		int i,j;
		int is[],js;
		int []is2,js2;
		js = 2;
		//js2 = 2;js2�� �迭��ȣ�� �տ� �����Ƿ� �迭�Դϴ�.
		//���� �迭�� �����ּҹ����� ��Ÿ���Ƿ� ������ �ʱ�ȭ �Ұ���
		js2 = new int[5];
		is = new int[3];
		TwoArrayTest1 tat1 = new TwoArrayTest1();
		tat1.test(is);
		tat1.test2(tat1.tis2);
	}

}