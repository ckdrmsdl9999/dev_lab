package com.ch7;

public interface Volume {
	//int i;
	//final int i;
	//static int j;
	final static int i=10;
	int j = 10;
	//public Volume(){}
	//public void go(){}
	public abstract void come();
	//���ܸ� ������.
	//����ó���� ���� ȣ���� ������ ��������.
	//����ó���� ���� ���� �ʰڴ�.
	public abstract void volumeUp() throws NullPointerException;
	public abstract void volumeDown() throws NullPointerException, Exception;
}
