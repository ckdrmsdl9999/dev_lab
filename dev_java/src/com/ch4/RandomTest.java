package com.ch4;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			Random r = new Random();
			int input = r.nextInt(10);
			System.out.println(input);
		}
	}

}
