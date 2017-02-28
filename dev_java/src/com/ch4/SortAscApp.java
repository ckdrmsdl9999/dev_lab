package com.ch4;

import java.util.Random;

public class SortAscApp {

	public static void main(String[] args) {
		int is[] = new int[5];
		for(int i=0;i<5;i++){
			Random r = new Random();
			is[i] = r.nextInt(1000);
		}
/*		for(int i:is){
			System.out.println(i);
		}*/
		int i,j,k,nTemp;
		for(i=0;i<is.length;i++){
			k = i;
			for(j=i+1;j<is.length;j++){
				if(is[j]<is[k]){
					k = j;
				}
			}
			nTemp = is[i];
			is[i] = is[k];
			is[k] = nTemp;
		}//////////////end of for
		for(int a:is){
			System.out.println(a);
		}
	}

}
