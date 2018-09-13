import java.awt.*;
import javax.swing.*;//스윙 컴포넌트를 사용하겠다고 선언한다. 
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class Rectangle2DTest extends JApplet{//JApplet컴포넌트를 상속받아서 Rectangle2DTest클래스를 작성한다. 
	Rectangle2D rec1;
	RoundRectangle2D rec2;
	
	public void init() {
		rec1 = new Rectangle2D.Double(10, 10, 100, 90);//(x좌표 시작점, y좌표 시작점, 가로, 세로) 
		//Rectangle2D의 새로운 객체 rec1을 만들고 x좌표 10, y좌표 10에서 시작해서 넓이가 100, 높이가 90인 사각형을 그린다. 
		rec2 = new RoundRectangle2D.Double(140, 10, 100, 90, 20, 20);//(x좌표 시작점, y좌표 시작점, 가로, 세로, 둥글기(가로), 둥글기(세로)) 
		//RoundRectangle2D의 새로운 객체 rec2를 만들고 x좌표 140, y좌표 10에서 시작해서 넓이가 100, 높이가 90이고 넓이와 높이의 둥글기가 각각 20인 사각형을 그린다. 
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setStroke(new BasicStroke(10));//선굵기 
		//BasicStroke클래스의 setStroke메소드를 이용해 선굵기를 지정한다. 
		g2.draw(rec1);
		g2.draw(rec2);
	}
}
