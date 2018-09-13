import java.awt.*;//Font클래스 포함 
import javax.swing.*;//이미지 그래픽 

public class DrawString1 extends JApplet {
	Font gulim;
	Font timesroman;//폰트 선언 
	
	public void init() {
		setSize(400, 400);//setSize는 init메소드에 포함시키기 
		gulim = new Font("굴림",Font.BOLD, 30);//(폰트, 성질, 크기) 
		timesroman = new Font("Timesroman", Font.ITALIC, 40);
	}
	
	public void paint(Graphics g) {
		g.setFont(gulim); 
		g.setColor(Color.red);
		g.drawString("Hello,World!", 10, 30);//저 문자열을 (10,30)위치에 그린다  
		
		g.setFont(timesroman);
		g.setColor(Color.blue);
		g.drawString("Java Graphics!", 10, 80);//저 문자열을 (10, 80)위치에 그린다 
	}
}

/*
 * 	<APPLET code = "DrawString.class" width = "300" height = "100">
 * 	</APPLET>
 */
