package com.ch5;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TwoArray2 extends JFrame {
	public void arrayTest(){
		JTextField jtfs[] = null;
		jtfs = new JTextField[3];
		JTextField jtfs2[][] = null;
		jtfs2 = new JTextField[3][3];
	}
	public void buttonArray(){
		JButton jbtns[][] = new JButton[3][3];
		for(int i=0;i<jbtns.length;i++){
			System.out.println(jbtns[i]);//1차 배열을 거느리고 있는 배열명
		}
		jbtns[1][2] = new JButton("jbtns[1][2]");
		jbtns[1][2].setText("글자색");
		//jbtns[1] = new JButton[3];
		jbtns[1][1] = new JButton("jbtns[1][1]");
		//this.add("Center",jbtns[0][1]);
		this.add("Center",jbtns[1][1]);
		this.add("North",jbtns[1][2]);
		this.setSize(300, 200);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		TwoArray2 ta2 = new TwoArray2();
		ta2.buttonArray();
		int is[][] = new int[3][3];
/*		for(int i=0;i<is.length;i++){
			//주소번지 3개가 출력됩니다.
			System.out.println("is["+i+"]="+is[i]);
			System.out.println(is[0][1]);//0
		}*/
	}

}
