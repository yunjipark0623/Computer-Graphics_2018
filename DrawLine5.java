import java.awt.*;
import javax.swing.*;

public class DrawLine5 extends JApplet{
	public void paint(Graphics g) {
		g.drawRect(0, 0, 299, 199);
		g.setColor(Color.red);
		for (int i = 0; i < 20; i++) {
			g.drawLine(0, 10 * i, 15 * i, 199);
		}
		for (int i = 0; i < 20; i++) {
			g.drawLine(15 * i, 199, 299, 199 - (10 * i));
		}
	}
}

/*
 * <APPLET code = "DrawLine5.class" width = "300" height = "200">
 * </APPLET>
 */
