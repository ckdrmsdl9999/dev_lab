package com.ch5;

import java.util.Random;

/*********************************************************************************
 * ����Ŭ ������ ���� �߻��� ���ؼ� 5�� �޾Ƽ� ������ ��� ���ϱ� 
 *
 *
 *********************************************************************************/
public class OracleJumsu {
	
	public static void main(String[] args) {
		//����ڰ� �Է��� ������ ���� �迭 �����ϰ� �����ϱ�
		int jumsu[] = new int[5];
		//5���� ������ ������ �Է� �޾ƾ� �ϹǷ� �ݺ��� ����ϱ�
		for(int i=0;i<5;i++){
			Random r = new Random();
			jumsu[i] = r.nextInt(101);
			System.out.println(jumsu[i]);
		}
		//���� ���ϱ� - ���� ����
		int tot = 0;
		for(int j=0;j<5;j++){
			tot = tot + jumsu[j];
		}
		System.out.println("���� : " + tot);
		//��� ���ϱ� - ���� ����
		double avg = 0.0;
		avg = tot/5.0;
		System.out.println("��� : " + avg);
	}////////////// end of main
}////////////////// end of OracleJumsu



