package com.ch6;
/******************************************************************
 * String
 * 1)����Ÿ�԰� ���� ������� �ʱ�ȭ�� �� �ִ�. String s = "�߱�����"; 
 *  :������ ���� ���ڿ��� ���� String�� �����ϸ� ���� �������� �ʰ�
 *   ������ ���ڿ��� ���� ���� �Ѵ�.
 *  :�� ���� �ٸ� ������ ���� �ּҹ����� ���´�.
 * 2)�ν��Ͻ�ȭ�� ���ؼ��� �ʱ�ȭ�� �� �ִ�.
 *   String s = new String("�߱�����");
 *   :���� ���ڿ��̶� �Ź� ���� ��ü�� �ε��ȴ�.
 *   
 * �����ڸ� ȣ���� �� ���� Ÿ���� ������ ���ο� ��ü�� �������� 
 * ���̴�.  
 ******************************************************************/
public class StringTest {

	public static void main(String[] args) {
		int i = 10;//������Ÿ��
		String s = "�߱�����";//������Ÿ��, ������ ȣ�� ����.
		String str = new String("�߱�����");//������ ȣ��
		String str1 = new String("���ڰ���");//������ ȣ��
		String str2 = "�߱�����";
		System.out.println(i==10);//true
		//�ּҹ����� ����?
		System.out.println(s==str);//false
		System.out.println(s==str2);//false
		//�ּҹ����� �����ϴ� ���ڿ��� ����?
		System.out.println(s.equals(str));//true
		//
		System.out.println(s.equals(str1));//false
		System.out.println(str.length());//4
		System.out.println("�߱�����".length());//4
		new String("�߱�����");
		System.out.println(new String("�߱�����").length());//4
		System.out.println(new String("�߱�����").length());
	}

}