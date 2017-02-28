package com.ch2;

public class MoonWeightApp {
	double moonWeight(double earth)
	{
		double w = 0.0;
		w = earth*0.17;
//		w = (earth*17)/100;
		return w;
	}
	/*
	 * 1.static안에서 non-static을 호출할 때에는
	 *   반드시 객체 생성할 것.
	 * 2.똑같은(non-static:non-static,
	 *   static:static) 상황이면 객체생성 없이 
	 *   바로 호출 가능하다. 
	 */
	public static void main(String[] args) {
		//System.out.println(args[0]);//60
		//System.out.println(args[0]+10);//6010
		String su = args[0];
//		int i = args[0];
		double earth = Double.parseDouble(args[0]);
		//System.out.println(earth+10);//6010
		//insert here - 메소드 호출
		MoonWeightApp mwapp = new MoonWeightApp();
		double w = mwapp.moonWeight(earth);
		System.out.println("지구몸무게:"+su);
		System.out.println("달  몸무게:"+w);
	}

}
