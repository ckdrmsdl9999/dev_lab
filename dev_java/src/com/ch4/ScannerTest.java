package com.ch4;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=1;i<6;i++){
			System.out.println("���ڸ� �Է��Ͻÿ�.");
			String num = sc.nextLine();
			System.out.println("num:"+num);
		}
	}

}
