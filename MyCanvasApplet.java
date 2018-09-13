import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

class MyCanvasApplet extends Canvas {
	Random random;
	int x, y, w,h;
	
	public MyCanvasApplet(int width, int height) {
		super();
		this.setSize(width, height);
		random = new Random();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		Dimension d = this.getSize();//랜덤으로 지정해주는 것 이미 사이즈가 정해져 있다면 그 사이즈를 얻어와서 지정해줌 
		Rectangle2D rect;
		Ellipse2D ellipse;
		
		//바탕을 검게 칠한다. 
		g2.setPaint(Color.black);
		rect = new Rectangle2D.Double(0, 0, d.width - 1, d.height - 1);
		g2.fill(rect);
		g2.draw(rect);
		
		//랜덤하게 타원 도형을 그린다. 
		g.setColor(Color.white);
		for (int i = 0; i < 50; i++) {
			x = (int) (random.nextDouble() * (d.width - 1));
			y = (int) (random.nextDouble() * (d.height - 1));
			w = h = (int) (random.nextDouble() * 70);
			
			ellipse = new Ellipse2D.Double(x, y, w, h);//시작점과 지름사이즈 
			g2.draw(ellipse);
		}
	}
}
