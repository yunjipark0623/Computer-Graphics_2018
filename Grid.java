import java.awt.*;
import java.awt.geom.*;
import java.applet.*;
import javax.swing.*;

public class Grid extends JApplet{
	private int vertexCount = 8;
	private int[] xPoints = new int [vertexCount];
	private int[] yPoints = new int [vertexCount];
	private Polygon polygon = null;
	
	//정적 메소드 : y좌표 교정용
	private static int rY(int y) {
		return -y;
	}
	
	public void init() {
		setSize(610, 410);
	}
	
	public void paint(Graphics g) {
		//
		//이 자리에 기본 도형 객체를 생성합니다.
		//
		//기준좌표를 화면 중앙으로 이동하고 
		//좌표 시스템을 그립니다.
		g.translate(300, 200);
		drawCartesian(g);
		
		//
		//이 자리에 기본 도형 객체를 생성하고,
		//변환한 다음 결과 도형객체를 다시 출력합니다.
		//
	}
	
	//////////// 좌표 그리기에 관련된 메소드 ////////////
	
	private void drawCartesian(Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(Color.white);
		g.fillRect(0, 0, 610, 410);
		g.setColor(oldColor);
		
		drawGrid(g);
		drawAxis(g);
	}
	
	//
	//그리드 출력하기
	//
	public void drawGrid(Graphics g) {
		g.setColor(Color.lightGray);
		
		for (int t = 0; t < 300; t += 10) {
			g.drawLine(t, rY(200), t, rY(-200));
			g.drawLine(-t, rY(200), -t, rY(-200));
		}
		
		for (int t = 0; t < 200; t += 10) {
			g.drawLine(-300, rY(t), 300, rY(t));
			g.drawLine(-300, rY(-t), 300, rY(-t));
		}
	}
	
	//
	//좌표 축 그리기
	//
	public void drawAxis(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(-300, rY(200), 600, 400);
		g.drawLine(0, 0, 300, 0);
		g.drawLine(0, 0, 0, rY(200));
		g.drawLine(0, 0, -300, 0);
		g.drawLine(0, 0, 0, rY(-200));
		
		for (int t = 0; t < 300; t += 30) {
			g.drawLine(t, 0, t, rY(4));
			g.drawLine(-t, 0, -t, rY(4));
			drawCoordLabel(g, String.valueOf(t), t, 0, 0);
			drawCoordLabel(g, String.valueOf(-t), -t, 0, 0);
		}
		
		for (int t = 30; t < 200; t += 30) {
			g.drawLine(0, rY(t), 4, rY(t));
			g.drawLine(0, rY(-t), 4, rY(-t));
			drawCoordLabel(g, String.valueOf(t), -10, rY(t), 1);
			drawCoordLabel(g, String.valueOf(-t), -10, rY(-t), 1);
		}
	}
	
	//
	//좌표 눈금 표시하기
	//
	public void drawCoordLabel(Graphics g, String label, int x, int y, int direction) {
		Graphics2D g2 = (Graphics2D) g;
		
		FontMetrics metrics = g2.getFontMetrics();
		Rectangle2D.Float box = (Rectangle2D.Float) metrics.getStringBounds(label, g2);
		
		if (direction == 0) {
			g2.drawString(label, x-box.width/2, y+box.height);
		}
		else {
			g2.drawString(label, x-box.width, y+box.height/2);
		}
	}
}

