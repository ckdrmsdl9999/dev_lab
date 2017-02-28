package com.ch13;

public class Customer extends Thread {
	BakerStack bs = null;
	int num=0;
	static int counter = 1;	
	public Customer(BakerStack bs){
		this.bs = bs;
		num = counter++;
	}
	public void run(){
		System.out.println("현재 스레드이름:"+this.currentThread().getName());
		String bread = null;
		String cbread[] = {"생크림빵","치즈케익","도너츠"};
		Thread.yield();//같은 등급의 스레드에게 양보한다.
		for(int i=0;i<3;i++){
			System.out.println("손님 "+num+" : "+cbread[i]+" 주세요.");
			bread = bs.pop(cbread[i]);
			try {
				sleep(1000);
			} catch (InterruptedException ie) {
				System.out.println("앗~~~ 내 빵!!!");
			}
		}
	}
}
