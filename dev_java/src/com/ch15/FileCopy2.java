package com.ch15;

import java.io.FileReader;
import java.io.IOException;

public class FileCopy2 {

	public static void main(String[] args) {
		String path = "src\\com\\vo\\";
		try {
			FileReader fis = 
					new FileReader(path+"DeptVO.java");
			int data = 0;
			//data = fis.read();
			while((data=fis.read())!=-1){
				char ch = (char)data;
				System.out.print(ch);
			}
		} catch (IOException ie) {
			// TODO: handle exception
		}
	}

}
