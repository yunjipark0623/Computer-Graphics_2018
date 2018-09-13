import java.awt.*;
import java.awt.geom.*;
import java.applet.*;
import javax.swing.*;

public class DrawingName extends JApplet {
	 private Polygon polygon = null;
	 
	 //정적메소드 : y좌표 교정용
	 private static int rY(int y) {
	     return -y;
	 }
	 
	 public void init() {
	     setSize(610, 410);
	 }
	 
	 public void paint(Graphics g) {
		 g.translate(300, 200);
	     drawCartesian(g);
	     
	     //박 
	     int[] parkx = {-230, -230, -140, -140, -160, -160, -210, -210};
	     int[] parky = {rY(180), rY(90), rY(90), rY(180), rY(180), rY(150), rY(150), rY(180)};
         g.fillPolygon(parkx, parky, 8);
         
         g.setColor(Color.white);
         int[] park1x = {-210, -210, -160, -160};
         int[] park1y = {rY(130), rY(110), rY(110), rY(130)};
         g.fillPolygon(park1x, park1y, 4);
         
         g.setColor(Color.black);
         int[] park2x = {-120, -120, -100, -100, -80, -80, -100, -100};
         int[] park2y = {rY(180), rY(90), rY(90), rY(130), rY(130), rY(150), rY(150), rY(180)};
         g.fillPolygon(park2x, park2y, 8);
         
         int[] park3x = {-230, -230, -120, -120, -100, -100};
         int[] park3y = {rY(70), rY(50), rY(50), rY(20), rY(20), rY(70)};
         g.fillPolygon(park3x, park3y, 6);
         
         //윤 
         g.fillOval(120, rY(180), 70, 70);
         g.setColor(Color.white);
         g.fillOval(140, rY(160), 30, 30);
         
         g.setColor(Color.black);
         int[] yunx = {90, 90, 125, 125, 145, 145, 165, 165, 185, 185, 220, 220};
         int[] yuny = {rY(100), rY(80), rY(80), rY(60), rY(60), rY(80), rY(80), rY(60), rY(60), rY(80), rY(80), rY(100)};
         g.fillPolygon(yunx, yuny, 12);
         
         int[] yun1x = {100, 100, 210, 210, 120, 120};
         int[] yun1y = {rY(60), rY(20), rY(20), rY(40), rY(40), rY(60)};
         g.fillPolygon(yun1x, yun1y, 6);
         
         //지 
         int[] jix = {-250, -250, -190, -250, -235, -200, -155, -140, -187, -150};
         int[] jiy = {rY(-40), rY(-60), rY(-60), rY(-140), rY(-155), rY(-110), rY(-155), rY(-140), rY(-93), rY(-40)};
         g.fillPolygon(jix, jiy, 10);
         
         int[] jix1 = {-120, -120, -100, -100};
         int[] jiy1 = {rY(-30), rY(-170), rY(-170), rY(-30)};
         g.fillPolygon(jix1, jiy1, 4);
         
         //나무 
         Color br = new Color(99, 58, 0);
         g.setColor(br);
         g.fillRect(140, rY(-120), 20, 50);
         
         Color gr = new Color(11, 121, 3);
         g.setColor(gr);
         g.fillOval(120, rY(-30), 60, 60);
         g.fillOval(120, rY(-70), 60, 60);
         g.fillOval(90, rY(-60), 50, 50);
         g.fillOval(160, rY(-60), 50, 50);
	 }
	 
	 ////////////좌표 그리기에 관련된 메소드 ////////////
		
	 private void drawCartesian(Graphics g) {
		 Color b = new Color(238, 238, 238);
		 JPanel c = new JPanel();
		 c.setBackground(b);  

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
