package com.ch8;

public class ExceptionExam2 {
	public ExceptionExam2(){
		try {
			test();
		} catch(NumberFormatException ne){
			System.out.println("NumberFormatException : "+ne.toString());
		} catch (Exception e) {
			System.out.println("Exception : "+e.toString());
		} finally{
			//������ ��찡 �ִ�.
			//����� �ڿ��� �ݳ��ؾ� �� �� - ��������... DBConnectionMgr�ڵ忡 ������ ����.
			System.exit(0);//�ڹٰ���ӽŰ� ������� ������ ���
			System.out.println("���� �߻��� ������� ������ ����");
		}
		System.out.println("����");
	}
	/*
	 * throws�� ���ܸ� ���� ȣ���� ������ ó�� ��������.
	 * throw�� ���ܸ� ���� ��.
	 * ���������� Ʈ����� ó���� ���ؼ� ���Ǳ⵵ �մϴ�.
	 * Ʈ�����ó���� �ϳ��� ������ �����ִ� ��.
	 */
	public void test() throws Exception
	{
		int i = 0;
		if(i<1){
			throw new NumberFormatException();
		}
	}
	public static void main(String[] args) {
		new ExceptionExam2();
	}

}
