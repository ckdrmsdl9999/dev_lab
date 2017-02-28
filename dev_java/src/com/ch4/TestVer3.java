package com.ch4;

public class TestVer3 {

	public static void main(String[] args) {
		int i = 0;
		int hap = 0;
		boolean sw = false;
		for(i=1;i<=100;i++){
			if(sw){
				System.out.println
				("Â¦¼öÀÏ °æ¿ì skip");
				hap = hap + i;
				System.out.println(i+", "+hap);
				sw = false;
			}///// end of if
			else{
				sw = true;
			}///// end of else
		}///////// end of for
		System.out.println(hap);
	}///////////// end of main
}///////////////// end of TestVer3
