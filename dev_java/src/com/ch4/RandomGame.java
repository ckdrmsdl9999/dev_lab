package com.ch4;
import java.util.Random;
import java.util.Scanner;

public class RandomGame {

	public static void main(String[] args) {
		Random r = new Random();
		//����ڰ� �Է��� ���� Ÿ���� String�̹Ƿ�
		//��(int)�� ���ϱ� ���ؼ��� ����ȯ�� �ʿ�
		int temp = 0;
		//�����ϰ� ä���� ���� ���� ���� ����
		int dap = 0;
		dap=r.nextInt(10);
		System.out.println("===> "+dap);
		//ȸ���� ���� ���� ����
		int count = 1;
		for(int i=1;i<4;i++){
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			temp = Integer.parseInt(input);
//			System.out.println(input);
			if(count < 3){//�ٺ��� �ƴ� ��~~~
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
					break;
				}///////////end of inner if
			}
			//�ٺ��� ��
			else{
				System.out.println("�� �ٺ�~~~");
				break;
			}/////////////end of outter if
		}/////////////////end of for
	}/////////////////////end of main
}/////////////////////////end of RandomGame
