package com.ch6;
/*****************************************************************************************
 * ���� ȣ���ϴ� ���
 * 1)call by value(����Ÿ��) - ���纻
 * 2)pass by value(����Ÿ��) - ����
 * �����ڸ� ȣ���ϴ� ���
 * new Galaxy7();
 * new Galaxy7(true);
 * new Galaxy7(true,false);
 * new Galaxy7(true,false,"���");
 ****************************************************************************************/
public class Galaxy7 {
	boolean power;//false
	boolean wifi;//false
	String color;//null
	//�����ڵ� non-static�����̹Ƿ� ���ȿ� �ִ� ����
	//Ȥ�� �޼ҵ带 ��ü�������� ���� ȣ���� �� �ִ�.
	public Galaxy7(){//����Ʈ �����ڿ��� ���������� ���� �ʱ�ȭ 
		//������ ȣ��
		System.out.println("������ ȣ�� ����");
		power = false;
		wifi = false;
		color = "���";
		isOnOff();
	}
	public Galaxy7(boolean power){
		//power = true;
		this.power = power;
	}
	public Galaxy7(boolean power, boolean wifi){
		
	}
	public Galaxy7(boolean power, boolean wifi, String color){
		
	}
	public boolean isOnOff(){
		System.out.println("isOnOff ȣ�� ����");
		if(power) power = false;
		else power = true;
		return power;
	}
	public boolean isWifi(){
		if(wifi) wifi = false;
		else wifi = true;
		return wifi;
	}
	//�޼ҵ� �������̵�.
	public String toString(){
		String name = "���� ������7 �Դϴ�.";
		return name;
	}
}
