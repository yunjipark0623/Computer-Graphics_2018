import java.awt.*;
import javax.swing.*;

public class SineAni extends JApplet{
	private Graphics offScreenBuffer = null;
	private Image offScreenImage = null;
	
	private int width;
	private int height;
	
	private int baseY = 150;
	private int currentX = 0;
	private int currentY = baseY;
	
	public void init() {
		setSize(800, 300);
		Dimension d = getSize();
		width = d.width;
		height = d.height;
		offScreenImage = this.createImage(width, height);
		offScreenBuffer = offScreenImage.getGraphics();
	}
	
	public void update(Graphics gc) {
		paint(gc);
	}
	
	public void paint(Graphics gc) {
		offScreenBuffer.setColor(Color.lightGray);
		offScreenBuffer.fillRect(0,  0,  width,  height);
		
		offScreenBuffer.setColor(Color.red);
		drawSine(offScreenBuffer, gc);
	}
	
	public void drawSine(Graphics gc, Graphics gcMain) {
		for(int angle = 0; angle < width; angle += 10) {
			currentX = angle;
			currentY = -(int)(Math.sin (angle * Math.PI / 180) * 100);
			drawCircle(gc, currentX,currentY + baseY);
			gcMain.drawImage(offScreenImage,  0,  0,  this);
			
			try {
	            Thread.sleep(30);
	        } catch (Exception e) {
	            //TODO: handle exception
	        }
		}
	}
	
	public void drawCircle(Graphics gc, int xCoord, int yCoord) {
		gc.setColor(Color.white);
//		gc.fillRect(0, 0, width, height);
		gc.setColor(Color.red);
		gc.fillOval(xCoord, yCoord, 10,  10);
	}
}

/*
<APPLET code = "SineAni.class" width = 600 height = 300>
</APPLET>
*/