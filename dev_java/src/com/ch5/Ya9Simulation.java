package com.ch5;

public class Ya9Simulation {

	public static void main(String[] args) {
		Ya9 ya9 = new Ya9();
		int p[][] = new int[2][3];
		int count = 0;
		int usr[][]=ya9.userInput(p);
		for(int i=0;i<usr[0].length;i++){
			System.out.print(usr[1][i]);
		}
		/********************************************************************************
		 * 세자리 숫자 채번하기 단위 테스트 해보기
		for(;;){
			int nanSu[][] = ya9.nanSu(p);
			for(int i=0;i<nanSu.length;i++){
				for(int j=0;j<nanSu[i].length;j++){
					System.out.println("nanSu["+i+"]["+j+"]="+nanSu[i][j]);
				}
			}
			if(count == 9) break;
			count++;
		}
		/********************************************************************************/
	}

}
