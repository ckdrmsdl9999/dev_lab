package com.ch7;

import javax.swing.JButton;
/*
 * ���� �ٸ� Ÿ���� ���߾� ����� �� �ִ�.
 * - ĳ���ÿ�����(��Ӱ���), ����ȯ�޼ҵ�(�Ķ���Ϳ� ����Ÿ��)
 * WrapperŬ����
 * int - Integer
 * double - Double
 * float - Float
 * boolean - Boolean
 * long - Long
 */
public class CastingTest {
	void go(Object obj){
		if(obj instanceof String){
			
		}
		else if(obj instanceof JButton){
			
		}
		else if(obj instanceof Integer){
			
		}
	}
	public static void main(String[] args) {
		//insert here - go�޼ҵ� ȣ��
		Integer it = new Integer(100);
		System.out.println("Integer it : "+it);
		int i = 10;
		i = it;//autoboxing
		int j = it.intValue();
		System.out.println("i : "+i);
		double d = 3.14;
		i = (int)d;
		double d1 = 1.5;
		d1 = i;
		Object obj = "�̼���";
		String name = "�̼���";
		name = (String)obj;
		name = obj.toString();
		obj = name;
		JButton jbtn_exit = new JButton("����");
		Object obj1 = jbtn_exit;
		if(jbtn_exit instanceof JButton){//�� ��ưŸ���̾�
			System.out.println("JButtonŸ�� �Դϴ�.");
		}else{
			System.out.println("JButtonŸ���� �ƴϴ�.");
		}
		//if(name){}
		System.out.println(jbtn_exit.getClass());
		
		Object myObj = new Object();
		
	}

}






