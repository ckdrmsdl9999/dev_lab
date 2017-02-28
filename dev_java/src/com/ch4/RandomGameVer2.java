package com.ch4;

import java.util.Random;
import java.util.Scanner;

public class RandomGameVer2 {
	/******************************************
	 * 0부터 9사이의 난수 채번하기
	 * @return int
	 *****************************************/
	int nanSu(){
		int dap;
		//insert here
		Random r = new Random();
		dap=r.nextInt(10);
		return dap;
	}
	/******************************************
	 * 컴퓨터가 채번한 값과 사용자가 입력한 값 비교하기
	 *****************************************/
	void gameRun(){
		System.out.println("0부터 9사이의 숫자를 골라봐~~~");
		int dap = nanSu();
		int count = 0;
		for(;count<3;){
//			System.out.println(input);
			int temp = userIntput();
			if(dap < temp){//답을 틀린 경우
				//회차 증가시키기
				count++;
				System.out.println("나차라~~~");
			}
			else if(dap > temp){//답을 틀린 경우
				//회차 증가시키기
				count++;
				System.out.println("노피라~~~");
			}
			else if(dap == temp){
				System.out.println("마따~~~");
				//게임 종료
				break;//반복문을 탈출할 때, 무한루프를 방지할 때
			}///////////end of inner if
		}/////////////////end of for		
		//바보일 때
		if(count==3){
			System.out.println("넌 바보~~~");
			//
			return;//메소드 탈출
		}/////////////end of outter if
	}
	/*****************************************
	 * 사용자가 화면에 입력한 값 받아오기 구현
	 * @return
	 *****************************************/
	int userIntput(){
		int temp = 0;
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		temp = Integer.parseInt(input);
		return temp;
	}
	public static void main(String[] args) {
		RandomGameVer2 rGame = new RandomGameVer2();
		rGame.gameRun();
	}

}
