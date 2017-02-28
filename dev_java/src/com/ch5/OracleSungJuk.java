package com.ch5;

import java.util.Random;

public class OracleSungJuk {
	//위 점수 중에서 최고점수를 찾아라?
	
	//위 점수 중에서 최소점수를 찾아라?
	
	public void test()
	{
		//총점을 담을 변수 선언
		int tot = 0;
		//평균을 담을 변수 선언
		double avg = 0.0;//소숫점이 계산되므로 실수타입으로 선언
		//배열 선언과 생성하기
		int oracle[] = new int[5];
		oracle[0] = 70;
		oracle[1] = 85;
		oracle[2] = 90;
		oracle[3] = 70;
		oracle[4] = 65;
		int oracle2[] = {70,85,90,70,65};
		//총점을 계산하기
		for(int x=0;x<5;x++){
		//tot = tot + oracle[x]와 같은 의미	
			tot += oracle[x];
		}
		//평균을 계산하기
		avg = tot/5.0;
		System.out.println("총점은 "+tot);
		System.out.println("평균은 "+avg);
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
		int tot = 0;//총점을 담을 변수 선언
		double avg = 0.0;//평균을 담을 변수 선언
		tot = a1+a2+a3+a4+a5;
		avg = tot/5.0;
		System.out.println("총점은 "+tot);
		System.out.println("평균은 "+avg);
	}

}
