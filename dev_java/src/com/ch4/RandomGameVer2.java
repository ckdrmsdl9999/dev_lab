package com.ch4;

import java.util.Random;
import java.util.Scanner;

public class RandomGameVer2 {
	/******************************************
	 * 0���� 9������ ���� ä���ϱ�
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
	 * ��ǻ�Ͱ� ä���� ���� ����ڰ� �Է��� �� ���ϱ�
	 *****************************************/
	void gameRun(){
		System.out.println("0���� 9������ ���ڸ� ����~~~");
		int dap = nanSu();
		int count = 0;
		for(;count<3;){
//			System.out.println(input);
			int temp = userIntput();
			if(dap < temp){//���� Ʋ�� ���
				//ȸ�� ������Ű��
				count++;
				System.out.println("������~~~");
			}
			else if(dap > temp){//���� Ʋ�� ���
				//ȸ�� ������Ű��
				count++;
				System.out.println("���Ƕ�~~~");
			}
			else if(dap == temp){
				System.out.println("����~~~");
				//���� ����
				break;//�ݺ����� Ż���� ��, ���ѷ����� ������ ��
			}///////////end of inner if
		}/////////////////end of for		
		//�ٺ��� ��
		if(count==3){
			System.out.println("�� �ٺ�~~~");
			//
			return;//�޼ҵ� Ż��
		}/////////////end of outter if
	}
	/*****************************************
	 * ����ڰ� ȭ�鿡 �Է��� �� �޾ƿ��� ����
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
