package com.ch4;

public class GuGuDan {
	public static void main(String[] args) {
	//������ �Ʒ��� ����ϱ�	
		for(int i=2;i<10;i++){
			for(int j=1;j<10;j++){
				System.out.println(i+"*"+j+"="+(i*j));
			}
		}
		System.out.println("========================");
	//������ ���������� ����ϱ�	
		for(int j=1;j<10;j++){
			for(int i=2;i<10;i++){
				System.out.print(i+"*"+j+"="+(i*j)+" ");
			}
			System.out.println();
		}
		System.out.println("========================");
		int i=2;
		int j;
		while(i<10){
			j=1;//�ʱ�ȭ�� ��ġ �߿��ϴ�.
			while(j<10){
				System.out.println(i+"*"+j+"="+(i*j));
				j++;
			}//////// end of inner while
			++i;
		}//////////// end of outter while
		System.out.println("========================");
		//i=2;
		j=1;
		while(j<10){
			i=2;//���� i�� �ܼ��̴�.
			while(i<10){
				System.out.print(i+"*"+j+"="+(i*j)+" ");
				i++;
			}//////// end of inner while
			System.out.println();
			++j;
		}//////////// end of outter while
	}

}






