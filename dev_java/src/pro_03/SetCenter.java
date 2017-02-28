package pro_03;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class SetCenter {
	public SetCenter(JFrame that){
		Dimension frameSize = that.size();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((screenSize.getWidth()-frameSize.getWidth())/2);
		int y = (int) ((screenSize.getHeight()-frameSize.getHeight())/2);
		that.setLocation(x, y);
	}
}
