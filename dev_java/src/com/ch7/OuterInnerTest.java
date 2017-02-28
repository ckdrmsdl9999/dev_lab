package com.ch7;
class Outter{
	int i;
	class Inner{
		int j;
		void print(){
			System.out.println
			("Inner print 호출 성공 ");
		}
	}
	void go(){
		System.out.println("Outter go호출 성공");
	}
}
public class OuterInnerTest {

	public static void main(String[] args) {
		Outter outt = new Outter();
		outt.go();
		//insert here - print메소드 호출하기.
		Outter.Inner inn = 
				new Outter().new Inner();
		Outter.Inner inn2 = outt.new Inner();
		inn.print();
		inn2.print();
		inn.go();
	}

}



