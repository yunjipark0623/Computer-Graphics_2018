import java.awt.*;
import java.applet.*;
import javax.swing.*;


public class star_moon extends JApplet{
	int[] coordX1 = {0, 100, 20, 50, 80, 0};
	int[] coordY1 = {40, 40, 100, 0, 100, 40};
	
	public void paint(Graphics g) {
		g.setColor(new Color(0, 255, 0));
		g.fillPolygon(coordX1, coordY1, 5);
		
		g.setColor(Color.yellow);
		g.fillArc(20,  120,  60,  60, 0, 180);
		
		g.setColor(Color.red);
		g.drawOval(20,  120,  60,  60);
		
		g.drawArc(20,  140,  30,  30,  0,  180);
		g.drawArc(50,  140,  30,  30,  0,  -180);
	}
}
