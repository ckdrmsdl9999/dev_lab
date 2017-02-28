package com.ch2;

public class JFrameTest {

	public static void main(String[] args) {
		javax.swing.JFrame jf = 
				new javax.swing.JFrame();
		//insert here
		int width = 300;
		int height = 200;
		String title = "전자계산기";
		jf.setTitle(title);
		jf.setSize(width, height);
		jf.setVisible(true);
	}

}
