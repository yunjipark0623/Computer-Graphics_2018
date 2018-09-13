import java.awt.*;
import javax.swing.*;
import java.applet.Applet;
import java.awt.geom.*;

public class CurvePanel2 extends JPanel {
	Point2D start, end, control;
	QuadCurve2D curve;
	
	//바탕을 칠하기 위해 사각 객체 참조를 선언합니다.ㅌ
	Rectangle bckArea;
	
	public CurvePanel2() {
		start = new Point2D.Double();
		end = new Point2D.Double();
		control = new Point2D.Double();
		curve = new QuadCurve2D.Double();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		//패널의 사이즈로 사각 영역 객체를 생성합니다.
		Dimension dim = getSize();
		bckArea = new Rectangle(dim);
		
		//Graphics2D의 setPaint() 메소드로 색상을 지정한 다음 fill() 메소드로 형태를 칠합니다.
		g2.setPaint(Color.yellow);
		g2.fill(bckArea);
		
		double w = dim.width;
		double h = dim.height;
		double interval = w/(2 * 15);
		double cX = w * 0.5;
		double cY = h * 0.5;
		double x = 0;
		
		for (int n = 0; n < 15; n++) {
			x += interval;
			start.setLocation(x, h - 1);
			end.setLocation(w - x, h - 1);
			control.setLocation(cX, cY - x * 2);
			g2.setPaint(Color.blue);
			g2.setStroke(new BasicStroke(3.0F));
			curve.setCurve(start, control, end);
			g2.draw(curve);
		}
	}
}

/*
 * <APPLET code = "QuadCurveApplet2.class" width = 500 height = 400>
 * </APPLET>
 */
