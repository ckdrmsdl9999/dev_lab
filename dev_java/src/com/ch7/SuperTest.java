package com.ch7;
/*****************************************************************
 * �ڹٿ����� ���� �̸��� �޼ҵ带 �ߺ� ���� �� �� �ֽ��ϴ�.
 * ��Ģ
 * ������� : �ݵ�� �޼ҵ��� �̸��� ���ƾ� �մϴ�.
 * �߰����� : ���� ��Ӱ��迡 ���� ��(�������̵��� ���)	
 *  �޼ҵ� �������̵�
 *  �ݵ�� ����ΰ� ��ġ�ؾ� �Ѵ�.
 *  :����Ÿ���̳� �Ķ���͸� ������ �� ����.
 *  :���������ڴ� �� ���� ?
 *
 *  �޼ҵ� �����ε�
 *  �ݵ�� �Ķ������ ������ �ٸ��ų� 
 *  �Ǵ� �Ķ������ Ÿ���� �޶�� �մϴ�.
 *  :����Ÿ���� �ְ� ����� ������ ����.
 *  :���������ڰ� �ְ� ����� ������ ����.
 *  :���ܸ� ������ ������ �ʰ�� ������ ����.
 * 
 *	this-�ڱ� �ڽ� & super-�θ�Ŭ����
 *  this() & super()
 ****************************************************************/
class Father{
	String name = null;
	int age = 0;
	//�����ڴ� �����ε� ��Ģ�� �ؼ��մϴ�.
	Father(){
		System.out.println("Father ȣ�� ����");
	}
	Father(String name){
		
	}
	Father(String name, int age){
		
	}	
	public void go(){
		System.out.println("Father go ȣ�� ����");
	}
	public void come(){
		System.out.println("Father come ȣ�� ����");
	}
	//�޼ҵ� ����ο� final�� ���̸� 
	//�ڽ� Ŭ�������� �������̵� �Ұ�.
	public final void stop(){
		System.out.println("Father stop ȣ�� ����");
	}	
}
class Son extends Father{
	String blood = null;
	Son(){
		System.out.println("Son ȣ�� ����");
	}
	Son(String name){
		
	}
	Son(String name, int age){
		
	}	
	Son(String name, int age, String blood){
		
	}
/*	public int go(){�����߻�:�޼ҵ� �����ε� ��Ģ ���.
		return 0;
	}*/
	public void stop(){
		System.out.println("Father stop ȣ�� ����");
	}	
	@Override
	public void go(){//�޼ҵ� �������̵� ����
		System.out.println("Son go ȣ�� ����");
	}
	public int go(int x){//�޼ҵ� �����ε� ����
		return 0;
	}
	public int go(int x, int y){//�޼ҵ� �����ε� ����
		return 0;
	}
}
public class SuperTest {
/*
 * �θ�� �ڽİ��� �������̵� ���迡 �ִ� �޼ҵ� ������
 * ������� Ÿ�Կ� ������� ������ Ÿ���� �ڽ� Ÿ���� ��
 * �θ� Ŭ������ ���ǵ� �޼ҵ�� ������ �޼ҵ尡 �˴ϴ�.
 */
	public static void main(String[] args) {
		Father my = new Son();
		my.go();//Son go ���
		//insert here - father go����ϱ�
		Father him = new Father();
		him.go();//Father go���
		Son me = new Son();
		me.go();//Son go ȣ��
		my.come();//Father comeȣ��
		me.come();//Father comeȣ��
	}

}
