package com.ch15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {
		String path = "src\\com\\vo\\";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(path+"DeptVO.java");
			fos = new FileOutputStream(path+"DeptVO2.java");
			int data = 0;
			//data = fis.read();
			while((data=fis.read())!=-1){
				//char ch = (char)data;
				//System.out.print(ch);
				fos.write(data);
			}
		} catch (IOException ie) {
			// TODO: handle exception
		} finally{
			try {
				if(fos!=null) fos.close();
				if(fis!=null) fis.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
