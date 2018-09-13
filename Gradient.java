import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.*;
 
public class Gradient extends java.applet.Applet {
	private Graphics offScreenBuffer = null;
	private Image offScreenImage = null;
	
	private int width = 200;
	private int height = 100;
	
	private int basePointX = 100;
	private int basePointY = 50;
	private int currentX = basePointX;
	private int currentY = basePointY;
	
	private int rVal = 0;
	private int gVal = 0;
	private int bVal = 255;
	
	Font font1;
	
	public Gradient() {
		
	}
	
	public void init() {
		setSize(500, 350);
		offScreenImage = this.createImage(400, 300);
		offScreenBuffer = offScreenImage.getGraphics();
		
		font1 = new Font("Serif", Font.PLAIN, 16);
	}
	
	public void paint(Graphics gc) {
		offScreenBuffer.setColor(Color.black);
		offScreenBuffer.fillRect(0, 0, 600, 430);
		
		drawGradient(offScreenBuffer);
		
		gc.drawImage(offScreenImage, 0, 0, this);
		
		gc.setFont(font1);
		gc.setColor(Color.white);
		gc.drawString("박윤지 2016108267", 135, 200);
	}
	
	public void drawGradient(Graphics gc) {
		currentY = basePointY + height;
		
		for (int z = 0; z < width; z++) {
			currentX = basePointX + z;
			
			rVal = z * 255/width;
			gVal = z * 255/width;
			//bVal = 255 - z*255/width;
			
			gc.setColor(new Color(rVal, gVal, bVal));
			gc.drawLine(currentX, basePointY, currentX, currentY);
		}
	}
}

