package com.ch13;

public class WaitNotifyTest {

	public static void main(String[] args) {
		BakerStack bs = new BakerStack();
		//6개의 스레드를 움직입니다.
		//start메소드의 호출 순서는 영향이 없습니다.
		//누가 먼저 점유하느냐에 따라 실행 순서는 매번 달라질 수도 
		//있습니다.
		//스레드 마다 별도의 가중치를 주지 않았으므로 모두 5이며
		//같은 레벨의 스레드가 6개 생성됩니다.
		//만드는 빵의 종류와 사가는 빵의 이름을 정하지 않았습니다.
		//실행하여 소스를 분석해 보고 사가는 빵의 이름을 정해서 
		//사가고 진열하도록 해보세요.
		//스레드에 대해서 가중치를 줄 수 있다.
		//디폴트 5이다.(Thread.yield():같은 등급의 스레드에게만 양보 한다.)
		/*
		 * 실행중에 자신에게 주어진 차례를 다른 쓰레드에게 양보하고 자신은 실행대기 상태
		 * 로 간다.
		 * 
		 */
		Baker b1 = new Baker(bs);
		b1.start();
		Baker b2 = new Baker(bs);
		b2.start();
		Baker b3 = new Baker(bs);
		b3.start();
		Customer c1 = new Customer(bs);
		c1.setPriority(10);
		c1.start();
		Customer c2 = new Customer(bs);
		c2.start();
		Customer c3 = new Customer(bs);
		c3.start();		
	}

}
