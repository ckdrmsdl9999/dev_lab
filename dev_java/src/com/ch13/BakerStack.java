package com.ch13;

import java.util.List;
import java.util.Vector;

public class BakerStack {
	List<String> breadList = 
			new Vector<String>(9);
	//���� �������� �޼ҵ�
	public synchronized String pop(String cbread){
		String bread = null;
		for(int i=0;i<breadList.size();i++){
			if(cbread.equals(breadList.get(i))){//������ �ּ���? - ��
				breadList.remove(cbread);
				break;
			}
			else{
				try {
					System.out.println("���� �����ϴ�. ��ø� ��ٷ��ּ���.");
					wait();//����� ���¸� �����ϱ� ���� ����Ѵ�.
				} catch (InterruptedException e) {
					System.out.println("��~~~ �� ��~~~~~~~");
				}
			}
		}//////////////////// end of for
		return bread;
	}
	
	//���� �����ϴ� �޼ҵ�
	public synchronized void push(String bread)
	{
		System.out.println("��ٷ��ּż� �����մϴ�."+bread+" ����������.");
		notify();
		//�����뿡 �� �߰��ϱ�
		breadList.add(bread);
	}
}
