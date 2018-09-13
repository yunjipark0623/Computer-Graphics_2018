import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JApplet;
import javax.swing.JComponent;
 
public class PingPongGame extends JApplet implements Runnable, MouseMotionListener
{
    private static final int WIDTH = 300;
    private static final int HEIGHT = 150;
    private int ballNum = 2;
    private PingPong pinpong;
    private int mouseX, mouseY;
    
    Thread aThread;
    
    public void init()
    {
        setSize(WIDTH, HEIGHT);
        pinpong = new PingPong();
        add(pinpong);
        addMouseMotionListener(this);
    }
    
    public void start()
    {
        if(aThread == null)
        {
            aThread = new Thread(this);
            aThread.start();
        }
    }
    
    public void stop()
    {
        if(aThread != null)
        {
            aThread = null;
        }
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            try{Thread.sleep(10);}
            catch(InterruptedException e){}
            repaint();
        }
    }
    
    class PingPong extends JComponent
    {
        public Ball basket[] = new Ball[ballNum];
 
        public PingPong()
        {
            for(int i =0 ; i < ballNum ; i++)
            {
                basket[i] = new Ball(20);
            }
        }
        
        public void paint(Graphics g)
        {
            super.paint(g);        
            for(Ball b : basket)
            {
                b.paint(g);
            }
            g.setColor(Color.GREEN);
            g.fill3DRect(mouseX-25, mouseY-5, 50, 10,true);
        }
    }
    
    class Ball
    {
        private int x = 0;
        private int y = 100;
        private final int diameter;
        private int vectorX = 1;
        private int vectorY = 1;
        
        public Ball(int d)
        {
            this.diameter = d;
            x = (int)(Math.random()*(getWidth() - d));
            y = (int)(Math.random()*(getHeight() - d));
            vectorX = 1;
            vectorY = 1;    
        }
        
        public void paint(Graphics g)
        {
            if(x<0 || x>(getWidth()- diameter))
            {
                vectorX =  -vectorX;
            }
            x += vectorX;
            
            if((y == mouseY-diameter) &&(((x+diameter/2) > mouseX-25 ) && (x+diameter/2)< mouseX+25))  
            {
                vectorY =  -vectorY;
            }
            else if(y<0 || y>(getHeight() - diameter))
            {
                vectorY =  -vectorY;
            }
            y += vectorY;
            
            g.setColor(Color.ORANGE);
            g.fillOval(x, y, diameter, diameter);
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e)    
    {
        mouseX = e.getX();
        mouseY = e.getY();
    }
    public void mouseMoved(MouseEvent e) 
    {
        mouseX = e.getX();
        mouseY = e.getY();
    }
    
}