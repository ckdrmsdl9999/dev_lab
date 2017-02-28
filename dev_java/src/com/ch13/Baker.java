package com.ch13;

public class Baker extends Thread {
	BakerStack bs = null;
	int num=0;
	static int counter = 1;
	public Baker(BakerStack bs){
		this.bs = bs;
		num = counter++;
	}
	public void run(){
		System.out.println("현재 스레드이름:"+this.currentThread().getName());
		String bread = null;
		for(int i=0;i<3;i++){
			bread = getBread();
			bs.push(bread);
			System.out.println("파리바게트 "+num+" : "+bread);
			try {
				sleep(1000);
			} catch (InterruptedException ie) {
				System.out.println("누구냐~~~ 넌?");
			}
		}
	}
	//빵을 제공하는 메소드
	public String getBread(){
		String bread=null;
		switch((int)(Math.random()*3)){
		case 0:
			bread="생크림빵";
			break;
		case 1:
			bread="치즈케익";
			break;
		case 2:
			bread="도너츠";
			break;
		}
		return bread;
	}
}
