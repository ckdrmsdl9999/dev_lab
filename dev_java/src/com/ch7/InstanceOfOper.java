package com.ch7;

import java.util.Vector;

public class InstanceOfOper {
	Vector vec = new Vector();//늘었다 줄었다 하죠
	Vector<String> bread = new Vector<String>(10,10);//내 안에 String만 담을 수 있다.
	Object objs[] = new Object[3];
	public InstanceOfOper(){
		System.out.println("bread.size():"+bread.size());
		String name = "이순신";
		//methodA(name);
		//methodA(10);
		Sonata myCar = new Sonata();
		//methodA(myCar);
		objs[0] = name;
		objs[1] = 10;
		objs[2] = myCar;
		methodB(objs);
		vec.add(name);
		vec.add(10);
		vec.add(myCar);
		vec.add(2, true);
		vec.remove(3);//해당 위치의 값을 삭제합니다.
		System.out.println("size값을 확인하기 : "+vec.size());
		methodB(vec);
	}
	private void methodB(Object[] objs2) {//UI솔루션을 사용할 경우 타입을 맞추는 문제 중요.
		System.out.println("=================================");
		for(int i=0;i<objs2.length;i++){
			if(objs[i] instanceof Sonata){
				Sonata herCar = (Sonata)objs2[i];
				System.out.println(herCar);
			}
			//너 String타입이니?
			else if(objs2[i] instanceof String){
				String str = (String)objs2[i];
				System.out.println(str);
			}
			else if(objs2[i] instanceof Integer){
				Integer it = (Integer)objs2[i];
				System.out.println(it);
			}			
		}
		System.out.println("=================================");
	}
	void methodB(Vector v){
	//Vector에는 여러개의 Object를 담을 수 있다.
	//Vector에 들어있는 값 출력해 보기	
		for(int i=0;i<v.size();i++){
			System.out.println(v.get(i));
		}
	}
/*	void methodA(String name){
		System.out.println("name:"+name);
	}*/
	void methodA(Object obj){
		//너 소나타 타입이니?
		if(obj instanceof Sonata){
			Sonata herCar = (Sonata)obj;
			System.out.println(herCar);
		}
		//너 String타입이니?
		else if(obj instanceof String){
			String str = (String)obj;
			System.out.println(str);
		}
		else if(obj instanceof Integer){
			Integer it = (Integer)obj;
			System.out.println(it);
		}
		//너 Integer타입이니?
		System.out.println(obj);
	}
	public static void main(String[] args) {
		new InstanceOfOper();//생성자 호출
	}

}
