package com.ch2;

public class VariableTest {

	public static void main(String[] args) {
		//insert here - ���� �� �� �����ϱ�
		int x = 1;
		int y = 2;
		//insert here - �� ���� ���� ���� ���� �����ϱ�
		int result = 0;
		//insert here - �� ���� �� ����� result������ ���
		result = x+y;//3
		System.out.println("�� ���� ��:"+result);//3
		//insert here - ù��°���� �ι�° ������ ����
		//�� �Ŀ� ������� result������ ��ƺ�����.
		result = x-y;//-1
		System.out.println("�� ���� ��:"+result);//-1
		//result = 0;�ּ����� �ϸ� result���� -1��
		//�ʱ�ȭ �Ǿ��־ 1���� 5������ ���� 14�� �ǰ�
		//result=0�� �ּ�ó�� ���ϸ�
		//result�� �ʱ�ȭ�� 0���� �Ǿ� �Ʒ� �������
		//������ ��ġ�� �ʴ´�.
		for(int i=1;i<=5;i=i+1){
			result = result+i;
		}
/*		result = result +1;
		result = result +2;
		result = result +3;
		result = result +4;
		result = result +5;*/
		System.out.println
		("1����5����������:"+result);//15
	}

}





