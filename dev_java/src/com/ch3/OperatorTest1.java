package com.ch3;

public class OperatorTest1 {

	public static void main(String[] args) {
		int i=1;
		int j=2;
		if((++i>j--)&(i>=j++)){
			System.out.println("���϶�");
		}else{
			System.out.println("�����϶�");
		}
		System.out.println("i:"+i+", j:"+j);
		System.out.println("=======================");
		i=1;
		j=2;
		if((++i>j--)&&(i>=j++)){
			System.out.println("���϶�");
		}else{
			System.out.println("�����϶�");
		}
		System.out.println("i:"+i+", j:"+j);
		System.out.println("=======================");
		i=1;
		j=2;
		if((i--<++j)|(++i>--j)){
			System.out.println("���϶�");
		}else{
			System.out.println("�����϶�");
		}
		System.out.println("i:"+i+", j:"+j);
		System.out.println("=======================");
		i=1;
		j=2;
		if((i--<++j)||(++i>--j)){
			System.out.println("���϶�");
		}else{
			System.out.println("�����϶�");
		}
		System.out.println("i:"+i+", j:"+j);
	}

}
