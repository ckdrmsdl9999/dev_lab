package com.ch7;

public interface Volume {
	//int i;
	//final int i;
	//static int j;
	final static int i=10;
	int j = 10;
	//public Volume(){}
	//public void go(){}
	public abstract void come();
	//예외를 던진다.
	//예외처리를 나를 호출한 곳에서 받으세요.
	//예외처리를 내가 하지 않겠다.
	public abstract void volumeUp() throws NullPointerException;
	public abstract void volumeDown() throws NullPointerException, Exception;
}
