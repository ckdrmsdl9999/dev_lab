package com.ch6;
class Sonata
{
	int speed;
	SonataSimulation simu = null;
	//SonataSimulation simu = new SonataSimulation();
	Sonata(){
		System.out.println("����Ʈ ������ ȣ�� ����");
	}
	Sonata(int speed){
		System.out.println("Sonata(10) ȣ�� ����");
		this.speed = speed;
	}
	Sonata(SonataSimulation simu){//ȣ���� ���ÿ�.
		this.simu = simu;
	}
	void speedUp(){
		speed = speed + 1;
		//insert here���� simu�� ����ϰ� �ͽ��ϴ�. �����?
		System.out.println("simu.a ===>"+simu.a);
	}
}
public class SonataSimulation {
	int a=10;
	SonataSimulation gSimu = null;//gSimu���� �ּҹ����� �Ҵ���� ���ѻ���
	public SonataSimulation(){
		//gSimu = new SonataSimulation();//��ü ����, gSimu�� ���ؼ� ������ �޼ҵ� ȣ�� ����
		new Sonata(this);//��ü����, ������ �����Ƿ� ������ ��ü ���� �Ұ�
		new Sonata(gSimu);//��ü����, ������ �����Ƿ� ������ ��ü ���� �Ұ�
	}
	/* 34-35(1)-36(2)-37(3)-26-27(4)-28(5)-29(6)-30-38-(7)
	 * new Sonata().speedUp();, myCar.speedUp();
	 */
	public static void main(String[] args) {
		Sonata myCar = new Sonata();
		Sonata herCar = new Sonata(10);
		SonataSimulation simu = new SonataSimulation();
		Sonata himCar = new Sonata(simu);
		System.out.println(myCar.speed);
		System.out.println(herCar.speed);
		//insert here
		//myCar.speedUp();
		//herCar.speedUp();
		himCar.speedUp();
	}

}
