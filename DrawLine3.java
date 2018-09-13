import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;

public class DrawLine3 extends JApplet{
	public void init() {
		setSize(300, 200);
	}
	public void paint(Graphics g) {
		g.drawRect(0, 0, 299, 199);
		for (int i = 0; i <10; i++) {
			g.drawLine(0, 0, 30 + (30 * i), 199);//시작점 고정시키고 끝좌표 조정하기 
		}
	}
}

/*
 * <APPLET code = "DrawLine3.class" width = "300" height = "200">
 * </APPLET>
 */
