package com.ch5;

import java.util.Scanner;

public class StringReverse {
	void reverse(String str){
		char ch[] = str.toCharArray();
		for(int i=ch.length-1;i>=0;i--){
			System.out.print(ch[i]+"");
		}
		System.out.println();		
	}
	void reverse(String[] str){
		for(int i=str.length-1;i>=0;i--){
			for(int j=str[i].length()-1;j>=0;j--){
				System.out.print(str[i].charAt(j));
			}
			System.out.print(" ");
		}		
	}
	//22-23-24-25-return�� ������ �ش� �޼ҵ� Ż��
	//22-28-29-30(�޼ҵ� ȣ��)-13(args�ּҹ���)-14-15-16-17-18-20(�޼ҵ� ���ೡ)-31
	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("���ڿ��� �Է��Ͻÿ�.");
			return;
		}
		else{
			StringReverse sr = new StringReverse();
			sr.reverse(args);
		}
/*		System.out.println("�Ųٷ� ����� ���ڿ��� �Է��ϼ���.\n");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		StringReverse sr = new StringReverse();
		sr.reverse(input);*/
/*		String words[] = new String[4];
		words[0] = "Have";
		words[1] = "a";
		words[2] = "good";
		words[3] = "time!";
		System.out.println("������ ����:"+words.length);//4
		System.out.println("������ ����:"+words[2].length());//4
		System.out.println("������ ����:"+words[1].length());//1
		System.out.println("m����ϱ�"+words[3].charAt(2));//m
		System.out.print(words[0]+" "+words[1]+" "+words[2]+" "+words[3]);//Have a good time!
		System.out.println();//�ٹٲ� ó���ϱ�
		System.out.print(words[3]+" "+words[2]+" "+words[1]+" "+words[0]);//time! good a Have
		System.out.println();//�ٹٲ� ó���ϱ�
		for(int i=words.length-1;i>=0;i--){
			System.out.print(words[i]+" ");
		}
		System.out.println("=============================================");
		for(int i=words.length-1;i>=0;i--){
			for(int j=words[i].length()-1;j>=0;j--){
				System.out.print(words[i].charAt(j));
			}
			System.out.print(" ");
		}
		System.out.println();*/
	}////////////////// end of main

}











