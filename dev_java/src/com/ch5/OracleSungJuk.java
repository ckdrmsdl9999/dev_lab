package com.ch5;

import java.util.Random;

public class OracleSungJuk {
	//�� ���� �߿��� �ְ������� ã�ƶ�?
	
	//�� ���� �߿��� �ּ������� ã�ƶ�?
	
	public void test()
	{
		//������ ���� ���� ����
		int tot = 0;
		//����� ���� ���� ����
		double avg = 0.0;//�Ҽ����� ���ǹǷ� �Ǽ�Ÿ������ ����
		//�迭 ����� �����ϱ�
		int oracle[] = new int[5];
		oracle[0] = 70;
		oracle[1] = 85;
		oracle[2] = 90;
		oracle[3] = 70;
		oracle[4] = 65;
		int oracle2[] = {70,85,90,70,65};
		//������ ����ϱ�
		for(int x=0;x<5;x++){
		//tot = tot + oracle[x]�� ���� �ǹ�	
			tot += oracle[x];
		}
		//����� ����ϱ�
		avg = tot/5.0;
		System.out.println("������ "+tot);
		System.out.println("����� "+avg);
	}
	public int[] jumSu()
	{
		int oracle[] = new int[5];
		for(int i=0;i<5;i++){
			Random r = new Random();
			oracle[i] = r.nextInt(101);
		}
		return oracle;
	}
	public void jumSuPrint(int[] oracle){
		for(int i=0;i<oracle.length;i++){
			System.out.println(oracle[i]);
		}
	}
	public static void main(String[] args) {
		OracleSungJuk osj = new OracleSungJuk();
		osj.test();
		int a1 = 70;
		int a2 = 85;
		int a3 = 90;
		int a4 = 70;
		int a5 = 65;
		int tot = 0;//������ ���� ���� ����
		double avg = 0.0;//����� ���� ���� ����
		tot = a1+a2+a3+a4+a5;
		avg = tot/5.0;
		System.out.println("������ "+tot);
		System.out.println("����� "+avg);
	}

}
