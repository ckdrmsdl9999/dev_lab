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
		//������ ������ ���� �����ϱ� - �ʱ�ȭ
		//����:1���� 100���� ���鼭 ¦���� �� ����ϱ�
//		if(1==1){
		System.out.println(10%2);//0
		if(i%2==0){
			System.out.println("i�� �󸶴�? "+i);
		}
		//�ʱ�ȭ ���� �ذ��ϱ�
		i = 0;
		hap = 0;
		//���� ������ ������ �ݺ������ϱ� ���� �ݺ����ʿ�
		for(i=1;i<101;i=i+1){
			//���� ������ ¦���϶��� ����Ǿ�� �ϹǷ�
			//���ǽ� �ʿ�
//			if(�� ¦����?){
			if(i%2==0){
				hap = hap + i;
			}//////////end of if /////////////
		}//////////////end of for ////////////
		//1���� 100���� ¦���� ���� ����ϸ�
		System.out.println
		("1���� 100���� ¦���� �� : "+hap);
	}

}
