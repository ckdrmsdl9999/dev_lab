package com.ch13;

public class WaitNotifyTest {

	public static void main(String[] args) {
		BakerStack bs = new BakerStack();
		//6���� �����带 �����Դϴ�.
		//start�޼ҵ��� ȣ�� ������ ������ �����ϴ�.
		//���� ���� �����ϴ��Ŀ� ���� ���� ������ �Ź� �޶��� ���� 
		//�ֽ��ϴ�.
		//������ ���� ������ ����ġ�� ���� �ʾ����Ƿ� ��� 5�̸�
		//���� ������ �����尡 6�� �����˴ϴ�.
		//����� ���� ������ �簡�� ���� �̸��� ������ �ʾҽ��ϴ�.
		//�����Ͽ� �ҽ��� �м��� ���� �簡�� ���� �̸��� ���ؼ� 
		//�簡�� �����ϵ��� �غ�����.
		//�����忡 ���ؼ� ����ġ�� �� �� �ִ�.
		//����Ʈ 5�̴�.(Thread.yield():���� ����� �����忡�Ը� �纸 �Ѵ�.)
		/*
		 * �����߿� �ڽſ��� �־��� ���ʸ� �ٸ� �����忡�� �纸�ϰ� �ڽ��� ������ ����
		 * �� ����.
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
