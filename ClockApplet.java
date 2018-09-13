import java.applet.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import java.awt.Image;
import java.net.URL;


public class ClockApplet extends Applet implements Runnable {
	Image img = null;
 
	public void init() {
		try {
			img = this.getImage(new URL(this.getCodeBase(), "mback.jpg") );
		}
		catch(Exception e){}
	}
 
	public void start() {
		setSize(600, 600);
		new Thread(this).start();
	}
 
	public void paint(Graphics g) {
	  Calendar cal = Calendar.getInstance();
	  String temp = cal.get(Calendar.HOUR_OF_DAY)+ " : ";
	  temp +=  cal.get(Calendar.MINUTE)+ " : ";
	  temp +=  cal.get(Calendar.SECOND) + "  ";
	  g.setColor(Color.BLUE);
	  g.setFont(new Font("sansSerif", Font.BOLD, 30));
	  g.drawString(temp, 30, 30);
	  g.drawImage(img, 20, 100, this);
	}
 
	public void stop(){}
 
	public void destroy(){}
 
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				repaint();
			}
			catch(InterruptedException e){}
		}
	}
}

