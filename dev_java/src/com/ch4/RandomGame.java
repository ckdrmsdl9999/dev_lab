package com.ch4;
import java.util.Random;
import java.util.Scanner;

public class RandomGame {

	public static void main(String[] args) {
		Random r = new Random();
		//사용자가 입력한 값의 타입이 String이므로
		//답(int)과 비교하기 위해서는 형전환이 필요
		int temp = 0;
		//랜던하게 채번된 값을 담을 변수 선언
		int dap = 0;
		dap=r.nextInt(10);
		System.out.println("===> "+dap);
		//회차를 담을 변수 선언
		int count = 1;
		for(int i=1;i<4;i++){
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			temp = Integer.parseInt(input);
//			System.out.println(input);
			if(count < 3){//바보가 아닐 때~~~
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
					break;
				}///////////end of inner if
			}
			//바보일 때
			else{
				System.out.println("넌 바보~~~");
				break;
			}/////////////end of outter if
		}/////////////////end of for
	}/////////////////////end of main
}/////////////////////////end of RandomGame
