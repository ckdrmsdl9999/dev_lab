package com.ch2;

public class ReturnType2 {
	/******************************************
	 * @param 홍길동학생 점수
	 * @param 이순신학생 점수
	 * @return 두 학생의 총점을 반환하기
	 *****************************************/
	static int hap(int jumsu1,int jumsu2){
		int tot = 0;
		tot = jumsu1+jumsu2;
		return tot;
	}
	/******************************************
	 * 
	 ******************************************/
	static void avg(){
//		int tot = jumsu1+jumsu2;
		int tot = hap(80,90);
		System.out.println(tot);//
		System.out.print(hap(80,90));//
//		double avg1 = tot/2.0;
		double avg1 = hap(80,90)/2.0;
		System.out.println("평균은 "+avg1);
	}
	public static void main(String[] args) {
		//ReturnType2 rt2 = new ReturnType2();
		//rt2.avg();
		ReturnType2.avg();
	}

}
