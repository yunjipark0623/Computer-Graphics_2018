import java.awt.*;
import javax.swing.*;

public class DrawLine4 extends JApplet{
	public void paint(Graphics g) {
		g.drawRect(0, 0, 299, 199);//(0,0)중심으로 가로 299 세로 199인 사각형 그리기 
		g.setColor(Color.red);
		for (int i = 0; i < 20; i++) {
			g.drawLine(0, 10 * i, 15 * i, 199);
		}
	}
}

/*
<APPLET code = "DrawLine4.class" width = "300" height = "200">
</APPLET>
*/
