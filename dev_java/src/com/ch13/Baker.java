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
		System.out.println("���� �������̸�:"+this.currentThread().getName());
		String bread = null;
		for(int i=0;i<3;i++){
			bread = getBread();
			bs.push(bread);
			System.out.println("�ĸ��ٰ�Ʈ "+num+" : "+bread);
			try {
				sleep(1000);
			} catch (InterruptedException ie) {
				System.out.println("������~~~ ��?");
			}
		}
	}
	//���� �����ϴ� �޼ҵ�
	public String getBread(){
		String bread=null;
		switch((int)(Math.random()*3)){
		case 0:
			bread="��ũ����";
			break;
		case 1:
			bread="ġ������";
			break;
		case 2:
			bread="������";
			break;
		}
		return bread;
	}
}
