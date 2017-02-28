package com.ch6;

public class Pride2017 {
	int door = 0;
	public Pride2017(){
	//insert here
		//new Sonata2017();
		this.door = new Sonata2017().door;
		//this.door = Sonata2017.door;
	}
	public Pride2017(int door){
	}	
	public static void main(String[] args) {
		Pride2017 pri = new Pride2017();
		System.out.println("µµ¾î ¼ö : "+pri.door);//4
	}

}
