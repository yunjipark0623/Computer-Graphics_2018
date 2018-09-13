import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.Random;

public class RandomLine2DArt extends JApplet{
	private final static int MAX = 100;
	Random rndObj;
	private Color[] mColors = { Color.red, Color.green, Color.blue, 
							    Color.cyan, Color.black, Color.yellow, Color.gray, Color.magenta, 
							    Color.orange, Color.pink, Color.lightGray, Color.darkGray };
	
	public void init() {
		rndObj = new Random();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		Dimension d = getSize();
		int w = d.width;
		int h = d.height;
		int x1, y1, x2, y2;
		
		for(int i = 0; i < MAX; i++) {
			x1 = (int) (rndObj.nextDouble() * w);
			y1 = (int) (rndObj.nextDouble() * h);
			x2 = (int) (rndObj.nextDouble() * w);
			y2 = (int) (rndObj.nextDouble() * h);
			
			Line2D line = new Line2D.Double(x1, y1, x2, y2);
			g2.setPaint(mColors[i % mColors.length]);
			g2.draw(line);
		}
	}
}

/*
 * <APPLET code = "Random2DArt.class" width = 400 height = 300>
 * </APPLET>
 */
