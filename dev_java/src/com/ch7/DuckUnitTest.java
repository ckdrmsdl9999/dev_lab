package com.ch7;

public class DuckUnitTest {

	public static void main(String[] args) {
		Duck duck = null;
//		Duck duck = new Duck();단독으로 인스턴스화 불가.
		//myDuck의 구현체 클래스는 MallardDuck이다.
		Duck myDuck = new MallardDuck();
		//herDuck의 구현체 클래스는 WoodDuck이다.
		Duck herDuck = new WoodDuck();
		//himDuck의 구현체 클래스는 RubberDuck이다.
		Duck himDuck = new RubberDuck();
		MallardDuck malDuck = new MallardDuck();
		WoodDuck wooDuck = new WoodDuck();
		RubberDuck rubDuck = new RubberDuck();
		duck = myDuck;
		duck = malDuck;
		duck = wooDuck;
		duck = rubDuck;
		//malDuck = wooDuck;
		//malDuck = rubDuck;
		//폴리모피즘이라고 한다. - 다형성
		//선언부와 생성부의 클래스 타입이 다를 때 다형성을 
		//누릴 수 있다.
		//myDuck.display();//청둥오리
		//herDuck.display();//나무오리
		//himDuck.display();//고무오리
		//insert here - 나는 나무오리입니다를 출력하시오.
//		malDuck = myDuck;오른 쪽에 더 큰타입이 올 수 없다.
		herDuck = myDuck;
/*
 * 결론
 * 원시타입일 경우에는 강제형전환 할 수 있다.
 * 함정:실수부 담을 수 없다.
 * 참조타입일 경우에는 강제형전환 할 수 있다(문법적으로 합법).
 * 런타입시에는 ClassCastException을 던진다.
 * :참조타입의 경우 무조건 오른쪽에는 자식클래스를 사용해야 한다.		
 */
		//malDuck = (MallardDuck)wooDuck;
		wooDuck = (WoodDuck)myDuck;
		wooDuck.display();
		MallardDuck mDuck = null;
		mDuck = malDuck;
	}

}









