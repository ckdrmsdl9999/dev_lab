package com.ch7;

import java.util.List;

/****************************************************************
 * �߻� Ŭ���� �����ϱ�
 * :�ܵ����� �ν��Ͻ�ȭ �� �� ����.
 * :�ݵ�� ����ü Ŭ������ ������ �Ѵ�.
 * �Ϲݺ��� ���� �� �ִ�.
 * �Ϲݸ޼ҵ� ���� �� �ִ�.
 * �߻�޼ҵ� ���� �� �ִ�.
 ***************************************************************/
public abstract class Duck {
	int eye;
	int leg;
	public Duck(){
		
	}
	public abstract void display();
	public void swimming()
	{
		System.out.println("��� ������ ���� ���.");
	}
}
