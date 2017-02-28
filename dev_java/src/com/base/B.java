package com.base;
class Super{
	public float getNum(){
		return 3.0f;
	}
}
class Sub extends Super
{
/*	public int getNum(){
		return 4.0f;
	}*/
}
public class B {

	public static void main(String[] args) {
		int i=0;
		int j=5;
		tp:for(;;){
			i++;
			for(;;){
				if(i>--j) break tp;
			}
		}
		System.out.println("i:"+i+" j:"+j);
	}

}
