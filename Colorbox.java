import java.awt.*;
import javax.swing.*;

public class Colorbox extends JApplet {
	private Polygon polygon = null;
	private Polygon frontpolygon = null;
	private Polygon rightpolygon = null;

	private int baseX, baseY;
	private int originalX, originalY;
	private double offsetX, offsetY;
	private int width;
	private int tangent;

	private int[] xPoints;
	private int[] yPoints;

	private int[] xfrontPoints;
	private int[] yfrontPoints;

	private int[] xrightPoints;
	private int[] yrightPoints;

	Color[] color;

	public void init() {
		setSize(500,500);
		baseX=50;
		baseY=100;
		offsetX=0;
		offsetY=0;
		width=100;
		tangent=70;
		xPoints=new int[4];
		yPoints=new int[4];
		xfrontPoints=new int[4];
		yfrontPoints=new int[4];
		xrightPoints=new int[4];
		yrightPoints=new int[4];
		color=new Color[3];
		color[0]=Color.red;
		color[1]=Color.green;
		color[2]=Color.blue;
	}

	public void paint(Graphics g) {
		offsetX = tangent*Math.cos(45*Math.PI/180);
		offsetY = tangent*Math.sin(45*Math.PI/180);

		originalX=baseX;
		originalY=baseY;
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				xPoints[0] = baseX + width/4 * j;
				yPoints[0] = baseY;

				xPoints[1] = baseX + width/4 * (j+1);
				yPoints[1] = baseY;

				xPoints[2] = baseX + width/4 * (j+1) + (int)offsetX/4;
				yPoints[2] = baseY - (int)offsetY/4;
				
				xPoints[3] = baseX + (int)offsetX/4 + width/4 * j;
				yPoints[3] = baseY - (int)offsetY/4;

				polygon = new Polygon(xPoints, yPoints, 4);
				g.setColor(color[((3-i)%3+j)%3]);
				g.fillPolygon(polygon);
			}
			baseX = originalX + (int)offsetX/4 * (i+1);
			baseY = originalY - (int)offsetY/4 * (i+1);
		}
		baseX = originalX;
		baseY = originalY;

		originalX = baseX;
		originalY = baseY;
		for (int i=0; i<4; i++) { 
			for (int j=0; j<4; j++) { 
				xfrontPoints[0] = baseX;
				yfrontPoints[0] = baseY + width/4;
				
				xfrontPoints[1] = baseX + width/4;
				yfrontPoints[1] = baseY + width/4;
				
				xfrontPoints[2] = baseX + width/4;
				yfrontPoints[2] = baseY;
				
				xfrontPoints[3] = baseX;
				yfrontPoints[3] = baseY;
				
				frontpolygon = new Polygon(xfrontPoints, yfrontPoints, 4);
				g.setColor(color[((3-i)%3+j)%3]);
				g.fillPolygon(frontpolygon);
				baseX = baseX + width/4;
			}
			baseX = originalX;
			baseY = baseY + width/4;
		}

		baseY = originalY;

		originalX = baseX;
		originalY = baseY;
		for (int i=0; i<4; i++) { 
			for (int j=0; j<4; j++) { 
				xrightPoints[0] = baseX + width + (int)offsetX/4 * j;
				yrightPoints[0] = baseY + width/4 - (int)offsetY/4 * j;
				
				xrightPoints[1] = baseX + width + (int)offsetX/4 * (j + 1);
				yrightPoints[1] = baseY + width/4 - (int)offsetY/4 * (j + 1);
				
				xrightPoints[2] = baseX + width + (int)offsetX/4 * (j + 1);
				yrightPoints[2] = baseY - (int)offsetY/4 * (j + 1);
				
				xrightPoints[3] = baseX + width + (int)offsetX/4 * j;
				yrightPoints[3] = baseY - (int)offsetY/4 * j;
				
				rightpolygon = new Polygon(xrightPoints, yrightPoints, 4);
				g.setColor(color[((3-i)%3+(3-j)%3)%3]);
				g.fillPolygon(rightpolygon);
			}
			baseX = originalX;
			baseY = originalY + width/4 * (i+1);
		}
	}
}

