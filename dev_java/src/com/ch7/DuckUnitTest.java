package com.ch7;

public class DuckUnitTest {

	public static void main(String[] args) {
		Duck duck = null;
//		Duck duck = new Duck();�ܵ����� �ν��Ͻ�ȭ �Ұ�.
		//myDuck�� ����ü Ŭ������ MallardDuck�̴�.
		Duck myDuck = new MallardDuck();
		//herDuck�� ����ü Ŭ������ WoodDuck�̴�.
		Duck herDuck = new WoodDuck();
		//himDuck�� ����ü Ŭ������ RubberDuck�̴�.
		Duck himDuck = new RubberDuck();
		MallardDuck malDuck = new MallardDuck();
		WoodDuck wooDuck = new WoodDuck();
		RubberDuck rubDuck = new RubberDuck();
		duck = myDuck;
		duck = malDuck;
		duck = wooDuck;
		duck = rubDuck;
		//malDuck = wooDuck;
		//malDuck = rubDuck;
		//�����������̶�� �Ѵ�. - ������
		//����ο� �������� Ŭ���� Ÿ���� �ٸ� �� �������� 
		//���� �� �ִ�.
		//myDuck.display();//û�տ���
		//herDuck.display();//��������
		//himDuck.display();//������
		//insert here - ���� ���������Դϴٸ� ����Ͻÿ�.
//		malDuck = myDuck;���� �ʿ� �� ūŸ���� �� �� ����.
		herDuck = myDuck;
/*
 * ���
 * ����Ÿ���� ��쿡�� ��������ȯ �� �� �ִ�.
 * ����:�Ǽ��� ���� �� ����.
 * ����Ÿ���� ��쿡�� ��������ȯ �� �� �ִ�(���������� �չ�).
 * ��Ÿ�Խÿ��� ClassCastException�� ������.
 * :����Ÿ���� ��� ������ �����ʿ��� �ڽ�Ŭ������ ����ؾ� �Ѵ�.		
 */
		//malDuck = (MallardDuck)wooDuck;
		wooDuck = (WoodDuck)myDuck;
		wooDuck.display();
		MallardDuck mDuck = null;
		mDuck = malDuck;
	}

}









