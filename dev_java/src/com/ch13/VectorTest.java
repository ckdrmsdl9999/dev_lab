package com.ch13;

import java.util.List;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		List<String> breadList = new Vector<String>(5);
		String cbread[] = {"档呈明","积农覆户","萍扼固胶","档呈明","积农覆户"};
		for(int i=0;i<cbread.length;i++){
			breadList.add(i,cbread[i]);
		}
		for(String bread:breadList){
			System.out.println(bread);
		}
		for(int i=0;i<breadList.size();i++){
			if("档呈明".equals(breadList.get(i))){
				breadList.remove("档呈明");
				break;
			}
		}
		System.out.println("=================================================");
		for(String bread:breadList){
			System.out.println(bread);
		}
	}

}
