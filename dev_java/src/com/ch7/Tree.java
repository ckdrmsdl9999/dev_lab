package com.ch7;

public class Tree {
	String name = null;
	public Tree(){
		this("�ҳ���");
		System.out.println("Tree����Ʈ ������ ȣ��");
	}
	public Tree(String name){
		this.name = name;
		System.out.println("Tree(String) ������ ȣ��");
	}
	public static void main(String[] args) {
		new Tree();
	}

}
