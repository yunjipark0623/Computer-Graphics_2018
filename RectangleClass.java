import java.awt.Color;
import java.awt.Graphics;

public class RectangleClass extends java.applet.Applet {//그래픽에 필요한 속성 데이터 선언 
	//그래픽 속성 데이터 선언 
	private int baseX, baseY;
	private int thick;
	private int recWidth, recHeight;
	
	public void init() {//애플릿 초기화 메소드 
		setSize(400, 400);//창 크기 지정 
		baseX = 50;
		baseY = 50;
		thick = 15;
		recWidth = recHeight = 200;
	}
	
	public void paint(Graphics g) {
		//그래픽 표시 
		for(int i = thick; i >= 0; i--) {
			if(i > 0) {
				g.setColor(Color.blue);
			}
			else {
				g.setColor(Color.yellow);
			}
			
			g.fillRect(baseX + i, baseY + i, recWidth, recHeight);
		}
	}
}

/*
 * <APPLET code = "RectangleClass.class" width = "400" height = "300">
 * </APPLET>
 */
