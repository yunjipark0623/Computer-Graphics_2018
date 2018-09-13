import java.awt.*;
import javax.swing.*;

public class RoundRect extends JApplet {
	public void paint(Graphics g) {
		g.drawRect(50, 50, 40, 90);
		g.fillRoundRect(90, 50, 80, 50, 10, 10);
	}

}
