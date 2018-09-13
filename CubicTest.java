import java.awt.*;
import javax.swing.*;

public class CubicTest extends JApplet{	
	private static int length = 60;
	private static int tangent = 50;
	private static int colorIndex = 0;
	
	private Polygon frontPoly = null;
	private Polygon topPoly = null;
	private Polygon rightPoly = null;
	
	private Color[] color = new Color[3];
	private int baseX, baseY;
	private double offsetX, offsetY;
	
	private int[] frontX;
	private int[] frontY;
	
	private int[] topX;
	private int[] topY;
	
	private int[] rightX;
	private int[] rightY;
	
	public void init() {
		
		setSize(600, 500);
		colorIndex = 0;
		baseX = 200;
		baseY = 300;
		
		color[0] = Color.orange;
		color[1] = Color.white;
		color[2] = Color.yellow;
		
		frontX = new int[4];
		frontY = new int[4];
		
		rightX = new int[4];
		rightY = new int[4];
		
		topX = new int[4];
		topY = new int[4];
		
		offsetX = tangent * Math.cos(45 * Math.PI/180);
		offsetY = tangent * Math.sin(45 * Math.PI/180);
	}

	public void paint(Graphics g) {
		drawBigCubic(g, baseX, baseY);
	}
	
	public void drawBigCubic(Graphics g, int baseX, int baseY) {
		int x = 0;
		int y = 0;
		
		for(int i = 0; i < 4; i++) {
			x = baseX - (i*(int)offsetX);
			y = baseY + (i*(int)offsetY);
			drawOnePlane(g, x, y);
		}
	}
		
	public void drawOnePlane(Graphics g, int baseX, int baseY) {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				drawOneCubic(g, baseX + (j*length), baseY - (i*length));
				colorIndex++;
			}
		}
	}
	
	public void drawOneCubic(Graphics g, int baseX, int baseY) {
		frontX[0] = baseX;
		frontY[0] = baseY;
		
		frontX[1] = baseX + length;
		frontY[1] = baseY;
		
		frontX[2] = baseX + length;
		frontY[2] = baseY - length;
		
		frontX[3] = baseX;
		frontY[3] = baseY - length;
		
		baseX = baseX + length;
		
		rightX[0] = baseX;
		rightY[0] = baseY;
		
		rightX[1] = baseX + (int)offsetX;
		rightY[1] = baseY - (int)offsetY;
		
		rightX[2] = baseX + (int)offsetX;
		rightY[2] = baseY - length - (int)offsetY;
		
		rightX[3] = baseX;
		rightY[3] = baseY - length;
		
		baseX = baseX - length;
		baseY = baseY - length;
		
		topX[0] = baseX;
		topY[0] = baseY;
		
		topX[1] = baseX + length;
		topY[1] = baseY;
		
		topX[2] = baseX + length + (int)offsetX;
		topY[2] = baseY - (int)offsetY;
		
		topX[3] = baseX + (int)offsetX;
		topY[3] = baseY - (int)offsetY;
		
		frontPoly = new Polygon(frontX, frontY, 4);
		rightPoly = new Polygon(rightX, rightY, 4);
		topPoly = new Polygon(topX, topY, 4);
		
		g.setColor(color[colorIndex % 3]);
		g.fillPolygon(frontPoly);
		g.fillPolygon(rightPoly);
		g.fillPolygon(topPoly);
	}
}

/*
 * <APPLET code = "CubicTest.class" width = "600" height = "500">
 * </APPLET>
 */
