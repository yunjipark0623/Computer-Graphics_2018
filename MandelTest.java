 import java.awt.*;
 import javax.swing.*;
 import java.awt.Dimension;
 
 public class MandelTest extends JApplet {
 
     private static int MAX = 100;
     Color[] color = {Color.black, Color.red, Color.green, Color.blue, Color.magenta, Color.yellow, Color.cyan, Color.white };
     int width;
     int height;
 
     public void init() {
    	 	Dimension dim = getSize();
    	 	setSize(500,500);
     }
     
     public void paint(Graphics g) {
    	 	Dimension dim = getSize();
    	 	width = dim.width;
 		height = dim.height;
        drawMandel(g, -2.1, -1.5, 0.9, 1.5);
     }
     
     public void drawMandel(Graphics g, double real1, double img1, double real2, double img2) {
 
         double x, y, x2, y2, c1, c2;
         int  colorIndex, k;
 
         for( int i = 0; i <= height; i++) {
             for(int j = 0; j <= width; j++) {
                 c1 = (real2 - real1) * j / width + real1;
                 c2 = (img2 - img1) * i / height + img1;
 
                 x = y = 0;
                 for (k = 0; k < MAX; k++) {
                     x2 = x*x - y*y + c1;
                     y2 = 2*x*y + c2;
                     x = x2;
                     y = y2;
 
                     if (x*x + y*y > 10000)
                         break;
                 }

                 if (k == MAX) {
                     colorIndex = 0;
                 } else if (k >= MAX / 2) {
                     colorIndex = 7;
                 } else {
                     colorIndex = k % 6 + 1;
                 }
 
                 g.setColor(color[colorIndex]);
                 g.drawRect(j, i, 1, 1);
             }
         }
     }
 }