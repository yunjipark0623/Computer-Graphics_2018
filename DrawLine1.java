import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;

public class DrawLine1 extends JApplet{
	public void init() {
		setSize(300, 150);
	}
	public void paint(Graphics g) {
		g.drawLine(10, 10, 250, 100);//(10,10)부터 (250,250)까지 직선을 그린다 
	}
}

/*
 * <APPLET code = "DrawLine.class" width = "300" height = "150">
 * </APPLET>
 */
