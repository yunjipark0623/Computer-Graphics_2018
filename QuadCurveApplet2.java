import java.awt.*;
import javax.swing.*;
import java.applet.Applet;
import java.awt.geom.*;

public class QuadCurveApplet2 extends JApplet {
	CurvePanel2 curvePanel = new CurvePanel2();
	
	public void init() {
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(curvePanel);
	}
}
