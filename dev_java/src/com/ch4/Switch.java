package com.ch4;

public class Switch {

	public static void main(String[] args) {
		int i = 1;
		//i = 3;
		switch(i){
		case 0:
			i++;
			break;//switch����� Ż���Ѵ�.
		case 1:
			i++;//2
			break;
		case 2:
			i++;//3
			break;
		default:
			i++;//4
			break;
		}
		//insert here - i�� ���ϱ��?
		System.out.println(i);
	}

}
