import java.awt.*;
import javax.swing.*;

public class DrawArc extends JApplet{
	public void paint(Graphics g) {
		g.drawArc(10, 10, 80, 80, 0, 90);//(10,10)중심으로 가로 80 세로80인 사각형 안에 0도부터 90도까지인 호 그리기 
		g.fillArc(100, 10, 80, 80, 10, 90);//(100,10)중심으로 가로80 세로 80인 사각형안에 10도부터 90도까지 꽉차있는 호 그리기 
		
		g.drawArc(10, 100, 80, 80, 0, -90);//음수는 반시계방향
		g.fillArc(100, 100, 80, 80, 10, -90);
	}
}

/*
 * <APPLET code = "DrawArc.class" width = "300" height = "200">
 * </APPLET>
 */
