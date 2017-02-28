package com.ch4;
class Param{
	int ival;
}
public class TestParam {
	void effectParam(Param p){
		p = new Param();
		p.ival = 500;
		//insert here -> sub ival=> ?  500  500
		System.out.println("sub ival ==> "+p.ival);
	}
	//13-14-15-16-17-6-7-8-10-19
	public static void main(String[] args) {
		TestParam tp = new TestParam();
		Param p = new Param();
		p.ival = 100;
		tp.effectParam(p);
		//insert here -> main ival=> ?  500   500
		System.out.println("main ival ==> "+p.ival);
	}

}
