package com.ch7;
class Outter{
	int i;
	class Inner{
		int j;
		void print(){
			System.out.println
			("Inner print ȣ�� ���� ");
		}
	}
	void go(){
		System.out.println("Outter goȣ�� ����");
	}
}
public class OuterInnerTest {

	public static void main(String[] args) {
		Outter outt = new Outter();
		outt.go();
		//insert here - print�޼ҵ� ȣ���ϱ�.
		Outter.Inner inn = 
				new Outter().new Inner();
		Outter.Inner inn2 = outt.new Inner();
		inn.print();
		inn2.print();
		inn.go();
	}

}



