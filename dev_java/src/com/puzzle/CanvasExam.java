package com.puzzle;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;

class MyCanvas extends Canvas
{
	public void paint(Graphics g){
		System.out.println("paint ȣ��");
		g.setColor(Color.red);
		g.drawRect(20, 20, 100, 100);
	}
}
public class CanvasExam {

	public static void main(String[] args) {
		//JFrame�� ����Ʈ ���̾ƿ��� 
		//BorderLayout�̴�.
		JFrame jf = new JFrame();
		//jf.setLayout(new GridLayout(4,1));
		MyCanvas mc = new MyCanvas();
		jf.setLocation((int)200.5, 200);
		jf.setResizable(false);
		jf.add("Center",mc);
		jf.setSize(200, 200);
		jf.setVisible(true);
	}

}
