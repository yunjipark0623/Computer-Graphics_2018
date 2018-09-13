import java.awt.*;
import java.awt.geom.*;//기하 도형 그리기 위해서 필요함 
import java.awt.event.*;//마우스 클릭하기 위한 이벤트들이 들어있음 
import javax.swing.*;
import java.util.Random;//랜덤으로 생성하는 것 

public class DrawEllipse2DArt extends JApplet implements ActionListener{
	//객체들 생성 
	Container c;
	MyCanvasApplet mc;
	Panel p;
	Button doit;
	
	public void init() {
		c = getContentPane();
		mc = new MyCanvasApplet(400, 300);
		p = new Panel();
		doit = new Button("Do It");
		doit.addActionListener(this);//기억해두기!! 액션리스터 (포괄하다, 품어있다)라는 뜻 
		p.add(doit);
		
		c.setLayout(new BorderLayout());
		c.add(BorderLayout.NORTH, p);
		c.add(BorderLayout.CENTER, mc);
	}
	
	public void actionPerformed(ActionEvent e) {
		mc.repaint();//계속 새로 그리는 것 앞에거 있는 상태에서 그릴수도 있고 없는 상태에서 그릴 수도 있다. 7.1에서는 그냥 paint여서 있는 상태에서 계속 그린거고 이건 repaint여서 다시 그리는 것 
	}
}

/*
<APPLET code = "DrawEllipse2DArt.class" width = 400 height = 300>
</APPLET>
*/