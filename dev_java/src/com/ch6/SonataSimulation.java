package com.ch6;
class Sonata
{
	int speed;
	SonataSimulation simu = null;
	//SonataSimulation simu = new SonataSimulation();
	Sonata(){
		System.out.println("디폴트 생성자 호출 성공");
	}
	Sonata(int speed){
		System.out.println("Sonata(10) 호출 성공");
		this.speed = speed;
	}
	Sonata(SonataSimulation simu){//호출해 보시오.
		this.simu = simu;
	}
	void speedUp(){
		speed = speed + 1;
		//insert here에서 simu를 사용하고 싶습니다. 어떡하지?
		System.out.println("simu.a ===>"+simu.a);
	}
}
public class SonataSimulation {
	int a=10;
	SonataSimulation gSimu = null;//gSimu아직 주소번지를 할당받지 못한상태
	public SonataSimulation(){
		//gSimu = new SonataSimulation();//객체 생성, gSimu를 통해서 변수와 메소드 호출 가능
		new Sonata(this);//객체생성, 변수가 없으므로 생성된 객체 접근 불가
		new Sonata(gSimu);//객체생성, 변수가 없으므로 생성된 객체 접근 불가
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
