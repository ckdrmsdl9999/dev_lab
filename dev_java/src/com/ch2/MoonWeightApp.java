package com.ch2;

public class MoonWeightApp {
	double moonWeight(double earth)
	{
		double w = 0.0;
		w = earth*0.17;
//		w = (earth*17)/100;
		return w;
	}
	/*
	 * 1.static�ȿ��� non-static�� ȣ���� ������
	 *   �ݵ�� ��ü ������ ��.
	 * 2.�Ȱ���(non-static:non-static,
	 *   static:static) ��Ȳ�̸� ��ü���� ���� 
	 *   �ٷ� ȣ�� �����ϴ�. 
	 */
	public static void main(String[] args) {
		//System.out.println(args[0]);//60
		//System.out.println(args[0]+10);//6010
		String su = args[0];
//		int i = args[0];
		double earth = Double.parseDouble(args[0]);
		//System.out.println(earth+10);//6010
		//insert here - �޼ҵ� ȣ��
		MoonWeightApp mwapp = new MoonWeightApp();
		double w = mwapp.moonWeight(earth);
		System.out.println("����������:"+su);
		System.out.println("��  ������:"+w);
	}

}
