package com.ch4;

public class RandomGameVer2Test {

	public static void main(String[] args) {
		RandomGameVer2 rv = 
				new RandomGameVer2();
		for(int i=0;i<10;i++){
			int dap = rv.nanSu();
			System.out.println
			("난수 테스트 dap:"+dap);
		}
	}

}
