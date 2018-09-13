import java.awt.*;
import javax.swing.*;

public class DrawRect extends JApplet{
	public void paint(Graphics g) {
		g.setColor(Color.black);//색깔 검정으로 설정 
		g.drawRect(10, 10, 100, 50);//(10,10)위치에 가로 100 세로 50인 사각형 그리기 
		g.drawRect(50, 50, 150, 70);//(50, 50)위치에 가로 150 세로 70인 사각형 그리기 
	}
}

/*
 * <APPLET code = "DrawRect.class" width = "300" height = "200">
 * </APPLET>
 */
