import java.awt.*;
import javax.swing.*;

public class CircleAni extends JApplet{
	private Graphics offScreenBuffer = null;
	private Image offScreenImage = null;
	
	private int width;
	private int height;
	
	private int basePointX = 300;
	private int basePointY = 250;
	
	private int currentX = basePointX;
	private int currentY = basePointY;
	
	private double offsetX = 0;
	private double offsetY = 0;
	
	private double slantLength = 60;
	private double slantAngle = 20;
	
	private double slantX = slantLength * Math.cos(slantAngle * Math.PI / 180);
	private double slantY = slantLength * Math.sin(slantAngle * Math.PI / 180);
	
	private double sineAngle1 = 0;
	private double cosineAngle1 = 0;
	
	private double sineAngle2 = 0;
	private double cosineAngle2 = 0;
	
	private int colorPartition = 45;
	
	private Color[] lineColors = {
			Color.red, Color.green, Color.blue, Color.yellow, Color.white, Color.magenta
	};
	
	private int colorCount = lineColors.length;
	
	public void init() {
		setSize(600, 550);
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
		offScreenBuffer.fillRect(0, 0, width, height);
		
		offScreenBuffer.setColor(Color.red);
		drawSpiral(offScreenBuffer, gc);
		
		gc.drawString("박윤지", 290, 250);
		gc.drawString("2016108267", 265, 265);
	}
	
	public void drawSpiral(Graphics gc, Graphics gcMain) {
		for(int angle = 0; angle < 1440; angle++) {
			sineAngle1 = Math.sin(angle * Math.PI / 180);
			cosineAngle1 = Math.cos(angle * Math.PI / 180);
			
			sineAngle2 = Math.sin(((110 / 20) + 1) * angle * Math.PI / 180);
			cosineAngle2 = Math.cos(((110 / 20) + 1) * angle * Math.PI / 180);
			
			offsetX = (110 + 20) * cosineAngle1 - 80 * cosineAngle2;
			offsetY = (110 + 20) * sineAngle1 - 80 * sineAngle2;
			
			currentX = basePointX + (int)offsetX;
			currentY = basePointY + (int)offsetY;
			
			drawCircle(gc, angle, currentX, currentY);
			gcMain.drawImage(offScreenImage,  0,  0,  this);
		}
	}
	
	public void drawCircle(Graphics gc, int x, int xCoord, int yCoord) {
		gc.setColor(lineColors[(x % 2) * 2]);
		gc.drawOval(xCoord,  yCoord,  10,  10);
	}
}

/*
 * <APPLET code = "CircleAni.class" width = 600 height = 500>
 * </APPLET>
 */
