import java.awt.*;
import javax.swing.*;

public class LabelClass extends JLabel{
	public void paint(Graphics g) {
		g.drawRect(10, 10, 100, 50);//(10,10)중심으로 가로 100 세로 50인 직사각형
		g.drawRect(50, 50, 150, 70);//(50,50)중심으로 가로 150 세로 70인 직사각형 
	}
}
