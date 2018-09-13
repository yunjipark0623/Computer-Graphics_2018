import java.applet.Applet;
import java.awt.*;
import javax.swing.*;

public class Drawline extends Applet{
	
	Font gulim;

	public void init() {
		setSize(400, 400);
		gulim = new Font("굴림", Font.BOLD, 15);	
	}
	
	public void paint(Graphics g) {
		
		g.setFont(gulim);
		g.setColor(Color.black);
		g.drawString("2016108267", 100, 60);
		g.drawString("박윤지", 127, 90);
		
		g.drawRect(0,  0,  299,  199);
		g.setColor(Color.blue);
		for(int i = 0; i < 20; i++) {
			
		g.drawLine(0,  10 * i,  15 * i, 199);		
		}
		
		for (int i = 0; i < 20; i++) {
			g.drawLine(15 * i, 199, 299, 199 - (10 * i));		
		}
	}
}
