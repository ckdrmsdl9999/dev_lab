package com.ch11;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
	//���� �����ϴ� �޼ҵ� - ��ũ���� | �ٰ�Ʈ | ���ڻ�
	public String getBread(){
		String bread = null;
		switch((int)(Math.random()*3)){
		case 0:
			bread = "��ũ����";
			break;
		case 1:
			bread = "�ٰ�Ʈ";
			break;
		case 2:
			bread = "���ڻ�";
			break;
		}
		return bread;
	}
	//�������븦 ������ ���� - ArrayList�����Ͻÿ�.
	//List<��> ������Ʈ = new ArrayList<��>();
	public List<String> push(){
		List<String> breadList = new ArrayList<String>();
		for(int i=0;i<20;i++){
			breadList.add(getBread());
		}
		return breadList;
	}
	public void push(List<String> breadList){
		for(int i=0;i<20;i++){
			breadList.add(getBread());
		}
	}	
}










