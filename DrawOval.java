import java.awt.*;
import javax.swing.*;

public class DrawOval extends JApplet {
	Color[] color;
	Font font1;
	Font font2;
	
	public void init() {
		setSize(400,400);
		color = new Color[5];
		
		color[0] = Color.black;
		color[1] = Color.red;
		color[2] = Color.blue;
		color[3] = Color.yellow;
		color[4] = Color.orange;
	}
	
	public void paint(Graphics g) {
		for(int i = 0; i < 15; i++) {
			g.setColor(color[i%5]);//색깔이 5개여서 5로 나눔 세개면 3으로 나눔 
			g.drawOval(250-(i*15), 190-(i*15), i*15, i*15);
		}
	}
}

/*
 * <APPLET code = "DrawOval.class" width = "300" height = "200">
 * </APPLET>
 */
