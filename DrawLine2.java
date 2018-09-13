import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;

public class DrawLine2 extends JApplet {
	public void init() {
		setSize(300, 100);
	}
	public void paint(Graphics g) {
		g.drawLine(10, 10, 250, 10);//(10,10)위치부터 (250,10)까지 직선 그리기 
		g.drawLine(10, 60, 250, 60);//(10,60)위치부터 (250,60)까지 직선 그리기 
		g.drawString("Java Graphics!", 50, 40);//(50,40)위치에 문자열 그리기 
	}
}

/*
 * <APPLET code = "DrawLine2.class" width = "300" height = "100">
 * </APPLET>
 */
