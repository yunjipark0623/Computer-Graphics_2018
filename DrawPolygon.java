import java.awt.*;
import javax.swing.*;

public class DrawPolygon extends JApplet{
	int[] coordX1 = {30, 40, 60, 30, 30};
	int[] coordY1 = {70, 80, 60, 110, 90};
	int[] coordX2 = {100, 150, 200, 200, 150, 100};
	int[] coordY2 = {100, 60, 70, 110, 120, 110};
	
	public void paint(Graphics g) {
		g.drawPolygon(coordX1, coordY1, 4);//coordX1과 coordY1의 원소를 각 쌍으로 좌표로 해서 4개의 코너점을 가지는 다각형 그리기 
		//원소를 각 쌍으로 하면 5개의 좌표가 나오는데 코너점으로 4개만 사용하라고 했으니깐 마지막쌍은 버린다. 
		
		Polygon pclass = new Polygon(coordX2, coordY2, 6);
		g.fillPolygon(pclass);//coordX2과 coordY2의 원소를 각 쌍으로 좌표로 해서 6개의 코너점을 가지는 다각형 그리고 채우기 
	}
}

/*
<APPLET code = "DrawPolygon.class" width = "300" height = "200">
</APPLET>
*/