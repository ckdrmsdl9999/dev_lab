package com.ch4;

public class BreakTest {
	void forToWhile()
	{
		int i=0;
		int hap=0;
		while(i<100){
			++i;
			System.out.println(i);
			hap = hap+i;//if�� �տ� ���� �� 50���� ����
			if(i==50){
				break;//16������ ����ȴ�.
			}///////end of if
			System.out.println
			("break���� ������ �Ǹ� ��µ��� �ʽ��ϴ�.");
		}///////////end of while
		System.out.println("����");
		System.out.println("hap ===> "+hap);		
	}
	public static void main(String[] args) {
		int i=0;
		int hap=0;
		BreakTest bt = new BreakTest();
		bt.forToWhile();
/*		for(i=1;i<101;i++){
			System.out.println(i);
			hap = hap+i;//if�� �տ� ���� �� 50���� ����
			//ī��Ʈ ������ 50�̸� for�� Ż���ϱ�
			if(i==50){
			//break���� ������ �Ǹ� �ݺ����� Ż��	
				break;//16������ ����ȴ�.
			}///////end of if
			//hap = hap+i;50�� ��� ������ �ȵȴ�.
			System.out.println
			("break���� ������ �Ǹ� ��µ��� �ʽ��ϴ�.");
		}///////////end of for
		System.out.println("����");
		System.out.println("hap ===> "+hap);
 */		
		
	}

}
