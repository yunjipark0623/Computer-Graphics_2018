import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
 
 public class CubicCurveApplet2 extends JApplet {
	CubicPanel cubicPanel = new CubicPanel();
     public void init() {
         Container c = getContentPane();
         c.setLayout( new BorderLayout());
         c.add(cubicPanel);
     }
 }
 
 class CubicPanel extends JPanel implements MouseListener, MouseMotionListener {

    private int x, y;

    Point2D start, end, control1, control2, point;
    Rectangle controlR1, controlR2, rect;
    CubicCurve2D curve;
    boolean isItValid = true;

    public CubicPanel() {
        start     = new Point2D.Double();
        end       = new Point2D.Double();
        control1  = new Point2D.Double();
        control2  = new Point2D.Double();
        controlR1 = new Rectangle(0, 0, 8, 8);
        controlR2 = new Rectangle(0, 0, 8, 8);
        curve     = new CubicCurve2D.Double();

        start.setLocation(100, 250);
        end.setLocation(350, 200);
        control1.setLocation(100, 100);
        control2.setLocation(350, 100); 

        addMouseMotionListener(this);
        addMouseListener(this);
    }

    public void update(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;

        controlR1.setLocation((int)(control1.getX()-4), (int)(control1.getY()-4));
        controlR2.setLocation((int)(control2.getX()-4), (int)(control2.getY()-4));

        g2.setPaint(Color.blue);
        g2.fill(controlR1);
        g2.fill(controlR2);
		g2.setStroke(new BasicStroke(5.0f));

        curve.setCurve(start, control1, control2, end);
        g2.setPaint(Color.red);
        g2.draw(curve);
    }
    
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        if (controlR1.contains(x,y)) {
            rect = controlR1;
            point = control1;

            x = controlR1.x - e.getX();
            y = controlR1.y - e.getY();
            updateLocation(e);
        } else if (controlR2.contains(x,y)) {
            rect = controlR2;
            point = control2;
            x = controlR2.x - e.getX();
            y = controlR2.y - e.getY();
            updateLocation(e);
        } else {
            isItValid = false;
        }
    }

    public void mouseDragged(MouseEvent e) {
        if (isItValid) {
            updateLocation(e);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (controlR1.contains(e.getX(), e.getY())) {
            rect = controlR1;
            point = control1;
            updateLocation(e);
        } else if (controlR2.contains(e.getX(), e.getY())) {
            rect = controlR2;
            point = control2;
             updateLocation(e);
         } else {
             isItValid = true;
         }
     }
 
     public void mouseMoved(MouseEvent e) {  }
     public void mouseClicked(MouseEvent e) {  }
     public void mouseExited(MouseEvent e) {   }
     public void mouseEntered(MouseEvent e) {  }
 
     public void updateLocation(MouseEvent e) {
         rect.setLocation((x + e.getX())-4, (y+e.getY())-4);
         point.setLocation(x + e.getX(), y + e.getY());
         curve.setCurve(start, control1, control2, end);
         repaint();
     }
 
     public void paintComponent(Graphics g) {
         super.paintComponent(g);
         update(g);
     }
 }
 
 /*
 ------------------------------------------------------------
 <APPLET code="CubicCurveApplet2.class" width=400 height=400>
 </APPLET>
 -----------------------------------------------------------
 */
