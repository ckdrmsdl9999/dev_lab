package com.ch6;

public class Duck {
	static Duck herDuck = null;
	Duck getInstance(){
		if(herDuck == null) herDuck = new Duck();
		herDuck.swimming();
		return herDuck;
	}
	public void swimming(){
		System.out.println("���� �����ϰ� �־��~~~~");
	}
	public void fly(){
		System.out.println("���� ���� �־��~~~");
	}
	public static void main(String[] args) {
		Duck myDuck = new Duck();
		Duck himDuck = myDuck.getInstance();
		System.out.println(myDuck+" , "+himDuck);
		//insert here
		herDuck.swimming();
		//myDuck.getInstance().swimming();
		himDuck.swimming();
	}

}
