package com.ch2;
/***********************************************
 * ������ ������ �� �ִ�. ���?
 * ���θ޼ҵ�� entry point�̴�. - ���ξ������� ���� �� �ִ�.
 * ���θ޼ҵ�� �ݵ��
 * public:���������� 
 * static:�����̴�. �����ȴ�.
 * �����տ� �� �� �ִ�.
 * �޼ҵ�տ� �� �� �ִ�.
 * ��ü ����(HelloWorld hw = new HelloWorld();)
 * ���� ����� �� �ִ�.
 * void : ���ϰ��� ����. ��ȯ���� ����.
 * �޼ҵ� �̸��� main�̴�.
 * �޼ҵ��� ���� - ����� ���� �޼ҵ�, �����Ǵ� �޼ҵ�
 * String[] args - �迭�̴�.
 * �迭�� ������ �����̴�.-ȣ���ϸ� �ּҹ����� ��µȴ�(16����)
 **********************************************/
public class VariableTest2 {
	static void go(int x){
		x=2;
		System.out.println(x);//2
	}
	static void go(double x){
		System.out.println(x);
	}
	public static void main(String[] args) {
		int x = 1;//1
		int y = x;//1
		int z;//��������
		z = 5;
		y = y + z;
		System.out.println(z);
		VariableTest2.go(10);
		go(10.5);
		System.out.println(args);
		System.out.println("args[0]:"+args[0]);
		System.out.println("args[1]:"+args[1]);
		go(Integer.parseInt(args[0]));
	}

}
